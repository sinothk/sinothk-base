package com.sinothk.base.keyValue;

import java.util.HashMap;
import java.util.Map;

public class ErrorCode {

    // 存在
    public static final int EXIST_ACCOUNT = 701;

    // 不存在
    public static final int NOT_EXIST_ACCOUNT = 801;
    public static final int NOT_LOGIN = 802;

    // 错误
    public static final int ERROR_COMM = 600; // 服务端错误
    public static final int ERROR_PWD = 601;

    // 成功
    public static final int SUCCESS = 200;

    private static Map<Integer, String> errorMap = new HashMap<Integer, String>();

    public static String getErrorMsg(int code) {
        return errorMap.get(code);
    }

    static {
        // 不存在/存在
        errorMap.put(NOT_EXIST_ACCOUNT, "账号不存在");
        errorMap.put(EXIST_ACCOUNT, "账号已存在");
        errorMap.put(NOT_LOGIN, "用户未登录");
        //错误
        errorMap.put(ERROR_COMM, "服务端错误");
        errorMap.put(ERROR_PWD, "密码错误");
    }
}
