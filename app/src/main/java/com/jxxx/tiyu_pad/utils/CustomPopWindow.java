package com.jxxx.tiyu_pad.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.tiyu_pad.R;
import com.jxxx.tiyu_pad.bean.CourseTypeListAllBean;
import com.jxxx.tiyu_pad.view.adapter.PopupWindowAdapter;

import java.util.ArrayList;
import java.util.List;

public class CustomPopWindow implements OnDismissListener {
    private static final String TAG = "CustomPopWindow";
    private static final float DEFAULT_ALPHA = 0.7F;
    private Context mContext;
    private int mWidth;
    private int mHeight;
    private boolean mIsFocusable;
    private boolean mIsOutside;
    private int mResLayoutId;
    private View mContentView;
    private PopupWindow mPopupWindow;
    private int mAnimationStyle;
    private boolean mClippEnable;
    private boolean mIgnoreCheekPress;
    private int mInputMode;
    private OnDismissListener mOnDismissListener;
    private int mSoftInputMode;
    private boolean mTouchable;
    private OnTouchListener mOnTouchListener;
    private Window mWindow;
    private boolean mIsBackgroundDark;
    private float mBackgroundDrakValue;
    private boolean enableOutsideTouchDisMiss;

    private CustomPopWindow(Context context) {
        this.mIsFocusable = true;
        this.mIsOutside = true;
        this.mResLayoutId = -1;
        this.mAnimationStyle = -1;
        this.mClippEnable = true;
        this.mIgnoreCheekPress = false;
        this.mInputMode = -1;
        this.mSoftInputMode = -1;
        this.mTouchable = true;
        this.mIsBackgroundDark = false;
        this.mBackgroundDrakValue = 0.0F;
        this.enableOutsideTouchDisMiss = true;
        this.mContext = context;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public CustomPopWindow showAsDropDown(View anchor, int xOff, int yOff) {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.showAsDropDown(anchor, xOff, yOff);
        }

        return this;
    }

    public CustomPopWindow showAsDropDown(View anchor) {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.showAsDropDown(anchor);
        }

        return this;
    }

    @RequiresApi(
            api = 19
    )
    public CustomPopWindow showAsDropDown(View anchor, int xOff, int yOff, int gravity) {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.showAsDropDown(anchor, xOff, yOff, gravity);
        }

        return this;
    }

    public CustomPopWindow showAtLocation(View parent, int gravity, int x, int y) {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.showAtLocation(parent, gravity, x, y);
        }

        return this;
    }

    private void apply(PopupWindow popupWindow) {
        popupWindow.setClippingEnabled(this.mClippEnable);
        if (this.mIgnoreCheekPress) {
            popupWindow.setIgnoreCheekPress();
        }

        if (this.mInputMode != -1) {
            popupWindow.setInputMethodMode(this.mInputMode);
        }

        if (this.mSoftInputMode != -1) {
            popupWindow.setSoftInputMode(this.mSoftInputMode);
        }

        if (this.mOnDismissListener != null) {
            popupWindow.setOnDismissListener(this.mOnDismissListener);
        }

        if (this.mOnTouchListener != null) {
            popupWindow.setTouchInterceptor(this.mOnTouchListener);
        }

        popupWindow.setTouchable(this.mTouchable);
    }

    private PopupWindow build() {
        if (this.mContentView == null) {
            this.mContentView = LayoutInflater.from(this.mContext).inflate(this.mResLayoutId, (ViewGroup)null);
        }

        Activity activity = (Activity)this.mContentView.getContext();
        if (activity != null && this.mIsBackgroundDark) {
            float alpha = this.mBackgroundDrakValue > 0.0F && this.mBackgroundDrakValue < 1.0F ? this.mBackgroundDrakValue : 0.7F;
            this.mWindow = activity.getWindow();
            LayoutParams params = this.mWindow.getAttributes();
            params.alpha = alpha;
            this.mWindow.addFlags(2);
            this.mWindow.setAttributes(params);
        }

        if (this.mWidth != 0 && this.mHeight != 0) {
            this.mPopupWindow = new PopupWindow(this.mContentView, this.mWidth, this.mHeight);
        } else {
            this.mPopupWindow = new PopupWindow(this.mContentView, -2, -2);
        }

        if (this.mAnimationStyle != -1) {
            this.mPopupWindow.setAnimationStyle(this.mAnimationStyle);
        }

        this.apply(this.mPopupWindow);
        if (this.mWidth == 0 || this.mHeight == 0) {
            this.mPopupWindow.getContentView().measure(0, 0);
            this.mWidth = this.mPopupWindow.getContentView().getMeasuredWidth();
            this.mHeight = this.mPopupWindow.getContentView().getMeasuredHeight();
        }

        this.mPopupWindow.setOnDismissListener(this);
        if (!this.enableOutsideTouchDisMiss) {
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setOutsideTouchable(false);
            this.mPopupWindow.setBackgroundDrawable((Drawable)null);
            this.mPopupWindow.getContentView().setFocusable(true);
            this.mPopupWindow.getContentView().setFocusableInTouchMode(true);
            this.mPopupWindow.getContentView().setOnKeyListener(new OnKeyListener() {
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (keyCode == 4) {
                        CustomPopWindow.this.mPopupWindow.dismiss();
                        return true;
                    } else {
                        return false;
                    }
                }
            });
            this.mPopupWindow.setTouchInterceptor(new OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    int x = (int)event.getX();
                    int y = (int)event.getY();
                    if (event.getAction() != 0 || x >= 0 && x < CustomPopWindow.this.mWidth && y >= 0 && y < CustomPopWindow.this.mHeight) {
                        if (event.getAction() == 4) {
                            Log.e("CustomPopWindow", "out side ...");
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        Log.e("CustomPopWindow", "out side ");
                        Log.e("CustomPopWindow", "width:" + CustomPopWindow.this.mPopupWindow.getWidth() + "height:" + CustomPopWindow.this.mPopupWindow.getHeight() + " x:" + x + " y  :" + y);
                        return true;
                    }
                }
            });
        } else {
            this.mPopupWindow.setFocusable(this.mIsFocusable);
            this.mPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
            this.mPopupWindow.setOutsideTouchable(this.mIsOutside);
        }

        this.mPopupWindow.update();
        return this.mPopupWindow;
    }

    public void onDismiss() {
        this.dissmiss();
    }

    public void dissmiss() {
        if (this.mOnDismissListener != null) {
            this.mOnDismissListener.onDismiss();
        }

        if (this.mWindow != null) {
            LayoutParams params = this.mWindow.getAttributes();
            params.alpha = 1.0F;
            this.mWindow.setAttributes(params);
        }

        if (this.mPopupWindow != null && this.mPopupWindow.isShowing()) {
            this.mPopupWindow.dismiss();
        }

    }

    public PopupWindow getPopupWindow() {
        return this.mPopupWindow;
    }

    public static class PopupWindowBuilder {
        private CustomPopWindow mCustomPopWindow;

        public PopupWindowBuilder(Context context) {
            this.mCustomPopWindow = new CustomPopWindow(context);
        }

        public PopupWindowBuilder size(int width, int height) {
            this.mCustomPopWindow.mWidth = width;
            this.mCustomPopWindow.mHeight = height;
            return this;
        }

        public PopupWindowBuilder setFocusable(boolean focusable) {
            this.mCustomPopWindow.mIsFocusable = focusable;
            return this;
        }

        public PopupWindowBuilder setView(int resLayoutId) {
            this.mCustomPopWindow.mResLayoutId = resLayoutId;
            this.mCustomPopWindow.mContentView = null;
            return this;
        }

        public PopupWindowBuilder setView(View view) {
            this.mCustomPopWindow.mContentView = view;
            this.mCustomPopWindow.mResLayoutId = -1;
            return this;
        }

        public PopupWindowBuilder setOutsideTouchable(boolean outsideTouchable) {
            this.mCustomPopWindow.mIsOutside = outsideTouchable;
            return this;
        }

        public PopupWindowBuilder setAnimationStyle(int animationStyle) {
            this.mCustomPopWindow.mAnimationStyle = animationStyle;
            return this;
        }

        public PopupWindowBuilder setClippingEnable(boolean enable) {
            this.mCustomPopWindow.mClippEnable = enable;
            return this;
        }

        public PopupWindowBuilder setIgnoreCheekPress(boolean ignoreCheekPress) {
            this.mCustomPopWindow.mIgnoreCheekPress = ignoreCheekPress;
            return this;
        }

        public PopupWindowBuilder setInputMethodMode(int mode) {
            this.mCustomPopWindow.mInputMode = mode;
            return this;
        }

        public PopupWindowBuilder setOnDissmissListener(OnDismissListener onDissmissListener) {
            this.mCustomPopWindow.mOnDismissListener = onDissmissListener;
            return this;
        }

        public PopupWindowBuilder setSoftInputMode(int softInputMode) {
            this.mCustomPopWindow.mSoftInputMode = softInputMode;
            return this;
        }

        public PopupWindowBuilder setTouchable(boolean touchable) {
            this.mCustomPopWindow.mTouchable = touchable;
            return this;
        }

        public PopupWindowBuilder setTouchIntercepter(OnTouchListener touchIntercepter) {
            this.mCustomPopWindow.mOnTouchListener = touchIntercepter;
            return this;
        }

        public PopupWindowBuilder enableBackgroundDark(boolean isDark) {
            this.mCustomPopWindow.mIsBackgroundDark = isDark;
            return this;
        }

        public PopupWindowBuilder setBgDarkAlpha(float darkValue) {
            this.mCustomPopWindow.mBackgroundDrakValue = darkValue;
            return this;
        }

        public PopupWindowBuilder enableOutsideTouchableDissmiss(boolean disMiss) {
            this.mCustomPopWindow.enableOutsideTouchDisMiss = disMiss;
            return this;
        }

        public CustomPopWindow create() {
            this.mCustomPopWindow.build();
            return this.mCustomPopWindow;
        }
    }
    public static CustomPopWindow initPopupWindow(Activity mActivity, View view1, List<String> lists, PopWindowInterface mPopWindowInterface) {
        View view = mActivity.getLayoutInflater().inflate(R.layout.popup_window_ty, null, false);
        RecyclerView rv_popup_list = view.findViewById(R.id.rv_popup_list);
        PopupWindowAdapter mPopupWindowAdapter = new PopupWindowAdapter(lists);
        if(view1 instanceof TextView){
            mPopupWindowAdapter.setTitle(((TextView) view1).getText().toString());
        }
        rv_popup_list.setAdapter(mPopupWindowAdapter);
        //创建PopupWindow
        CustomPopWindow distancePopWindow = new PopupWindowBuilder(mActivity)
                .setView(view)
                .setFocusable(true)//是否获取焦点，默认为ture
                .setOnDissmissListener(new OnDismissListener() {
                    @Override
                    public void onDismiss() {
//                        rbDistance.setChecked(false);
                    }
                })
                .setBgDarkAlpha(0.5f)
                .enableBackgroundDark(true)
                .setOutsideTouchable(true)//是否PopupWindow 以外触摸dissmiss
                .size(view1.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT)//显示大小
                .create()//创建PopupWindow
                .showAsDropDown(view1);//显示PopupWindow
        mPopupWindowAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mPopWindowInterface.getPosition(position);
                distancePopWindow.dissmiss();
            }
        });
        return distancePopWindow;
    }

    static int pos = -1;
    public static CustomPopWindow initPopupWindow_shuang(Activity mActivity, TextView view1, List<CourseTypeListAllBean> lists, PopWindowInterface_f mPopWindowInterface) {
        View view = mActivity.getLayoutInflater().inflate(R.layout.popup_window_ty, null, false);
        RecyclerView rv_popup_list = view.findViewById(R.id.rv_popup_list);
        view.findViewById(R.id.view).setVisibility(View.VISIBLE);
        RecyclerView rv_popup_list_f = view.findViewById(R.id.rv_popup_list_f);
        rv_popup_list_f.setVisibility(View.VISIBLE);
        List<String> titles = new ArrayList<>();
        for(int i=0;i<lists.size();i++){
            titles.add(lists.get(i).getTypeName());
        }
        PopupWindowAdapter mPopupWindowAdapter = new PopupWindowAdapter(titles);
        mPopupWindowAdapter.setYou(true);
        mPopupWindowAdapter.setTitle(view1.getText().toString());
        rv_popup_list.setAdapter(mPopupWindowAdapter);
        List<String> titles_f = new ArrayList<>();
        if(!view1.getText().toString().equals("大类别")){
            for(int i = 0 ;i<lists.size();i++){
                if(view1.getText().toString().contains(lists.get(i).getTypeName())){
                    pos = i;
                    for(int j=0;j< lists.get(i).getChildren().size();j++){
                        titles_f.add(lists.get(i).getChildren().get(j).getTypeName());
                    }
                }
            }
        }
        PopupWindowAdapter mPopupWindowAdapter_f = new PopupWindowAdapter(titles_f);
        mPopupWindowAdapter_f.setTitle(view1.getText().toString());
        rv_popup_list_f.setAdapter(mPopupWindowAdapter_f);
        //创建PopupWindow
        CustomPopWindow distancePopWindow = new PopupWindowBuilder(mActivity)
                .setView(view)
                .setFocusable(true)//是否获取焦点，默认为ture
                .setOnDissmissListener(new OnDismissListener() {
                    @Override
                    public void onDismiss() {
//                        rbDistance.setChecked(false);
                    }
                })
                .setBgDarkAlpha(0.5f)
                .enableBackgroundDark(true)
                .setOutsideTouchable(true)//是否PopupWindow 以外触摸dissmiss
                .size(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)//显示大小
                .create()//创建PopupWindow
                .showAsDropDown(view1);//显示PopupWindow
        mPopupWindowAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mPopWindowInterface.getPosition(lists.get(position).getId());
                List<String> titles_f = new ArrayList<>();
                for(int i=0;i<lists.get(position).getChildren().size();i++){
                    titles_f.add(lists.get(position).getChildren().get(i).getTypeName());
                }
                mPopupWindowAdapter_f.setNewData(titles_f);
                view1.setText(titles.get(position));
                pos = position;
                mPopupWindowAdapter.setTitle(titles.get(position));
                mPopupWindowAdapter.notifyDataSetChanged();

            }
        });
        mPopupWindowAdapter_f.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mPopWindowInterface.getPosition(lists.get(pos).getChildren().get(position).getId());
                view1.setText(lists.get(pos).getTypeName()+"/"+mPopupWindowAdapter_f.getData().get(position));
                distancePopWindow.dissmiss();
            }
        });
        return distancePopWindow;
    }

    public interface PopWindowInterface {
        public void getPosition( int position);
    }
    public interface PopWindowInterface_f {
        public void getPosition(String position);
    }
}
