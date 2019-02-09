package com.hyj.util.common.enums;

public enum ErrorCode {
    PARAM_ERR(201,"参数错误"),

    SYS_ERR(401,"程序内部错误"),
    ;
    public Integer code;
    public String desc;

    ErrorCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
