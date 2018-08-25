package zpe.jiakeyi.com.zhanpaieaw.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.bean.SystemMassageBean;

/**
 * Created by Administrator on 2018/8/16.
 */

public class SystemAdapter extends BaseQuickAdapter<SystemMassageBean.DataBean.ListBean, BaseViewHolder> {
    public SystemAdapter(int layoutResId, @Nullable List<SystemMassageBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SystemMassageBean.DataBean.ListBean item) {
        ImageView viewById = helper.itemView.findViewById(R.id.item_system_img);
        TextView viewById1 = helper.itemView.findViewById(R.id.item_massage_riqi);
        TextView viewById2 = helper.itemView.findViewById(R.id.item_massage_title);
        TextView viewById3 = helper.itemView.findViewById(R.id.item_massage_context);
        Glide.with(mContext).load(item.getImgUrl()).error(R.mipmap.img_7).into((ImageView) viewById);
        viewById1.setText(item.getCreateTime());
        viewById2.setText(item.getTitle());
        viewById3.setText(item.getContent());


    }
}
