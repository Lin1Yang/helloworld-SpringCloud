package com.inossem.wms.service.common;

import com.inossem.wms.common.exception.WMSException;

public interface ILangCommonService {
	
	/**
	 * 获取本地语言类型代码
	 * 
	 * @param userId
	 * @author lys
	 */
	String getLangcode(Integer userId) throws WMSException;

}
