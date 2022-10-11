package com.jxxx.tiyu_pad.utils.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.jxxx.tiyu_pad.R;
import com.jxxx.tiyu_pad.bean.SchoolStudentDetailBean;
import com.jxxx.tiyu_pad.bean.VersionResponse;
import com.jxxx.tiyu_pad.utils.CustomPopWindow;
import com.jxxx.tiyu_pad.utils.GlideImgLoader;
import com.jxxx.tiyu_pad.utils.StringUtil;
import com.jxxx.tiyu_pad.utils.TimeCounter;
import com.jxxx.tiyu_pad.utils.ToastUtil;
import com.jxxx.tiyu_pad.view.adapter.MainAdapter_4_dialog_kcxz;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import constant.UiType;
import listener.Md5CheckResultListener;
import listener.UpdateDownloadListener;
import model.UiConfig;
import model.UpdateConfig;
import update.UpdateAppUtils;

public class DialogUtils {

    public static void showDialogHint(Context context, String title, boolean isOne, final ErrorDialogInterface dialogConfirm) {

        final Dialog dialog5 = new Dialog(context, R.style.selectorDialog);
        final View view = LayoutInflater.from(context).inflate(R.layout.dialog_hine, null);
        TextView bt_ok = (TextView) view.findViewById(R.id.bt_confirm);
        TextView suanle = (TextView) view.findViewById(R.id.bt_suanle);
        TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_title.setText(title);
        if(isOne){
            suanle.setVisibility(View.GONE);
        }
        suanle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog5.dismiss();
            }
        });
        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dialogConfirm!=null){
                    dialogConfirm.btnConfirm();
                }
                dialog5.dismiss();
            }
        });
        dialog5.setCancelable(false);
        dialog5.setContentView(view);
        dialog5.show();
    }

    /**
     * 设备外带申报单
     */
    public static void showDialogWaiDaiShenBao(Context context, String title,final ErrorDialogInterfaceA dialogConfirm) {

        final Dialog dialog5 = new Dialog(context, R.style.selectorDialog);
        final View view = LayoutInflater.from(context).inflate(R.layout.dialog_sbgl_waidaishenbao, null);
        TextView btn_1 =  view.findViewById(R.id.btn_1);
        TextView btn_2 =  view.findViewById(R.id.btn_2);
        btn_1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(dialogConfirm!=null){
                    dialogConfirm.btnConfirm(1);
                }
                dialog5.dismiss();
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog5.dismiss();
            }
        });
        dialog5.setCancelable(false);
        dialog5.setContentView(view);
        dialog5.show();
    }
    /**
     * 设备主机详情
     */
    public static void showDialogZhuJiXiangQing(Context context, String title,final ErrorDialogInterfaceA dialogConfirm) {

        final Dialog dialog5 = new Dialog(context, R.style.selectorDialog);
        final View view = LayoutInflater.from(context).inflate(R.layout.dialog_sbgl_zhujixiangqiang, null);
//        TextView btn_1 =  view.findViewById(R.id.btn_1);
//        TextView btn_2 =  view.findViewById(R.id.btn_2);
//        btn_1.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                if(dialogConfirm!=null){
//                    dialogConfirm.btnConfirm(1);
//                }
//                dialog5.dismiss();
//            }
//        });
//        btn_2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog5.dismiss();
//            }
//        });
        dialog5.setCancelable(true);
        dialog5.setContentView(view);
        dialog5.show();
    }
    /**
     * 设备损坏申报单
     */
    public static void showDialogSunHuaiShenBao(Context context, String title,final ErrorDialogInterfaceA dialogConfirm) {

        final Dialog dialog5 = new Dialog(context, R.style.selectorDialog);
        final View view = LayoutInflater.from(context).inflate(R.layout.dialog_sbgl_sunhuanshenbao, null);
        TextView btn_1 =  view.findViewById(R.id.btn_1);
        TextView btn_2 =  view.findViewById(R.id.btn_2);
        btn_1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(dialogConfirm!=null){
                    dialogConfirm.btnConfirm(1);
                }
                dialog5.dismiss();
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog5.dismiss();
            }
        });
        dialog5.setCancelable(false);
        dialog5.setContentView(view);
        dialog5.show();
    }

    /**
     * 申请学校
     */
    public static void showDialogShenqingxuexiao(Context context, String title,final ErrorDialogInterfaceA dialogConfirm) {

        final Dialog dialog5 = new Dialog(context, R.style.selectorDialog);
        final View view = LayoutInflater.from(context).inflate(R.layout.dialog_qtsz_shenqingxuexiao, null);
        TextView btn =  view.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(dialogConfirm!=null){
                    dialogConfirm.btnConfirm(1);
                }
                dialog5.dismiss();
            }
        });
        dialog5.setCancelable(true);
        dialog5.setContentView(view);
        dialog5.show();
    }

    /**
     * 课程编辑
     */
    public static void showDialogKeChengKuBianji(Context context, String title,final ErrorDialogInterfaceA dialogConfirm) {

        final Dialog dialog5 = new Dialog(context, R.style.selectorDialog);
        final View view = LayoutInflater.from(context).inflate(R.layout.dialog_kechengku_bianji, null);
        TextView btn =  view.findViewById(R.id.btn);
        ImageView iv_quxiao =view.findViewById(R.id.iv_quxiao);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(dialogConfirm!=null){
                    dialogConfirm.btnConfirm(1);
                }
                dialog5.dismiss();
            }
        });
        iv_quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog5.dismiss();
            }
        });
        dialog5.setCancelable(true);
        dialog5.setContentView(view);
        dialog5.show();
    }

    /**
     * 课程编辑——下一步
     */
    public static void showDialogKeChengKuBianji_xyb(Context context, String title,final ErrorDialogInterfaceA dialogConfirm) {

        final Dialog dialog5 = new Dialog(context, R.style.selectorDialog);
        final View view = LayoutInflater.from(context).inflate(R.layout.dialog_kechengku_bianji_xyb, null);
        TextView btn_1 =  view.findViewById(R.id.btn_1);
        TextView btn_2 =  view.findViewById(R.id.btn_2);
        ImageView iv_quxiao =view.findViewById(R.id.iv_quxiao);
        btn_1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(dialogConfirm!=null){
                    dialogConfirm.btnConfirm(1);
                }
                dialog5.dismiss();
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(dialogConfirm!=null){
                    dialogConfirm.btnConfirm(2);
                }
                dialog5.dismiss();
            }
        });
        iv_quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog5.dismiss();
            }
        });
        dialog5.setCancelable(true);
        dialog5.setContentView(view);
        dialog5.show();
    }

    /**
     * 课程编辑——下一步_开始运动
     */
    public static void showDialogKeChengKuBianji_xyb_ksyd(Context context, String title,final ErrorDialogInterfaceA dialogConfirm) {

        final Dialog dialog5 = new Dialog(context, R.style.selectorDialog);
        final View view = LayoutInflater.from(context).inflate(R.layout.dialog_kechengku_bianji_xyb_ksyd, null);
        Button btn =  view.findViewById(R.id.btn);
        ImageView iv_quxiao =view.findViewById(R.id.iv_quxiao);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(dialogConfirm!=null){
                    dialogConfirm.btnConfirm(1);
                }
                dialog5.dismiss();
            }
        });
        iv_quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog5.dismiss();
            }
        });
        dialog5.setCancelable(true);
        dialog5.setContentView(view);
        dialog5.show();
    }

    /**
     * 学生信息
     */
    public static void showDialogXueShengXinXi(Context context, SchoolStudentDetailBean mSchoolStudentDetailBean, final ErrorDialogInterfaceXueSheng dialogConfirm) {

        final Dialog dialog5 = new Dialog(context, R.style.selectorDialog);
        final View view = LayoutInflater.from(context).inflate(R.layout.dialog_xuesheng_xinxi, null);
        Button btn =  view.findViewById(R.id.btn);
        EditText tv_id =  view.findViewById(R.id.tv_id);
        EditText tv_name =  view.findViewById(R.id.tv_name);
        TextView tv_xb =  view.findViewById(R.id.tv_xb);
        TextView tv_csrq =  view.findViewById(R.id.tv_csrq);
        EditText tv_sg =  view.findViewById(R.id.tv_sg);
        EditText tv_tz =  view.findViewById(R.id.tv_tz);
        EditText tv_dh =  view.findViewById(R.id.tv_dh);
        ImageView iv_zb =  view.findViewById(R.id.iv_zb);
        if(mSchoolStudentDetailBean!=null){
            tv_id.setText(mSchoolStudentDetailBean.getId());
            tv_name.setText(mSchoolStudentDetailBean.getStudentName());

            String gender = "未知";
            if(mSchoolStudentDetailBean.getGender()==0){
                gender = "男";
            }
            if(mSchoolStudentDetailBean.getGender()==1){
                gender = "女";
            }
            if(mSchoolStudentDetailBean.getGender()==2){
                gender = "未知";
            }
            tv_xb.setText(gender);
            tv_csrq.setText(mSchoolStudentDetailBean.getBirthday());
            tv_sg.setText(mSchoolStudentDetailBean.getHeight());
            tv_tz.setText(mSchoolStudentDetailBean.getWeight());
            tv_dh.setText(mSchoolStudentDetailBean.getParentPhone());
            GlideImgLoader.loadImageViewRadius(context,(String) mSchoolStudentDetailBean.getImgUrl(),10,iv_zb);
        }
        if(mSchoolStudentDetailBean==null){
            mSchoolStudentDetailBean = new SchoolStudentDetailBean();
        }
        SchoolStudentDetailBean finalMSchoolStudentDetailBean = mSchoolStudentDetailBean;

        List<String> lists = new ArrayList<>();
        lists.add("未知");
        lists.add("男");
        lists.add("女");
        tv_xb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomPopWindow.initPopupWindow((Activity) context, tv_xb, lists,
                        new CustomPopWindow.PopWindowInterface() {
                            @Override
                            public void getPosition(int position) {
                                tv_xb.setText(lists.get(position));
                            }
                        });
            }
        });
        tv_csrq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                TimeCounter.selectorDate(cal.get(Calendar.YEAR)-100,cal.get(Calendar.YEAR),context,
                        new boolean[]{true,true,true,false,false,false}, new TimeCounter.GetTimeInterface() {
                            @Override
                            public void getTime(Date time) {
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                tv_csrq.setText(simpleDateFormat.format(time));
                            }
                        });
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(dialogConfirm!=null){
                    String xb = tv_xb.getText().toString();
                    int gender = 2;
                    if(xb.equals("未知")){
                        gender = 2;
                    }
                    if(xb.equals("男") || xb.equals("女")){
                        gender = xb.equals("男")?0:1;
                    }
                    finalMSchoolStudentDetailBean.setStudentNo(tv_id.getText().toString());
                    finalMSchoolStudentDetailBean.setStudentName(tv_name.getText().toString());
                    finalMSchoolStudentDetailBean.setGender(gender);
                    finalMSchoolStudentDetailBean.setBirthday(tv_csrq.getText().toString());
                    finalMSchoolStudentDetailBean.setHeight(tv_sg.getText().toString());
                    finalMSchoolStudentDetailBean.setWeight(tv_tz.getText().toString());
                    finalMSchoolStudentDetailBean.setParentPhone(tv_dh.getText().toString());
                    finalMSchoolStudentDetailBean.setImgUrl("https://pics0.baidu.com/feed/9345d688d43f87948e582ea0ef1418ff1ad53ab6.jpeg@f_auto?token=44910339b3568419d3b59b607f36fdee");
                    dialogConfirm.btnConfirm(finalMSchoolStudentDetailBean);
                }
                dialog5.dismiss();
            }
        });
        dialog5.setCancelable(true);
        dialog5.setContentView(view);
        dialog5.show();
    }

    /**
     * 选择小节课程
     */
    public static void showDialogSelectXiaoJie(Context context, String title,final ErrorDialogInterfaceA dialogConfirm) {

        final Dialog dialog5 = new Dialog(context, R.style.selectorDialog);
        final View view = LayoutInflater.from(context).inflate(R.layout.dialog_select_xiaojie, null);
        Display  mDisplay = ((Activity) context).getWindowManager().getDefaultDisplay();
        Log.w("paramsAct","paramsAct.width:"+mDisplay.getWidth());
        Log.w("paramsAct","paramsAct.height:"+mDisplay.getHeight());
        ViewGroup.LayoutParams layout = new ViewGroup.LayoutParams(mDisplay.getWidth()-500, mDisplay.getHeight()-200);
        RecyclerView rv_list = view.findViewById(R.id.rv_list);
        Button btn =  view.findViewById(R.id.btn);
        List<String> list_sq = new ArrayList<>();
        list_sq.add("每组4人  |  共4个小节");
        list_sq.add("每组4人  |  共4个小节");
        list_sq.add("每组4人  |  共4个小节");
        list_sq.add("每组4人  |  共4个小节");
        list_sq.add("每组4人  |  共4个小节");
        rv_list.setAdapter(new MainAdapter_4_dialog_kcxz(list_sq));
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(dialogConfirm!=null){
                    dialogConfirm.btnConfirm(1);
                }
                dialog5.dismiss();
            }
        });
        dialog5.setCancelable(true);
        dialog5.setContentView(view,layout);
        dialog5.show();
    }
    /**
     * 开始上课
     */
    public static void showDialogKaiShiShangKe(Context context, String title,final ErrorDialogInterfaceA dialogConfirm) {

        final Dialog dialog5 = new Dialog(context, R.style.selectorDialog);
        final View view = LayoutInflater.from(context).inflate(R.layout.dialog_kaishishangke, null);
        TextView btn_kaishishangke = (TextView) view.findViewById(R.id.btn_kaishishangke);
        ImageView iv_quxiao =view.findViewById(R.id.iv_quxiao);
        TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_title.setText(title);
        btn_kaishishangke.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(dialogConfirm!=null){
                    dialogConfirm.btnConfirm(1);
                }
                dialog5.dismiss();
            }
        });
        iv_quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog5.dismiss();
            }
        });
        dialog5.setCancelable(false);
        dialog5.setContentView(view);
        dialog5.show();
    }

    /**
     * 备课设备提示
     */
    public static void showDialogBeiKeSheBei(Context context, String title,final ErrorDialogInterfaceA dialogConfirm) {

        final Dialog dialog5 = new Dialog(context, R.style.selectorDialog);
        final View view = LayoutInflater.from(context).inflate(R.layout.dialog_beikebuzu_show, null);
        Button btn_fangqi = view.findViewById(R.id.btn_fangqi);
        Button btn_queren =view.findViewById(R.id.btn_queren);
        TextView tv_title = (TextView) view.findViewById(R.id.tv_title_1);
        tv_title.setText(title);
        btn_fangqi.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(dialogConfirm!=null){
                    dialogConfirm.btnConfirm(1);
                }
                dialog5.dismiss();
            }
        });
        btn_queren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog5.dismiss();
            }
        });
        dialog5.setCancelable(true);
        dialog5.setContentView(view);
        dialog5.show();
    }

    /**
     * 链接设备
     */
    public static void showDialogLianJieSheBei(Context context, String title,final ErrorDialogInterfaceA dialogConfirm) {

        final Dialog dialog5 = new Dialog(context, R.style.selectorDialog);
        final View view = LayoutInflater.from(context).inflate(R.layout.dialog_lianjieshebei, null);
        TextView tv_title = view.findViewById(R.id.tv_title_sb);
        Button btn_lianjie = view.findViewById(R.id.btn_lianjie);
        ImageView iv_quxiao = view.findViewById(R.id.iv_quxiao);
        TextView btn_1 = view.findViewById(R.id.btn_1);
        TextView btn_2 = view.findViewById(R.id.btn_2);
        TextView btn_3 = view.findViewById(R.id.btn_3);
        tv_title.setText(title);

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_1.setTextColor(context.getResources().getColor(R.color.white));
                btn_1.setBackgroundResource(R.drawable.shape_radius_line_828df1_select);
                btn_2.setTextColor(context.getResources().getColor(R.color.color_999999));
                btn_2.setBackgroundResource(R.drawable.shape_radius_line_828df1);
                btn_3.setTextColor(context.getResources().getColor(R.color.color_999999));
                btn_3.setBackgroundResource(R.drawable.shape_radius_line_828df1);
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_2.setTextColor(context.getResources().getColor(R.color.white));
                btn_2.setBackgroundResource(R.drawable.shape_radius_line_828df1_select);
                btn_1.setTextColor(context.getResources().getColor(R.color.color_999999));
                btn_1.setBackgroundResource(R.drawable.shape_radius_line_828df1);
                btn_3.setTextColor(context.getResources().getColor(R.color.color_999999));
                btn_3.setBackgroundResource(R.drawable.shape_radius_line_828df1);
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_3.setTextColor(context.getResources().getColor(R.color.white));
                btn_3.setBackgroundResource(R.drawable.shape_radius_line_828df1_select);
                btn_2.setTextColor(context.getResources().getColor(R.color.color_999999));
                btn_2.setBackgroundResource(R.drawable.shape_radius_line_828df1);
                btn_1.setTextColor(context.getResources().getColor(R.color.color_999999));
                btn_1.setBackgroundResource(R.drawable.shape_radius_line_828df1);
            }
        });
        btn_lianjie.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(dialogConfirm!=null){
                    dialogConfirm.btnConfirm(2);
                }
                dialog5.dismiss();
            }
        });
        iv_quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog5.dismiss();
            }
        });
        dialog5.setCancelable(false);
        dialog5.setContentView(view);
        dialog5.show();
    }
    static int currentCounts = 0;
    /**
     * 开始寻球
     */
    public static void showDialogXunQiu(Context context, String title,final ErrorDialogInterfaceA dialogConfirm) {
        currentCounts = 0;
        final Dialog dialog5 = new Dialog(context, R.style.selectorDialog);
        final View view = LayoutInflater.from(context).inflate(R.layout.dialog_kaishixunqiu, null);
        Button btn_xunqiu = view.findViewById(R.id.btn_xunqiu);
        ImageView iv_quxiao =view.findViewById(R.id.iv_quxiao);
        TextView tv_title =  view.findViewById(R.id.tv_title);
        TextView tv_bfb =  view.findViewById(R.id.tv_bfb);
        StepArcView_n mSvN = view.findViewById(R.id.sv_n);
        mSvN.setCurrentCount(10,currentCounts,tv_bfb);
        btn_xunqiu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(currentCounts==10){
                    if(dialogConfirm!=null){
                        dialogConfirm.btnConfirm(1);
                    }
                    dialog5.dismiss();
                    return;
                }
                currentCounts++;
                mSvN.setCurrentCount(10,currentCounts,tv_bfb);
            }
        });
        iv_quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog5.dismiss();
            }
        });
        dialog5.setCancelable(false);
        dialog5.setContentView(view);
        dialog5.show();
    }
    public interface ErrorDialogInterfaceA {
        /**
         * 确定
         */
        public void btnConfirm(int index);
    }
    public interface ErrorDialogInterfaceXueSheng {
        /**
         * 确定
         */
        public void btnConfirm(SchoolStudentDetailBean mSchoolStudentDetailBean);
    }

    public interface ErrorDialogInterface {
        /**
         * 确定
         */
        public void btnConfirm();
    }


    public static void goUpdating(Context mContext, VersionResponse data) {
        if(TextUtils.isEmpty(data.getDownloadPath())){
            return;
        }
        UpdateAppUtils.init(mContext);
        UpdateConfig updateConfig = new UpdateConfig();
        updateConfig.setCheckWifi(true);
        updateConfig.setNeedCheckMd5(false);
        updateConfig.setNotifyImgRes(R.mipmap.ic_logo);
        UiConfig uiConfig = new UiConfig();
        uiConfig.setUiType(UiType.PLENTIFUL);
        uiConfig.setUpdateLogoImgRes(R.mipmap.ic_logo);
        uiConfig.setUpdateBtnBgRes(R.drawable.shape_radius_eff6ff);

        UpdateAppUtils
                .getInstance()
                .apkUrl(data.getDownloadPath())
                .updateTitle("发现新版本:V"+data.getVersionNo())
                .updateContent("更新内容:"+Html.fromHtml(data.getUpdateContent()))
                .uiConfig(uiConfig)
                .updateConfig(updateConfig)
                .setMd5CheckResultListener(new Md5CheckResultListener() {
                    @Override
                    public void onResult(boolean result) {

                    }
                })
                .setUpdateDownloadListener(new UpdateDownloadListener() {
                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onDownload(int progress) {

                    }

                    @Override
                    public void onFinish() {

                    }

                })
                .update();
    }
    public static void downLoad(String path,Context context)throws Exception {
        URL url = new URL(path);
        InputStream is = url.openStream();
        String end = path.substring(path.lastIndexOf("."));
        //打开手机对应的输出流,输出到文件中
        OutputStream os = context.openFileOutput("Cache_" + System.currentTimeMillis() + end, Context.MODE_PRIVATE);
        byte[] buffer = new byte[1024];
        int len = 0;
        //从输入六中读取数据,读到缓冲区中
        while ((len = is.read(buffer)) > 0) {
            os.write(buffer, 0, len);
        }
        //关闭输入输出流
        is.close();
        os.close();
    }
}
