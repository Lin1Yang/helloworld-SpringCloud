package com.inossem.wms.common.exception;


import com.inossem.wms.enums.EnumReturnCode;


public class InterfaceCallException extends WMSException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3400089880526473877L;

	public InterfaceCallException(String... args) {
		this.args = args;
		errorCode = EnumReturnCode.RETURN_CODE_INTERFACE_CALL_FAILURE;
	}
}
