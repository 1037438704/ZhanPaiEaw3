package zpe.jiakeyi.com.zhanpaieaw.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import zpe.jiakeyi.com.zhanpaieaw.library.bean.SeekShowBean;

/**
 * Created by Administrator on 2018/8/20.
 */

public class SeekShowAdapter extends BaseQuickAdapter<SeekShowBean.DataBean.ListBean, BaseViewHolder> {
    public SeekShowAdapter(int layoutResId, @Nullable List<SeekShowBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SeekShowBean.DataBean.ListBean item) {

    }
}
