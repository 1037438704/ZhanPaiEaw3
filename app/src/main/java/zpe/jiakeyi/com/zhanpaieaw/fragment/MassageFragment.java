package zpe.jiakeyi.com.zhanpaieaw.fragment;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hyphenate.EMContactListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.domain.EaseUser;
import com.hyphenate.easeui.ui.EaseChatFragment;
import com.hyphenate.easeui.ui.EaseContactListFragment;
import com.hyphenate.easeui.ui.EaseConversationListFragment;
import com.hyphenate.easeui.utils.EaseCommonUtils;
import com.hyphenate.exceptions.HyphenateException;
import com.kongzue.baseframework.BaseFragment;
import com.kongzue.baseframework.interfaces.Layout;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import zpe.jiakeyi.com.zhanpaieaw.MainActivity;
import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.activity.login.LoginActivity;
import zpe.jiakeyi.com.zhanpaieaw.activity.massage.ChatActivity;
import zpe.jiakeyi.com.zhanpaieaw.adapter.MyCollectAdapter;
import zpe.jiakeyi.com.zhanpaieaw.adapter.MyCollectFragmentAdapter;
import zpe.jiakeyi.com.zhanpaieaw.bean.HuanXinUsers;
import zpe.jiakeyi.com.zhanpaieaw.bean.friendBean;
import zpe.jiakeyi.com.zhanpaieaw.fragment.message.FriendFragment;
import zpe.jiakeyi.com.zhanpaieaw.fragment.message.SystemFragment;
import zpe.jiakeyi.com.zhanpaieaw.fragment.message.UserFragment;
import zpe.jiakeyi.com.zhanpaieaw.utils.RequestUtlis;

/**
 * 创建人： 郭健福
 * 创建时间： 2018/7/23 21:44
 * 功能描述：消息页面
 *
 * @author dell-pc
 */
@Layout(R.layout.fragment_massage)
public class MassageFragment extends BaseFragment {
    private TabLayout tablayout_xiaoxi;
    private ViewPager viewpager;
    private List<Fragment> data;
    private List<String> lists;
    private AutoLinearLayout auto_ll;
    private EaseConversationListFragment easeConversationListFragment;
    private EaseContactListFragment contactListFragment;
    private List<String> usernames;
    private static List<HuanXinUsers.DataBean.UserInfoListBean> userInfoList;

    public MassageFragment() {
    }

    @Override
    public void initViews() {
        tablayout_xiaoxi = findViewById(R.id.tablayout_xiaoxi);
        auto_ll = findViewById(R.id.auto_ll);
        viewpager = findViewById(R.id.viewpager);
        lists = new ArrayList<>();
        data = new ArrayList<>();
    }

    @Override
    public void initDatas() {
        auto_ll.setY(me.getStatusBarHeight());
        lists.add("互动消息");
        lists.add("系统信息");
        lists.add("我的好友");
        easeConversationListFragment = new EaseConversationListFragment();
        contactListFragment = new EaseContactListFragment();
//需要设置联系人列表才能启动fragment

        if (RequestUtlis.ID != null) {
            MyThread myThread = new MyThread();
            myThread.start();
            if (usernames != null) {
                myThread.stop();
            }
        } else {
            jump(LoginActivity.class);
        }


//设置item点击事件
        contactListFragment.setContactListItemClickListener(new EaseContactListFragment.EaseContactListItemClickListener() {

            @Override
            public void onListItemClicked(EaseUser user) {
                startActivity(new Intent(getActivity(), ChatActivity.class).putExtra(EaseConstant.EXTRA_USER_ID, user.getUsername()));
            }
        });
        data.add(easeConversationListFragment);
        data.add(new SystemFragment());
        data.add(contactListFragment);
        MyCollectFragmentAdapter myAdaptre = new MyCollectFragmentAdapter(getChildFragmentManager(), data, lists);
        viewpager.setAdapter(myAdaptre);
        viewpager.setCurrentItem(0);

        tablayout_xiaoxi.addTab(tablayout_xiaoxi.newTab().setText(lists.get(0)));
        tablayout_xiaoxi.addTab(tablayout_xiaoxi.newTab().setText(lists.get(1)));
        tablayout_xiaoxi.setupWithViewPager(viewpager);//把tablayout和viewpage绑定在一起
    }

    private Map<String, EaseUser> getContacts(List<HuanXinUsers.DataBean.UserInfoListBean> userInfoList) {
        Map<String, EaseUser> contacts = new HashMap<>();
        for (int i = 0; i <= userInfoList.size() - 1; i++) {
            EaseUser user = new EaseUser(userInfoList.get(i).getUserName());
            contacts.put(userInfoList.get(i).getNickName(), user);
        }
        Log.i("json", "getContacts: " + contacts);
        return contacts;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                usernames = EMClient.getInstance().contactManager().getAllContactsFromServer();
            } catch (HyphenateException e) {
                e.printStackTrace();
            } finally {
                Log.d("usernames", "initDatas: " + usernames);
                Gson gson = new Gson();
                String s = gson.toJson(usernames);
                Log.i("字符串", "run: " + s + "");
                Log.i("手机号", "run: " + RequestUtlis.UserPhone);
                Log.i("字符串", "run: " + RequestUtlis.Token);
                OkHttpUtils.post().url(RequestUtlis.getImUserInfo)
                        .addHeader("Content-Type", "application/json")
                        .addHeader("Accept", "application/json")
                        .addHeader("loginType", "1")
                        .addHeader("ACCESS_TOKEN", RequestUtlis.Token)
                        .addParams("userList", s)
                        .build()
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Call call, Exception e, int id) {
                                Log.e("错误", "onError: " + e);
                            }

                            @Override
                            public void onResponse(String response, int id) {
                                Log.i("列表?", "onResponse: " + response);
                                Gson gson = new Gson();
                                HuanXinUsers huanXinUsers = gson.fromJson(response, HuanXinUsers.class);
                                userInfoList = huanXinUsers.getData().getUserInfoList();
                                Map<String, EaseUser> contacts = getContacts(userInfoList);
//                                Log.i("列表", "onResponse: " + response);
//                                friendBean v = gson.fromJson(response, friendBean.class);
//                                List<friendBean.DataBean.FriendListBean> friendList = v.getData().getFriendList();
//                                Map<String, EaseUser> contacts = getContacts(friendList);
//                                Log.i("列表?", "onResponse: " + friendList);
                                contactListFragment.setContactsMap(contacts);
                            }
                        });
            }

        }
    }

    @Override
    public void setEvents() {
        easeConversationListFragment.setConversationListItemClickListener(new EaseConversationListFragment.EaseConversationListItemClickListener() {
            @Override
            public void onListItemClicked(EMConversation conversation) {
                Toast.makeText(me, "" + conversation.conversationId(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), ChatActivity.class).putExtra(EaseConstant.EXTRA_USER_ID, conversation.conversationId()));
            }
        });
        EMClient.getInstance().contactManager().setContactListener(new EMContactListener() {

            public void onContactAgreed(String username) {
                Toast.makeText(me, username + "同意了您的好友请求", Toast.LENGTH_SHORT).show();
                //好友请求被同意
            }

            public void onContactRefused(String username) {
                //好友请求被拒绝
                Toast.makeText(me, username + "拒绝了您的好友请求!", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onContactInvited(final String username, String reason) {
                //收到好友邀请
                AlertDialog.Builder builder = new AlertDialog.Builder(me);
                //    设置Title的图标
                builder.setIcon(R.drawable.ic_launcher);
                //    设置Title的内容
                builder.setTitle("好友请求");
                //    设置Content来显示一个信息
                builder.setMessage(username + "请求添加您为好友");
                //    设置一个PositiveButton
                builder.setPositiveButton("同意", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            EMClient.getInstance().contactManager().acceptInvitation(username);
                            contactListFragment.refresh();

                        } catch (HyphenateException e) {
                            e.printStackTrace();
                        }
                    }
                });
                //    设置一个NegativeButton
                builder.setNegativeButton("拒绝", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            EMClient.getInstance().contactManager().declineInvitation(username);
                        } catch (HyphenateException e) {
                            e.printStackTrace();
                        }
                    }
                });
                //    显示出该对话框
                builder.show();
            }

            @Override
            public void onFriendRequestAccepted(String s) {

            }

            @Override
            public void onFriendRequestDeclined(String s) {

            }

            @Override
            public void onContactDeleted(String username) {
                //被删除时回调此方法
            }


            @Override
            public void onContactAdded(String username) {
                //增加了联系人时回调此方法
            }
        });
    }

}
