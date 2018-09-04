package zpe.jiakeyi.com.zhanpaieaw.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.activity.home.ProductActivity;
import zpe.jiakeyi.com.zhanpaieaw.bean.sysBean;


/**
 * 创建人： 郭健福
 * 创建时间： 2018/7/23 21:44
 * 功能描述：三级商品展示页右侧主标题Adapter
 *
 * @author dell-pc
 */
public class GoodsRecyclerViewAdapte_First extends RecyclerView.Adapter<GoodsRecyclerViewAdapte_First.MyViewHolder> {


    private Context mContext;
    private MyViewHolder myViewHolder;
    private GoodsRecyclerViewAdapter_Second goodsRecyclerViewAdapter_second;
    private List<sysBean.DataBean.ListBeanXX.ListBeanX> list;

    public GoodsRecyclerViewAdapte_First(Context mContext, List<sysBean.DataBean.ListBeanXX.ListBeanX> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_goods_item_first, null);
        myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvTitleGoodsFirst.setText(list.get(position).getTypeName());
        final List<sysBean.DataBean.ListBeanXX.ListBeanX.ListBean> list = this.list.get(position).getList();
        goodsRecyclerViewAdapter_second = new GoodsRecyclerViewAdapter_Second(mContext, list);
        goodsRecyclerViewAdapter_second.setItemClickListener(new GoodsRecyclerViewAdapter_Second.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent();
                intent.putExtra("id", list.get(position).getId() + "");
                intent.setClass(mContext, ProductActivity.class);
                mContext.startActivity(intent);
            }
        });
        holder.reMatGoodsFirst.setAdapter(goodsRecyclerViewAdapter_second);
        holder.reMatGoodsFirst.setLayoutManager(new GridLayoutManager(mContext, 3, OrientationHelper.VERTICAL, false));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitleGoodsFirst;
        RecyclerView reMatGoodsFirst;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvTitleGoodsFirst = itemView.findViewById(R.id.tv_title_goods_first);
            reMatGoodsFirst = itemView.findViewById(R.id.re_mat_goods_first);
        }
    }
}
