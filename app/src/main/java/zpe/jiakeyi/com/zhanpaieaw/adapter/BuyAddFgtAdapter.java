package zpe.jiakeyi.com.zhanpaieaw.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.library.bean.BuyListAllBean;
import zpe.jiakeyi.com.zhanpaieaw.library.utils.RequestUtlis;
/**
 * 功能描述: 求购界面适配器
 *
 * @author dell-pc
 * @date 2018/7/25
 */

public class BuyAddFgtAdapter extends BaseQuickAdapter<BuyListAllBean.DataBean.ListBeanX.ListBean, BaseViewHolder> {

    public BuyAddFgtAdapter(int layoutResId, @Nullable List<BuyListAllBean.DataBean.ListBeanX.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BuyListAllBean.DataBean.ListBeanX.ListBean item) {
        final ImageView imageView = helper.itemView.findViewById(R.id.img_buy_item);
        TextView tv_title = helper.itemView.findViewById(R.id.tv_buy_title);
        TextView tv_name = helper.itemView.findViewById(R.id.tv_buy_name);
        TextView tv_time = helper.itemView.findViewById(R.id.tv_time_buy);
        TextView tv_address = helper.itemView.findViewById(R.id.tv_buy_address);
        tv_title.setText(item.getTitle());
        tv_name.setText(item.getUserName());
        tv_time.setText(item.getCreateTime());
        tv_address.setText(item.getAddressB() + "  " + item.getAddressC());
        Glide.with(mContext).load(item.getUserViaImg()).error(R.mipmap.buy_img_person).into(imageView);
    }
}
