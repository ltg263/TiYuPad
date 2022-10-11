package com.jxxx.tiyu_pad.view.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.tiyu_pad.R;
import com.jxxx.tiyu_pad.bean.SchoolClassBean;

import java.util.List;

public class MainAdapter_2_bjgl extends BaseQuickAdapter<SchoolClassBean, BaseViewHolder> {


    public MainAdapter_2_bjgl(@Nullable List<SchoolClassBean> data) {
        super(R.layout.item_main_2_bjgl, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, SchoolClassBean item) {
        helper.setGone(R.id.ll_top,false)
                .addOnClickListener(R.id.tv_bjxq)
                .addOnClickListener(R.id.tv_bjcj)
                .addOnClickListener(R.id.tv_dlsz)
            .setText(R.id.tv_nianji,item.getGrade()+"年级")
            .setText(R.id.tv_xueshengnum,item.getStudentNum()+"")
            .setText(R.id.tv_shangketime,item.getClassTimes().replace(",","\n"))
            .setText(R.id.tv_banji,item.getClassName());
        if(helper.getLayoutPosition()==0){
//            helper.setGone(R.id.ll_top,true);
        }
        helper.setBackgroundColor(R.id.ll,mContext.getResources().getColor(R.color.color_transparent));
        if(helper.getLayoutPosition()%2!=0){
            helper.setBackgroundColor(R.id.ll,mContext.getResources().getColor(R.color.color_ffffff_1a));
        }

    }
}
