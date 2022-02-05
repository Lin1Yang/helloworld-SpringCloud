package com.inossem.wms.common.exception;

import com.inossem.wms.enums.EnumReturnCode;
import com.inossem.wms.enums.EnumReturnMessageLevel;

/**
 * WMS系统基础异常类自带一个异常码errorCode
 * 
 * @author ebola
 * @author libin
 */
public class WMSException extends RuntimeException {

	private static final long serialVersionUID = -3549258026559432905L;
	protected EnumReturnCode errorCode;
	protected String[] args;
	protected EnumReturnMessageLevel errorLevel;

	public WMSException() {
		super(EnumReturnCode.RETURN_CODE_EXCEPTION.name());
		errorCode = EnumReturnCode.RETURN_CODE_EXCEPTION;
		errorLevel = EnumReturnMessageLevel.ERROR;
	}
	
	public WMSException(EnumReturnMessageLevel level) {
		super(EnumReturnCode.RETURN_CODE_EXCEPTION.name());
		errorCode = EnumReturnCode.RETURN_CODE_EXCEPTION;
		errorLevel = level;
	}

	public WMSException(EnumReturnCode enumReturnCode, String... args) {
		super(enumReturnCode.name());
		this.args = args;
		errorCode = enumReturnCode;
		errorLevel = EnumReturnMessageLevel.ERROR;
	}
	
	public WMSException(EnumReturnMessageLevel level, EnumReturnCode enumReturnCode, String... args) {
		super(enumReturnCode.name());
		this.args = args;
		errorCode = enumReturnCode;
		errorLevel = level;
	}

	public EnumReturnCode getErrorCode() {
		return errorCode;
	}

	public String[] getArgs() {
		return args;
	}

	public EnumReturnMessageLevel getErrorLevel() {
		return errorLevel;
	}
	
}
