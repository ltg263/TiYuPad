package com.jxxx.tiyu_pad.view.fragment;

import androidx.recyclerview.widget.RecyclerView;

import com.jxxx.tiyu_pad.R;
import com.jxxx.tiyu_pad.base.BaseFragment;
import com.jxxx.tiyu_pad.view.adapter.MainAdapter_1_ckxq;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 *
 */
public class MainFragment_1_ckxq extends BaseFragment {


    @BindView(R.id.rv_list)
    RecyclerView rv_list;
    MainAdapter_1_ckxq mHomeTwoTwoListAdapter;
    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_main_1_kcxq;
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

        mHomeTwoTwoListAdapter = new MainAdapter_1_ckxq(list_bd);
        rv_list.setAdapter(mHomeTwoTwoListAdapter);
    }

    @Override
    protected void initData() {

    }
}
