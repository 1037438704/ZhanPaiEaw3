package zpe.jiakeyi.com.zhanpaieaw.fragment.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kongzue.baseframework.BaseFragment;
import com.kongzue.baseframework.interfaces.Layout;

import java.util.List;

import zpe.jiakeyi.com.zhanpaieaw.R;
import zpe.jiakeyi.com.zhanpaieaw.adapter.GoodsRecyclerViewAdapte_First;
import zpe.jiakeyi.com.zhanpaieaw.library.bean.sysBean;

/**
 * 创建人： 郭健福
 * 创建时间： 2018/7/23 21:44
 * 功能描述：三级搜索分类列表中用于承载第二三级的Fragment
 *
 * @author dell-pc
 */
@Layout(R.layout.fragment_goods)
public class GoodsFragment extends BaseFragment {


    private RecyclerView recycleGoods;
    private GoodsRecyclerViewAdapte_First goodsRecyclerViewAdapte_first;

    public GoodsFragment() {
        // Required empty public constructor
    }


    @Override
    public void initViews() {
        recycleGoods = findViewById(R.id.recycle_goods);
    }

    @Override
    public void initDatas() {
        Bundle arguments = getArguments();
        sysBean.DataBean.ListBeanXX goodsFragment = (sysBean.DataBean.ListBeanXX) arguments.getSerializable("GoodsFragment");
        List<sysBean.DataBean.ListBeanXX.ListBeanX> list = goodsFragment.getList();
        recycleGoods.setLayoutManager(new LinearLayoutManager(getActivity()));
        goodsRecyclerViewAdapte_first = new GoodsRecyclerViewAdapte_First(getActivity(), list);
        recycleGoods.setAdapter(goodsRecyclerViewAdapte_first);
    }

    @Override
    public void setEvents() {

    }
}
