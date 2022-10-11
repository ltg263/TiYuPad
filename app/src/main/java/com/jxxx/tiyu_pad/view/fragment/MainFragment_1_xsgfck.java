package com.jxxx.tiyu_pad.view.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.jxxx.tiyu_pad.R;
import com.jxxx.tiyu_pad.base.BaseFragment;
import com.jxxx.tiyu_pad.view.adapter.MainAdapter_1_xsgfkc;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *
 */
public class MainFragment_1_xsgfck extends BaseFragment {


    @BindView(R.id.rv_list)
    RecyclerView rv_list;
    @BindView(R.id.ll_dgdb)
    LinearLayout ll_dgdb;
    @BindView(R.id.ll_gdq)
    LinearLayout ll_gdq;
    @BindView(R.id.tv_sjck)
    TextView tv_sjck;
    @BindView(R.id.tv_cjbk)
    TextView tv_cjbk;
    MainAdapter_1_xsgfkc mMainAdapter_1_xsgfkc;
    String typeName = "电光地板";
    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_main_1_djkc;
    }

    @Override
    protected void initView() {
        tv_sjck.setVisibility(View.INVISIBLE);
        tv_cjbk.setVisibility(View.INVISIBLE);
        List<String> list_bd = new ArrayList<>();
        list_bd.add("每组4人  |  共4个小节");
        list_bd.add("每组4人  |  共4个小节");

        mMainAdapter_1_xsgfkc = new MainAdapter_1_xsgfkc(list_bd);
        rv_list.setAdapter(mMainAdapter_1_xsgfkc);
    }

    @Override
    protected void initData() {

    }
    @OnClick({R.id.ll_dgdb, R.id.ll_gdq})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_dgdb:
                typeName = "电光地板";
                ll_dgdb.setBackgroundResource(R.drawable.icon_djkc_dgdb_bj);
                ll_gdq.setBackgroundColor(getResources().getColor(R.color.color_ffffff_1a));
                break;
            case R.id.ll_gdq:
                typeName = "电光球";
                ll_gdq.setBackgroundResource(R.drawable.icon_djkc_dgdb_bj);
                ll_dgdb.setBackgroundColor(getResources().getColor(R.color.color_ffffff_1a));
                break;
        }
    }
}
