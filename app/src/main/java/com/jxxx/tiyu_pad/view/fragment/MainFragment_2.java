package com.jxxx.tiyu_pad.view.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.jxxx.tiyu_pad.MainActivity;
import com.jxxx.tiyu_pad.R;
import com.jxxx.tiyu_pad.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class MainFragment_2 extends BaseFragment {

    TextView tv_title_name;
    LinearLayout ll_back;
    List<String> listTitle = new ArrayList<>();
    List<String> listTitleIndex = new ArrayList<>();
    public static int MAIN_FRAGMENT_INDEX_BJGL = 1;
    public static int MAIN_FRAGMENT_INDEX_BJCJ= 2;
    public static int MAIN_FRAGMENT_INDEX_XLJL = 3;
    public static int MAIN_FRAGMENT_INDEX_CKBB = 4;
    public static int MAIN_FRAGMENT_INDEX_BJXQ = 5;
    public static int MAIN_FRAGMENT_INDEX_XSCJ = 6;
    public static int MAIN_FRAGMENT_INDEX_DLSE = 7;
    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_main_1;
    }

    @Override
    protected void initView() {
        tv_title_name = ((MainActivity)getActivity()).getTv_title_name();
        ll_back = ((MainActivity)getActivity()).getLl_back();
        ll_back.setVisibility(View.GONE);
        setInitView(MAIN_FRAGMENT_INDEX_BJGL,"班级管理");
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
     * @param index 1班级管理 2班级成绩;3训练记录；4查看报表；5班级详情;6学生成绩
     * @param title
     */
    public void setInitView(int index,String title) {
        setInitView(index,title,null);
    }
    public void setInitView(int index,String title,String v) {
        intentGoFragment(index,title,v,getChildFragmentManager().beginTransaction());
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

    @Override
    protected void initData() {
    }

    private void intentGoFragment(int index,String title,String v,FragmentTransaction fragmentTransaction) {
        Fragment mFragment;
        Bundle mBundle1 = new Bundle();
        if(index == MAIN_FRAGMENT_INDEX_BJGL) {
            mFragment = new MainFragment_2_bjgl();
            fragmentTransaction.replace(R.id.deliver_frame, mFragment);
        }else if(index == MAIN_FRAGMENT_INDEX_BJCJ) {
            fragmentTransaction.replace(R.id.deliver_frame, new MainFragment_2_bjcj());
        }else if(index == MAIN_FRAGMENT_INDEX_XLJL){
            fragmentTransaction.replace(R.id.deliver_frame, new MainFragment_2_xljl());
        }else if(index == MAIN_FRAGMENT_INDEX_CKBB){
            fragmentTransaction.replace(R.id.deliver_frame, new MainFragment_2_ckbb());
        }else if(index == MAIN_FRAGMENT_INDEX_BJXQ){
            mFragment = new MainFragment_2_bjxq();
            mBundle1.putString("v",v);
            mFragment.setArguments(mBundle1);
            fragmentTransaction.replace(R.id.deliver_frame, mFragment);
        }else if(index == MAIN_FRAGMENT_INDEX_XSCJ){
            fragmentTransaction.replace(R.id.deliver_frame, new MainFragment_2_xscj());
        }else if(index == MAIN_FRAGMENT_INDEX_DLSE){
            fragmentTransaction.replace(R.id.deliver_frame, new MainFragment_2_dlsz());
        }
        fragmentTransaction.addToBackStack(title);
        fragmentTransaction.commit();
    }
}



