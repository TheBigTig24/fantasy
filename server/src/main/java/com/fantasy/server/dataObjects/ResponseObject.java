package com.fantasy.server.dataObjects;

public class ResponseObject<T> {
    
    private T data;
    private String msg;

    public ResponseObject() {}

    public ResponseObject(T data, String msg) {
        this.data = data;
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
