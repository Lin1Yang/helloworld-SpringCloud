package com.inossem.wms.common.exception;

import com.inossem.wms.enums.EnumReturnCode;

public class BeanCastException extends WMSException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8298663635943263047L;

	public BeanCastException(String... args) {
		this.args = args;
		errorCode = EnumReturnCode.RETURN_CODE_BEAN_CAST_EXCEPTION;
	}
}
