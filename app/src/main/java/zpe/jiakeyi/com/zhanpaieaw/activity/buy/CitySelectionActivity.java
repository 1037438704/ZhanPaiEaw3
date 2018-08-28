package zpe.jiakeyi.com.zhanpaieaw.activity.buy;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.kongzue.baseframework.BaseActivity;
import com.kongzue.baseframework.interfaces.DarkStatusBarTheme;
import com.kongzue.baseframework.interfaces.Layout;
import com.kongzue.baseframework.util.JumpParameter;
import com.kongzue.baseframework.util.Preferences;

import java.util.List;

import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.adapter.BeanXAdapter;
import zpe.jiakeyi.com.zhanpaieaw.adapter.CityAdapter;
import zpe.jiakeyi.com.zhanpaieaw.adapter.ListAdapter;
import zpe.jiakeyi.com.zhanpaieaw.bean.CityBean;
import zpe.jiakeyi.com.zhanpaieaw.bean.CityDataBean;
import zpe.jiakeyi.com.zhanpaieaw.utils.RequestUtlis;

/**
 * @author Gjianfu
 * @date 2018/8/16
 * 功能描述:
 */

@Layout(R.layout.activity_city_selection)
@DarkStatusBarTheme(true) //开启顶部状态栏图标、文字暗色模式
public class CitySelectionActivity extends BaseActivity {
    private RecyclerView rtll_rv_sheng;
    private RecyclerView rtll_rv_shi;
    private RecyclerView rtll_rv_qu;
    private CityAdapter cityAdapter;
    private ImageView fh_city;
    private List<CityBean.ListBeanXX> list;
    private List<CityBean.ListBeanXX.ListBeanX> list2;
    private List<CityBean.ListBeanXX.ListBeanX.ListBean> list3;
    private TextView chongzhi;
    private TextView queren;
    private String shengshi;
    private BeanXAdapter beanXAdapter;
    private CityBean.ListBeanXX Sheng;
    private CityBean.ListBeanXX.ListBeanX Shi;
    private CityBean.ListBeanXX.ListBeanX.ListBean Qu;

    @Override
    public void initViews() {
        rtll_rv_sheng = findViewById(R.id.rtll_rv_sheng);
        rtll_rv_shi = findViewById(R.id.rtll_rv_shi);
        rtll_rv_qu = findViewById(R.id.rtll_rv_qu);
        chongzhi = findViewById(R.id.chongzhi);
        queren = findViewById(R.id.queren);
        fh_city = findViewById(R.id.fh_city);
        //创建布局管理
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rtll_rv_sheng.setLayoutManager(layoutManager);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
        layoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        rtll_rv_shi.setLayoutManager(layoutManager2);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this);
        layoutManager3.setOrientation(LinearLayoutManager.VERTICAL);
        rtll_rv_qu.setLayoutManager(layoutManager3);
    }

    @Override
    public void initDatas(JumpParameter paramer) {
    }


    @Override
    public void setEvents() {
        queren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResponse(new JumpParameter().put("省", Sheng).put("市", Shi).put("区", Qu));
                finish();
            }
        });
        chongzhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list2.clear();
                list3.clear();
                cityAdapter.notifyDataSetChanged();
                beanXAdapter.notifyDataSetChanged();
                shengshi = null;
            }
        });
        fh_city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



    @Override
    protected void onResume() {
        super.onResume();
        luoji();

    }

    private void luoji() {
        if (Preferences.getInstance().getString(me, "user", "user") != null){
            String string = Preferences.getInstance().getString(me, "user", "user");
            Gson gson = new Gson();
            CityDataBean cityDataBean = gson.fromJson(string, CityDataBean.class);
            Log.d("zdl","================"+string);
            String info = cityDataBean.getData().getInfo();
            CityBean cityBean = gson.fromJson(info, CityBean.class);
            list = cityBean.getList();
            cityAdapter = new CityAdapter(R.layout.item_sheng, list);
            rtll_rv_sheng.setAdapter(cityAdapter);
            cityAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, final int position1) {
                    list2 = CitySelectionActivity.this.list.get(position1).getList();
                    beanXAdapter = new BeanXAdapter(R.layout.item_sheng, list2);
                    rtll_rv_shi.setAdapter(beanXAdapter);
                    beanXAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, final int position2) {
                            list3 = list2.get(position2).getList();
                            ListAdapter listAdapter = new ListAdapter(R.layout.item_sheng, list3);

                            rtll_rv_qu.setAdapter(listAdapter);
                            beanXAdapter.notifyDataSetChanged();
                            listAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position3) {
                                    toast(list.get(position1).getAreaName() + "," + list2.get(position2).getAreaName() + "," + list3.get(position3).getAreaName());
                                    shengshi = list.get(position1).getAreaName() + "," + list2.get(position2).getAreaName() + "," + list3.get(position3).getAreaName();
                                    Sheng = list.get(position1);
                                    Shi = list.get(position1).getList().get(position2);
                                    Qu = list.get(position1).getList().get(position2).getList().get(position3);
                                }
                            });
                        }
                    });
                    cityAdapter.notifyDataSetChanged();
                    beanXAdapter.notifyDataSetChanged();
                    if (list3 != null) {
                        list3.clear();
                        beanXAdapter.notifyDataSetChanged();
                    }

                }
            });
        }
    }

}
