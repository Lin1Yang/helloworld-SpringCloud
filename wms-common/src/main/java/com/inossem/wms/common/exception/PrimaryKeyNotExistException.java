package com.inossem.wms.common.exception;


import com.inossem.wms.enums.EnumReturnCode;


/**
 * 不存在异常
 * 校验主数据不存在时的提示异常
 * 
 * @author ebola
 *
 */
public class PrimaryKeyNotExistException extends WMSException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 43807323925951536L;

	public PrimaryKeyNotExistException(EnumReturnCode enumReturnCode,String... args) {
		this.args = args;
		errorCode = enumReturnCode;
	}
}
