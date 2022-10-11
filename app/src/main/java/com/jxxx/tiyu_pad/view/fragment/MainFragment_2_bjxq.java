package com.jxxx.tiyu_pad.view.fragment;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.tiyu_pad.R;
import com.jxxx.tiyu_pad.api.RetrofitUtil;
import com.jxxx.tiyu_pad.app.ConstValues;
import com.jxxx.tiyu_pad.base.BaseFragment;
import com.jxxx.tiyu_pad.base.Result;
import com.jxxx.tiyu_pad.bean.SchoolStudentBean;
import com.jxxx.tiyu_pad.bean.SchoolStudentDetailBean;
import com.jxxx.tiyu_pad.utils.CustomPopWindow;
import com.jxxx.tiyu_pad.utils.SharedUtils;
import com.jxxx.tiyu_pad.utils.StringUtil;
import com.jxxx.tiyu_pad.utils.ToastUtil;
import com.jxxx.tiyu_pad.utils.view.DialogUtils;
import com.jxxx.tiyu_pad.view.adapter.MainAdapter_2_bjxq;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 *
 */
public class MainFragment_2_bjxq extends BaseFragment {


    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.rv_list)
    RecyclerView rv_list;
    @BindView(R.id.tv_xb)
    TextView tv_xb;
    @BindView(R.id.tv_searchValue)
    TextView tv_searchValue;
    @BindView(R.id.et_searchValue)
    EditText et_searchValue;
    MainAdapter_2_bjxq mMainAdapter_2_bjxq;
    int page = 1;
    String gender = null ,searchValue = null;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_main_2_bjxq;
    }

    @Override
    protected void initView() {
        List<String> lists = new ArrayList<>();
        lists.add("不限");
        lists.add("男");
        lists.add("女");
        tv_searchValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchValue = et_searchValue.getText().toString();
                if(StringUtil.isNotBlank(searchValue)){
                    page=1;
                    initData();
                }
            }
        });
        tv_xb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomPopWindow.initPopupWindow((Activity) mContext, tv_xb, lists,
                        new CustomPopWindow.PopWindowInterface() {
                            @Override
                            public void getPosition(int position) {
                                page=1;
                                tv_xb.setText(lists.get(position));
                                if(position == 0){
                                    gender = null;
                                }else if(position == 1){
                                    gender = "0";
                                }else if(position == 2){
                                    gender = "1";
                                }
                                initData();
                            }
                        });
            }
        });
        refreshLayout.setRefreshHeader(new MaterialHeader(mContext).setShowBezierWave(false));
        refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                initData();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page=1;
                initData();
            }
        });
        mMainAdapter_2_bjxq = new MainAdapter_2_bjxq(null);
        rv_list.setAdapter(mMainAdapter_2_bjxq);
        mMainAdapter_2_bjxq.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            }
        });
        mMainAdapter_2_bjxq.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.tv_ckcj:
                        ((MainFragment_2) getBaseParentFragment(2)).setInitView(MainFragment_2.MAIN_FRAGMENT_INDEX_XSCJ, "学生成绩");
                        break;
                    case R.id.tv_jbxx:
                        showDialogXueShengXinXi(mMainAdapter_2_bjxq.getData().get(position).getId());
                        break;
                    case R.id.tv_sc:
                        getSchoolStudentDelete(mMainAdapter_2_bjxq.getData().get(position).getId(),position);
                        break;
                }
            }
        });
    }

    private void getSchoolStudentDelete(String id, int position) {
        showLoading();
        RetrofitUtil.getInstance().apiService()
                .getSchoolStudentDelete(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result result) {
                        if (isResultOk(result) && result.getData() != null) {
                            mMainAdapter_2_bjxq.remove(position);
                            mMainAdapter_2_bjxq.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        hideLoading();
                    }

                    @Override
                    public void onComplete() {
                        hideLoading();
                    }
                });

    }

    public void showDialogXueShengXinXi(String id) {
        showLoading();
        RetrofitUtil.getInstance().apiService()
                .getSchoolStudentDetail(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<SchoolStudentDetailBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<SchoolStudentDetailBean> result) {
                        if (isResultOk(result) && result.getData() != null) {
                            DialogUtils.showDialogXueShengXinXi(mContext, result.getData(), new DialogUtils.ErrorDialogInterfaceXueSheng() {
                                @Override
                                public void btnConfirm(SchoolStudentDetailBean mSchoolStudentDetailBean) {
                                    getSchoolStudentPut(mSchoolStudentDetailBean);
                                }
                            });
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        hideLoading();
                    }

                    @Override
                    public void onComplete() {
                        hideLoading();
                    }
                });
    }
    @Override
    protected void initData() {
        RetrofitUtil.getInstance().apiService()
                .getSchoolStudentList(getArguments().getString("v"),
                        gender,searchValue,page, ConstValues.PAGE_SIZE)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<List<SchoolStudentBean>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<List<SchoolStudentBean>> result) {
                        if(isResultOk(result) && result.getData()!=null){
                            if(page==1){
                                mMainAdapter_2_bjxq.setNewData(result.getData());
                            }else{
                                mMainAdapter_2_bjxq.addData(result.getData());
                            }
                            int totalPage = StringUtil.getTotalPage(result.getTotal(), ConstValues.PAGE_SIZE);
                            if(totalPage <= page){
                                refreshLayout.finishLoadMoreWithNoMoreData();
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        refreshLayout.finishRefresh();
                        refreshLayout.finishLoadMore();
                        hideLoading();
                    }

                    @Override
                    public void onComplete() {
                        refreshLayout.finishRefresh();
                        refreshLayout.finishLoadMore();
                        hideLoading();
                    }
                });
    }


    @OnClick({R.id.tv_daoruxuesheng, R.id.tv_daochushuju, R.id.tv_add_xuesheng})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_daoruxuesheng:
                break;
            case R.id.tv_daochushuju:
                break;
            case R.id.tv_add_xuesheng:
                DialogUtils.showDialogXueShengXinXi(mContext, null, new DialogUtils.ErrorDialogInterfaceXueSheng() {
                    @Override
                    public void btnConfirm(SchoolStudentDetailBean mSchoolStudentDetailBean) {
                        mSchoolStudentDetailBean.setClassId(getArguments().getString("v"));
                        mSchoolStudentDetailBean.setSchoolId(SharedUtils.singleton().get(ConstValues.SCHOOL_ID,""));
                        getSchoolStudentAdd(mSchoolStudentDetailBean);
                    }
                });
                break;
        }
    }

    private void getSchoolStudentPut(SchoolStudentDetailBean mSchoolStudentDetailBean) {
        showLoading();
        RetrofitUtil.getInstance().apiService()
                .getSchoolStudentPut(mSchoolStudentDetailBean)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result result) {
                        if(isResultOk(result) && result.getData()!=null){
                            ToastUtil.showLongStrToast(mContext,"修改成功");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        hideLoading();
                    }

                    @Override
                    public void onComplete() {
                        hideLoading();
                    }
                });
    }

    private void getSchoolStudentAdd(SchoolStudentDetailBean mSchoolStudentDetailBean) {
        showLoading();
        RetrofitUtil.getInstance().apiService()
                .getSchoolStudentAdd(mSchoolStudentDetailBean)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result result) {
                        if(isResultOk(result) && result.getData()!=null){
                            ToastUtil.showLongStrToast(mContext,"保存成功");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        hideLoading();
                    }

                    @Override
                    public void onComplete() {
                        hideLoading();
                    }
                });
    }
}
