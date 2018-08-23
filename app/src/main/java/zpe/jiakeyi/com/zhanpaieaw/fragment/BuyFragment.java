package zpe.jiakeyi.com.zhanpaieaw.fragment;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kongzue.baseframework.BaseFragment;
import com.kongzue.baseframework.interfaces.Layout;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.ArrayList;

import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.activity.buy.ReleaseForAty;
import zpe.jiakeyi.com.zhanpaieaw.activity.home.SeekActivity;
import zpe.jiakeyi.com.zhanpaieaw.adapter.MyPagerAdapter;
import zpe.jiakeyi.com.zhanpaieaw.fragment.buy.BuyAddFragment;

/**
 * 创建人： 郭健福
 * 创建时间： 2018/7/23 21:44
 * 功能描述：求购页面
 *
 * @author dell-pc
 */
@Layout(R.layout.fragment_buy)
public class BuyFragment extends BaseFragment {
    private ImageView title_back;
    private TextView title_name;
//    private ImageView title_seek;
    private TabLayout tab_news;
    private ViewPager vpa_news;
    private MyPagerAdapter myPagerAdapter;
    private ArrayList<String> titles;
    private AutoLinearLayout at_ll_title;
    private ImageView img_issue;


    @Override
    public void initViews() {
        me.setDarkStatusBarTheme(true);
        at_ll_title = findViewById(R.id.at_ll_title);
        title_back = findViewById(R.id.title_back);
        title_name = findViewById(R.id.title_name);
//        title_seek = findViewById(R.id.title_seek);
        tab_news = findViewById(R.id.tab_news);
        vpa_news = findViewById(R.id.vpa_news);
        img_issue = findViewById(R.id.img_issue);
        myPagerAdapter = new MyPagerAdapter(me.getSupportFragmentManager());
        title_name.setText("求购");
    }

    @Override
    public void initDatas() {
        at_ll_title.setY(me.getStatusBarHeight());
        ArrayList<Fragment> datas = new ArrayList<Fragment>();
        titles = new ArrayList<String>();
        titles.add("全部");
        titles.add("实验仪器");
        titles.add("服务");
        titles.add("家具");
        titles.add("仪器与耗材");
        datas.add(new BuyAddFragment(0, titles.get(0)));
        datas.add(new BuyAddFragment(1, titles.get(1)));
        datas.add(new BuyAddFragment(2, titles.get(2)));
        datas.add(new BuyAddFragment(3, titles.get(3)));
        datas.add(new BuyAddFragment(4, titles.get(4)));
        myPagerAdapter.setData(datas);
        myPagerAdapter.setTitles(titles);
        // 将适配器设置进ViewPager
        vpa_news.setAdapter(myPagerAdapter);
        // 将ViewPager与TabLayout相关联
        tab_news.setupWithViewPager(vpa_news);
    }


    @Override
    public void setEvents() {
//        title_seek.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                jump(SeekActivity.class);
//            }
//        });
        //跳转到发布界面
        img_issue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump(ReleaseForAty.class);
            }
        });
    }
}
