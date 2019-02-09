package com.hyj.util.web;

import lombok.Data;

@Data
public class ResData {
    private boolean status= false;
    private int code=0;
    private String msg;
    private Object data;

    public ResData(boolean status, int code, String msg, Object data) {

        this.status = status;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 正常数据返回
     * @param data
     */
    public ResData(Object data) {
        this.data = data;
        this.status = true;
    }

    /**
     * 错误数据返回
     * @param code
     * @param msg
     */
    public ResData(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
