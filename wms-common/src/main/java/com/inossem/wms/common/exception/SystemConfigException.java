package com.inossem.wms.common.exception;

import com.inossem.wms.enums.EnumReturnCode;

public class SystemConfigException extends WMSException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1150179345098528L;

	public SystemConfigException(String... args) {
		this.args = args;
		errorCode = EnumReturnCode.RETURN_CODE_SYSTEM_CONFIG_ERROR;
	}
}
