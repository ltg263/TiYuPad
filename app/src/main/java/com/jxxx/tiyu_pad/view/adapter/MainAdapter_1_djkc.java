package com.jxxx.tiyu_pad.view.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.tiyu_pad.R;
import com.jxxx.tiyu_pad.bean.SchoolCourseBean;
import com.jxxx.tiyu_pad.utils.GlideImgLoader;

import java.util.List;

public class MainAdapter_1_djkc extends BaseQuickAdapter<SchoolCourseBean, BaseViewHolder> {


    public MainAdapter_1_djkc(@Nullable List<SchoolCourseBean> data) {
        super(R.layout.item_main_1_djkc, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, SchoolCourseBean item) {
        GlideImgLoader.loadImageViewRadiusNoCenter(mContext,item.getImgUrl(),helper.getView(R.id.iv_icon));
        helper.setText(R.id.tv_name_sj,item.getCourseName())
                .addOnClickListener(R.id.tv_beike)
                .addOnClickListener(R.id.tv_shangke)
                .addOnClickListener(R.id.tv_fuzhi)
                .addOnClickListener(R.id.tv_bianji)
                .setText(R.id.tv_type_1,item.getLables().replace(",","|"))
                .setText(R.id.tv_name,"每组"+item.getGroupNum()+"人  |  共"+item.getCourseSectionVoList().size()+"个小节");
    }
}
