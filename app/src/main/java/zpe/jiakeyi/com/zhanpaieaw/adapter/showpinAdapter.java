package zpe.jiakeyi.com.zhanpaieaw.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.library.bean.ShowBean;

/**
 * Created by Administrator on 2018/8/16.
 */

public class showpinAdapter extends BaseQuickAdapter<ShowBean.DataBean.ListBean, BaseViewHolder> {
    public showpinAdapter(int layoutResId, @Nullable List<ShowBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShowBean.DataBean.ListBean item) {
        ImageView viewById1 = helper.itemView.findViewById(R.id.img_show_recycle_item);
        TextView viewById2 = helper.itemView.findViewById(R.id.tv_show_recycle_item_name);
        TextView viewById3 = helper.itemView.findViewById(R.id.tv_show_recycle_item_city);
        TextView viewById4 = helper.itemView.findViewById(R.id.tv_show_recycle_item_region);
        TextView viewById5 = helper.itemView.findViewById(R.id.tv_show_recycle_look);
        if (item != null) {
            Glide.with(mContext).load(item.getImgUrl()).error(R.mipmap.product_img_list).into((ImageView) viewById1);
            viewById2.setText(item.getPname());
            viewById3.setText(item.getAreaA() + "");
            viewById4.setText(item.getAreaB() + "");
            viewById5.setText(item.getClickNo() + "人看过");
        }


    }
}
