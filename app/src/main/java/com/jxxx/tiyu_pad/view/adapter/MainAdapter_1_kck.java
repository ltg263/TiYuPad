package com.jxxx.tiyu_pad.view.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.tiyu_pad.R;

import java.util.List;

public class MainAdapter_1_kck extends BaseQuickAdapter<String, BaseViewHolder> {


    public MainAdapter_1_kck(@Nullable List<String> data) {
        super(R.layout.item_home_one, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_name,item).setText(R.id.tv_type_1,"10节课程");
        helper.setVisible(R.id.view_line,true);
        if(helper.getLayoutPosition()==mData.size()-1){
            helper.setVisible(R.id.view_line,false);
        }
    }
}
