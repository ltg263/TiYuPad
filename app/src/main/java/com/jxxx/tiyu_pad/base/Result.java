package com.jxxx.tiyu_pad.base;


import com.jxxx.tiyu_pad.app.MainApplication;
import com.jxxx.tiyu_pad.utils.ToastUtil;

public class Result<T> {


    private int code;
    private int total;
    private String msg;
    private T data;
    private T rows;

    public void setRows(T rows) {
        this.rows = rows;
    }

//    public T getRows() {
//        return rows;
//    }

    public int getCode() {
        if(code!=200){
            ToastUtil.showLongStrToast(MainApplication.getContext(),msg);
        }
        return code;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        if(data!=null){
            return data;
        }
        return rows;
    }

    public void setData(T data) {
        this.data = data;
    }
}
