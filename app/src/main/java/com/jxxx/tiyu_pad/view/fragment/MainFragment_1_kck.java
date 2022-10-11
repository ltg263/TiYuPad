package com.jxxx.tiyu_pad.view.fragment;


import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.tiyu_pad.R;
import com.jxxx.tiyu_pad.base.BaseFragment;
import com.jxxx.tiyu_pad.view.adapter.MainAdapter_1_kck;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainFragment_1_kck extends BaseFragment {

    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.rv_list_1)
    RecyclerView rv_list_1;
    @BindView(R.id.rv_list_2)
    RecyclerView rv_list_2;
    MainAdapter_1_kck mMainAdapter_1kck_bd, mMainAdapter_1kck_xs;
    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_main_1_kck;
    }

    @Override
    protected void initView() {
        refreshLayout.setEnableRefresh(false);
        refreshLayout.setEnableLoadMore(false);
        List<String> list_bd = new ArrayList<>();
        list_bd.add("大节课程");
        list_bd.add("小节课程");
        List<String> list_xs = new ArrayList<>();
        list_xs.add("线上官方课程");

        mMainAdapter_1kck_bd = new MainAdapter_1_kck(list_bd);
        rv_list_1.setAdapter(mMainAdapter_1kck_bd);

        mMainAdapter_1kck_xs = new MainAdapter_1_kck(list_xs);
        rv_list_2.setAdapter(mMainAdapter_1kck_xs);

        mMainAdapter_1kck_bd.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if(position == 0){
                    ((MainFragment_1) getBaseParentFragment(1)).setInitView(MainFragment_1.MAIN_FRAGMENT_INDEX_DJCK,"大节课程");
                }
                if(position == 1){
                    ((MainFragment_1) getBaseParentFragment(1)).setInitView(MainFragment_1.MAIN_FRAGMENT_INDEX_XJCK,"小节课程");
                }
            }
        });
        mMainAdapter_1kck_xs.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ((MainFragment_1) getBaseParentFragment(1)).setInitView(MainFragment_1.MAIN_FRAGMENT_INDEX_XSCK,"线上官方课程");
            }
        });
    }

    @Override
    protected void initData() {

    }
}



