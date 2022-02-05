package com.inossem.wms.common.exception;

import com.inossem.wms.enums.EnumReturnCode;

/**
 * 国际化异常
 * 
 * @author 666
 *
 */
public class TextException extends WMSException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7115914175339693053L;

	public TextException(String... args) {
		this.args = args;
		errorCode = EnumReturnCode.RETURN_CODE_RESULT_TEXT;
	}
}
