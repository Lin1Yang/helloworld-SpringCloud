/** 
 * 文件名: SapApiCallProxy.java 
 * 
 * Copyright (c) 2020 Inossem All rights reserved. 
 */ 
package com.inossem.wms.service.impl.sap;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.inossem.wms.common.util.UtilConst;
import com.inossem.wms.common.util.UtilREST;

/**
 * 说明: SAP api 调用包装类
 * Facade Pattern
 * 在调用接口前后进行日志记录
 * 
 * @author 李斌
 * 创建时间: 2020年3月18日
 */
@Component
public class SapApiCallProxy {
	
	/**
	 * 该方法包装了直接调用方法
	 * 该方法增加了aop拦截的日志处理，不要单独修改方法签名
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 * @author 李斌
	 */
	public JSONObject callSapApi(String url, JSONObject params) throws Exception {
		JSONObject result = UtilREST.executePostJSONTimeOut(url, params, UtilConst.getInstance().getTimeout());
		return result;
	}

}
