/**
 * 文件名: ExceptionCollector.java
 * 
 * Copyright (c) 2020 Inossem All rights reserved.
 */
package com.inossem.wms.common.exception;

import java.util.LinkedList;
import java.util.List;

import com.inossem.wms.enums.EnumReturnMessageLevel;

/**
 * 说明: 异常收集器，主要用在接口正常返回数据时，需要额外携带异常提示时使用。
 * <p>
 * 通过ThrealLocal的单例多线程特性，将异常信息按照不同线程进行收集<br>
 * 每个线程在调用<code>add()</code>方法时，只收集本线程自己的异常信息<br>
 * 收集后的异常信息将在{@link com.inossem.wms.exception.ExceptionAdditionalHandler}补充异常处理器中进行处理
 * </p>
 * 
 * @author 李斌 
 * 创建时间: 2020年2月26日
 */
public class ExceptionCollector {

	private static ThreadLocal<List<WMSException>> exceptionList = new ThreadLocal<List<WMSException>>() {
		public List<WMSException> initialValue() {
			return new LinkedList<WMSException>();
		}
	};
	
	private static ThreadLocal<EnumReturnMessageLevel> exceptionLevel = new ThreadLocal<EnumReturnMessageLevel>() {
		public EnumReturnMessageLevel initialValue() {
			// 默认设置为警告级别
			return EnumReturnMessageLevel.WARN;
		}
	};
	
	public static void add(WMSException e) {
		List<WMSException> elist = exceptionList.get();
		elist.add(e);
		exceptionList.set(elist);
	}
	
	public static List<WMSException> getAll() {
		return exceptionList.get();
	}
	
	public static EnumReturnMessageLevel getLevel() {
		return exceptionLevel.get();
	}
	
	/**
	 * 设置异常收集器中所有异常信息在提示时的消息返回级别<br>
	 * 用于处理前端弹窗的样式
	 * 
	 * @param level
	 * @author 李斌
	 */
	public static void setLevel(EnumReturnMessageLevel level) {
		exceptionLevel.set(level);
	}

}
