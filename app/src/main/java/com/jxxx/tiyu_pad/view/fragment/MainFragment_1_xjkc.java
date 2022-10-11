package com.jxxx.tiyu_pad.view.fragment;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.tiyu_pad.MainActivity;
import com.jxxx.tiyu_pad.R;
import com.jxxx.tiyu_pad.api.RetrofitUtil;
import com.jxxx.tiyu_pad.app.ConstValues;
import com.jxxx.tiyu_pad.base.BaseFragment;
import com.jxxx.tiyu_pad.base.Result;
import com.jxxx.tiyu_pad.bean.CourseTypeListAllBean;
import com.jxxx.tiyu_pad.bean.DictDataTypeBean;
import com.jxxx.tiyu_pad.bean.SchoolCourseBean;
import com.jxxx.tiyu_pad.bean.SchoolCourseBeanSmall;
import com.jxxx.tiyu_pad.utils.CustomPopWindow;
import com.jxxx.tiyu_pad.utils.StringUtil;
import com.jxxx.tiyu_pad.utils.view.DialogUtils;
import com.jxxx.tiyu_pad.view.adapter.MainAdapter_1_xjkc;
import com.jxxx.tiyu_pad.view.adapter.MainAdapter_1_xjkc;
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
public class MainFragment_1_xjkc extends BaseFragment {


    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.rv_list)
    RecyclerView rv_list;
    @BindView(R.id.ll_dgdb)
    LinearLayout ll_dgdb;
    @BindView(R.id.ll_gdq)
    LinearLayout ll_gdq;
    @BindView(R.id.tv_sjck)
    TextView tv_sjck;
    MainAdapter_1_xjkc mMainAdapter_1_xjkc;
    String typeName = "电光地板";
    @BindView(R.id.tv_nianji)
    TextView mTvNianji;
    @BindView(R.id.tv_jiaoxueneirong)
    TextView mTvJiaoxueneirong;
    @BindView(R.id.tv_daleibie)
    TextView mTvDaleibie;
    @BindView(R.id.tv_hexinzhibiao)
    TextView mTvHexinzhibiao;
    int page = 1;
    String courseName = null;
    String ageRange = null, contentType = null, category = null,theme = null,processType=null,trainType=null;

    List<String> list = new ArrayList<>();
    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_main_1_djkc;
    }

    @Override
    protected void initView() {
        tv_sjck.setVisibility(View.INVISIBLE);
        mTvHexinzhibiao.setVisibility(View.VISIBLE);
        mTvDaleibie.setText("流程");
        refreshLayout.setRefreshHeader(new MaterialHeader(mContext).setShowBezierWave(false));
        refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                getSchoolCourseListSmall();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page=1;
                ageRange = null; contentType = null; category = null;theme = null;processType=null;trainType=null;
                mTvNianji.setText("年级");
                mTvJiaoxueneirong.setText("教学内容");
                mTvDaleibie.setText("流程");
                mTvHexinzhibiao.setText("核心指标");
                getSchoolCourseListSmall();
            }
        });
        mMainAdapter_1_xjkc = new MainAdapter_1_xjkc(null);
        rv_list.setAdapter(mMainAdapter_1_xjkc);
        mMainAdapter_1_xjkc.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ((MainFragment_1) getBaseParentFragment(1)).setInitView(MainFragment_1.MAIN_FRAGMENT_INDEX_KCXQ,typeName+"——视频名称");
            }
        });
        mMainAdapter_1_xjkc.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.tv_bianji:
                        ((MainFragment_1) getBaseParentFragment(1)).setInitView(MainFragment_1.MAIN_FRAGMENT_INDEX_XJCK_BJ,typeName+"——编辑备课");
                        break;
                    case R.id.tv_fuzhi:

                        break;
                }
            }
        });
    }

    @Override
    protected void initData() {
        getSchoolCourseListSmall();
    }
    List<DictDataTypeBean> mDictDataTypeBeans = null;
    @OnClick({R.id.ll_dgdb, R.id.ll_gdq, R.id.tv_cjbk,R.id.tv_nianji, R.id.tv_jiaoxueneirong,R.id.tv_hexinzhibiao, R.id.tv_daleibie})
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
            case R.id.tv_cjbk:
                ((MainFragment_1) getBaseParentFragment(1)).setInitView(MainFragment_1.MAIN_FRAGMENT_INDEX_XJCK_BJ,typeName+"——创建备课");
                break;
            case R.id.tv_nianji:
                mDictDataTypeBeans = MainActivity.mDictDataTypeBeans.get("sys_grade");
                if(mDictDataTypeBeans==null){
                    return;
                }
                list.clear();
                for(int i=0;i<mDictDataTypeBeans.size();i++){
                    list.add(mDictDataTypeBeans.get(i).getDictLabel());
                }
                CustomPopWindow.initPopupWindow((Activity) mContext, mTvNianji, list,
                        new CustomPopWindow.PopWindowInterface() {
                            @Override
                            public void getPosition(int position) {
                                page=1;
                                mTvNianji.setText(list.get(position));
                                ageRange = mDictDataTypeBeans.get(position).getDictValue();
                                getSchoolCourseListSmall();
                            }
                        });
                break;
            case R.id.tv_jiaoxueneirong:
                mDictDataTypeBeans =  MainActivity.mDictDataTypeBeans.get("sys_content_type");
                if(mDictDataTypeBeans==null){
                    return;
                }
                list.clear();
                for(int i=0;i<mDictDataTypeBeans.size();i++){
                    list.add(mDictDataTypeBeans.get(i).getDictLabel());
                }
                CustomPopWindow.initPopupWindow((Activity) mContext, mTvJiaoxueneirong, list,
                        new CustomPopWindow.PopWindowInterface() {
                            @Override
                            public void getPosition(int position) {
                                page=1;
                                mTvJiaoxueneirong.setText(list.get(position));
                                contentType = mDictDataTypeBeans.get(position).getDictValue();
                                getSchoolCourseListSmall();
                            }
                        });
                break;
            case R.id.tv_hexinzhibiao:
                mDictDataTypeBeans =  MainActivity.mDictDataTypeBeans.get("sys_train_type");
                if(mDictDataTypeBeans==null){
                    return;
                }
                list.clear();
                for(int i=0;i<mDictDataTypeBeans.size();i++){
                    list.add(mDictDataTypeBeans.get(i).getDictLabel());
                }
                CustomPopWindow.initPopupWindow((Activity) mContext, mTvHexinzhibiao, list,
                        new CustomPopWindow.PopWindowInterface() {
                            @Override
                            public void getPosition(int position) {
                                page=1;
                                mTvHexinzhibiao.setText(list.get(position));
                                trainType = mDictDataTypeBeans.get(position).getDictValue();
                                getSchoolCourseListSmall();
                            }
                        });
                break;
            case R.id.tv_daleibie:
                mDictDataTypeBeans =  MainActivity.mDictDataTypeBeans.get("sys_process_type");
                if(mDictDataTypeBeans==null){
                    return;
                }
                list.clear();
                for(int i=0;i<mDictDataTypeBeans.size();i++){
                    list.add(mDictDataTypeBeans.get(i).getDictLabel());
                }
                CustomPopWindow.initPopupWindow((Activity) mContext, mTvDaleibie, list,
                        new CustomPopWindow.PopWindowInterface() {
                            @Override
                            public void getPosition(int position) {
                                page=1;
                                mTvDaleibie.setText(list.get(position));
                                processType = mDictDataTypeBeans.get(position).getDictValue();
                                getSchoolCourseListSmall();
                            }
                        });
                break;
        }
    }
    private void getSchoolCourseListSmall() {
        showLoading();
        RetrofitUtil.getInstance().apiService()
                .getSchoolCourseListSmall(courseName,ageRange,contentType,processType,trainType,
                        page,ConstValues.PAGE_SIZE)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<List<SchoolCourseBeanSmall>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<List<SchoolCourseBeanSmall>> result) {
                        if(isResultOk(result)){
                            if(page==1){
                                mMainAdapter_1_xjkc.setNewData(result.getData());
                            }else{
                                mMainAdapter_1_xjkc.addData(result.getData());
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
