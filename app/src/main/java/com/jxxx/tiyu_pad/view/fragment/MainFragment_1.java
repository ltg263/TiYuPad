package com.jxxx.tiyu_pad.view.fragment;


import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.FragmentTransaction;

import com.jxxx.tiyu_pad.MainActivity;
import com.jxxx.tiyu_pad.R;
import com.jxxx.tiyu_pad.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class MainFragment_1 extends BaseFragment {

    TextView tv_title_name;
    LinearLayout ll_back;
    List<String> listTitle = new ArrayList<>();
    List<String> listTitleIndex = new ArrayList<>();
    public static int MAIN_FRAGMENT_INDEX_KCK = 1;
    public static int MAIN_FRAGMENT_INDEX_DJCK = 2;
    public static int MAIN_FRAGMENT_INDEX_XJCK = 3;
    public static int MAIN_FRAGMENT_INDEX_XSCK = 4;
    public static int MAIN_FRAGMENT_INDEX_KCXQ = 5;
    public static int MAIN_FRAGMENT_INDEX_XJCK_BJ = 6;
    public static int MAIN_FRAGMENT_INDEX_XJCK_BJ_OK = 7;
    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_main_1;
    }

    @Override
    protected void initView() {
        tv_title_name = ((MainActivity)getActivity()).getTv_title_name();
        ll_back = ((MainActivity)getActivity()).getLl_back();
        ll_back.setVisibility(View.GONE);
        setInitView(MAIN_FRAGMENT_INDEX_KCK,"课程库");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        ll_back.setVisibility(View.GONE);
        if(!hidden && listTitle.size()>1){
            ll_back.setVisibility(View.VISIBLE);
            tv_title_name.setText(listTitle.get(listTitle.size()-1));
        }
    }
    @Override
    public void setBackStack() {
        if(listTitle.size()>1){
            getChildFragmentManager().popBackStack();
            listTitle.remove(listTitle.size()-1);
            listTitleIndex.remove(listTitleIndex.size()-1);
            tv_title_name.setText(listTitle.get(listTitle.size()-1));
            if(listTitle.size()==1){
                ll_back.setVisibility(View.INVISIBLE);
            }
        }
    }

    /**
     *
     * @param index:
     *        1:课程库;2大节课程;3小节课程;4线上官方课程;5课程详情;6小节课程编辑;6小节课程提交
     *
     */
    public void setInitView(int index,String title) {
        intentGoFragment(index,title,getChildFragmentManager().beginTransaction());
        tv_title_name.setText(title);
        if(listTitleIndex.contains(index+"")){
            int sign = 0;
            for(int i=0;i<listTitleIndex.size();i++){
                if(listTitleIndex.get(i).equals(index+"")){
                    sign = i;
                }
            }
            for(int i=listTitleIndex.size()-1;i>=sign;i--){
                getChildFragmentManager().popBackStack();
                listTitleIndex.remove(i);
                listTitle.remove(i);
            }
        }
        listTitle.add(title);
        listTitleIndex.add(index+"");
        ll_back.setVisibility(View.GONE);
        if(listTitle.size()>1){
            ll_back.setVisibility(View.VISIBLE);
        }
    }

    private void intentGoFragment(int index,String title,FragmentTransaction fragmentTransaction) {
        if(index == MAIN_FRAGMENT_INDEX_KCK) {
            fragmentTransaction.replace(R.id.deliver_frame, new MainFragment_1_kck());
        }else if(index == MAIN_FRAGMENT_INDEX_DJCK) {
            fragmentTransaction.replace(R.id.deliver_frame, new MainFragment_1_djkc());
        }else if(index == MAIN_FRAGMENT_INDEX_XJCK) {
            fragmentTransaction.replace(R.id.deliver_frame, new MainFragment_1_xjkc());
        }else if(index == MAIN_FRAGMENT_INDEX_XSCK) {
            fragmentTransaction.replace(R.id.deliver_frame, new MainFragment_1_xsgfck());
        }else if(index == MAIN_FRAGMENT_INDEX_KCXQ){
            fragmentTransaction.replace(R.id.deliver_frame, new MainFragment_1_ckxq());
        }else if(index == MAIN_FRAGMENT_INDEX_XJCK_BJ){
            fragmentTransaction.replace(R.id.deliver_frame, new MainFragment_1_xjkc_bj());
        }else if(index == MAIN_FRAGMENT_INDEX_XJCK_BJ_OK){
            fragmentTransaction.replace(R.id.deliver_frame, new MainFragment_1_xjkc_bj_ok());
        }
        fragmentTransaction.addToBackStack(title);
        fragmentTransaction.commit();
    }

    @Override
    protected void initData() {
    }
}



