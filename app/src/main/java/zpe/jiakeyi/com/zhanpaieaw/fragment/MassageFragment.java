package zpe.jiakeyi.com.zhanpaieaw.fragment;


import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.api.Response;
import com.google.gson.Gson;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.domain.EaseUser;

import com.hyphenate.easeui.ui.EaseContactListFragment;
import com.hyphenate.easeui.ui.EaseConversationListFragment;

import com.hyphenate.exceptions.HyphenateException;
import com.kongzue.baseframework.BaseFragment;
import com.kongzue.baseframework.interfaces.Layout;
import com.kongzue.baseframework.util.Preferences;
import com.zhy.autolayout.AutoLinearLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.activity.login.LoginActivity;
import zpe.jiakeyi.com.zhanpaieaw.activity.massage.ChatActivity;
import zpe.jiakeyi.com.zhanpaieaw.adapter.MyCollectFragmentAdapter;
import zpe.jiakeyi.com.zhanpaieaw.fragment.message.SystemFragment;
import zpe.jiakeyi.com.zhanpaieaw.library.bean.HuanXinUsers;
import zpe.jiakeyi.com.zhanpaieaw.library.bean.LoginBeanCode;
import zpe.jiakeyi.com.zhanpaieaw.library.utils.RequestUtlis;

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
//需要设置联系人列表才能启动fragment
        MyThread myThread = new MyThread();
        if (RequestUtlis.ID != null) {
            myThread.start();
            if (usernames != null) {
                myThread.stop();
            }
        } else {
            jump(LoginActivity.class);
        }
        easeConversationListFragment = new EaseConversationListFragment();
        contactListFragment = new EaseContactListFragment();
        lists.add("系统信息");
        auto_ll.setY(me.getStatusBarHeight());
        lists.add("互动消息");
        lists.add("我的好友");


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
            EaseUser user = new EaseUser(userInfoList.get(i).getNickName());
            user.setAvatar(userInfoList.get(i).getIcon());
            contacts.put(userInfoList.get(i).getUserName(), user);
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
                if (usernames != null) {
                    usernames.clear();
                    usernames.addAll(EMClient.getInstance().contactManager().getAllContactsFromServer());
                }
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
                    String post = post(RequestUtlis.getImUserInfo, s, RequestUtlis.Token);
                    Log.i("返回值", "run: " + post);
                    HuanXinUsers huanXinUsers = gson.fromJson(post, HuanXinUsers.class);
                    userInfoList = huanXinUsers.getData().getUserInfoList();
                    Map<String, EaseUser> contacts = getContacts(userInfoList);
                    Log.i("返回值", "run: " + contacts);
                    contactListFragment.setContactsMap(contacts);
                }


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
        try (okhttp3.Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    @Override
    public void setEvents() {
        easeConversationListFragment.setConversationListItemClickListener(new EaseConversationListFragment.EaseConversationListItemClickListener() {
            @Override
            public void onListItemClicked(EMConversation conversation) {
                Toast.makeText(me, "" + conversation.conversationId(), Toast.LENGTH_SHORT).show();
                String string = Preferences.getInstance().getString(me, "UseUser", "UseUser");
                RequestUtlis.UserMassage = string;
                Gson gson = new Gson();
                final LoginBeanCode loginBeanCode = gson.fromJson(string, LoginBeanCode.class);
                EMMessage message = EMMessage.createTxtSendMessage("user", loginBeanCode.getData().getImUserInfo().getUserName());
                // 增加自己特定的属性
                message.setAttribute("icon", loginBeanCode.getData().getImUserInfo().getIcon());
                EMClient.getInstance().chatManager().sendMessage(message);
                String icon = message.getStringAttribute("icon", "http://www.ghost64.com/qqtupian/zixunImg/local/2018/09/07/15363017762367.jpeg");
                log(icon);
                startActivity(new Intent(getActivity(), ChatActivity.class).putExtra(EaseConstant.EXTRA_USER_ID, conversation.conversationId()));
            }
        });

        EMMessageListener msgListener = new EMMessageListener() {

            @Override
            public void onMessageReceived(List<EMMessage> messages) {
                easeConversationListFragment.refresh();
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
