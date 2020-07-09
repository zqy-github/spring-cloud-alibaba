package com.yuoumall.push.center.model;

public class ReturnY<T> extends com.xxl.job.core.biz.model.ReturnT{

    private int code;
    private String msg;
    private String rtcod;
    private T content;

    public ReturnY() {
    }

    public ReturnY(T content) {
        this.code = SUCCESS_CODE;
        this.content = content;
    }

    public ReturnY(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ReturnY(int code, String rtcod, String msg) {
        this.code = code;
        this.rtcod = rtcod;
        this.msg = msg;
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

    @Override
    public String toString() {
        return "ReturnY{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", rtcod='" + rtcod + '\'' +
                ", content=" + content +
                '}';
    }
}
