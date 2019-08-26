package com.restaurant.entity;

public class ResultUtil {

    private int code;
    private String message;
    private Object data;

    /**
     * 重置
     */
    public void reset(){
        message=null;
        data=null;
        code=-1;
    }

    public ResultUtil() {
    }

    public int getCode() {
        return code;
    }

    public ResultUtil setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResultUtil setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ResultUtil setData(Object data) {
        this.data = data;
        return this;
    }
}
