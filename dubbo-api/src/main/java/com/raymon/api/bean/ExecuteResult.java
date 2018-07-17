package com.raymon.api.bean;

import com.raymon.api.constent.StatusCode;

import java.io.Serializable;

public class ExecuteResult<T> implements Serializable {
    private StatusCode rntCode = StatusCode.OK;


    private String rntMsg = "";

    private  int rntCodeValue = StatusCode.OK.getValue();

    private T responseParams;

    public ExecuteResult() {
    }

    public ExecuteResult(StatusCode rntCode, T responseParams) {
        this.rntCode = rntCode;
        this.responseParams = responseParams;
        this.rntMsg = this.rntCode.GetDescription();
        this.rntCodeValue = this.rntCode.getValue();
    }


    public ExecuteResult(StatusCode rntCode) {
        this.rntCode = rntCode;
        this.rntMsg = this.rntCode.GetDescription();
        this.rntCodeValue = this.rntCode.getValue();
    }

    public ExecuteResult(T responseParams) {
        this.setResponseParams(responseParams);
    }

    public T getResponseParams() {
        return responseParams;
    }

    public void setResponseParams(T responseParams) {
        this.responseParams = responseParams;
    }

    public String getRntMsg() {
        return rntMsg;
    }

    public void setRntMsg(String rntMsg) {
        this.rntMsg = rntMsg;
    }

    public StatusCode getRntCode() {
        return rntCode;
    }

    public void setRntCode(StatusCode rntCode) {
        this.rntCode = rntCode;
        this.rntMsg = this.rntCode.GetDescription();
        this.rntCodeValue = this.rntCode.getValue();
    }

    public int getRntCodeValue() {
        return rntCodeValue;
    }

    public void setRntCodeValue(int rntCodeValue) {
        this.rntCodeValue = rntCodeValue;
    }

    public String getErrorMsg(){
        String errorMsg = "错误码:" + this.rntCodeValue + ",错误信息:" + this.rntMsg;
        return errorMsg;

    }

    @Override
    public String toString() {
        return "ExecuteResult [rntCode=" + rntCode + ", rntMsg=" + rntMsg
                + ", rntCodeValue=" + rntCodeValue + ", responseParams="
                + responseParams + "]";
    }
}
