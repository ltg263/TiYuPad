package com.jxxx.tiyu_pad.view.fragment;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.tiyu_pad.R;
import com.jxxx.tiyu_pad.base.BaseFragment;
import com.jxxx.tiyu_pad.utils.view.DialogUtils;
import com.jxxx.tiyu_pad.utils.view.StepArcView_n;
import com.jxxx.tiyu_pad.view.adapter.MainAdapter_5_bjsk;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *
 */
public class MainFragment_5_bjsk extends BaseFragment {


    @BindView(R.id.rv_list)
    RecyclerView rv_list;
    MainAdapter_5_bjsk mMainAdapter_5_bjsk;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_main_5_bjsk;
    }

    @Override
    protected void initView() {
        List<String> list_bd = new ArrayList<>();
        list_bd.add("每组4人  |  共4个小节");
        list_bd.add("每组4人  |  共4个小节");
        list_bd.add("每组4人  |  共4个小节");
        list_bd.add("每组4人  |  共4个小节");

        mMainAdapter_5_bjsk = new MainAdapter_5_bjsk(list_bd);
        rv_list.setAdapter(mMainAdapter_5_bjsk);
        mMainAdapter_5_bjsk.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ((MainFragment_5) getBaseParentFragment(5)).setInitView(MainFragment_5.MAIN_FRAGMENT_INDEX_CKXQ,"第"+(position+1)+"小节");
            }
        });
        mMainAdapter_5_bjsk.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.tv_beike:

                        break;
                }
            }
        });
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.btn_queren})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_queren:
                DialogUtils.showDialogKaiShiShangKe(mContext, "今日上午第三节课即将开始\n是否开始上课？", new DialogUtils.ErrorDialogInterfaceA() {
                    @Override
                    public void btnConfirm(int index) {
                        DialogUtils.showDialogLianJieSheBei(mContext, "您还未连接光电球或光电地板",
                                new DialogUtils.ErrorDialogInterfaceA() {
                                    @Override
                                    public void btnConfirm(int count_z) {
                                        showDialogXunQiu(count_z);
                                    }
                                });
                    }
                });
                break;
        }
    }

    Dialog dialog;
    StepArcView_n mSvN;
    TextView tv_bfb;
    Button btn_xunqiu;
    private void showDialogXunQiu(int count_z) {
//        DialogUtils.showDialogXunQiu(this, "", new DialogUtils.ErrorDialogInterfaceA() {
//            @Override
//            public void btnConfirm(int index) {
////                WifiSupport.openWifi(HomeTwoShangKeActivity.this);
//                startActivity(new Intent(HomeTwoShangKeActivity.this,HomeTwoXueShengActivity.class));
//            }
//        });
        dialog = new Dialog(mContext, R.style.selectorDialog);
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_kaishixunqiu, null);
        btn_xunqiu = view.findViewById(R.id.btn_xunqiu);
        ImageView iv_quxiao =view.findViewById(R.id.iv_quxiao);
        TextView tv_title =  view.findViewById(R.id.tv_title);
        tv_bfb =  view.findViewById(R.id.tv_bfb);
        mSvN = view.findViewById(R.id.sv_n);
//        btn_xunqiu.setText("开始寻球");
        btn_xunqiu.setText("完成寻球");
        mSvN.setCurrentCount(count_z,0,tv_bfb);
        btn_xunqiu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(btn_xunqiu.getText().toString().equals("正在寻球")){
                    return;
                }
                if(btn_xunqiu.getText().toString().equals("开始寻球")){
                    btn_xunqiu.setText("正在寻球");
                }
                if(btn_xunqiu.getText().toString().equals("完成寻球")){
                    ((MainFragment_5) getBaseParentFragment(5)).setInitView(MainFragment_5.MAIN_FRAGMENT_INDEX_KSYD,"运动中");
                    dialog.dismiss();
                }
            }
        });
        iv_quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.setCancelable(false);
        dialog.setContentView(view);
        dialog.show();
    }
}
