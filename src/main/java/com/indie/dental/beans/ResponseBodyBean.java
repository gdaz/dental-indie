package com.indie.dental.beans;

public class ResponseBodyBean {
    private int status;
    private Object result;

    public ResponseBodyBean(int status, Object result) {
        this.status = status;
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
