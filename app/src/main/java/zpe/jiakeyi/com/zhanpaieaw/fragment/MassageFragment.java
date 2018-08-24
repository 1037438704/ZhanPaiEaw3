package zpe.jiakeyi.com.zhanpaieaw.fragment;


import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.kongzue.baseframework.BaseFragment;
import com.kongzue.baseframework.interfaces.Layout;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.ArrayList;
import java.util.List;

import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.adapter.MyCollectAdapter;
import zpe.jiakeyi.com.zhanpaieaw.adapter.MyCollectFragmentAdapter;
import zpe.jiakeyi.com.zhanpaieaw.fragment.message.FriendFragment;
import zpe.jiakeyi.com.zhanpaieaw.fragment.message.SystemFragment;
import zpe.jiakeyi.com.zhanpaieaw.fragment.message.UserFragment;

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
        data.add(new UserFragment());
        data.add(new SystemFragment());
        data.add(new FriendFragment());
        MyCollectFragmentAdapter myAdaptre = new MyCollectFragmentAdapter(getChildFragmentManager(), data, lists);
        viewpager.setAdapter(myAdaptre);
        viewpager.setCurrentItem(0);

        tablayout_xiaoxi.addTab(tablayout_xiaoxi.newTab().setText(lists.get(0)));
        tablayout_xiaoxi.addTab(tablayout_xiaoxi.newTab().setText(lists.get(1)));
        tablayout_xiaoxi.setupWithViewPager(viewpager);//把tablayout和viewpage绑定在一起
    }

    @Override
    public void setEvents() {

    }

}
