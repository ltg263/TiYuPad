package com.jxxx.tiyu_pad.view.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.tiyu_pad.R;

import java.util.List;

public class MainAdapter_4_kcbk extends BaseQuickAdapter<String, BaseViewHolder> {


    public MainAdapter_4_kcbk(@Nullable List<String> data) {
        super(R.layout.item_main_4_kcbk, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, String item) {
        if (helper.getLayoutPosition() == 0) {
            helper.setGone(R.id.ll_top, true);
        }
        helper.setGone(R.id.tv_add_xiaojie, false).setGone(R.id.tv_xiaojie, true)
                .setVisible(R.id.ll_kcxz, true).setVisible(R.id.tv_bjdls, true)
                .setVisible(R.id.tv_dlzdrs, true).setVisible(R.id.ll_dlgs, true)
                .setVisible(R.id.ll_xhcs,true).setText(R.id.tv_xiaojie,"第"+(helper.getLayoutPosition()+1)+"小节");
        if (helper.getLayoutPosition() == mData.size() - 1) {
            helper.setGone(R.id.tv_add_xiaojie, true).setGone(R.id.tv_xiaojie, false)
                    .setVisible(R.id.ll_kcxz, false).setVisible(R.id.tv_bjdls, false)
                    .setVisible(R.id.tv_dlzdrs, false).setVisible(R.id.ll_dlgs, false)
                    .setVisible(R.id.ll_xhcs,false);
        }
        helper.setBackgroundColor(R.id.ll, mContext.getResources().getColor(R.color.color_transparent))
                .addOnClickListener(R.id.ll_kcxz).addOnClickListener(R.id.tv_dlgs).addOnClickListener(R.id.tv_mrcs);
        if (helper.getLayoutPosition() % 2 != 0) {
            helper.setBackgroundColor(R.id.ll, mContext.getResources().getColor(R.color.color_ffffff_1a));
        }
    }
}
