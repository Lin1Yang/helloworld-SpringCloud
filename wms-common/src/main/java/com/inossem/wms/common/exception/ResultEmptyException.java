package com.inossem.wms.common.exception;


import com.inossem.wms.enums.EnumReturnCode;


/**
 * 结果为空
 * @author 666
 *
 */
public class ResultEmptyException extends WMSException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7653694814122373999L;

	public ResultEmptyException(String... args) {
		this.args = args;
		errorCode = EnumReturnCode.RETURN_CODE_RESULT_EMPTY;
	}
}
