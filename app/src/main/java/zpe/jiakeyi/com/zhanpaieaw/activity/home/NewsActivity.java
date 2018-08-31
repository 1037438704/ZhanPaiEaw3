package zpe.jiakeyi.com.zhanpaieaw.activity.home;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kongzue.baseframework.BaseActivity;
import com.kongzue.baseframework.interfaces.DarkNavigationBarTheme;
import com.kongzue.baseframework.interfaces.DarkStatusBarTheme;
import com.kongzue.baseframework.interfaces.Layout;
import com.kongzue.baseframework.interfaces.NavigationBarBackgroundColor;
import com.kongzue.baseframework.util.JumpParameter;

import java.util.ArrayList;

import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.adapter.MyPagerAdapter;
import zpe.jiakeyi.com.zhanpaieaw.fragment.home.NewsFragment;

/**
 * 创建人： 郭健福
 * 创建时间： 2018/7/23 21:44
 * 功能描述：新闻列表页
 *
 * @author dell-pc
 */
@Layout(R.layout.activity_news)
@DarkStatusBarTheme(true) //开启顶部状态栏图标、文字暗色模式
public class NewsActivity extends BaseActivity {

    private ImageView title_back;
    private TextView title_name;
    private ImageView title_seek;
    private TabLayout tab_news;
    private ViewPager vpa_news;
    private MyPagerAdapter myPagerAdapter;
    private ArrayList<String> titles;

    @Override
    public void initViews() {
        title_back = findViewById(R.id.title_back);
        title_name = findViewById(R.id.title_name);
        title_seek = findViewById(R.id.title_seek);
        tab_news = findViewById(R.id.tab_news);
        vpa_news = findViewById(R.id.vpa_news);
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        title_name.setText("平台快报");
    }

    @Override
    public void initDatas(JumpParameter paramer) {
        ArrayList<Fragment> datas = new ArrayList<Fragment>();
        titles = new ArrayList<String>();
        titles.add("精选");
        titles.add("平台动态");
        titles.add("行业新闻");
        titles.add("政策法规");
        datas.add(addFragment(0, titles.get(0)));
        datas.add(addFragment(1, titles.get(1)));
        datas.add(addFragment(2, titles.get(2)));
        datas.add(addFragment(3, titles.get(3)));
        myPagerAdapter.setData(datas);

        myPagerAdapter.setTitles(titles);
        // 将适配器设置进ViewPager
        vpa_news.setAdapter(myPagerAdapter);
        // 将ViewPager与TabLayout相关联
        tab_news.setupWithViewPager(vpa_news);

    }

    private Fragment addFragment(int count, String title) {
        Fragment fragment = new NewsFragment(count, titles.get(count));
        return fragment;
    }

    @Override
    public void setEvents() {
        title_seek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump(SeekActivity.class);
            }
        });
        title_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
