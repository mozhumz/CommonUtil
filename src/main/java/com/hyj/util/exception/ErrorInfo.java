package com.hyj.util.exception;

/**
 * Created by liwj0 on 2017/7/19.
 */
public enum ErrorInfo {
    

    NO_LOGIN(10002, "登录失效请，重新登录"),
    LOGIN_ERROR(10003, "权限不足或登录失效"),
    PARAMS_ERROR(10004, "参数错误"),
    
    UNKNOWN_ERROR(10005,"程序内部错误"),
    PARSE_TIME_ERROR(10006,"时间解析错误"),
    ;

    public final String desc;
    public final int code;
    // 构造方法
    private ErrorInfo(int code, String desc) {
        this.desc = desc;
        this.code = code;
    }


}
