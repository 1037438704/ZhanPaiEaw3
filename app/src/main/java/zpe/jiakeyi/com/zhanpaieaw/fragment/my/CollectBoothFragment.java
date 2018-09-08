package zpe.jiakeyi.com.zhanpaieaw.fragment.my;

import com.google.gson.Gson;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kongzue.baseframework.BaseFragment;
import com.kongzue.baseframework.interfaces.Layout;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;
import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.adapter.unslovedAdapter;
import zpe.jiakeyi.com.zhanpaieaw.library.bean.solveBean;
import zpe.jiakeyi.com.zhanpaieaw.library.bean.unsolvedBean;
import zpe.jiakeyi.com.zhanpaieaw.library.utils.RequestUtlis;
/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
@Layout(R.layout.fragment_blank_fragment2)
public class CollectBoothFragment extends BaseFragment {
    private int count;
    private RecyclerView recy_collect_fm;

    public CollectBoothFragment(int count) {
        this.count = count;
    }

    @Override
    public void initViews() {
        recy_collect_fm = findViewById(R.id.recy_collect_fm);
    }

    @Override
    public void initDatas() {
        if (count == 0) {
            LinearLayoutManager MassageManager = new LinearLayoutManager(me);
            MassageManager.setOrientation(LinearLayoutManager.VERTICAL);
            recy_collect_fm.setLayoutManager(MassageManager);
            OkHttpUtils.post().url(RequestUtlis.sAu)
                    .addHeader("loginType", "1")
                    .addParams("pageSize", "100")
                    .addParams("pageNum", "1")
                    .addParams("userId", RequestUtlis.ID)
                    .addParams("solveStatus", "1")
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {

                        }

                        @Override
                        public void onResponse(String response, int id) {
                            Gson gson = new Gson();
                            solveBean solveBean = gson.fromJson(response, solveBean.class);
                        }

                    });
        } else if (count == 1) {
            LinearLayoutManager MassageManager = new LinearLayoutManager(me);
            MassageManager.setOrientation(LinearLayoutManager.VERTICAL);
            recy_collect_fm.setLayoutManager(MassageManager);
            OkHttpUtils.post().url(RequestUtlis.sAu)
                    .addHeader("loginType", "1")
                    .addParams("pageSize", "100")
                    .addParams("pageNum", "1")
                    .addParams("userId", RequestUtlis.ID)
                    .addParams("solveStatus", "0")
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {

                        }

                        @Override
                        public void onResponse(String response, int id) {
                            Gson gson = new Gson();
                            unsolvedBean unsolvedBean = gson.fromJson(response, unsolvedBean.class);
                            List<zpe.jiakeyi.com.zhanpaieaw.library.bean.unsolvedBean.DataBean.ListBeanX.ListBean> list = unsolvedBean.getData().getList().getList();
                            unslovedAdapter unslovedAdapter = new unslovedAdapter(R.layout.item_jiejue_adapter2, list);
                            recy_collect_fm.setAdapter(unslovedAdapter);
                        }

                    });
        }
//        lists.add("未解决");
//        lists.add("已解决");
//        lists.add("已解决");
//        lists.add("已解决");
//        lists.add("已解决");
//        lists.add("已解决");
//        lists.add("已解决");
//        lists.add("已解决");
//        data.add(new ExhibitsFragment(count, 0));
//        data.add(new ExhibitsFragment(count, 1));
//        data.add(new ExhibitsFragment(count, 2));
//        data.add(new ExhibitsFragment(count, 3));
//        data.add(new ExhibitsFragment(count, 4));
//        data.add(new ExhibitsFragment(count, 5));
//        data.add(new ExhibitsFragment(count, 6));
//        data.add(new ExhibitsFragment(count, 7));
//
//        myFragmentAdapter = new MyCollectFragmentAdapter(getChildFragmentManager(), data, lists);
//
//        fragment_viewpager.setAdapter(myFragmentAdapter);
//        // 将ViewPager与TabLayout相关联
//        fragment_tab.setupWithViewPager(fragment_viewpager);
    }

    @Override
    public void setEvents() {

    }
}
