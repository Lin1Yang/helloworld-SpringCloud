package com.inossem.wms.common.exception;

import com.inossem.wms.enums.EnumReturnCode;

public class AccessDeniedException extends WMSException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6540222613007996859L;

	public AccessDeniedException(String... args) {
		this.args = args;
		errorCode = EnumReturnCode.RETURN_CODE_ACCESS_DENY;
	}
}
