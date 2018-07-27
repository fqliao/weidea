package cn.webank.weidea.model;

public class Result<T> {
	private int code;
	private T data;
	private String errorMsg;

	public Result() {
	}

	public Result(int code, T data, String errorMsg) {
		super();
		this.code = code;
		this.data = data;
		this.errorMsg = errorMsg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
