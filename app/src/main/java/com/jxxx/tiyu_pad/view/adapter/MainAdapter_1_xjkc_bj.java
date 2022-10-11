package com.jxxx.tiyu_pad.view.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.tiyu_pad.R;

import java.util.List;

public class MainAdapter_1_xjkc_bj extends BaseQuickAdapter<String, BaseViewHolder> {

    int type;
    public MainAdapter_1_xjkc_bj(int type, @Nullable List<String> data) {
        super(R.layout.item_main_1_xjkc_bj, data);
        this.type = type;
    }


    @Override
    protected void convert(BaseViewHolder helper, String item) {
        if(type == 1){
            helper.setText(R.id.tv_name,helper.getLayoutPosition()+1+"号球");
            helper.setImageResource(R.id.iv_icon,R.drawable.icon_djkc_dgq);
        }else {
            helper.setText(R.id.tv_name,helper.getLayoutPosition()+1+"号板");
            helper.setImageResource(R.id.iv_icon,R.drawable.icon_djkc_dgdb);
        }
    }
}
