package com.jxxx.tiyu_pad.view.fragment;

import android.view.View;

import com.jxxx.tiyu_pad.R;
import com.jxxx.tiyu_pad.base.BaseFragment;

import butterknife.OnClick;

/**
 *
 */
public class MainFragment_1_xjkc_bj_ok extends BaseFragment {


    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_main_1_xjck_bj_ok;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {

    }

    @OnClick(R.id.btn_save)
    public void onClick() {
        ((MainFragment_1) getBaseParentFragment(1)).setInitView(MainFragment_1.MAIN_FRAGMENT_INDEX_XJCK,"小节课程");
    }
}
