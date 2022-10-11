package com.jxxx.tiyu_pad.view.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.tiyu_pad.R;

import java.util.List;

public class MainAdapter_3_kbj_vp extends BaseQuickAdapter<String, BaseViewHolder> {


    public MainAdapter_3_kbj_vp(@Nullable List<String> data) {
        super(R.layout.item_main_3_kcb_vp, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setGone(R.id.ll_top,false);
        if(helper.getLayoutPosition()==0){
            helper.setGone(R.id.ll_top,true);
        }
        helper.setBackgroundColor(R.id.ll,mContext.getResources().getColor(R.color.color_transparent));
        if(helper.getLayoutPosition()%2!=0){
            helper.setBackgroundColor(R.id.ll,mContext.getResources().getColor(R.color.color_ffffff_1a));
        }
    }
}
