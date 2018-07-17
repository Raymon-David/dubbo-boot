package com.raymon.api.bean;

public class ResultBean {
    private SuccessResult result;
    private String orderId;//订单号
    private String payType;//支付方式

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public SuccessResult getResult() {
        return result;
    }

    public void setResult(SuccessResult result) {
        this.result = result;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
