package zpe.jiakeyi.com.zhanpaieaw.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.kongzue.baseframework.BaseFragment;
import com.kongzue.baseframework.interfaces.DarkNavigationBarTheme;
import com.kongzue.baseframework.interfaces.DarkStatusBarTheme;
import com.kongzue.baseframework.interfaces.Layout;
import com.kongzue.baseframework.interfaces.NavigationBarBackgroundColor;
import com.kongzue.baseframework.util.JumpParameter;
import com.squareup.okhttp.Request;
import com.stx.xhb.xbanner.XBanner;
import com.sunfusheng.marqueeview.MarqueeView;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.activity.exhibition.ExhibitionActivity;
import zpe.jiakeyi.com.zhanpaieaw.activity.home.CategoryActivity;
import zpe.jiakeyi.com.zhanpaieaw.activity.home.NewsActivity;
import zpe.jiakeyi.com.zhanpaieaw.activity.home.ProductActivity;
import zpe.jiakeyi.com.zhanpaieaw.activity.home.SeekActivity;
import zpe.jiakeyi.com.zhanpaieaw.activity.home.ShowActivity;
import zpe.jiakeyi.com.zhanpaieaw.adapter.HomeRecyclerViewAdapter_new;
import zpe.jiakeyi.com.zhanpaieaw.adapter.HomeRecyclerViewAdapter_recommend;
import zpe.jiakeyi.com.zhanpaieaw.bean.HomeBean;
import zpe.jiakeyi.com.zhanpaieaw.utils.RequestUtlis;
import zpe.jiakeyi.com.zhanpaieaw.view.ObservableScrollView;

/**
 * 创建人： 郭健福
 * 创建时间： 2018/7/23 21:44
 * 功能描述：首页
 *
 * @author dell-pc
 */
@Layout(R.layout.fragment_home)
@DarkStatusBarTheme(true)           //开启顶部状态栏图标、文字暗色模式
@DarkNavigationBarTheme(true)       //开启底部导航栏按钮暗色模式
@NavigationBarBackgroundColor(a = 255,r = 255,g = 255,b = 255)      //设置底部导航栏背景颜色（a = 0,r = 0,g = 0,b = 0可透明）
public class HomeFragment extends BaseFragment implements View.OnClickListener {
    private ObservableScrollView home_obs_scroll;
    private AutoLinearLayout auto_sousuo;
    private XBanner xbanner;
    private ImageView homeSao;
    private MarqueeView marqueeView2;
    private RecyclerView RecyclerHomeNew;
    private RecyclerView RecyclerHomeRecommend;
    private static List images;
    private static HomeRecyclerViewAdapter_new homeRecyclerViewAdapter_new;
    private static HomeRecyclerViewAdapter_recommend homeRecyclerViewAdapter_recommend;
    private AutoLinearLayout img_yq;
    private AutoLinearLayout img_fw;
    private AutoLinearLayout img_jj;
    private AutoLinearLayout img_hc;
    private AutoLinearLayout news_title;
    private TextView more_new_rz;
    private RecyclerView Recycler_home_new;
    private TextView more_tj;
    private RecyclerView Recycler_home_recommend;
    private AutoLinearLayout seek_layout,home_auto_ll_title;

    private static List<HomeBean.DataBean.Adv1Bean> list;
    private static List<HomeBean.DataBean.ProductListBean> recommend;
    private static List<HomeBean.DataBean.StandListBean> exhibition;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void initViews() {
        home_auto_ll_title = findViewById(R.id.home_auto_ll_title);
        home_obs_scroll = findViewById(R.id.home_obs_scroll);
        xbanner = findViewById(R.id.xbanner);
        marqueeView2 = findViewById(R.id.marqueeView2);
        RecyclerHomeNew = findViewById(R.id.Recycler_home_new);
        RecyclerHomeRecommend = findViewById(R.id.Recycler_home_recommend);
        img_yq = findViewById(R.id.img_yq);
        img_fw = findViewById(R.id.img_fw);
        img_jj = findViewById(R.id.img_jj);
        img_hc = findViewById(R.id.img_hc);
        seek_layout = findViewById(R.id.seek_layout);
        news_title = findViewById(R.id.news_title);
        more_new_rz = findViewById(R.id.more_new_rz);
        more_tj = findViewById(R.id.more_tj);
        Recycler_home_recommend = findViewById(R.id.Recycler_home_recommend);
        auto_sousuo = findViewById(R.id.auto_sousuo);
        me.setDarkStatusBarTheme(true);//白色
        list = new ArrayList<>();
        recommend = new ArrayList<>();
        exhibition = new ArrayList<>();
//        DarkStatusBarTheme
        news_title.setOnClickListener(this);
        img_yq.setOnClickListener(this);
        img_fw.setOnClickListener(this);
        img_jj.setOnClickListener(this);
        img_hc.setOnClickListener(this);
        seek_layout.setOnClickListener(this);
        more_new_rz.setOnClickListener(this);
        more_tj.setOnClickListener(this);
        requestData();
    }

    public void requestData() {
        OkHttpUtils
                .post()
                .addParams("", "")
                .url(RequestUtlis.HP)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        HomeBean homeBean = gson.fromJson(response, HomeBean.class);
                        list = homeBean.getData().getAdv1();
                        images = new ArrayList<String>();
                        recommend = homeBean.getData().getProductList();
                        exhibition = homeBean.getData().getStandList();
                        for (int i = 0; i < list.size(); i++) {
                            images.add(list.get(i).getUrl());
                        }
                        //实例化

                        Log.i("11", "initDatas: " + images.get(1));

                        // 为XBanner绑定数据
                        xbanner.setData(images, null);
// XBanner适配数据
                        xbanner.setmAdapter(new XBanner.XBannerAdapter() {
                            @Override
                            public void loadBanner(XBanner banner, Object model, View view, int position) {
//                Glide.with(getActivity()).load(images.get(position)).error(R.mipmap.banner).into((ImageView) view);
                                Glide.with(getActivity()).load(images.get(position)).apply(new RequestOptions().error(R.mipmap.banner)).into((ImageView) view);
                            }

                        });
                        List<String> info = new ArrayList<>();
                        List<HomeBean.DataBean.Adv2Bean> adv2 = homeBean.getData().getAdv2();
                        for (int i = 0; i < adv2.size(); i++) {
                            info.add(adv2.get(i).getContent());
                        }
                        marqueeView2.startWithList(info);
                        RecyclerHomeNew.setLayoutManager(new GridLayoutManager(getActivity(), 3, OrientationHelper.VERTICAL, false));
                        homeRecyclerViewAdapter_new = new HomeRecyclerViewAdapter_new(R.layout.home_recycler_new_item, exhibition);
                        RecyclerHomeNew.setAdapter(homeRecyclerViewAdapter_new);
                        RecyclerHomeRecommend.setLayoutManager(new GridLayoutManager(getActivity(), 3, OrientationHelper.VERTICAL, false));
                        homeRecyclerViewAdapter_recommend = new HomeRecyclerViewAdapter_recommend(R.layout.home_recycler_recommend, recommend);
                        RecyclerHomeRecommend.setAdapter(homeRecyclerViewAdapter_recommend);
                        homeRecyclerViewAdapter_recommend.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                toast("你点击了第" + position + "条");
                                jump(ExhibitionActivity.class);
                                ExhibitionActivity.IntentOne(list.get(position).getId());
                            }
                        });

                        homeRecyclerViewAdapter_new.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                toast("你点击了第" + position + "条");
                                //跳转到商品详情界面
                                jump(ProductActivity.class);


                            }
                        });
                    }
                });
        OkHttpUtils.post().url("http://192.168.1.180/ot/loadType")
                .addParams("", "").build().execute(new StringCallback() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(String response) {

            }
        });
    }

    @Override
    public void initDatas() {


    }

    private SpannableString NewsTitleText(String label, String msg) {
        if (msg.length() >= 18) {
            String substring = msg.substring(0, 14);
            substring = substring + "...";
            Log.i("lala", "NewsTitleText: " + substring);
            return NewsTitleText(label, substring);
        } else {
            SpannableString spannableString = new SpannableString(label + "   " + msg);
            ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#fb533b"));
            ForegroundColorSpan colorSpan2 = new ForegroundColorSpan(Color.parseColor("#333333"));
            spannableString.setSpan(colorSpan, 0, label.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            spannableString.setSpan(colorSpan2, label.length() + 3, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            return spannableString;
        }
    }


    @Override
    public void setEvents() {

    }

    @Override
    public void onStart() {
        super.onStart();
        marqueeView2.startFlipping();
    }

    @Override
    public void onStop() {
        super.onStop();
        marqueeView2.stopFlipping();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //跳转新闻页面
            case R.id.news_title:
                jump(NewsActivity.class);
                break;
            //跳转实验室仪器页面
            case R.id.img_yq:
                jump(CategoryActivity.class, new JumpParameter().put("类型", "1"));
                break;
            //跳转实验室服务页面
            case R.id.img_fw:
                jump(CategoryActivity.class, new JumpParameter().put("类型", "2"));
                break;
            //跳转实验室家具界面
            case R.id.img_jj:
                jump(CategoryActivity.class, new JumpParameter().put("类型", "3"));
                break;
            //跳转试剂与耗材页面
            case R.id.img_hc:
                jump(CategoryActivity.class, new JumpParameter().put("类型", "4"));
                break;
            //最新入驻的查看全部页面
            case R.id.more_new_rz:
                jump(ShowActivity.class, new JumpParameter().put("是否显示分类栏", true));
                break;
            //推荐产品的查看全部页面
            case R.id.more_tj:
                jump(ShowActivity.class);

                break;
            //搜索框的跳转事件
            case R.id.seek_layout:
                jump(SeekActivity.class);
                break;
            default:
        }
    }
}
