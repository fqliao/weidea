package cn.webank.weidea.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KeyManagementRsp {
	@JsonProperty(value = "code")
	private int code;
	
	@JsonProperty(value = "errorMsg")
	private String errorMsg;
	
	@JsonProperty(value = "data")
	private String data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "KeyManagementRsp [code=" + code + ", errorMsg=" + errorMsg + ", data=" + data + "]";
	}
}
