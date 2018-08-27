package zpe.jiakeyi.com.zhanpaieaw.fragment.message;

import com.google.gson.Gson;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kongzue.baseframework.BaseFragment;
import com.kongzue.baseframework.interfaces.Layout;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.activity.login.LoginActivity;
import zpe.jiakeyi.com.zhanpaieaw.adapter.SystemAdapter;
import zpe.jiakeyi.com.zhanpaieaw.bean.SystemMassageBean;
import zpe.jiakeyi.com.zhanpaieaw.utils.RequestUtlis;

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
                    public void onError(Request request, Exception e) {
                    }

                    @Override
                    public void onResponse(String response) {
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
