package com.inossem.wms.common.exception;

import com.inossem.wms.enums.EnumReturnCode;
import com.inossem.wms.enums.EnumReturnMessageLevel;

public class RequestAlreadyInProgressException extends WMSException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3545490405461642650L;

	public RequestAlreadyInProgressException(String... args) {
		super();
		this.args = args;
		errorLevel = EnumReturnMessageLevel.WARN;
		errorCode = EnumReturnCode.RETURN_CODE_REQUEST_ALREADY_IN_PROGRESS_EXCEPTION;
	}

}
