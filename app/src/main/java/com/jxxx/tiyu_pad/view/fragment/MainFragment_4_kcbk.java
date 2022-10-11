package com.jxxx.tiyu_pad.view.fragment;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.tiyu_pad.R;
import com.jxxx.tiyu_pad.base.BaseFragment;
import com.jxxx.tiyu_pad.utils.CustomPopWindow;
import com.jxxx.tiyu_pad.utils.view.CustomViewPager;
import com.jxxx.tiyu_pad.utils.view.DialogUtils;
import com.jxxx.tiyu_pad.view.adapter.MainAdapter_4_kcbk;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *
 */
public class MainFragment_4_kcbk extends BaseFragment {


    @BindView(R.id.btn_xiugai)
    Button btn_xiugai;
    @BindView(R.id.tv_kcbk_top)
    TextView tv_kcbk_top;
    @BindView(R.id.rv_list)
    RecyclerView rv_list;
    MainAdapter_4_kcbk mMainAdapter_4_kcbk;
    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_main_4_kcbk;
    }

    @Override
    protected void initView() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        mMainAdapter_4_kcbk = new MainAdapter_4_kcbk(list);
        rv_list.setAdapter(mMainAdapter_4_kcbk);
        mMainAdapter_4_kcbk.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.ll_kcxz:
                        DialogUtils.showDialogSelectXiaoJie(mContext, "", new DialogUtils.ErrorDialogInterfaceA() {
                            @Override
                            public void btnConfirm(int index) {

                            }
                        });
                        break;
                    case R.id.tv_dlgs:
                    case R.id.tv_mrcs:
                        CustomPopWindow.initPopupWindow((Activity) mContext, view, list,
                                new CustomPopWindow.PopWindowInterface() {
                                    @Override
                                    public void getPosition(int position) {
                                        ((TextView)view).setText(list.get(position));
                                    }
                                });
                        break;
                }
            }
        });
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.btn_xiugai,R.id.tv_kcbk_top})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_xiugai:
                DialogUtils.showDialogBeiKeSheBei(mContext, "您此次课程需要设备数量如下：", new DialogUtils.ErrorDialogInterfaceA() {
                    @Override
                    public void btnConfirm(int index) {

                    }
                });
                break;
            case R.id.tv_kcbk_top:
                ((MainFragment_4)getBaseParentFragment(4)).setInitView(MainFragment_4.MAIN_FRAGMENT_INDEX_KCB,"课程表");
                break;
        }
    }

}
