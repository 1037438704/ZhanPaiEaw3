package zpe.jiakeyi.com.zhanpaieaw.fragment.home;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.kongzue.baseframework.BaseFragment;
import com.kongzue.baseframework.interfaces.Layout;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;
import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.activity.home.NewsDetailsAty;
import zpe.jiakeyi.com.zhanpaieaw.adapter.NewsAdapter;
import zpe.jiakeyi.com.zhanpaieaw.bean.NewsListBean;
import zpe.jiakeyi.com.zhanpaieaw.utils.RequestUtlis;

/**
 * 创建人： 郭健福
 * 创建时间： 2018/7/23 21:44
 * 功能描述：新闻列表页中所展示的Fragment
 *
 * @author dell-pc
 */
@SuppressLint("ValidFragment")
@Layout(R.layout.fragment_news)
public class NewsFragment extends BaseFragment {

    private List list;
    private RecyclerView recycle_news;
    private NewsAdapter newsAdapter;
    private String title;
    private int count;

    public NewsFragment(int count, String title) {
        this.count = count;
        this.title = title;
    }


    @Override
    public void initViews() {
        recycle_news = findViewById(R.id.recycle_news);
    }

    @Override
    public void initDatas() {
        if (count == 0 && title.equals("精选")) {
            requestData(count);

        } else if (count == 1 && title.equals("平台动态")) {
            requestData(count);
        } else if (count == 2 && title.equals("行业新闻")) {
            requestData(count);
        } else if (count == 3 && title.equals("政策法规")) {
            requestData(count);
        }

    }

    private void requestData(int count) {
        if (count == 0) {
            OkHttpUtils.post().url(RequestUtlis.SN)
                    .addParams("typea", "")
                    .addParams("pageSize", "0")
                    .addParams("pageNum", "1")
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {

                        }

                        @Override
                        public void onResponse(String response, int id) {
                            Gson gson = new Gson();
                            NewsListBean newsListBean = gson.fromJson(response, NewsListBean.class);
                            list = newsListBean.getData().getList().getList();
                            newsAdapter = new NewsAdapter(R.layout.news_layout_recycler_item, list);
                            recycle_news.setAdapter(newsAdapter);
                            recycle_news.setLayoutManager(new LinearLayoutManager(me));
                            newsAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                                @Override
                                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                                    Intent intent = new Intent();
                                    intent.setClass(me, NewsDetailsAty.class);
                                    startActivity(intent);
                                }
                            });
                        }

                    });
        } else {
            OkHttpUtils.post().url(RequestUtlis.SN)
                    .addParams("typea", count + "")
                    .addParams("pageSize", "0")
                    .addParams("pageNum", "1")
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {

                        }

                        @Override
                        public void onResponse(String response, int id) {
                            Gson gson = new Gson();
                            NewsListBean newsListBean = gson.fromJson(response, NewsListBean.class);
                            list = newsListBean.getData().getList().getList();
                            newsAdapter = new NewsAdapter(R.layout.news_layout_recycler_item, list);
                            recycle_news.setAdapter(newsAdapter);
                            recycle_news.setLayoutManager(new LinearLayoutManager(me));
                            newsAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                                @Override
                                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                                    Intent intent = new Intent();
                                    intent.setClass(me, NewsDetailsAty.class);
                                    startActivity(intent);
                                }
                            });
                        }

                    });
        }
    }

    @Override
    public void setEvents() {

    }

}
