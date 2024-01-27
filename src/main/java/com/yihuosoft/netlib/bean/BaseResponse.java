package com.yihuosoft.netlib.bean;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class BaseResponse<T> implements Serializable {
    private int code;                   //响应码
    private String message;             //提示信息
    private String path;
    private String timestamp;
    private Extra extra;

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", extra=" + extra +
                ", data=" + data +
                '}';
    }

    public static class Extra implements Serializable {
        public boolean isRegister;

        public boolean isRegister() {
            return isRegister;
        }

        public void setRegister(boolean register) {
            isRegister = register;
        }

        @NonNull
        @Override
        public String toString() {
            return "Extra{" +
                    "isRegister=" + isRegister +
                    '}';
        }
    }

}
