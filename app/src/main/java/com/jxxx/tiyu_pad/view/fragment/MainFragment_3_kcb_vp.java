package com.jxxx.tiyu_pad.view.fragment;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.tiyu_pad.R;
import com.jxxx.tiyu_pad.base.BaseFragment;
import com.jxxx.tiyu_pad.view.adapter.MainAdapter_3_kbj_vp;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 *
 */
public class MainFragment_3_kcb_vp extends BaseFragment {


    @BindView(R.id.rv_list)
    RecyclerView rv_list;
    MainAdapter_3_kbj_vp mMainAdapter_3_kbj_vp;
    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_main_3_kcb_vp;
    }

    @Override
    protected void initView() {
        List<String> list_sq = new ArrayList<>();
        list_sq.add("每组4人  |  共4个小节");
        list_sq.add("每组4人  |  共4个小节");
        list_sq.add("每组4人  |  共4个小节");
        list_sq.add("每组4人  |  共4个小节");
        list_sq.add("每组4人  |  共4个小节");
        list_sq.add("每组4人  |  共4个小节");
        list_sq.add("每组4人  |  共4个小节");
        list_sq.add("每组4人  |  共4个小节");
        mMainAdapter_3_kbj_vp = new MainAdapter_3_kbj_vp(list_sq);
        rv_list.setAdapter(mMainAdapter_3_kbj_vp);
        mMainAdapter_3_kbj_vp.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            }
        });
    }

    @Override
    protected void initData() {

    }
}
