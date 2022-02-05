package com.inossem.wms.common.exception;

import com.inossem.wms.enums.EnumReturnCode;

public class DebitCreditException extends WMSException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4268659947272969005L;

	public DebitCreditException(String... args) {
		this.args = args;
		errorCode = EnumReturnCode.RETURN_CODE_DEBIT_CREDIT_EXCEPTION;
	}
}
