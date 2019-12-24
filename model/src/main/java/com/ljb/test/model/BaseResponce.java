package com.ljb.test.model;

public class BaseResponce {
    public boolean success;
    public int errorCode;
    public String errorMessage;
    public Object data;

    public BaseResponce(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public BaseResponce(boolean success, int errorCode, String errorMessage) {
        this.success = success;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "BaseResponce{" +
                "success=" + success +
                ", errorCode=" + errorCode +
                ", errorMessage='" + errorMessage + '\'' +
                ", data=" + data +
                '}';
    }
}
