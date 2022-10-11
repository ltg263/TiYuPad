package com.jxxx.tiyu_pad.view.fragment;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.tiyu_pad.R;
import com.jxxx.tiyu_pad.api.RetrofitUtil;
import com.jxxx.tiyu_pad.app.ConstValues;
import com.jxxx.tiyu_pad.base.BaseFragment;
import com.jxxx.tiyu_pad.base.Result;
import com.jxxx.tiyu_pad.bean.SchoolClassBean;
import com.jxxx.tiyu_pad.utils.SharedUtils;
import com.jxxx.tiyu_pad.utils.StringUtil;
import com.jxxx.tiyu_pad.view.adapter.MainAdapter_2_bjgl;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.List;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 *
 */
public class MainFragment_2_bjgl extends BaseFragment {


    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.rv_list)
    RecyclerView rv_list;
    MainAdapter_2_bjgl mMainAdapter_2_bjgl;

    int page = 1;
    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_main_2_bjgl;
    }

    @Override
    protected void initView() {
        refreshLayout.setRefreshHeader(new MaterialHeader(mContext).setShowBezierWave(false));
        refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                getSchoolClassList();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page=1;
                getSchoolClassList();
            }
        });
        mMainAdapter_2_bjgl = new MainAdapter_2_bjgl(null);
        rv_list.setAdapter(mMainAdapter_2_bjgl);
        mMainAdapter_2_bjgl.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            }
        });
        mMainAdapter_2_bjgl.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.tv_bjxq:
                        ((MainFragment_2)getBaseParentFragment(2))
                                .setInitView(MainFragment_2.MAIN_FRAGMENT_INDEX_BJXQ,"班级详情",mMainAdapter_2_bjgl.getData().get(position).getId());
                        break;
                    case R.id.tv_bjcj:
                        ((MainFragment_2)getBaseParentFragment(2)).setInitView(MainFragment_2.MAIN_FRAGMENT_INDEX_BJCJ,"班级成绩");
                        break;
                    case R.id.tv_dlsz:
                        ((MainFragment_2)getBaseParentFragment(2)).setInitView(MainFragment_2.MAIN_FRAGMENT_INDEX_DLSE,"队列设置");
                        break;
                }
            }
        });
    }

    @Override
    protected void initData() {
        getSchoolClassList();
    }
    private void getSchoolClassList() {
        RetrofitUtil.getInstance().apiService()
                .getSchoolClassList(SharedUtils.singleton().get(ConstValues.TEACHER_ID,""),
                        SharedUtils.singleton().get(ConstValues.SCHOOL_ID,""),page, ConstValues.PAGE_SIZE)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<List<SchoolClassBean>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<List<SchoolClassBean>> result) {
                        if(isResultOk(result) && result.getData()!=null){
                            if(page==1){
                                mMainAdapter_2_bjgl.setNewData(result.getData());
                            }else{
                                mMainAdapter_2_bjgl.addData(result.getData());
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


}
