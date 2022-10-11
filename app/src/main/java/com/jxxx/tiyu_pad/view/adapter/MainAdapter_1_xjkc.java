package com.jxxx.tiyu_pad.view.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.tiyu_pad.R;
import com.jxxx.tiyu_pad.bean.SchoolCourseBeanSmall;
import com.jxxx.tiyu_pad.utils.GlideImgLoader;

import java.util.List;

public class MainAdapter_1_xjkc extends BaseQuickAdapter<SchoolCourseBeanSmall, BaseViewHolder> {


    public MainAdapter_1_xjkc(@Nullable List<SchoolCourseBeanSmall> data) {
        super(R.layout.item_main_1_xjkc, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, SchoolCourseBeanSmall item) {
        GlideImgLoader.loadImageViewRadiusNoCenter(mContext,item.getImgUrl(),helper.getView(R.id.iv_icon));
        helper.setText(R.id.tv_name_sj,item.getCourseName())
                .addOnClickListener(R.id.tv_bianji).addOnClickListener(R.id.tv_fuzhi)
                .setText(R.id.tv_type_1,item.getLables().replace(",","|"))
                .setText(R.id.tv_name,"每组"+item.getGroupNum()+"人  |  共"+item.getStepNum()+"个步骤");
    }
}
