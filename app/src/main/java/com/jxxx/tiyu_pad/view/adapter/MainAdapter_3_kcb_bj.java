package com.jxxx.tiyu_pad.view.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.tiyu_pad.R;

import java.util.List;

public class MainAdapter_3_kcb_bj extends BaseQuickAdapter<String, BaseViewHolder> {


    public MainAdapter_3_kcb_bj(@Nullable List<String> data) {
        super(R.layout.item_main_3_kcb_bj, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.addOnClickListener(R.id.tv_banji);
        helper.setBackgroundRes(R.id.tv_banji,R.drawable.icon_kcb_selebtn_2);
        if(helper.getLayoutPosition()==1){
            helper.setBackgroundRes(R.id.tv_banji,R.drawable.icon_kcb_selebtn_1);
        }
    }
}
