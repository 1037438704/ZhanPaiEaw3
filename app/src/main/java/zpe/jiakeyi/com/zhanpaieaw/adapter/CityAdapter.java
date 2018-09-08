package zpe.jiakeyi.com.zhanpaieaw.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.library.bean.CityBean;

/**
 * Created by dell-pc on 2018/8/16.
 */

public class CityAdapter extends BaseQuickAdapter<CityBean.ListBeanXX,BaseViewHolder>{

    public CityAdapter(int layoutResId, @Nullable List<CityBean.ListBeanXX> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CityBean.ListBeanXX item) {
        helper.setText(R.id.item_tv_sheng,item.getAreaName());
    }
}
