package zpe.jiakeyi.com.zhanpaieaw.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.bean.HomeBean;

/**
 * 创建人： 郭健福
 * 创建时间： 2018/7/23 21:44
 * 功能描述：首页中新品展示列表
 *
 * @author dell-pc
 */

public class HomeRecyclerViewAdapter_new extends BaseQuickAdapter<HomeBean.DataBean.StandListBean, BaseViewHolder> {


    public HomeRecyclerViewAdapter_new(int layoutResId, @Nullable List<HomeBean.DataBean.StandListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeBean.DataBean.StandListBean item) {
        TextView text_home_recycler_new = helper.itemView.findViewById(R.id.text_home_recycler_new);
        ImageView img_home_recycler_new = helper.itemView.findViewById(R.id.img_home_recycler_new);
        Glide.with(mContext).load(item.getStandCover()).error(R.mipmap.img_7).into((ImageView) img_home_recycler_new);
        text_home_recycler_new.setText(item.getStandName());


    }
}
