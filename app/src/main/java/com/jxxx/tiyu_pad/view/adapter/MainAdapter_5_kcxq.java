package com.jxxx.tiyu_pad.view.adapter;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.tiyu_pad.R;
import com.jxxx.tiyu_pad.utils.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter_5_kcxq extends BaseQuickAdapter<String, BaseViewHolder> {


    public MainAdapter_5_kcxq(@Nullable List<String> data) {
        super(R.layout.item_main_5_kcxq, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, String item) {
        if(StringUtil.isBlank(item)){
            helper.setGone(R.id.ll_add_dl,true).setGone(R.id.ll_dlcontext,false);
            return;
        }
        helper.setText(R.id.tv_pos,"队列"+(helper.getLayoutPosition()+1))
                .setGone(R.id.ll_add_dl,false).setGone(R.id.ll_dlcontext,true);
        RecyclerView rv_list = helper.getView(R.id.rv_list);
        List<String> lists = new ArrayList<>();
        lists.add("");
        lists.add("");
        lists.add("");
        lists.add("");
        lists.add("");
        rv_list.setAdapter(new MainAdapter_5_kcxq_xs(lists));
    }
}
