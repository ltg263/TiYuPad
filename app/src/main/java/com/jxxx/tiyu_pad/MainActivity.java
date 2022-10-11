package com.jxxx.tiyu_pad;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.jxxx.tiyu_pad.api.RetrofitUtil;
import com.jxxx.tiyu_pad.app.MainApplication;
import com.jxxx.tiyu_pad.base.BaseActivity;
import com.jxxx.tiyu_pad.base.BaseFragment;
import com.jxxx.tiyu_pad.base.Result;
import com.jxxx.tiyu_pad.bean.CourseTypeListAllBean;
import com.jxxx.tiyu_pad.bean.DictDataTypeBean;
import com.jxxx.tiyu_pad.bean.UserInfoProfileBean;
import com.jxxx.tiyu_pad.bean.VersionResponse;
import com.jxxx.tiyu_pad.utils.CustomPopWindow;
import com.jxxx.tiyu_pad.utils.SharedUtils;
import com.jxxx.tiyu_pad.utils.StringUtil;
import com.jxxx.tiyu_pad.utils.ToastUtil;
import com.jxxx.tiyu_pad.utils.view.DialogUtils;
import com.jxxx.tiyu_pad.view.activity.LoginActivity;
import com.jxxx.tiyu_pad.view.fragment.MainFragment_1;
import com.jxxx.tiyu_pad.view.fragment.MainFragment_2;
import com.jxxx.tiyu_pad.view.fragment.MainFragment_3;
import com.jxxx.tiyu_pad.view.fragment.MainFragment_4;
import com.jxxx.tiyu_pad.view.fragment.MainFragment_5;
import com.jxxx.tiyu_pad.view.fragment.MainFragment_6;
import com.jxxx.tiyu_pad.view.fragment.MainFragment_7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends BaseActivity {
    @BindView(R.id.main_title_1)
    LinearLayout mMainTitle1;
    @BindView(R.id.main_title_2)
    LinearLayout mMainTitle2;
    @BindView(R.id.main_title_3)
    LinearLayout mMainTitle3;
    @BindView(R.id.main_title_4)
    LinearLayout mMainTitle4;
    @BindView(R.id.main_title_5)
    LinearLayout mMainTitle5;
    @BindView(R.id.main_title_6)
    LinearLayout mMainTitle6;
    @BindView(R.id.main_title_7)
    LinearLayout mMainTitle7;
    @BindView(R.id.frameLayout)
    FrameLayout mFrameLayout;
    @BindView(R.id.iv_1)
    ImageView mIv1;
    @BindView(R.id.tv_1)
    TextView mTv1;
    @BindView(R.id.iv_2)
    ImageView mIv2;
    @BindView(R.id.tv_2)
    TextView mTv2;
    @BindView(R.id.iv_3)
    ImageView mIv3;
    @BindView(R.id.tv_3)
    TextView mTv3;
    @BindView(R.id.iv_4)
    ImageView mIv4;
    @BindView(R.id.tv_4)
    TextView mTv4;
    @BindView(R.id.iv_5)
    ImageView mIv5;
    @BindView(R.id.tv_5)
    TextView mTv5;
    @BindView(R.id.iv_6)
    ImageView mIv6;
    @BindView(R.id.tv_6)
    TextView mTv6;
    @BindView(R.id.iv_7)
    ImageView mIv7;
    @BindView(R.id.tv_7)
    TextView mTv7;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_name)
    TextView tv_name;
    @BindView(R.id.tv_title_name)
    TextView tv_title_name;
    @BindView(R.id.ll_back)
    LinearLayout ll_back;
    @BindView(R.id.ll_title)
    LinearLayout ll_title;
    @BindView(R.id.iv_background)
    ImageView iv_background;
    private Fragment mFragment;
    private BaseFragment mMainFragment_1,mMainFragment_2,mMainFragment_3,mMainFragment_4,mMainFragment_5,mMainFragment_6,mMainFragment_7;
    public static Map<String, List<DictDataTypeBean>> mDictDataTypeBeans;
    public static Map<String,List<CourseTypeListAllBean>> mCourseTypeListAllBeans;

    public LinearLayout getLl_back() {
        return ll_back;
    }

    public TextView getTv_title_name() {
        return tv_title_name;
    }

    @Override
    public int intiLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);//保持屏幕唤醒
        MainApplication.addActivity(this);
        Glide.with(this)
                .asGif()
                .load(R.drawable.tiyu_bj_gy)
                .into(iv_background);
        initBottomBar();
//        new GlideImageLoader().loadGifFixXY(this,R.drawable.tiyu_bj_gy,iv_background);

        mDictDataTypeBeans = new HashMap<>();
        mCourseTypeListAllBeans = new HashMap<>();
        //大课程
        // 'sys_grade', //年级
        // 'sys_content_type', //教学内容
        // 'sys_category', //大类别
        // 'sys_theme', //主题内容
        //小课程
        // 'sys_grade', //年级
        // 'sys_content_type', //教学内容
        // 'sys_process_type', //流程
        // 'sys_train_type', //核心指标
        getDictDataType("sys_grade");//年级
        getDictDataType("sys_content_type");//教学内容
        getDictDataType("sys_category");//大类别
        getDictDataType("sys_theme"); //主题内容
        getDictDataType("sys_process_type"); //流程
        getDictDataType("sys_train_type"); //核心指标
    }

    @Override
    public void initData() {
        getSchoolTeacherCurrent();
//        RetrofitUtil.getInstance().apiService()
//                .getLast("1")
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Observer<Result<VersionResponse>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Result<VersionResponse> result) {
//                        if (result.getCode() == 200) {
////                            if(!result.getData().getVersionNo().equals(getVersionName(MainActivity.this))){
////                                DialogUtils.goUpdating(MainActivity.this,result.getData());
////                            }
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//                    }
//                });
    }


    /**
     * 获取筛选的条件
     */
    private void getDictDataType(String dictType) {
        if("sys_category".equals(dictType)){
            RetrofitUtil.getInstance().apiService()
                    .getCourseTypeListAll()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Observer<Result<List<CourseTypeListAllBean>>>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(Result<List<CourseTypeListAllBean>> result) {
                            if(isResultOk(result)){
                                mCourseTypeListAllBeans.put(dictType,result.getData());
                            }
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {
                        }
                    });
            return;
        }
        RetrofitUtil.getInstance().apiService()
                .getDictDataType(dictType)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<List<DictDataTypeBean>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<List<DictDataTypeBean>> result) {
                        if(isResultOk(result)){
                            mDictDataTypeBeans.put(dictType,result.getData());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }
    private void initBottomBar() {
        mMainFragment_1 = new MainFragment_1();
        mMainFragment_2 = new MainFragment_2();
        mMainFragment_3 = new MainFragment_3();
        mMainFragment_4 = new MainFragment_4();
        mMainFragment_5 = new MainFragment_5();
        mMainFragment_6 = new MainFragment_6();
        mMainFragment_7 = new MainFragment_7();
        mFragment = mMainFragment_1;
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frameLayout, mMainFragment_1).commit();
        setSelectedItemIndex(mMainFragment_1,mMainTitle1,mTv1,mIv1);
    }


    public void switchFragment(Fragment fragment) {
        //判断当前显示的Fragment是不是切换的Fragment
        if (mFragment != fragment) {
            if (!fragment.isAdded()) {
                //如果没有，则先把当前的Fragment隐藏，把切换的Fragment添加上
                getSupportFragmentManager().beginTransaction().hide(mFragment).add(R.id.frameLayout, fragment).commit();
            } else {
                //如果已经添加过，则先把当前的Fragment隐藏，把切换的Fragment显示出来
                getSupportFragmentManager().beginTransaction().hide(mFragment).show(fragment).commit();
            }
            mFragment = fragment;
        }
    }

    @Override
    public void onBackPressed() {
        ToastUtil.showToast("再按一次退出程序");
        if (isSlowDoubleClick()) {
            this.finish();
            System.exit(0);
        } else {

        }
    }

    private static long lastClickTime = 0;

    public static boolean isSlowDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < 2000) {
            return true;
        }

        lastClickTime = time;

        return false;
    }

    @OnClick({R.id.main_title_1, R.id.main_title_2,
            R.id.main_title_3, R.id.main_title_4,
            R.id.main_title_5, R.id.main_title_6,
            R.id.main_title_7, R.id.ll_back,
            R.id.ll_title})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_title_1:
                setSelectedItemIndex(mMainFragment_1,mMainTitle1,mTv1,mIv1);
                break;
            case R.id.main_title_2:
                setSelectedItemIndex(mMainFragment_2,mMainTitle2,mTv2,mIv2);
                break;
            case R.id.main_title_3:
                setSelectedItemIndex(mMainFragment_3,mMainTitle3,mTv3,mIv3);
                break;
            case R.id.main_title_4:
                setSelectedItemIndex(mMainFragment_4,mMainTitle4,mTv4,mIv4);
                break;
            case R.id.main_title_5:
                setSelectedItemIndex(mMainFragment_5,mMainTitle5,mTv5,mIv5);
                break;
            case R.id.main_title_6:
                setSelectedItemIndex(mMainFragment_6,mMainTitle6,mTv6,mIv6);
                break;
            case R.id.main_title_7:
                setSelectedItemIndex(mMainFragment_7,mMainTitle7,mTv7,mIv7);
                break;
            case R.id.ll_back:
                ((BaseFragment)mFragment).setBackStack();
                break;
            case R.id.ll_title:
                showDistancePopup();
                break;
        }
    }
    private void setSelectedItemIndex(Fragment mFragment,LinearLayout mMainTitle,TextView mTv,ImageView mIv){
        mMainTitle1.setBackgroundColor(getResources().getColor(R.color.color_transparent));
        mMainTitle2.setBackgroundColor(getResources().getColor(R.color.color_transparent));
        mMainTitle3.setBackgroundColor(getResources().getColor(R.color.color_transparent));
        mMainTitle4.setBackgroundColor(getResources().getColor(R.color.color_transparent));
        mMainTitle5.setBackgroundColor(getResources().getColor(R.color.color_transparent));
        mMainTitle6.setBackgroundColor(getResources().getColor(R.color.color_transparent));
        mMainTitle7.setBackgroundColor(getResources().getColor(R.color.color_transparent));
        mTv1.setTextColor(getResources().getColor(R.color.main_color_text));
        mTv2.setTextColor(getResources().getColor(R.color.main_color_text));
        mTv3.setTextColor(getResources().getColor(R.color.main_color_text));
        mTv4.setTextColor(getResources().getColor(R.color.main_color_text));
        mTv5.setTextColor(getResources().getColor(R.color.main_color_text));
        mTv6.setTextColor(getResources().getColor(R.color.main_color_text));
        mTv7.setTextColor(getResources().getColor(R.color.main_color_text));
        mIv1.setVisibility(View.INVISIBLE);
        mIv2.setVisibility(View.INVISIBLE);
        mIv3.setVisibility(View.INVISIBLE);
        mIv4.setVisibility(View.INVISIBLE);
        mIv5.setVisibility(View.INVISIBLE);
        mIv6.setVisibility(View.INVISIBLE);
        mIv7.setVisibility(View.INVISIBLE);

        mMainTitle.setBackgroundColor(getResources().getColor(R.color.main_color_text));
        mTv.setTextColor(getResources().getColor(R.color.white));
        mIv.setVisibility(View.VISIBLE);

        switchFragment(mFragment);
    }

    private CustomPopWindow distancePopWindow;
    private void showDistancePopup() {

        View view = getLayoutInflater().inflate(R.layout.popup_window_sb, null, false);
        TextView tvTuiChu = view.findViewById(R.id.tv_tuichu);
        tvTuiChu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                distancePopWindow.dissmiss();
                DialogUtils.showDialogHint(MainActivity.this, "您确定要退出登录吗？",
                        false, new DialogUtils.ErrorDialogInterface() {
                            @Override
                            public void btnConfirm() {
                                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                                finish();
                            }
                        });
            }
        });
        //创建并显示popWindow
        distancePopWindow = new CustomPopWindow.PopupWindowBuilder(this)
                .setView(view)
                .setFocusable(true)//是否获取焦点，默认为ture
                .setOnDissmissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
//                        rbDistance.setChecked(false);
                    }
                })
                .setOutsideTouchable(true)//是否PopupWindow 以外触摸dissmiss
                .size(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)//显示大小
                .create()//创建PopupWindow
                .showAsDropDown(ll_title, ll_title.getWidth(), 0);//显示PopupWindow
    }
    private void getSchoolTeacherCurrent() {
        RetrofitUtil.getInstance().apiService()
                .getSchoolTeacherCurrent()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<UserInfoProfileBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<UserInfoProfileBean> result) {
                        if (isResultOk(result)) {
                            tv_title.setText(result.getData().getTeacherName());
                            tv_name.setText(result.getData().getTeacherName()+"\n任职"+result.getData().getSchoolName()+"学校");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

}