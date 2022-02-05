package com.inossem.wms.common.util;

import java.util.Collection;

/**
 * 集合工具类, 参考spring的集合工具类以及apache集合工具类的实现
 * 实际上是一个这两个工具类的封装类(Facade Pattern)
 * 需要添加新工具方法时，请优先参考这两个工具类中的已有实现。
 * 
 * @see org.apache.commons.collections4.CollectionUtils
 * @see org.springframework.util.CollectionUtils
 * @author 高海涛
 * @author 李斌
 * @date 2018年12月20日
 * @date 2020年03月18日
 */
public class UtilCollection {

	/**
	 * 判断集合是否为空
	 * 
	 * @param collection 需要检查的集合类或集合类的子类 eg. ArrayList/ HashSet
	 * @return 如果提供的集合为null或isEmpty为true(JDK集合默认实现)，则返回true。否则返回false。
	 * @see org.springframework.util.CollectionUtils#isEmpty
	 * @author 李斌
	 */
	public static boolean isEmpty(Collection<?> collection) {
		return org.springframework.util.CollectionUtils.isEmpty(collection);
	}
	
	/**
	 * 判断集合是否<b>不为</b>空
	 * 
	 * @param collection 需要检查的集合类或集合类的子类 eg. ArrayList/ HashSet
	 * @return 如果提供的集合不为null或isEmpty为fasle(JDK集合默认实现)，则返回true。否则返回false。
	 * @see org.springframework.util.CollectionUtils#isEmpty
	 * @author 李斌
	 */
	public static boolean isNotEmpty(Collection<?> collection) {
		return !org.springframework.util.CollectionUtils.isEmpty(collection);
	}
}
