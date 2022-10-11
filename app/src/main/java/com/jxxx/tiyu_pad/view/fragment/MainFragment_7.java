package com.jxxx.tiyu_pad.view.fragment;


import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.FragmentTransaction;

import com.jxxx.tiyu_pad.MainActivity;
import com.jxxx.tiyu_pad.R;
import com.jxxx.tiyu_pad.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class MainFragment_7 extends BaseFragment {

    TextView tv_title_name;
    LinearLayout ll_back;
    List<String> listTitle = new ArrayList<>();
    List<String> listTitleIndex = new ArrayList<>();
    public static int MAIN_FRAGMENT_INDEX_SBGL = 1;
    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_main_1;
    }

    @Override
    protected void initView() {
        tv_title_name = ((MainActivity)getActivity()).getTv_title_name();
        ll_back = ((MainActivity)getActivity()).getLl_back();
        ll_back.setVisibility(View.GONE);
        setInitView(MAIN_FRAGMENT_INDEX_SBGL,"其他设置");
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

    @Override
    protected void initData() {
    }

    private void intentGoFragment(int index,String title,FragmentTransaction fragmentTransaction) {
        if(index == MAIN_FRAGMENT_INDEX_SBGL) {
            fragmentTransaction.replace(R.id.deliver_frame, new MainFragment_7_qtsz());
        }
        fragmentTransaction.addToBackStack(title);
        fragmentTransaction.commit();
    }
}



