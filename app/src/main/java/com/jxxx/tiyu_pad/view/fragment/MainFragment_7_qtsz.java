package com.jxxx.tiyu_pad.view.fragment;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.tiyu_pad.R;
import com.jxxx.tiyu_pad.base.BaseFragment;
import com.jxxx.tiyu_pad.utils.view.DialogUtils;
import com.jxxx.tiyu_pad.view.adapter.MainAdapter_7_qtsz;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 *
 */
public class MainFragment_7_qtsz extends BaseFragment {


    @BindView(R.id.rv_list)
    RecyclerView rv_list;
    MainAdapter_7_qtsz mMainAdapter_7_qtsz;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_main_7_qtsz;
    }

    @Override
    protected void initView() {
        List<String> list_sq = new ArrayList<>();
        list_sq.add("每组4人  |  共4个小节");
        list_sq.add("每组4人  |  共4个小节");
        list_sq.add("每组4人  |  共4个小节");
        list_sq.add("每组4人  |  共4个小节");
        mMainAdapter_7_qtsz = new MainAdapter_7_qtsz(list_sq);
        rv_list.setAdapter(mMainAdapter_7_qtsz);
        mMainAdapter_7_qtsz.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
        mMainAdapter_7_qtsz.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.tv_sqxx:
                        DialogUtils.showDialogShenqingxuexiao(mContext, "", new DialogUtils.ErrorDialogInterfaceA() {
                            @Override
                            public void btnConfirm(int index) {

                            }
                        });
                        break;
                }
            }
        });
    }

    @Override
    protected void initData() {

    }


}
