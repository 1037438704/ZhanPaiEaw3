/**
 * Copyright (C) 2016 Hyphenate Inc. All rights reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hyphenate.easeui.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import okhttp3.MediaType;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hyphenate.EMConnectionListener;
import com.hyphenate.EMContactListener;
import com.hyphenate.EMError;
import com.hyphenate.chat.EMClient;
import com.hyphenate.easeui.R;
import com.hyphenate.easeui.domain.EaseUser;
import com.hyphenate.easeui.utils.EaseCommonUtils;
import com.hyphenate.easeui.widget.EaseContactList;
import com.hyphenate.easeui.widget.EaseTitleBar;
import com.hyphenate.exceptions.HyphenateException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import zpe.jiakeyi.com.zhanpaieaw.library.bean.HuanXinUsers;
import zpe.jiakeyi.com.zhanpaieaw.library.utils.RequestUtlis;

/**
 * contact list
 */
public class EaseContactListFragment extends EaseBaseFragment {
    private static final String TAG = "EaseContactListFragment";
    protected List<EaseUser> contactList;
    protected ListView listView;
    protected boolean hidden;
    protected ImageButton clearSearch;
    protected EditText query;
    protected Handler handler = new Handler();
    protected EaseUser toBeProcessUser;
    protected String toBeProcessUsername;
    protected EaseContactList contactListLayout;
    protected boolean isConflict;
    protected FrameLayout contentContainer;
    private EaseTitleBar titleBar;
    private Map<String, EaseUser> contactsMap;
    private List<String> usernames = new ArrayList<>();
    private static List<HuanXinUsers.DataBean.UserInfoListBean> userInfoList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.ease_fragment_contact_list, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        //to avoid crash when open app after long time stay in background after user logged into another device
        if (savedInstanceState != null && savedInstanceState.getBoolean("isConflict", false))
            return;
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    protected void initView() {
        contentContainer = (FrameLayout) getView().findViewById(R.id.content_container);

        contactListLayout = (EaseContactList) getView().findViewById(R.id.contact_list);
        listView = contactListLayout.getListView();

        //search
        titleBar = getView().findViewById(R.id.title_bar);
        query = (EditText) getView().findViewById(R.id.query);
        clearSearch = (ImageButton) getView().findViewById(R.id.search_clear);
    }

    @Override
    protected void setUpView() {
        Log.d("aaaaa","setUpView");
        EMClient.getInstance().addConnectionListener(connectionListener);

        contactList = new ArrayList<EaseUser>();
        getContactList();
        //init list
        contactListLayout.init(contactList);
        titleBar.setRightLayoutClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AddContactActivity.class));
            }
        });
        if (listItemClickListener != null) {
            listView.setOnItemClickListener(new OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    EaseUser user = (EaseUser) listView.getItemAtPosition(position);
                    listItemClickListener.onListItemClicked(user);
                }
            });
        }

        query.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                contactListLayout.filter(s);
                if (s.length() > 0) {
                    clearSearch.setVisibility(View.VISIBLE);
                } else {
                    clearSearch.setVisibility(View.INVISIBLE);

                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void afterTextChanged(Editable s) {
            }
        });
        clearSearch.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                query.getText().clear();
                hideSoftKeyboard();
            }
        });

        listView.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hideSoftKeyboard();
                return false;
            }
        });



        EMClient.getInstance().contactManager().setContactListener(new EMContactListener(){

            public void onContactAgreed(String username){
                Toast.makeText(getContext(), username + "同意了您的好友请求", Toast.LENGTH_SHORT).show();
                //好友请求被同意
            }

            public void onContactRefused(String username){
                //好友请求被拒绝
                Toast.makeText(getContext(), username + "拒绝了您的好友请求!", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onContactInvited(final String username, final String reason){
                Log.i("123", "onContactInvited: " + username + "," + reason);
                getActivity().runOnUiThread(new Runnable(){
                    @Override
                    public void run(){
                        //收到好友邀请
                        final android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
                        //    设置Title的内容
                        builder.setTitle("好友请求");
                        //    设置Content来显示一个信息
                        builder.setMessage(username + ":" + reason);
                        //    设置一个PositiveButton
                        builder.setPositiveButton("同意", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which){
                                try{
                                    EMClient.getInstance().contactManager().acceptInvitation(username);
                                    refresh();
                                }catch(HyphenateException e){
                                    e.printStackTrace();
                                }
                            }
                        });
                        //    设置一个NegativeButton
                        builder.setNegativeButton("拒绝", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which){
                                try{
                                    EMClient.getInstance().contactManager().declineInvitation(username);
                                }catch(HyphenateException e){
                                    e.printStackTrace();
                                }
                            }
                        });
                        //    显示出该对话框
                        builder.show();
                        Toast.makeText(getContext(), "对话框你出来", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onFriendRequestAccepted(String s){
                Log.i("好友", "onFriendRequestAccepted: " + s);
            }

            @Override
            public void onFriendRequestDeclined(String s){
                Log.i("好友", "onFriendRequestDeclined: " + s);
            }

            @Override
            public void onContactDeleted(String username){
                //被删除时回调此方法
            }


            @Override
            public void onContactAdded(String username){
                new Thread(new Runnable(){
                    @Override
                    public void run(){
                        MyThread myThread = new MyThread();
                        myThread.start();
                    }
                }).start();
            }
        });
    }

    public class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                usernames.clear();
                usernames.addAll(EMClient.getInstance().contactManager().getAllContactsFromServer());
            } catch (HyphenateException e) {
                e.printStackTrace();
            } finally {
                if (usernames != null) {
                    PostThread postThread = new PostThread();
                    postThread.start();
                }
            }

        }
    }


    public class PostThread extends Thread {
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void run() {
            super.run();
            try {
                usernames = EMClient.getInstance().contactManager().getAllContactsFromServer();
                if (usernames != null) {
                    Log.d("usernames", "initDatas: " + usernames);
                    Gson gson = new Gson();
                    String s = gson.toJson(usernames);
                    String post = getRequest(RequestUtlis.getImUserInfo, s, RequestUtlis.Token);
                    Log.i("返回值", "run: " + post);
                    HuanXinUsers huanXinUsers = gson.fromJson(post, HuanXinUsers.class);
                    userInfoList.clear();
                    userInfoList.addAll(huanXinUsers.getData().getUserInfoList());
                    Map<String, EaseUser> contacts = getContacts(userInfoList);
                    Log.i("返回值", "run: " + contacts);
                    setContactsMap(contacts);
                }


            } catch (IOException e) {
                e.printStackTrace();
            } catch (HyphenateException e) {
                e.printStackTrace();
            }
        }
    }

    private Map<String, EaseUser> getContacts(List<HuanXinUsers.DataBean.UserInfoListBean> userInfoList) {
        Map<String, EaseUser> contacts = new HashMap<>();
        for (int i = 0; i <= userInfoList.size() - 1; i++) {
            EaseUser user = new EaseUser(userInfoList.get(i).getNickName());
            user.setAvatar(userInfoList.get(i).getIcon());
            contacts.put(userInfoList.get(i).getUserName(), user);
        }
        Log.i("json", "getContacts: " + contacts);
        return contacts;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        this.hidden = hidden;
        if (!hidden) {
            refresh();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!hidden) {
            refresh();
        }
    }


    /**
     * move user to blacklist
     */
    protected void moveToBlacklist(final String username) {
        final ProgressDialog pd = new ProgressDialog(getActivity());
        String st1 = getResources().getString(R.string.Is_moved_into_blacklist);
        final String st2 = getResources().getString(R.string.Move_into_blacklist_success);
        final String st3 = getResources().getString(R.string.Move_into_blacklist_failure);
        pd.setMessage(st1);
        pd.setCanceledOnTouchOutside(false);
        pd.show();
        new Thread(new Runnable() {
            public void run() {
                try {
                    //move to blacklist
                    EMClient.getInstance().contactManager().addUserToBlackList(username, false);
                    getActivity().runOnUiThread(new Runnable() {
                        public void run() {
                            pd.dismiss();
                            Toast.makeText(getActivity(), st2, Toast.LENGTH_SHORT).show();
                            refresh();
                        }
                    });
                } catch (HyphenateException e) {
                    e.printStackTrace();
                    getActivity().runOnUiThread(new Runnable() {
                        public void run() {
                            pd.dismiss();
                            Toast.makeText(getActivity(), st3, Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        }).start();

    }

    // refresh ui
    public void refresh() {
        getContactList();
        contactListLayout.refresh();
    }


    @Override
    public void onDestroy() {

        EMClient.getInstance().removeConnectionListener(connectionListener);

        super.onDestroy();
    }


    /**
     * get contact list and sort, will filter out users in blacklist
     */
    protected void getContactList() {
        contactList.clear();
        if (contactsMap == null) {
            return;
        }
        synchronized (this.contactsMap) {
            Iterator<Entry<String, EaseUser>> iterator = contactsMap.entrySet().iterator();
            List<String> blackList = EMClient.getInstance().contactManager().getBlackListUsernames();
            while (iterator.hasNext()) {
                Entry<String, EaseUser> entry = iterator.next();
                // to make it compatible with data in previous version, you can remove this check if this is new app
                if (!entry.getKey().equals("item_new_friends")
                        && !entry.getKey().equals("item_groups")
                        && !entry.getKey().equals("item_chatroom")
                        && !entry.getKey().equals("item_robots")) {
                    if (!blackList.contains(entry.getKey())) {
                        //filter out users in blacklist
                        EaseUser user = entry.getValue();
                        EaseCommonUtils.setUserInitialLetter(user);
                        contactList.add(user);
                    }
                }
            }
        }

        // sorting
        Collections.sort(contactList, new Comparator<EaseUser>() {

            @Override
            public int compare(EaseUser lhs, EaseUser rhs) {
                if (lhs.getInitialLetter().equals(rhs.getInitialLetter())) {
                    return lhs.getNick().compareTo(rhs.getNick());
                } else {
                    if ("#".equals(lhs.getInitialLetter())) {
                        return 1;
                    } else if ("#".equals(rhs.getInitialLetter())) {
                        return -1;
                    }
                    return lhs.getInitialLetter().compareTo(rhs.getInitialLetter());
                }

            }
        });

    }


    protected EMConnectionListener connectionListener = new EMConnectionListener() {

        @Override
        public void onDisconnected(int error) {
            if (error == EMError.USER_REMOVED || error == EMError.USER_LOGIN_ANOTHER_DEVICE || error == EMError.SERVER_SERVICE_RESTRICTED) {
                isConflict = true;
            } else {
                getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        onConnectionDisconnected();
                    }

                });
            }
        }

        @Override
        public void onConnected() {
            getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    onConnectionConnected();
                }

            });
        }
    };
    private EaseContactListItemClickListener listItemClickListener;


    protected void onConnectionDisconnected() {

    }

    protected void onConnectionConnected() {

    }

    /**
     * set contacts map, key is the hyphenate id
     *
     * @param contactsMap
     */
    public void setContactsMap(Map<String, EaseUser> contactsMap) {
        this.contactsMap = contactsMap;
    }

    public interface EaseContactListItemClickListener {
        /**
         * on click event for item in contact list
         *
         * @param user --the user of item
         */
        void onListItemClicked(EaseUser user);
    }

    /**
     * set contact list item click listener
     *
     * @param listItemClickListener
     */
    public void setContactListItemClickListener(EaseContactListItemClickListener listItemClickListener) {
        this.listItemClickListener = listItemClickListener;
    }

    public static final MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public String getRequest(String url, String json, String token) throws IOException {//post请求，返回String类型
        RequestBody body = RequestBody.create(mediaType, json);
        Request request = new Request.Builder()
                .addHeader("Content-Type", "application/json")//添加头部
                .addHeader("ACCESS_TOKEN", token)
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
