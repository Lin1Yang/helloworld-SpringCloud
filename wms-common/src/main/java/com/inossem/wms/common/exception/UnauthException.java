package com.inossem.wms.common.exception;

import com.inossem.wms.enums.EnumReturnCode;

/***
 * 未登录异常
 * @author Steven
 *
 */
public class UnauthException extends WMSException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3820720503835715522L;

	public UnauthException(String... args) {
		this.args = args;
		errorCode = EnumReturnCode.RETURN_CODE_UNAUTH;
	}
}
