package com.raymon.api.bean;

import com.raymon.api.bean.success.StatusBean;

public class SuccessResult {
    private StatusBean status;

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }
}
