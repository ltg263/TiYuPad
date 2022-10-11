package com.jxxx.tiyu_pad.view.fragment;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.tiyu_pad.R;
import com.jxxx.tiyu_pad.base.BaseFragment;
import com.jxxx.tiyu_pad.view.adapter.MainAdapter_2_bjcj;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 *
 */
public class MainFragment_2_bjcj extends BaseFragment {


    @BindView(R.id.rv_list)
    RecyclerView rv_list;
    MainAdapter_2_bjcj mMainAdapter_2_bjcj;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_main_2_bjcj;
    }

    @Override
    protected void initView() {
        List<String> list_sq = new ArrayList<>();
        list_sq.add("每组4人  |  共4个小节");
        list_sq.add("每组4人  |  共4个小节");
        list_sq.add("每组4人  |  共4个小节");
        list_sq.add("每组4人  |  共4个小节");
        mMainAdapter_2_bjcj = new MainAdapter_2_bjcj(list_sq);
        rv_list.setAdapter(mMainAdapter_2_bjcj);
        mMainAdapter_2_bjcj.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ((MainFragment_2)getBaseParentFragment(2)).setInitView(MainFragment_2.MAIN_FRAGMENT_INDEX_XLJL,"训练记录");
            }
        });
    }

    @Override
    protected void initData() {

    }


}
