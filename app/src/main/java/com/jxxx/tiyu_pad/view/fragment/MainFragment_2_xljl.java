package com.jxxx.tiyu_pad.view.fragment;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.tiyu_pad.R;
import com.jxxx.tiyu_pad.base.BaseFragment;
import com.jxxx.tiyu_pad.view.adapter.MainAdapter_2_xljl_td;
import com.jxxx.tiyu_pad.view.adapter.MainAdapter_2_xljl_xl;
import com.jxxx.tiyu_pad.view.adapter.MainAdapter_2_xljl_zh;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 *
 */
public class MainFragment_2_xljl extends BaseFragment {


    @BindView(R.id.rv_list_xl)
    RecyclerView rv_list_xl;
    @BindView(R.id.rv_list_zh)
    RecyclerView rv_list_zh;
    @BindView(R.id.rv_list_td)
    RecyclerView rv_list_td;
    MainAdapter_2_xljl_xl mMainAdapter_2_xljl_xl;
    MainAdapter_2_xljl_td mMainAdapter_2_xljl_td;
    MainAdapter_2_xljl_zh mMainAdapter_2_xljl_zh;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_main_2_xljl;
    }

    @Override
    protected void initView() {
        List<String> list_sq = new ArrayList<>();
        list_sq.add("每组4人  |  共4个小节");
        mMainAdapter_2_xljl_xl = new MainAdapter_2_xljl_xl(list_sq);
        rv_list_xl.setAdapter(mMainAdapter_2_xljl_xl);


        List<String> list_td = new ArrayList<>();
        list_td.add("每组4人  |  共4个小节");
        list_td.add("每组4人  |  共4个小节");
        mMainAdapter_2_xljl_td = new MainAdapter_2_xljl_td(list_td);
        rv_list_td.setAdapter(mMainAdapter_2_xljl_td);
        mMainAdapter_2_xljl_td.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ((MainFragment_2)getBaseParentFragment(2))
                        .setInitView(MainFragment_2.MAIN_FRAGMENT_INDEX_CKBB,"查看报表");

            }
        });

        List<String> list_zh = new ArrayList<>();
        list_zh.add("每组4人  |  共4个小节");
        list_zh.add("每组4人  |  共4个小节");
        list_zh.add("每组4人  |  共4个小节");
        mMainAdapter_2_xljl_zh = new MainAdapter_2_xljl_zh(list_zh);
        rv_list_zh.setAdapter(mMainAdapter_2_xljl_zh);
    }

    @Override
    protected void initData() {

    }


}
