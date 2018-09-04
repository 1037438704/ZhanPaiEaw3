package zpe.jiakeyi.com.zhanpaieaw.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kongzue.baseframework.BaseActivity;

import java.util.List;

import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.bean.sysBean;

/**
 * 创建人： 郭健福
 * 创建时间： 2018/7/23 21:44
 * 功能描述：三级商品展示页左侧ListAdapter
 *
 * @author dell-pc
 */

public class CategoryListAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<sysBean.DataBean.ListBeanXX> mDatas;
    private int mPosition;


    public void setPosition(int mPosition) {
        this.mPosition = mPosition;
    }

    //MyAdapter需要一个Context，通过Context获得Layout.inflater，然后通过inflater加载item的布局
    public CategoryListAdapter(Context context, List<sysBean.DataBean.ListBeanXX> datas) {
        mInflater = LayoutInflater.from(context);
        this.mDatas = datas;
        this.mPosition = mPosition;
    }

    //返回数据集的长度
    @Override
    public int getCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //这个方法才是重点，我们要为它编写一个ViewHolder
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.listview_category_item, parent, false); //加载布局
            holder = new ViewHolder();
            holder.titleTv = convertView.findViewById(R.id.tv_category_list);
            holder.tagTV = convertView.findViewById(R.id.tv_category_list_checked);
            convertView.setTag(holder);
        } else {   //else里面说明，convertView已经被复用了，说明convertView中已经设置过tag了，即holder
            holder = (ViewHolder) convertView.getTag();
        }
        holder.titleTv.setText(mDatas.get(position).getTypeName());
        if (mPosition == position) {
            holder.tagTV.setVisibility(View.VISIBLE);
            holder.titleTv.setTextColor(Color.parseColor("#333333"));
            holder.titleTv.setBackgroundColor(Color.parseColor("#ffffff"));
            holder.titleTv.getPaint().setFakeBoldText(true);
            holder.titleTv.setTextSize(14);
        } else {
            holder.tagTV.setVisibility(View.GONE);
            holder.titleTv.setTextColor(Color.parseColor("#666666"));
            holder.titleTv.setBackgroundColor(Color.parseColor("#f5f5f5"));
            holder.titleTv.getPaint().setFakeBoldText(false);
            holder.titleTv.setTextSize(12);
        }
        return convertView;
    }

    //这个ViewHolder只能服务于当前这个特定的adapter，因为ViewHolder里会指定item的控件，不同的ListView，item可能不同，所以ViewHolder写成一个私有的类
    private class ViewHolder {
        TextView titleTv;
        TextView tagTV;
    }
}
