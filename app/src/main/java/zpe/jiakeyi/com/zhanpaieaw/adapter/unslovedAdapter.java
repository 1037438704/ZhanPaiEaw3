package zpe.jiakeyi.com.zhanpaieaw.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import zpe.jiakeyi.com.zhanpaieaw.library.bean.unsolvedBean;

/**
 * Created by Administrator on 2018/8/16.
 */

public class unslovedAdapter extends BaseQuickAdapter<unsolvedBean.DataBean.ListBeanX.ListBean, BaseViewHolder> {
    public unslovedAdapter(int layoutResId, @Nullable List<unsolvedBean.DataBean.ListBeanX.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, unsolvedBean.DataBean.ListBeanX.ListBean item) {

    }
}
