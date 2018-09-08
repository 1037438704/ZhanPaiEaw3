package zpe.jiakeyi.com.zhanpaieaw.activity.home;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.kongzue.baseframework.BaseActivity;
import com.kongzue.baseframework.interfaces.DarkStatusBarTheme;
import com.kongzue.baseframework.interfaces.Layout;
import com.kongzue.baseframework.util.JumpParameter;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;
import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.adapter.SeekShowAdapter;
import zpe.jiakeyi.com.zhanpaieaw.library.bean.SeekShowBean;
import zpe.jiakeyi.com.zhanpaieaw.library.utils.RequestUtlis;

@Layout(R.layout.activity_seek_show)
@DarkStatusBarTheme(true)
public class SeekShowActivity extends BaseActivity {
    private ImageView return_img_seek;
    private TextView seek_content_tv;
    private AutoLinearLayout seek_title;
    private ImageView search_title;
    private AutoLinearLayout seek_title_layout;
    private RecyclerView recycle_seek_show_home;

    @Override
    public void initViews() {
        return_img_seek = findViewById(R.id.return_img_seek);
        seek_content_tv = findViewById(R.id.seek_content_tv);
        seek_title = findViewById(R.id.seek_title);
        search_title = findViewById(R.id.search_title);
        seek_title_layout = findViewById(R.id.seek_title_layout);
        recycle_seek_show_home = findViewById(R.id.recycle_seek_show_home);

    }

    @Override
    public void initDatas(JumpParameter paramer) {
        if (paramer != null) {
            String textContent = paramer.getString("TextContent");
            seek_content_tv.setText(textContent);
            OkHttpUtils.post()
                    .url(RequestUtlis.selPWeb)
                    .addHeader("loginType", "1")
                    .addParams("str", textContent)
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {

                        }

                        @Override
                        public void onResponse(String response, int id) {
                            Gson gson = new Gson();
                            SeekShowBean seekShowBean = gson.fromJson(response, SeekShowBean.class);
                            List<SeekShowBean.DataBean.ListBean> list = seekShowBean.getData().getList();
                            SeekShowAdapter seekShowAdapter = new SeekShowAdapter(R.layout.recycler_show_home_item, list);
                            recycle_seek_show_home.setLayoutManager(new GridLayoutManager(me, 2, OrientationHelper.VERTICAL, false));
                            recycle_seek_show_home.setAdapter(seekShowAdapter);
                            seekShowAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                                @Override
                                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                                    jump(ProductActivity.class);
                                }
                            });
                        }

                    });
        }

    }


    @Override
    public void setEvents() {
        return_img_seek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        seek_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump(SeekActivity.class);
            }
        });
    }

}
