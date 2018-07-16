package com.raymon.bean.success;

import java.math.BigDecimal;
import java.util.Map;

public class StatusBean {
    private String code;
    private String message;
    private String toUrl;
    private BigDecimal amount;
    private Map<String,Object> signResult;
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public StatusBean() {
        this.code = 1+"";
        this.message = "success";
    }
    public StatusBean(String code,String message) {
        this.code = code;
        this.message = message;
    }
    public String getToUrl() {
        return toUrl;
    }
    public void setToUrl(String toUrl) {
        this.toUrl = toUrl;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public Map<String, Object> getSignResult() {
        return signResult;
    }
    public void setSignResult(Map<String, Object> signResult) {
        this.signResult = signResult;
    }
}
