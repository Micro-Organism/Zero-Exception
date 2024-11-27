package com.zero.exception.common.model;

import com.zero.exception.common.interfaces.BaseErrorInfoInterface;
import com.zero.exception.common.enums.CommonEnum;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ResultBodyModel {

	private String code;

	private String message;

	private Object result;

	public ResultBodyModel() {
	}

	public ResultBodyModel(BaseErrorInfoInterface errorInfo) {
		this.code = errorInfo.getResultCode();
		this.message = errorInfo.getResultMsg();
	}

	public static ResultBodyModel success() {
		return success(null);
	}

	public static ResultBodyModel success(Object data) {
		ResultBodyModel rb = new ResultBodyModel();
		rb.setCode(CommonEnum.SUCCESS.getResultCode());
		rb.setMessage(CommonEnum.SUCCESS.getResultMsg());
		rb.setResult(data);
		return rb;
	}

	public static ResultBodyModel error(BaseErrorInfoInterface errorInfo) {
		ResultBodyModel rb = new ResultBodyModel();
		rb.setCode(errorInfo.getResultCode());
		rb.setMessage(errorInfo.getResultMsg());
		rb.setResult(null);
		return rb;
	}

	public static ResultBodyModel error(String code, String message) {
		ResultBodyModel rb = new ResultBodyModel();
		rb.setCode(code);
		rb.setMessage(message);
		rb.setResult(null);
		return rb;
	}

	public static ResultBodyModel error(String message) {
		ResultBodyModel rb = new ResultBodyModel();
		rb.setCode("-1");
		rb.setMessage(message);
		rb.setResult(null);
		return rb;
	}

}

