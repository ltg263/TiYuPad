package com.jxxx.tiyu_pad.view.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.tiyu_pad.R;
import com.jxxx.tiyu_pad.bean.SchoolStudentBean;
import com.jxxx.tiyu_pad.utils.GlideImageLoader;
import com.jxxx.tiyu_pad.utils.GlideImgLoader;

import java.util.List;

public class MainAdapter_2_bjxq extends BaseQuickAdapter<SchoolStudentBean, BaseViewHolder> {


    public MainAdapter_2_bjxq(@Nullable List<SchoolStudentBean> data) {
        super(R.layout.item_main_2_bjxq, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, SchoolStudentBean item) {
        String gender = "未知";
        if(item.getGender()==0){
            gender = "男";
        }
        if(item.getGender()==1){
            gender = "女";
        }
        if(item.getGender()==2){
            gender = "未知";
        }
        helper.setGone(R.id.ll_top,false)
                .addOnClickListener(R.id.tv_ckcj)
                .addOnClickListener(R.id.tv_jbxx)
                .addOnClickListener(R.id.tv_sc)
                .setText(R.id.tv_id,item.getStudentNo())
                .setText(R.id.tv_name,item.getStudentName())
                .setText(R.id.tv_xb,gender)
                .setText(R.id.tv_nl,item.getAge());
        GlideImgLoader.loadImageViewRadius(mContext,item.getImgUrl(),10,helper.getView(R.id.iv_zp));
        if(helper.getLayoutPosition()==0){
//            helper.setGone(R.id.ll_top,true);
        }
        helper.setBackgroundColor(R.id.ll,mContext.getResources().getColor(R.color.color_transparent));
        if(helper.getLayoutPosition()%2!=0){
            helper.setBackgroundColor(R.id.ll,mContext.getResources().getColor(R.color.color_ffffff_1a));
        }
    }
}
