package com.inossem.wms.common.exception;

import com.inossem.wms.enums.EnumReturnCode;

/**
 * 结果溢出
 * 
 * @author 666
 *
 */
public class ResultOverflowException extends WMSException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5896059880928690871L;

	public ResultOverflowException(String... args) {
		this.args = args;
		errorCode = EnumReturnCode.RETURN_CODE_RESULT_OVERFLOW;
	}
}
