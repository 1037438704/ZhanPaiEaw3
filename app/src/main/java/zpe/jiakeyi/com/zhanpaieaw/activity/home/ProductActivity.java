package zpe.jiakeyi.com.zhanpaieaw.activity.home;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.kongzue.baseframework.BaseActivity;
import com.kongzue.baseframework.interfaces.DarkStatusBarTheme;
import com.kongzue.baseframework.interfaces.Layout;
import com.kongzue.baseframework.util.JumpParameter;
import com.stx.xhb.xbanner.XBanner;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;
import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.activity.login.LoginActivity;
import zpe.jiakeyi.com.zhanpaieaw.library.bean.prodictBean;
import zpe.jiakeyi.com.zhanpaieaw.library.utils.RequestUtlis;

/**
 * @author dell-pc
 * @date 2018/7/25
 * 功能描述:商品详情界面
 */
@Layout(R.layout.activity_product)
@DarkStatusBarTheme(true)
public class ProductActivity extends BaseActivity {

    private WebView web_product;
    private ImageView back_pd;
    private ImageView share_pd;
    private ImageView sc_pd;
    private XBanner xbanner;
    private TextView cp_titler;
    private TextView gs_name;
    private TextView dq_tv;
    private TextView cslx_tv;
    private TextView pp_tv;
    private TextView xh_tv;
    private TextView yyly_id;
    private ImageView rt_top;
    private ScrollView sc_id;
    public static String mid;
    private List<prodictBean.DataBean.ImgListBean> list;

    @Override
    public void initViews() {

        web_product = findViewById(R.id.web_product);
        back_pd = findViewById(R.id.back_pd);
        share_pd = findViewById(R.id.share_pd);
        sc_pd = findViewById(R.id.sc_pd);
        xbanner = findViewById(R.id.xbanner);
        cp_titler = findViewById(R.id.cp_titler);
        gs_name = findViewById(R.id.gs_name);
        dq_tv = findViewById(R.id.dq_tv);
        cslx_tv = findViewById(R.id.cslx_tv);
        pp_tv = findViewById(R.id.pp_tv);
        xh_tv = findViewById(R.id.xh_tv);
        yyly_id = findViewById(R.id.yyly_id);
        rt_top = findViewById(R.id.rt_top);
        sc_id = findViewById(R.id.sc_id);
    }

    @Override
    public void initDatas(JumpParameter paramer) {
        if (paramer == null) {
            Bundle extras = getIntent().getExtras();
            String id = extras.getString("id");
            OkHttpUtils.post().url(RequestUtlis.getP)
                    .addHeader("loginType", "1")
                    .addParams("id", id)
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {

                        }

                        @Override
                        public void onResponse(String response, int id) {
                            Gson gson = new Gson();
                            prodictBean prodictBean = gson.fromJson(response, prodictBean.class);
                            zpe.jiakeyi.com.zhanpaieaw.library.bean.prodictBean.DataBean.InfoBean info = prodictBean.getData().getInfo();
                            list = prodictBean.getData().getImgList();
                            xbanner.setData(list, null);
                            // XBanner适配数据
                            xbanner.setmAdapter(new XBanner.XBannerAdapter() {
                                @Override
                                public void loadBanner(XBanner banner, Object model, View view, int position) {
                                    Glide.with(ProductActivity.this).load(list.get(position).getUrl()).error(R.mipmap.product_img_details).into((ImageView) view);
                                }

                            });
                            if (info != null) {
                                cp_titler.setText(info.getPname());
                                gs_name.setText(info.getFirmName());
                                dq_tv.setText(info.getAreaB() + "   " + info.getAreaC());
                                cslx_tv.setText(info.getFirmType() + "");
                                pp_tv.setText(info.getBrandName());
                                xh_tv.setText(info.getVersion());
                                yyly_id.setText(info.getField());
                                mid = info.getId();
                            }

                        }
                    });
            web_product.loadUrl("http://m.baidu.com/?cip=117.136.54.19&amp;baiduid=B02FA207E9F6316421974343BBAC55C0&amp;from=844b&amp;vit=fps?from=844b&amp;vit=fps&amp;index=&amp;ssid=0&amp;bd_page_type=1&amp;logid=7938441944509756072&pu=sz%401321_480&t_noscript=jump");

        } else {
            String id = paramer.getString("id");
            OkHttpUtils.post().url(RequestUtlis.getP)
                    .addHeader("loginType", "1")
                    .addParams("id", id)
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {

                        }

                        @Override
                        public void onResponse(String response, int id) {
                            Gson gson = new Gson();
                            prodictBean prodictBean = gson.fromJson(response, prodictBean.class);
                            zpe.jiakeyi.com.zhanpaieaw.library.bean.prodictBean.DataBean.InfoBean info = prodictBean.getData().getInfo();
                            list = prodictBean.getData().getImgList();
                            xbanner.setData(list, null);
                            // XBanner适配数据
                            xbanner.setmAdapter(new XBanner.XBannerAdapter() {
                                @Override
                                public void loadBanner(XBanner banner, Object model, View view, int position) {
                                    Glide.with(ProductActivity.this).load(list.get(position).getUrl()).error(R.mipmap.product_img_details).into((ImageView) view);
                                }

                            });
                            if (info != null) {
                                cp_titler.setText(info.getPname());
                                gs_name.setText(info.getFirmName());
                                dq_tv.setText(info.getAreaB() + "   " + info.getAreaC());
                                cslx_tv.setText(info.getFirmType() + "");
                                pp_tv.setText(info.getBrandName());
                                xh_tv.setText(info.getVersion());
                                yyly_id.setText(info.getField());
                                mid = info.getId();
                            }

                        }
                    });
            web_product.loadUrl("http://m.baidu.com/?cip=117.136.54.19&amp;baiduid=B02FA207E9F6316421974343BBAC55C0&amp;from=844b&amp;vit=fps?from=844b&amp;vit=fps&amp;index=&amp;ssid=0&amp;bd_page_type=1&amp;logid=7938441944509756072&pu=sz%401321_480&t_noscript=jump");

        }
    }


    @Override
    public void setEvents() {
        rt_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sc_id.scrollTo(0, 0);
            }
        });
        sc_pd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (RequestUtlis.Token != "") {
                    Log.i("请求", "onClick: " + RequestUtlis.ID + mid);
                    OkHttpUtils.post().url(RequestUtlis.ifCP)
                            .addHeader("loginType", "1")
                            .addParams("userId", RequestUtlis.ID)
                            .addParams("productId", mid)
                            .build()
                            .execute(new StringCallback() {
                                @Override
                                public void onError(Call call, Exception e, int id) {

                                }

                                @Override
                                public void onResponse(String response, int id) {
                                    Toast.makeText(me, "" + response, Toast.LENGTH_SHORT).show();

                                }

                            });
                } else if (RequestUtlis.Token == null) {
                    jump(LoginActivity.class);
                    Toast.makeText(me, "您还没有登录哦!请先登录", Toast.LENGTH_SHORT).show();
                }

            }
        });
        back_pd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}
