package com.inossem.wms.common.util;

import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
 
/**
 * 系统bean帮助类
 */
public class UtilSpringContext implements ApplicationContextAware  {
 
	private static ApplicationContext context;
 
	@Override
	@SuppressWarnings("static-access" )
	public void setApplicationContext(ApplicationContext contex)
			throws BeansException {
		 this.context = contex;
	}
	public static Object getBean(String beanName){
		return context.getBean(beanName);
	}
	
	/** 通过类型获取上下文中的bean */
	public static Object getBean(Class<?> classType) {
		return context.getBean(classType);
	}
	
	public static String getMessage(String key){
		return context.getMessage(key, null, Locale.getDefault());
	}
}
