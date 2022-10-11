package com.jxxx.tiyu_pad.base;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import com.jxxx.tiyu_pad.R;
import com.jxxx.tiyu_pad.utils.StatusBarUtil;
import com.jxxx.tiyu_pad.utils.StringUtil;
import com.jxxx.tiyu_pad.utils.ToastUtil;
import com.jxxx.tiyu_pad.utils.view.LoadingDialog;

import butterknife.ButterKnife;


/**
 * Created by Administrator on 2018/8/25.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected final String TAG = this.getClass().getSimpleName();
    private LoadingDialog mLoading;

    protected String tag = "";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        StatusBarUtil.setStatusBarMode(this, true, R.color.white);
//        if (Build.VERSION.SDK_INT >= 21) {
//            View decorView = getWindow().getDecorView();
//            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//            decorView.setSystemUiVisibility(option);
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//        }
        setContentView(intiLayout());
        ButterKnife.bind(this);
        //初始化控件
        initView();
        //设置数据
        initData();
    }

    /**
     * 设置布局
     *
     * @return
     */
    public abstract int intiLayout();

    /**
     * 初始化布局
     */
    public abstract void initView();

    /**
     * 设置数据
     */
    public abstract void initData();
    public void setToolbar(Toolbar mToolbar, String title) {
        this.setToolbar(mToolbar, title, true,null);
    }
    public void setToolbarR(Toolbar mToolbar, String title,String strR) {
        this.setToolbar(mToolbar, title, true,strR);
    }

    public void setToolbar(Toolbar mToolbar, String title, Boolean isBack,String strR) {
        Log.w("strR","strR"+strR);
        TextView mViewToolBarTitle = mToolbar.findViewById(R.id.toolbar_title);
        mViewToolBarTitle.setText(title);
        if(StringUtil.isNotBlank(strR)){
            TextView tv_xz = mToolbar.findViewById(R.id.tv_xz);
            tv_xz.setVisibility(View.VISIBLE);
            tv_xz.setText(strR);
        }
        if (isBack) {
            mToolbar.setNavigationIcon(R.mipmap.back_b);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressedA();
                }
            });
        }
    }

    public void onBackPressedA(){
        finish();
    }

    public void readyGoActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

    public void showLoading() {
        if (mLoading != null && !mLoading.isShowing()) {
            mLoading.show();
        } else {
            mLoading = LoadingDialog.show(this, R.string.loading_text, false, null);
        }
    }

    public void showLoading(String name) {
        if (mLoading != null && !mLoading.isShowing()) {
            mLoading.show();
        } else {
            mLoading = LoadingDialog.show(this, name, false, null);
        }
    }


    public void hideLoading() {
        if (mLoading != null && mLoading.isShowing()) {
            mLoading.dismiss();
        }
    }

    /**
     * 点击屏幕隐藏软键盘方法
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    //处理Editext的光标隐藏、显示逻辑
                    v.clearFocus();
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }
    public boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击的是输入框区域，保留点击EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
    }



    public boolean isResultOk(Result mResult) {
        if(mResult.getCode()==200){
            return true;
        }
        return false;
    }
}
