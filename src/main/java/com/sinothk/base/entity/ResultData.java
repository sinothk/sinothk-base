package com.sinothk.base.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sinothk.base.keyValue.ErrorCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ApiModel(description = "服务器返回结构")
@Data
@ToString
public class ResultData<T> implements Serializable {

    @JsonIgnore
    public final int SUCCESS = 200;
    @JsonIgnore
    public final int ERROR = 500;

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "结果编码")
    private int code;

    @ApiModelProperty(value = "结果描述")
    private String msg;

    @ApiModelProperty(value = "数据对象")
    private T data;

    public ResultData() {
    }

    @Deprecated
    public static <E> ResultData<E> success(E data) {
        return new ResultData<E>(ErrorCode.SUCCESS, "成功", data);
    }

    @Deprecated
    public static <E> ResultData<E> error(String msg) {
        return new ResultData<E>(ErrorCode.ERROR_COMM, msg, null);
    }

    @Deprecated
    public static <E> ResultData<E> error(String msg, E errorInfo) {
        return new ResultData<E>(ErrorCode.ERROR_COMM, msg, errorInfo);
    }

    @Deprecated
    public static <E> ResultData<E> error(int errorCode) {
        return new ResultData<E>(errorCode, ErrorCode.getErrorMsg(errorCode), null);
    }

    @Deprecated
    public static <E> ResultData<E> error(int errorCode, String msg) {
        return new ResultData<E>(errorCode, msg, null);
    }

    public ResultData(int code, String msg, T data) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public ResultData<T> getSuccess(T data) {
        return new ResultData<T>(SUCCESS, "成功", data);
    }

    public ResultData<T> getError(String msg) {
        return new ResultData<>(ERROR, msg, null);
    }

//    public int getCode() {
//        return code;
//    }
//
//    public void setCode(int code) {
//        this.code = code;
//    }
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//
//    public T getData() {
//        return data;
//    }
//
//    public void setData(T data) {
//        this.data = data;
//    }

//    @Override
//    public String toString() {
//        return JSON.toJSONString(this);
//    }

//    private void logPrint(ResultData<T> resultData) {
//        new Thread(() -> LogUtil.getInstance(ResultData.class).debug(resultData.toString())).start();
//    }
}
