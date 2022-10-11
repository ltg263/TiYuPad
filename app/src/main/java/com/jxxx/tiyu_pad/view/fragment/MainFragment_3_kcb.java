package com.jxxx.tiyu_pad.view.fragment;

import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.jxxx.tiyu_pad.R;
import com.jxxx.tiyu_pad.base.BaseFragment;
import com.jxxx.tiyu_pad.utils.view.CustomViewPager;
import com.jxxx.tiyu_pad.view.adapter.MainAdapter_3_kcb_bj;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *
 */
public class MainFragment_3_kcb extends BaseFragment {


    @BindView(R.id.view_pager)
    CustomViewPager mViewPager;
    @BindView(R.id.btn_xiugai)
    Button btn_xiugai;
    @BindView(R.id.rv_list)
    RecyclerView rv_list;
    MainAdapter_3_kcb_bj mMainAdapter_3_kcb_bj;
    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_main_3_kcb;
    }

    @Override
    protected void initView() {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        mMainAdapter_3_kcb_bj = new MainAdapter_3_kcb_bj(list);
        rv_list.setAdapter(mMainAdapter_3_kcb_bj);
        initVP(list);
    }

    @Override
    protected void initData() {

    }

    private void initVP(List<String> list) {
        getFragments(list);
        mViewPager.setOffscreenPageLimit(list.size());
        mViewPager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return "";
            }
        });
        mViewPager.setIsCanScroll(false);
        mViewPager.setCurrentItem(0);
    }
    List<Fragment> fragments = new ArrayList<>();

    private List<Fragment> getFragments(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            MainFragment_3_kcb_vp fragment = new MainFragment_3_kcb_vp();
            fragments.add(fragment);
        }
        return fragments;
    }
    @OnClick({R.id.btn_xiugai,R.id.iv_you,R.id.iv_zuo})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_xiugai:
                if(btn_xiugai.getText().toString().equals("确认")){
                    rv_list.setVisibility(View.GONE);
                    btn_xiugai.setText("修改课程");
                    return;
                }
                rv_list.setVisibility(View.VISIBLE);
                btn_xiugai.setText("确认");
                break;
            case R.id.iv_you:
                if(mViewPager.getCurrentItem()>0){
                    mViewPager.setCurrentItem(mViewPager.getCurrentItem()-1);
                }
                break;
            case R.id.iv_zuo:
                if(mViewPager.getCurrentItem()<mViewPager.getChildCount()){
                    mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
                }
                break;
        }
    }

}
