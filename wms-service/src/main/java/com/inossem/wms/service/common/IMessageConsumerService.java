/** 
 * 文件名: IMessageConsumerService.java 
 * 
 * Copyright (c) 2019 Inossem All rights reserved. 
 */ 
package com.inossem.wms.service.common;

import org.aspectj.lang.JoinPoint;

/**
 * 说明: 消息消费着接口，声明消费方法
 * 
 * @author 李斌
 * 创建时间: 2019年12月25日
 */
public interface IMessageConsumerService {

	void saveReTryInfo(JoinPoint joinPoint, Throwable e);
	
}
