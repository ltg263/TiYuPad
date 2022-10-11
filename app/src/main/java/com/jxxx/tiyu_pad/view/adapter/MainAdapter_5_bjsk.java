package com.jxxx.tiyu_pad.view.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.tiyu_pad.R;

import java.util.List;

public class MainAdapter_5_bjsk extends BaseQuickAdapter<String, BaseViewHolder> {


    public MainAdapter_5_bjsk(@Nullable List<String> data) {
        super(R.layout.item_main_5_bjsk, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, String item) {

        helper.setText(R.id.tv_name,item).setText(R.id.tv_type_1,"平衡  |  反应力")
                .setText(R.id.tv_pos,"第"+(helper.getLayoutPosition()+1)+"小节")
                .addOnClickListener(R.id.tv_1).addOnClickListener(R.id.tv_2);
    }
}
