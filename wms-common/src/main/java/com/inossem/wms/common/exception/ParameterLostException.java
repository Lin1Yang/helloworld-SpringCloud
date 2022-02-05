package com.inossem.wms.common.exception;


import com.inossem.wms.enums.EnumReturnCode;


/**
 * 参数不全异常
 * @author maoy
 *
 */
public class ParameterLostException extends WMSException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4463613105875746884L;

	public ParameterLostException(String... args) {
		this.args = args;
		errorCode = EnumReturnCode.RETURN_CODE_PARAMETER_LOST;
	}
}
