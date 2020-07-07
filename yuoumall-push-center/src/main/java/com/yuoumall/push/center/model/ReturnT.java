package com.yuoumall.push.center.model;

import java.io.Serializable;

public class ReturnT<T> extends com.xxl.job.core.biz.model.ReturnT implements Serializable {
    public static final long serialVersionUID = 42L;

    public static final int SUCCESS_CODE = 200;
    public static final int FAIL_CODE = 500;

    public static final ReturnT<String> SUCCESS = new ReturnT<String>(SUCCESS_CODE, null);
    public static final ReturnT<String> FAIL = new ReturnT<String>(FAIL_CODE, null);

    private int code;
    private String msg;
    private String rtcod;
    private T content;

    public ReturnT() {
    }

    public ReturnT(T content) {
        this.code = SUCCESS_CODE;
        this.content = content;
    }

    public ReturnT(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ReturnT(int code, String rtcod, String msg) {
        this.code = code;
        this.rtcod = rtcod;
        this.msg = msg;
    }

    public static ReturnT<String> getFAIL() {
        return FAIL;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRtcod() {
        return rtcod;
    }

    public void setRtcod(String rtcod) {
        this.rtcod = rtcod;
    }

    @Override
    public T getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = (T) content;
    }
}
