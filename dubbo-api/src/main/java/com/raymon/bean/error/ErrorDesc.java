package com.raymon.bean.error;

public class ErrorDesc {
	/**
	 * 错误代码
	 */
	private String code;
	/**
	 * 错误描述
	 */
	private String message;
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
}
