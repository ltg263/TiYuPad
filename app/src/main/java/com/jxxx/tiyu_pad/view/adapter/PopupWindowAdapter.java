package com.jxxx.tiyu_pad.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.tiyu_pad.R;

import java.util.List;

public class PopupWindowAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    boolean isYou = false;
    String title = "";
    public PopupWindowAdapter(List<String> data) {
        super(R.layout.item_spinner_product_type, data);
    }

    public void setYou(boolean you) {
        isYou = you;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    protected void convert(BaseViewHolder helper,String item) {
        helper.setText(R.id.text,item).setVisible(R.id.view,true)
                .setTextColor(R.id.text,mContext.getResources().getColor(R.color.color_333333));
        if(helper.getLayoutPosition()==mData.size()-1){
            helper.setVisible(R.id.view,false);
        }
        if(isYou){
            helper.setVisible(R.id.iv,true);
        }

        if(title.contains(item)){
            helper.setTextColor(R.id.text,mContext.getResources().getColor(R.color.red40));
        }
    }

}
