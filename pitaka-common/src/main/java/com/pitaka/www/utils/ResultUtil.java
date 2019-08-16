package com.pitaka.www.utils;

/**
 * 响应结构
 * @author braw
 */
public class ResultUtil<T> {


    private Integer status;     // 响应业务状态
    private String msg;         // 响应消息
    private T data;             // 响应中的数据

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public ResultUtil(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ResultUtil(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ResultUtil(T data) {
        this.status = 200;
        this.msg = "success";
        this.data = data;
    }

    public ResultUtil() {
        this.status = 500;
        this.msg = "error";
        this.data = null;
    }

    public static <T> ResultUtil<T> success(T data) {
        return new ResultUtil<T>(data);
    }


    public static <T> ResultUtil<T> error(T data) {
        return new ResultUtil<T>(500, "error", data);
    }
    public static <T> ResultUtil<T> error(Integer status,String msg) {
        return new ResultUtil<T>(status, msg);
    }

    @Override
    public String toString() {
        return "ResultUtil [status=" + status + ", msg=" + msg + ", data=" + data + "]";
    }

}
