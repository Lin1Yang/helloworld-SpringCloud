package com.inossem.wms.common.exception;


import com.inossem.wms.enums.EnumReturnCode;


/**
 * 参数错误
 * @author maoy
 *
 */
public class ParameterErrorException extends WMSException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7702852442720657227L;

	public ParameterErrorException(EnumReturnCode enumReturnCode,String... args) {
		this.args = args;
		errorCode = enumReturnCode;
	}
	
	public ParameterErrorException(String... args) {
		this.args = args;
		errorCode = EnumReturnCode.RETURN_CODE_PARAMETER_ERROR;
	}
}
