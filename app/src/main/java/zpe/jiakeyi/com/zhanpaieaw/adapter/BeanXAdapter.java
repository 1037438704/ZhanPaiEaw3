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

public class BeanXAdapter extends BaseQuickAdapter<CityBean.ListBeanXX.ListBeanX,BaseViewHolder>{

    public BeanXAdapter(int layoutResId, @Nullable List<CityBean.ListBeanXX.ListBeanX> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CityBean.ListBeanXX.ListBeanX item) {
        helper.setText(R.id.item_tv_sheng,item.getAreaName());
    }
}
