package com.inossem.wms.common.exception;

import com.inossem.wms.enums.EnumReturnCode;


/**
 * 行项目为空
 * @author 666
 *
 */
public class EmptyItemException extends WMSException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4098506472780680209L;

	public EmptyItemException(String... args) {
		this.args = args;
		errorCode = EnumReturnCode.RETURN_CODE_EMPTY_ITEM;
	}
}
