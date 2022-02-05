/** 
 * 文件名: CacheCommonServiceImpl.java 
 * 
 * Copyright (c) 2020 Inossem All rights reserved. 
 */ 
package com.inossem.wms.service.impl.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.inossem.wms.service.common.ICacheCommonService;

/**
 * 说明: 缓存实现代理类
 * 提供一个缓存实现的代理，便于以后拓展缓存的实现方式
 * 
 * @author 李斌
 * 创建时间: 2020年2月19日
 */
@Primary
@Service
public class CacheCommonServiceImpl implements ICacheCommonService {
	
	@Autowired
	@Qualifier("redisCacheCommonServiceImpl")
	/* 当前只有一个缓存实现类，如果增加缓存实现类可以考虑通过配置的方式 
	 * 动态选择缓存的具体实现类，最终达到切换缓存实现的代理效果 */
	private ICacheCommonService cacheImplProxy;

	@Override
	public void put(String key, Object hashKey, Object value) {
		cacheImplProxy.put(key, hashKey, value);
	}

	@Override
	public Object get(String key, Object hashKey) {
		return cacheImplProxy.get(key, hashKey);
	}

	@Override
	public Object get(String key) {
		return cacheImplProxy.get(key);
	}

	@Override
	public boolean delete(String key) {
		return cacheImplProxy.delete(key);
	}

	@Override
	public void delete(String key, Object hashKey) {
		cacheImplProxy.delete(key, hashKey);
	}

	@Override
	public <T> List<T> multiGet(String key, List<?> hashKeys, Class<T> retObjClazz) {
		return cacheImplProxy.multiGet(key, hashKeys, retObjClazz);
	}

	@Override
	public List<Object> multiGet(String key, List<Object> hashKeys) {
		return cacheImplProxy.multiGet(key, hashKeys);
	}

}
