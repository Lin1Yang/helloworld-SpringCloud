package com.inossem.wms.service.common;

import java.util.List;

import org.springframework.lang.NonNull;

public interface ICacheCommonService {
	
	/**
	 * 将数据放入缓存
	 * 
	 * @param key
	 * @param hashKey
	 * @param value
	 * @author libin
	 */
	void put(@NonNull String key, @NonNull Object hashKey, Object value);
	
	/**
	 * 从缓存中读取数据
	 * 
	 * @param key
	 * @param hashKey
	 * @return
	 * @author libin
	 */
	Object get(@NonNull String key, @NonNull Object hashKey);

	/**
	 * 从缓存中读取数据
	 *
	 * @param key
	 * @return
	 */
	Object get(@NonNull String key);
	
	/**
	 * 删除指定缓存key对应的值
	 * 
	 * @param key
	 * @author libin
	 * @return true if delete action executed success, otherwise return false.
	 */
	boolean delete(@NonNull String key);

	/**
	 * 删除指定缓存key对应的值
	 *
	 * @param key
	 * @author libin
	 */
	void delete(@NonNull String key, @NonNull Object hashKey);

	/**
	 * 提供一个带有类型转换的批量获取方法
	 * 
	 * @param key
	 * @param hashKeys
	 * @param retObjClazz
	 * @return
	 * @author 李斌
	 */
	<T> List<T> multiGet(@NonNull String key, @NonNull List<?> hashKeys, Class<T> retObjClazz);

	/**
	 * 提供不带类型转换的批量获取方法
	 * 
	 * @param key
	 * @param hashKeys
	 * @return
	 * @author 李斌
	 */
	List<Object> multiGet(@NonNull String key, @NonNull List<Object> hashKeys);


}
