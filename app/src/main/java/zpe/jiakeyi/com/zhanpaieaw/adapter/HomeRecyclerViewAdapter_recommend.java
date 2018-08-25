package zpe.jiakeyi.com.zhanpaieaw.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.bean.HomeBean;


/**
 * 创建人： 郭健福
 * 创建时间： 2018/7/23 21:44
 * 功能描述：首页中的推荐展品的列表
 *
 * @author dell-pc
 */

public class HomeRecyclerViewAdapter_recommend extends BaseQuickAdapter<HomeBean.DataBean.ProductListBean, BaseViewHolder> {


    public HomeRecyclerViewAdapter_recommend(int layoutResId, @Nullable List<HomeBean.DataBean.ProductListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeBean.DataBean.ProductListBean item) {
        TextView text_home_recycler_new_recommend = helper.itemView.findViewById(R.id.text_home_recycler_new_recommend);
        ImageView img_home_recycler_recommend = helper.itemView.findViewById(R.id.img_home_recycler_recommend);
        Glide.with(mContext).load(item.getUrl()).error(R.mipmap.img_7).into((ImageView) img_home_recycler_recommend);
        text_home_recycler_new_recommend.setText(item.getPname());
        Toast.makeText(mContext, item.getPname(), Toast.LENGTH_SHORT).show();

    }
}
