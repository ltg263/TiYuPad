package com.jxxx.tiyu_pad.view.fragment;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.jxxx.tiyu_pad.R;
import com.jxxx.tiyu_pad.base.BaseFragment;
import com.jxxx.tiyu_pad.utils.view.DialogUtils;
import com.jxxx.tiyu_pad.utils.view.StepArcView_n;
import com.jxxx.tiyu_pad.view.adapter.MainAdapter_5_bjsk;
import com.jxxx.tiyu_pad.view.adapter.MainAdapter_5_dlcj;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *
 */
public class MainFragment_5_ksyd extends BaseFragment {


    @BindView(R.id.rv_list)
    RecyclerView rv_list;
    @BindView(R.id.rv_list_xx)
    RecyclerView rv_list_xx;
    MainAdapter_5_bjsk mMainAdapter_5_bjsk;
    MainAdapter_5_dlcj mMainAdapter_5_dlcj;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_main_5_ksyd;
    }

    @Override
    protected void initView() {
        List<String> list_bd = new ArrayList<>();
        list_bd.add("每组4人  |  共4个小节");

        mMainAdapter_5_bjsk = new MainAdapter_5_bjsk(list_bd);
        rv_list.setAdapter(mMainAdapter_5_bjsk);

        List<String> list_sq = new ArrayList<>();
        list_sq.add("每组4人  |  共4个小节");
        list_sq.add("每组4人  |  共4个小节");
        list_sq.add("每组4人  |  共4个小节");
        list_sq.add("每组4人  |  共4个小节");
        list_sq.add("每组4人  |  共4个小节");
        mMainAdapter_5_dlcj = new MainAdapter_5_dlcj(list_sq);
        rv_list_xx.setAdapter(mMainAdapter_5_dlcj);
    }

    @Override
    protected void initData() {

    }


}
