package com.jxxx.tiyu_pad.view.fragment;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.tiyu_pad.R;
import com.jxxx.tiyu_pad.base.BaseFragment;
import com.jxxx.tiyu_pad.utils.view.DialogUtils;
import com.jxxx.tiyu_pad.view.adapter.MainAdapter_6_sbgl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 *
 */
public class MainFragment_6_sbgl extends BaseFragment {


    @BindView(R.id.rv_list)
    RecyclerView rv_list;
    MainAdapter_6_sbgl mMainAdapter_6_sbgl;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_main_2_bjgl;
    }

    @Override
    protected void initView() {
        List<String> list_sq = new ArrayList<>();
        list_sq.add("每组4人  |  共4个小节");
        list_sq.add("每组4人  |  共4个小节");
        list_sq.add("每组4人  |  共4个小节");
        list_sq.add("每组4人  |  共4个小节");
        mMainAdapter_6_sbgl = new MainAdapter_6_sbgl(list_sq);
        rv_list.setAdapter(mMainAdapter_6_sbgl);
        mMainAdapter_6_sbgl.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                DialogUtils.showDialogZhuJiXiangQing(mContext, "主机详情", new DialogUtils.ErrorDialogInterfaceA() {
                    @Override
                    public void btnConfirm(int index) {

                    }
                });
            }
        });
        mMainAdapter_6_sbgl.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.tv_shsq:
                        DialogUtils.showDialogSunHuaiShenBao(mContext, "设备损坏申报单", new DialogUtils.ErrorDialogInterfaceA() {
                            @Override
                            public void btnConfirm(int index) {

                            }
                        });
                        break;
                    case R.id.tv_sqwd:
                        DialogUtils.showDialogWaiDaiShenBao(mContext, "设备外带申报单", new DialogUtils.ErrorDialogInterfaceA() {
                            @Override
                            public void btnConfirm(int index) {

                            }
                        });
                        break;
                    case R.id.tv_sbh:
                        break;
                }
            }
        });
    }

    @Override
    protected void initData() {

    }


}
