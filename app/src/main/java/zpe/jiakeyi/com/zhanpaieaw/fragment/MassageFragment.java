package zpe.jiakeyi.com.zhanpaieaw.fragment;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hyphenate.EMContactListener;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.EaseUI;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
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
            user.setAvatar(userInfoList.get(i).getIcon());
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
                if (usernames != null)
                    Log.d("usernames", "initDatas: " + usernames);
                Gson gson = new Gson();
                String s = gson.toJson(usernames);
                PostThread postThread = new PostThread();
                postThread.start();

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
                if (usernames != null)
                    Log.d("usernames", "initDatas: " + usernames);
                Gson gson = new Gson();
                String s = gson.toJson(usernames);
                String post = post(RequestUtlis.getImUserInfo, s, RequestUtlis.Token);
                Log.i("返回值", "run: " + post);
                HuanXinUsers huanXinUsers = gson.fromJson(post, HuanXinUsers.class);
                userInfoList = huanXinUsers.getData().getUserInfoList();
                Map<String, EaseUser> contacts = getContacts(userInfoList);
                Log.i("返回值", "run: " + contacts);
                contactListFragment.setContactsMap(contacts);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (HyphenateException e) {
                e.printStackTrace();
            }
        }
    }

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public String post(String url, String json, String token) throws IOException {//post请求，返回String类型
        RequestBody body = RequestBody.create(JSON, json);
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
                contactListFragment.notifyAll();
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
                            contactListFragment.notifyAll();

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
                contactListFragment.notifyAll();
                //增加了联系人时回调此方法
            }
        });
        EMMessageListener msgListener = new EMMessageListener() {

            @Override
            public void onMessageReceived(List<EMMessage> messages) {
                easeConversationListFragment
                        .refresh();
                //收到消息
            }

            @Override
            public void onCmdMessageReceived(List<EMMessage> messages) {
                //收到透传消息
            }

            @Override
            public void onMessageRead(List<EMMessage> messages) {
                //收到已读回执
            }

            @Override
            public void onMessageDelivered(List<EMMessage> message) {
                //收到已送达回执
            }

            @Override
            public void onMessageRecalled(List<EMMessage> messages) {
                //消息被撤回
            }

            @Override
            public void onMessageChanged(EMMessage message, Object change) {
                //消息状态变动
            }
        };
        EMClient.getInstance().chatManager().addMessageListener(msgListener);
    }
}
