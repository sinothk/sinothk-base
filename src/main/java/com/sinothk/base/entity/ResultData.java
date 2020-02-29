package com.sinothk.base.entity;


import com.alibaba.fastjson.JSON;
import com.sinothk.base.keyValue.ErrorCode;

import java.io.Serializable;

public class ResultData<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int code;

    private String msg;

    private T data;

    public ResultData() {
    }

    public static <E> ResultData<E> success(E data) {
        return new ResultData<E>(ErrorCode.SUCCESS, "成功", data);
    }


    public static <E> ResultData<E> error(String msg) {
        return new ResultData<E>(ErrorCode.ERROR_COMM, msg, null);
    }

    public static <E> ResultData<E> error(String msg, E errorInfo) {
        return new ResultData<E>(ErrorCode.ERROR_COMM, msg, errorInfo);
    }

    public static <E> ResultData<E> error(int errorCode) {
        return new ResultData<E>(errorCode, ErrorCode.getErrorMsg(errorCode), null);
    }

    public static <E> ResultData<E> error(int errorCode, String msg) {
        return new ResultData<E>(errorCode, msg, null);
    }

    public ResultData(int code, String msg, T data) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public int getCode() {
        return code;
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
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

//    private void logPrint(ResultData<T> resultData) {
//        new Thread(() -> LogUtil.getInstance(ResultData.class).debug(resultData.toString())).start();
//    }
}
