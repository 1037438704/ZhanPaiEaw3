package zpe.jiakeyi.com.zhanpaieaw.activity.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.kongzue.baseframework.interfaces.DarkStatusBarTheme;
import com.kongzue.baseframework.interfaces.Layout;
import com.kongzue.baseframework.util.JumpParameter;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;
import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.adapter.CategoryListAdapter;
import zpe.jiakeyi.com.zhanpaieaw.library.bean.sysBean;
import zpe.jiakeyi.com.zhanpaieaw.fragment.home.GoodsFragment;
import zpe.jiakeyi.com.zhanpaieaw.library.utils.RequestUtlis;
import zpe.jiakeyi.com.zhanpaieaw.view.MainViewPager;

/**
 * 创建人： 郭健福
 * 创建时间： 2018/7/23 21:44
 * 功能描述：分类列表页
 *
 * @author dell-pc
 */
@Layout(R.layout.activity_category)
@DarkStatusBarTheme(true) //开启顶部状态栏图标、文字暗色模式
public class CategoryActivity extends com.kongzue.baseframework.BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {


    private ImageView img_search_category;
    private TextView title_name_home;
    private ImageView fh_fl;
    private CategoryListAdapter categoryListAdapter;
    private List<sysBean.DataBean.ListBeanXX> mDatas;
    private int mPosition;
    private ListView listview_category;
    private MainViewPager viewpager_category;
    private ShopAdapter shopAdapter;


    @Override
    public void initViews() {
        img_search_category = (ImageView) findViewById(R.id.img_search_category);
        fh_fl = (ImageView) findViewById(R.id.fh_fl);
        fh_fl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        listview_category = (ListView) findViewById(R.id.listview_category);
        title_name_home = (TextView) findViewById(R.id.title_name_home);
        listview_category.setOnItemClickListener(this);


    }

    @Override
    public void initDatas(JumpParameter paramer) {
        final String type = paramer.getString("类型");
        switch (type) {
            case "1":
                title_name_home.setText("实验室仪器");
                break;
            case "2":
                title_name_home.setText("实验室服务");

                break;
            case "3":
                title_name_home.setText("实验室家具");

                break;

            case "4":
                title_name_home.setText("试剂与耗材");

                break;
        }
        OkHttpUtils
                .post()
                .url(RequestUtlis.sTs)
                .addParams("i", type)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        log(response);
                        Gson gson = new Gson();
                        sysBean bean = gson.fromJson(response, sysBean.class);
                        mDatas = bean.getData().getList();
                        viewpager_category = (MainViewPager) findViewById(R.id.viewpager_category);
                        categoryListAdapter = new CategoryListAdapter(me, mDatas);
                        listview_category.setAdapter(categoryListAdapter);
                        viewpager_category.setCurrentItem(0);
                        shopAdapter = new ShopAdapter(getSupportFragmentManager());
                        viewpager_category.setAdapter(shopAdapter);
                    }

                });
    }

    @Override
    public void setEvents() {
        img_search_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump(SeekActivity.class);
            }
        });

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //点击listView回滚居中
        mPosition = position;
//        int totalHeight = listview.getMeasuredHeight() - 120;
//        listview.smoothScrollToPositionFromTop(mPosition, totalHeight / 2, 50);
        //改变条目选中时候的样式，刷新adapter
        categoryListAdapter.setPosition(mPosition);
        categoryListAdapter.notifyDataSetChanged();
        viewpager_category.setCurrentItem(mPosition, false);
    }

    @Override
    public void onClick(View v) {

    }

    private class ShopAdapter extends FragmentPagerAdapter {
        ShopAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int arg0) {
            Fragment fragment = new GoodsFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("GoodsFragment", mDatas.get(arg0));
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return mDatas != null ? mDatas.size() : 0;
        }
    }

}
