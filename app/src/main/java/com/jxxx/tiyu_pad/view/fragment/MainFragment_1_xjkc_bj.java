package com.jxxx.tiyu_pad.view.fragment;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.tiyu_pad.R;
import com.jxxx.tiyu_pad.base.BaseFragment;
import com.jxxx.tiyu_pad.view.adapter.MainAdapter_1_xjkc_bj;
import com.jxxx.tiyu_pad.view.adapter.MainAdapter_1_xjkc_bj_add;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *
 */
public class MainFragment_1_xjkc_bj extends BaseFragment {


    @BindView(R.id.rv_list_qiu)
    RecyclerView rv_list_qiu;
    @BindView(R.id.rv_list_ban)
    RecyclerView rv_list_ban;
    @BindView(R.id.rv_list_duilie)
    RecyclerView rv_list_duilie;
    MainAdapter_1_xjkc_bj mMainAdapter_1_xjkc_bj;
    MainAdapter_1_xjkc_bj_add mMainAdapter_1_xjkc_bj_add;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_main_1_xjck_bj;
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
        mMainAdapter_1_xjkc_bj = new MainAdapter_1_xjkc_bj(1, list_bd);
        rv_list_qiu.setAdapter(mMainAdapter_1_xjkc_bj);
        mMainAdapter_1_xjkc_bj.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            }
        });

        mMainAdapter_1_xjkc_bj = new MainAdapter_1_xjkc_bj(2, list_bd);
        rv_list_ban.setAdapter(mMainAdapter_1_xjkc_bj);
        mMainAdapter_1_xjkc_bj.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            }
        });
        List<String> list_bd_add = new ArrayList<>();
        list_bd_add.add("");
        mMainAdapter_1_xjkc_bj_add = new MainAdapter_1_xjkc_bj_add(list_bd);
        rv_list_duilie.setAdapter(mMainAdapter_1_xjkc_bj_add);
        mMainAdapter_1_xjkc_bj_add.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            }
        });
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.btn_update_xyb, R.id.tv_add_qiu, R.id.tv_add_ban, R.id.tv_rem, R.id.tv_add})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_update_xyb:
                ((MainFragment_1) getBaseParentFragment(1)).setInitView(MainFragment_1.MAIN_FRAGMENT_INDEX_XJCK_BJ_OK,"返回上一步");
                break;
            case R.id.tv_add_qiu:
                break;
            case R.id.tv_add_ban:
                break;
            case R.id.tv_rem:
                break;
            case R.id.tv_add:
                break;
        }
    }
}
