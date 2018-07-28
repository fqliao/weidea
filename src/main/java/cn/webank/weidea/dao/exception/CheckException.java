package cn.webank.weidea.dao.exception;

import cn.webank.weidea.model.Result;
import cn.webank.weidea.util.CodeUtil;

public class CheckException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings({ "rawtypes" })
	private Result result;

	public CheckException(String errorMsg) {
		Result<String> result = new Result<>();
		result.setErrorMsg(errorMsg);
		result.setCode(CodeUtil.CHECK_ERROR);
		this.result = result;
	}

	@SuppressWarnings("rawtypes")
	public CheckException(Result result) {
		this.result = result;
	}

	public CheckException(String errorMsg, Throwable arg0) {
		super(arg0);
		Result<String> result = new Result<>();
		result.setErrorMsg(errorMsg);
		result.setCode(CodeUtil.CHECK_ERROR);
		this.result = result;
	}

	public CheckException(Result<String> result, Throwable arg0) {
		super(arg0);
		this.result = result;
	}

	@SuppressWarnings("rawtypes")
	public Result getResult() {
		return result;
	}

	public void setResult(@SuppressWarnings("rawtypes") Result result) {
		this.result = result;
	}

}
