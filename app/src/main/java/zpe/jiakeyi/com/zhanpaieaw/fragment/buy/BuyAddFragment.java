package zpe.jiakeyi.com.zhanpaieaw.fragment.buy;


import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.kongzue.baseframework.BaseFragment;
import com.kongzue.baseframework.interfaces.Layout;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;
import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.activity.buy.ParticularsActivity;
import zpe.jiakeyi.com.zhanpaieaw.adapter.BuyAddFgtAdapter;
import zpe.jiakeyi.com.zhanpaieaw.bean.BuyListAllBean;
import zpe.jiakeyi.com.zhanpaieaw.utils.RequestUtlis;

/**
 * A simple {@link Fragment} subclass.
 *
 * @author dell-pc
 *         功能描述 求购界面的
 */
@SuppressLint("ValidFragment")
@Layout(R.layout.fragment_buy_add)
public class BuyAddFragment extends BaseFragment {
    private int count;
    private RecyclerView recyclerView;
    private List<BuyListAllBean.DataBean.ListBeanX.ListBean> list;
    private static BuyAddFgtAdapter buyAddFgtAdapter;
    private String title;

    public BuyAddFragment(int count, String title) {
        this.count = count;
        this.title = title;
    }

    @Override
    public void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        //创建布局管理
        LinearLayoutManager layoutManager = new LinearLayoutManager(me);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void requestData(final int count) {
        if (count == 0) {
            OkHttpUtils.post().url(RequestUtlis.SATY).addParams("typea", "")
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {

                        }

                        @Override
                        public void onResponse(String response, int id) {
                            Gson gson = new Gson();
                            BuyListAllBean buyListAllBean = gson.fromJson(response, BuyListAllBean.class);
                            list = buyListAllBean.getData().getList().getList();
                            buyAddFgtAdapter = new BuyAddFgtAdapter(R.layout.item_buy_add_fgt, BuyAddFragment.this.list);
                            recyclerView.setAdapter(buyAddFgtAdapter);
                            buyAddFgtAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                    jump(ParticularsActivity.class);
                                }
                            });
                        }

                    });
        } else {
            OkHttpUtils.post().url(RequestUtlis.SATY).addParams("typea", count - 1 + "")
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {

                        }

                        @Override
                        public void onResponse(String response, int id) {
                            Gson gson = new Gson();
                            Log.i("问题?", "onResponse: " + response);
                            BuyListAllBean buyListAllBean = gson.fromJson(response, BuyListAllBean.class);
                            list = buyListAllBean.getData().getList().getList();
                            buyAddFgtAdapter = new BuyAddFgtAdapter(R.layout.item_buy_add_fgt, list);
                            recyclerView.setAdapter(buyAddFgtAdapter);
                            buyAddFgtAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                    jump(ParticularsActivity.class);
                                }
                            });
                        }

                    });
        }

    }


    @Override
    public void initDatas() {
        if (count == 0 && title.equals("全部")) {
            requestData(count);

        } else if (count == 1 && title.equals("实验仪器")) {
            requestData(count);
        } else if (count == 2 && title.equals("服务")) {
            requestData(count);
        } else if (count == 3 && title.equals("家具")) {
            requestData(count);
        } else if (count == 4 && title.equals("仪器耗材")) {
            requestData(count);
        }

    }

    @Override
    public void setEvents() {

    }

}
