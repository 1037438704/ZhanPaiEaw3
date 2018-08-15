package zpe.jiakeyi.com.zhanpaieaw.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.bean.ShowTypeBean;


/**
 * 创建人： 郭健福
 * 创建时间： 2018/7/23 21:44
 * 功能描述：求购页面中PopWindow的适配器
 * @author dell-pc
 */

public class MyPopuWindowAdapter extends BaseQuickAdapter<ShowTypeBean,BaseViewHolder> {

    public MyPopuWindowAdapter(int layoutResId, @Nullable List<ShowTypeBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShowTypeBean item) {

        TextView item_tv_name = helper.itemView.findViewById(R.id.item_tv_name);
        item_tv_name.setText(item.name);
        TextView textView = helper.itemView.findViewById(R.id.item_tv_duigou);
        if (item.judge == true){
            textView.setVisibility(View.VISIBLE);
            item_tv_name.setTextColor(Color.BLUE);
        }else {
            textView.setVisibility(View.GONE);
            item_tv_name.setTextColor(Color.BLACK);
        }
    }
}
