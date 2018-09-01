package zpe.jiakeyi.com.zhanpaieaw.fragment;


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
    private static Map<String, EaseUser> contacts;

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

    private Map<String, EaseUser> getContacts() {
        final Gson gson = new Gson();
        String s = gson.toJson(usernames);
        OkHttpUtils.post().url(RequestUtlis.getImUserInfo)
                .addHeader("ACCESS_TOKEN", RequestUtlis.Token)
                .addParams("userList", s)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        contacts = new HashMap<String, EaseUser>();
                        HuanXinUsers huanXinUsers = gson.fromJson(response, HuanXinUsers.class);
                        userInfoList = huanXinUsers.getData().getUserInfoList();
                        for (int i = 0; i <= userInfoList.size() - 1; i++) {
                            EaseUser user = new EaseUser(userInfoList.get(i).getUserName());
                            contacts.put(userInfoList.get(i).getNickName(), user);
                        }
                        Log.i("contacts", "onResponse: " + contacts);
                    }
                });
        Log.i("json", "getContacts: " + s);
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
                Log.d("usernames", "initDatas: " + usernames);
                Map<String, EaseUser> contacts = getContacts();
                contactListFragment.setContactsMap(contacts);
            } catch (HyphenateException e) {
                e.printStackTrace();
                Log.d("usernames", "initDatas: " + e);
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
    }

}
