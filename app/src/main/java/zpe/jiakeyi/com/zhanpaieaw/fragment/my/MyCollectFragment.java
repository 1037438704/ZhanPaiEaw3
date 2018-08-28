package zpe.jiakeyi.com.zhanpaieaw.fragment.my;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.kongzue.baseframework.BaseFragment;
import com.kongzue.baseframework.interfaces.Layout;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;
import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.activity.home.ProductActivity;
import zpe.jiakeyi.com.zhanpaieaw.adapter.showpinAdapter;
import zpe.jiakeyi.com.zhanpaieaw.bean.ShowBean;
import zpe.jiakeyi.com.zhanpaieaw.utils.RequestUtlis;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
@Layout(R.layout.fragment_my_collect)
public class MyCollectFragment extends BaseFragment {
    private int count;
    private RecyclerView recy_buy_buy;

    public MyCollectFragment(int count) {
        this.count = count;
    }

    @Override
    public void initViews() {
        recy_buy_buy = findViewById(R.id.recy_buy_buy);

    }

    @Override
    public void initDatas() {
        if (count == 2) {
            Log.i("token", "onResponse: " + RequestUtlis.Token);

            recy_buy_buy.setLayoutManager(new GridLayoutManager(me, 2, OrientationHelper.VERTICAL, false));
            OkHttpUtils.post().url(RequestUtlis.selCollP)
                    .addHeader("ACCESS_TOKEN", RequestUtlis.Token)
                    .addParams("", "")
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {
                            log(e);
                            Toast.makeText(me, "" + e, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onResponse(String response, int id) {
                            Toast.makeText(me, "" + response, Toast.LENGTH_SHORT).show();
                            Gson gson = new Gson();
                            ShowBean showBean = gson.fromJson(response, ShowBean.class);
                            List<ShowBean.DataBean.ListBean> list = showBean.getData().getList();
                            showpinAdapter showpinAdapter = new showpinAdapter(R.layout.recycler_show_home_item, list);
                            showpinAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                                @Override
                                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                                    jump(ProductActivity.class);
                                }
                            });
                            recy_buy_buy.setAdapter(showpinAdapter);
                        }
                    });

        } else if (count == 3) {
            LinearLayoutManager MassageManager = new LinearLayoutManager(me);
            MassageManager.setOrientation(LinearLayoutManager.VERTICAL);
            recy_buy_buy.setLayoutManager(MassageManager);
            OkHttpUtils.post().url(RequestUtlis.selCollP)
                    .addHeader("loginType", "1")
                    .addParams("ACCESS_TOKEN", RequestUtlis.Token)
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {

                        }

                        @Override
                        public void onResponse(String response, int id) {

                        }

                    });
        }
    }

    @Override
    public void setEvents() {

    }

}
