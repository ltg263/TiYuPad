package com.jxxx.tiyu_pad.view.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.core.app.ActivityCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jxxx.tiyu_pad.MainActivity;
import com.jxxx.tiyu_pad.R;
import com.jxxx.tiyu_pad.api.RetrofitUtil;
import com.jxxx.tiyu_pad.app.ConstValues;
import com.jxxx.tiyu_pad.app.MainApplication;
import com.jxxx.tiyu_pad.base.BaseActivity;
import com.jxxx.tiyu_pad.base.Result;
import com.jxxx.tiyu_pad.bean.AuthLoginBean;
import com.jxxx.tiyu_pad.utils.GlideImageLoader;
import com.jxxx.tiyu_pad.utils.SharedUtils;
import com.jxxx.tiyu_pad.utils.StringUtil;
import com.jxxx.tiyu_pad.utils.ToastUtil;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.iv_background)
    ImageView iv_background;
    @BindView(R.id.et_user)
    EditText mEtUser;
    @BindView(R.id.et_pas)
    EditText mEtPas;
    @BindView(R.id.btn_register)
    Button mBtnRegister;
    @BindView(R.id.btn_login)
    Button mBtnLogin;
    boolean isLogin = true;

    public static void startActivityIntent(Context mContext) {
        mContext.startActivity(new Intent(mContext, LoginActivity.class));
    }

    @Override
    public int intiLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        MainApplication.addActivity(this);

        Glide.with(this)
                .asGif()
                .load(R.drawable.tiyu_bj_gy)
                .into(iv_background);
//        new GlideImageLoader().loadGifFixXY(this,R.drawable.tiyu_bj_gy,iv_background);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.btn_login,R.id.btn_register})
    public void onClick(View view) {
        String[] permissions = new String[]{Manifest.permission.ACCESS_WIFI_STATE,
                Manifest.permission.CHANGE_WIFI_STATE,
                Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.CHANGE_NETWORK_STATE,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION};
        if (ActivityCompat.checkSelfPermission(this, permissions[0]) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, permissions[1]) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, permissions[2]) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, permissions[3]) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, permissions[4]) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, permissions[5]) != PackageManager.PERMISSION_GRANTED) {
//            String[] permissions = new String[]{Manifest.permission.ACCESS_FINE_LOCATION};
            ActivityCompat.requestPermissions(this, permissions, 1);
            return;
        }
        switch (view.getId()) {
            case R.id.btn_login:
                mEtUser.setHint("请输入账号");
                mEtPas.setHint("请输入密码");
                mBtnLogin.setBackgroundResource(R.drawable.btn_shape_theme_login);
                mBtnRegister.setBackgroundResource(R.drawable.btn_shape_theme_999);
                if(isLogin){
                    postAuthLogin();
                }
                isLogin = true;
                break;
            case R.id.btn_register:
                mEtUser.setHint("请设置账号");
                mEtPas.setHint("请设置密码");
                mBtnRegister.setBackgroundResource(R.drawable.btn_shape_theme_login);
                mBtnLogin.setBackgroundResource(R.drawable.btn_shape_theme_999);
                if(!isLogin){
                    postAuthRegister();
                }
                isLogin = false;
                break;
        }

    }

    private void postAuthRegister() {
        String username = mEtUser.getText().toString();
        String password = mEtPas.getText().toString();
        if(StringUtil.isBlank(username) || StringUtil.isBlank(password)){
            ToastUtil.showLongStrToast(this,"账号或密码不能为空");
            return;
        }
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("username", username);
        paramMap.put("password", password);
        paramMap.put("userType", "sys_user");
        showLoading();
        RetrofitUtil.getInstance().apiService()
                .postAuthRegister(RetrofitUtil.createJsonRequest(paramMap))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result result) {
                        if(isResultOk(result)){
                            ToastUtil.showLongStrToast(LoginActivity.this,"注册成功");
                            mEtUser.setHint("请输入账号");
                            mEtPas.setHint("请输入密码");
                            mBtnLogin.setBackgroundResource(R.drawable.btn_shape_theme_login);
                            mBtnRegister.setBackgroundResource(R.drawable.btn_shape_theme_999);
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

    private void postAuthLogin() {
        String username = mEtUser.getText().toString();
        String password = mEtPas.getText().toString();
        if(StringUtil.isBlank(username) || StringUtil.isBlank(password)){
            ToastUtil.showLongStrToast(this,"账号或密码不能为空");
            return;
        }
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("username", username);
        paramMap.put("password", password);
        paramMap.put("userType", "sys_user");
        showLoading();
        RetrofitUtil.getInstance().apiService()
                .postAuthLogin(RetrofitUtil.createJsonRequest(paramMap))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<AuthLoginBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<AuthLoginBean> result) {
                        if(isResultOk(result)){
                            ToastUtil.showLongStrToast(LoginActivity.this,"登录成功");
                            SharedUtils.singleton().put(ConstValues.TOKEN,result.getData().getAccess_token());
                            SharedUtils.singleton().put(ConstValues.TEACHER_ID,result.getData().getTeacherId());
                            SharedUtils.singleton().put(ConstValues.SCHOOL_ID,result.getData().getSchoolId());
                            SharedUtils.singleton().put(ConstValues.USER_ID,result.getData().getUserId());
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            finish();
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
