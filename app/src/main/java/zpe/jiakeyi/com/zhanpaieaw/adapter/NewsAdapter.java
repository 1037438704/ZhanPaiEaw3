package zpe.jiakeyi.com.zhanpaieaw.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.List;

import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.bean.NewsListBean;

/**
 * 创建人： 郭健福
 * 创建时间： 2018/7/23 21:44
 * 功能描述：新闻Fragment中的RecyclerView的适配器
 *
 * @author dell-pc
 */

public class NewsAdapter extends BaseQuickAdapter<NewsListBean.DataBean.ListBeanX.ListBean, BaseViewHolder> {

    public NewsAdapter(int layoutResId, @Nullable List<NewsListBean.DataBean.ListBeanX.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NewsListBean.DataBean.ListBeanX.ListBean item) {
        ImageView img_news = helper.itemView.findViewById(R.id.img_news);
        TextView title_news = helper.itemView.findViewById(R.id.title_news);
        TextView look_news_tv = helper.itemView.findViewById(R.id.look_news_tv);
        TextView time_news_tv = helper.itemView.findViewById(R.id.time_news_tv);
        AutoLinearLayout news_layout = helper.itemView.findViewById(R.id.news_layout);
        Glide.with(mContext).load(item.getCoverImg()).error(R.mipmap.banner).into((ImageView) img_news);
        helper.addOnClickListener(R.id.news_layout);
        title_news.setText(item.getIntro());
        look_news_tv.setText(item.getPageView() + "人浏览");
        time_news_tv.setText(item.getCreateTime().substring(0, 16));
    }

}