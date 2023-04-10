package com.melodic.common;

public class Result<T> {

    public static final int SUCCESS = 0;
    public static final int FAILED = 1;

    Integer code;
    T data;
    String message;

    public Result(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public Result(Integer code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public static <T> Result<T> success(T object) {
        return new Result<T>(SUCCESS, object);
    }

    public static <T> Result<T> error(T object) {
        return new Result<T>(FAILED, object);
    }

    public static <T> Result<T> success(T object, String message) {
        return new Result<T>(SUCCESS, object, message);
    }

    public static <T> Result<T> error(T object, String message) {
        return new Result<T>(FAILED, object, message);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
