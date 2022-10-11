package com.jxxx.tiyu_pad.utils;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;

import java.util.Calendar;
import java.util.Date;

public class TimeCounter extends CountDownTimer {

    private TextView tv;
    public TimeCounter(long millisInFuture, long countDownInterval, TextView tv) {
        super(millisInFuture, countDownInterval);
        this.tv=tv;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        tv.setClickable(false);
        tv.setText(millisUntilFinished/1000+"秒");
    }

    @Override
    public void onFinish() {
        tv.setClickable(true);
        tv.setText("获取验证码");
    }

    public static void selectorDate(Context mContext, boolean[] timeType, GetTimeInterface timeInterface){
        selectorDate(2000,2100,mContext,timeType,timeInterface);
    }
    /**
     * 时间选择器
     * @param mContext
     */
    public static void selectorDate(int startDateyy,int endDateyy,Context mContext, boolean[] timeType,GetTimeInterface timeInterface) {
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();

        //正确设置方式 原因：注意事项有说明
        startDate.set(startDateyy, 0, 1);
//        startDate.setTime(new Date());
        endDate.set(endDateyy, 11, 31);
        //时间选择器
        TimePickerView pvTime = new TimePickerBuilder(mContext, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                //Toast.makeText(MainActivity.this, getTime(date), Toast.LENGTH_SHORT).show();
                timeInterface.getTime(date);
            }
        })
                .setType(timeType)// 默认全部显示 new boolean[]{true, true, true, false, false, false};
                .setCancelText("取消")//取消按钮文字
                .setSubmitText("确定")//确认按钮文字
//                .setTitleSize(20)//标题文字大小
                .setTitleText("请选时间")//标题文字
//                .setOutSideCancelable(false)//点击屏幕，点在控件外部范围时，是否取消显示
                .isCyclic(false)//是否循环滚动
//                .setTitleColor(Color.BLACK)//标题文字颜色
//                .setSubmitColor(Color.BLUE)//确定按钮文字颜色
//                .setCancelColor(Color.BLUE)//取消按钮文字颜色
//                .setTitleBgColor(0xFF666666)//标题背景颜色 Night mode
//                .setBgColor(0xFF333333)//滚轮背景颜色 Night mode
                .setDate(Calendar.getInstance())// 如果不设置的话，默认是系统时间*/
                .setRangDate(startDate, endDate)//起始终止年月日设定
                .setLabel("年", "月", "日", "时", "分", "秒")//默认设置为年月日时分秒
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .isDialog(true)//是否显示为对话框样式
                .build();

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM);
        params.leftMargin = 0;
        params.rightMargin = 0;
        ViewGroup contentContainer = pvTime.getDialogContainerLayout();
        contentContainer.setLayoutParams(params);
        pvTime.getDialog().getWindow().setGravity(Gravity.BOTTOM);//可以改成Bottom
        pvTime.getDialog().getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        pvTime.show();
    }
    public interface GetTimeInterface{
        void getTime(Date time);
    }
}
