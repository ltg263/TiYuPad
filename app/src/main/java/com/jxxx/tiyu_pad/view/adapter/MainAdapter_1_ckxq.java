package com.jxxx.tiyu_pad.view.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.tiyu_pad.R;

import java.util.List;

public class MainAdapter_1_ckxq extends BaseQuickAdapter<String, BaseViewHolder> {

    public MainAdapter_1_ckxq(@Nullable List<String> data) {
        super(R.layout.item_main_1_ckxq, data);
    }


    @Override
    protected void convert(BaseViewHolder helper,String item) {
        helper.setVisible(R.id.view_line,true);
        if(helper.getLayoutPosition()==mData.size()-1){
            helper.setVisible(R.id.view_line,false);
        }
    }
}
