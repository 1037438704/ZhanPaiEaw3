package zpe.jiakeyi.com.zhanpaieaw.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.library.bean.sysBean;

/**
 * 创建人： 郭健福
 * 创建时间： 2018/7/23 21:44
 * 功能描述：三级商品展示页右侧详细列表Adapter
 *
 * @author dell-pc
 */
public class GoodsRecyclerViewAdapter_Second extends RecyclerView.Adapter<GoodsRecyclerViewAdapter_Second.MyViewHolder> implements View.OnClickListener {
    private Context mContext;
    private MyViewHolder myViewHolder;
    private List<sysBean.DataBean.ListBeanXX.ListBeanX.ListBean> list;
    private OnItemClickListener mItemClickListener;

    public GoodsRecyclerViewAdapter_Second(Context mContext, List<sysBean.DataBean.ListBeanXX.ListBeanX.ListBean> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public void onClick(View v) {
        if (mItemClickListener != null) {
            mItemClickListener.onItemClick((Integer) v.getTag());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_goods_item_two, null);
        myViewHolder = new MyViewHolder(view);
        view.setOnClickListener(this);
        return myViewHolder;
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.itemView.setTag(position);
        holder.tv_recycler_goods_two.setText(list.get(position).getTypeName());
        Glide.with(mContext).load(list.get(position).getImg()).error(R.mipmap.product_img_clean_1).into(holder.img_recycler_goods_two);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img_recycler_goods_two;
        TextView tv_recycler_goods_two;

        public MyViewHolder(View itemView) {
            super(itemView);
            img_recycler_goods_two = itemView.findViewById(R.id.img_recycler_goods_two);
            tv_recycler_goods_two = itemView.findViewById(R.id.tv_recycler_goods_two);
        }
    }
}
