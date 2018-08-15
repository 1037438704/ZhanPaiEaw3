package zpe.jiakeyi.com.zhanpaieaw.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.bean.BuyListAllBean;
import zpe.jiakeyi.com.zhanpaieaw.bean.PersonBean;
import zpe.jiakeyi.com.zhanpaieaw.utils.RequestUtlis;

/**
 * 功能描述: 求购界面适配器
 *
 * @author dell-pc
 * @date 2018/7/25
 */

public class BuyAddFgtAdapter extends BaseQuickAdapter<BuyListAllBean.DataBean.ListBean, BaseViewHolder> {

    public BuyAddFgtAdapter(int layoutResId, @Nullable List<BuyListAllBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BuyListAllBean.DataBean.ListBean item) {
        final ImageView imageView = helper.itemView.findViewById(R.id.img_buy_item);
        TextView tv_title = helper.itemView.findViewById(R.id.tv_buy_title);
        TextView tv_name = helper.itemView.findViewById(R.id.tv_buy_name);
        TextView tv_time = helper.itemView.findViewById(R.id.tv_time_buy);
        TextView tv_address = helper.itemView.findViewById(R.id.tv_buy_address);
        OkHttpUtils.
                post()
                .url(RequestUtlis.SS)
                .addHeader("ACCESS_TOKEN", "" + 1)
                .addParams("", "")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        PersonBean personBean = gson.fromJson(response, PersonBean.class);
//                        String viaUrl = personBean.getData().getUser().getViaUrl();
//                        Glide.with(mContext).load(viaUrl).apply(new RequestOptions().error(R.mipmap.buy_img_person)).into(imageView);
                    }
                });
        tv_title.setText(item.getTitle());
        tv_name.setText(item.getContent());
        tv_time.setText(item.getCreateTime());
        tv_address.setText(item.getAddressB() + "  " + item.getAddressC());
    }
}
