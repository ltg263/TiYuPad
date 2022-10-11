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
import com.jxxx.tiyu_pad.view.adapter.MainAdapter_2_dlsz_xsxx;
import com.jxxx.tiyu_pad.view.adapter.MainAdapter_5_kcxq;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *
 */
public class MainFragment_2_dlsz extends BaseFragment {


    @BindView(R.id.rv_list)
    RecyclerView rv_list;
    @BindView(R.id.rv_list_xuesheng)
    RecyclerView rv_list_xuesheng;
    MainAdapter_2_dlsz_xsxx mMainAdapter_2_dlsz_xsxx;
    MainAdapter_5_kcxq mMainAdapter_5_kcxq;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_main_2_dlsz;
    }

    @Override
    protected void initView() {
        List<String> list_bd = new ArrayList<>();
        list_bd.add("");
        list_bd.add("");
        list_bd.add("");
        list_bd.add("");
        list_bd.add("");
        list_bd.add("");
        list_bd.add("");
        list_bd.add("");
        list_bd.add("");
        list_bd.add("");
        list_bd.add("");
        list_bd.add("");
        list_bd.add("");
        list_bd.add("");
        list_bd.add("");
        list_bd.add("");
        list_bd.add("");
        list_bd.add("");
        list_bd.add("");
        list_bd.add("");
        mMainAdapter_2_dlsz_xsxx = new MainAdapter_2_dlsz_xsxx(list_bd);
        rv_list.setAdapter(mMainAdapter_2_dlsz_xsxx);

        List<String> list_sq = new ArrayList<>();
        list_sq.add("每组4人  |  共4个小节");
        list_sq.add("每组4人  |  共4个小节");
        list_sq.add("每组4人  |  共4个小节");
        list_sq.add("每组4人  |  共4个小节");
        list_sq.add(null);
        mMainAdapter_5_kcxq = new MainAdapter_5_kcxq(list_sq);
        rv_list_xuesheng.setAdapter(mMainAdapter_5_kcxq);
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.btn_queren})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_queren:
                break;
        }
    }
}
