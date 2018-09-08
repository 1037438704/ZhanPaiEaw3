package zpe.jiakeyi.com.zhanpaieaw.fragment.message;

import com.google.gson.Gson;

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
import zpe.jiakeyi.com.zhanpaieaw.adapter.SystemAdapter;
import zpe.jiakeyi.com.zhanpaieaw.library.bean.SystemMassageBean;

import zpe.jiakeyi.com.zhanpaieaw.library.utils.RequestUtlis;

/**
 * A simple {@link Fragment} subclass.
 */
@Layout(R.layout.fragment_system)
public class SystemFragment extends BaseFragment {

    private RecyclerView system_massage;

    @Override
    public void onStart() {
        super.onStart();

    }

    public SystemFragment() {
        // Required empty public constructor
    }

    @Override
    public void initViews() {
        system_massage = findViewById(R.id.system_massage);
        LinearLayoutManager MassageManager = new LinearLayoutManager(me);
        MassageManager.setOrientation(LinearLayoutManager.VERTICAL);
        system_massage.setLayoutManager(MassageManager);
        if (RequestUtlis.ID != null) {
            getData();
        }
    }

    public void getData() {
        OkHttpUtils.post().url(RequestUtlis.sAty)
                .addHeader("loginType", "1")
                .addParams("userId", RequestUtlis.ID)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Gson gson = new Gson();
                        SystemMassageBean systemMassageBean = gson.fromJson(response, SystemMassageBean.class);
                        List<SystemMassageBean.DataBean.ListBean> list = systemMassageBean.getData().getList();
                        SystemAdapter systemAdapter = new SystemAdapter(R.layout.system_massage_item, list);
                        system_massage.setAdapter(systemAdapter);
                    }

                });

    }

    @Override
    public void initDatas() {

    }

    @Override
    public void setEvents() {

    }
}
