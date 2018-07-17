package com.raymon.api.bean.error;

public class ErrorInfo {
	private String type;
	private ErrorDesc errDesc;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ErrorDesc getErrDesc() {
		return errDesc;
	}
	public void setErrDesc(ErrorDesc errDesc) {
		this.errDesc = errDesc;
	}
}
