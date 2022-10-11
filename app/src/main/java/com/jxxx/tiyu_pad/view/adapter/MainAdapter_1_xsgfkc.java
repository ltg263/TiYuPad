package com.jxxx.tiyu_pad.view.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.tiyu_pad.R;

import java.util.List;

public class MainAdapter_1_xsgfkc extends BaseQuickAdapter<String, BaseViewHolder> {


    public MainAdapter_1_xsgfkc(@Nullable List<String> data) {
        super(R.layout.item_main_1_xsgfkc, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_name,item).setText(R.id.tv_type_1,"平衡  |  反应力");
    }
}
