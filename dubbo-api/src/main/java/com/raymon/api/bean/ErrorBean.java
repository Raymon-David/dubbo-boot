package com.raymon.api.bean;

import com.raymon.api.bean.error.ErrorInfo;

public class ErrorBean {
    private ErrorInfo error;

    public ErrorInfo getError() {
        return error;
    }

    public void setError(ErrorInfo error) {
        this.error = error;
    }
}
