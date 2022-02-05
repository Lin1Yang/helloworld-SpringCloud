package com.inossem.wms.service.impl.common;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.inossem.wms.service.common.ICacheCommonService;

/**
 * 缓存通用方法实现类 
 * 提供基于redis的缓存实现
 * 
 * @author libin 2019年6月4日
 */
@Component("redisCacheCommonServiceImpl")
public class RedisCacheCommonServiceImpl implements ICacheCommonService {

	@Autowired
	@Qualifier("bizRedisTemplate")
	protected RedisTemplate<String, Object> redisTemplate;

	@Override
	public void put(String key, Object hashKey, Object value) {
		redisTemplate.opsForHash().put(key, hashKey, value);
	}

	@Override
	public Object get(String key, Object hashKey) {
		return redisTemplate.opsForHash().get(key, hashKey);
	}

	@Override
	public Object get(String key) {
		return redisTemplate.opsForHash().entries(key);
	}

	@Override
	public boolean delete(String key) {
		return redisTemplate.delete(key);
	}

	@Override
	public void delete(String key, Object hashKey) {
		redisTemplate.opsForHash().delete(key, hashKey);
	}

	/**
	 * 提供一个带有类型转换的批量获取方法
	 * 
	 * @param key
	 * @param hashKeys
	 * @param retObjClazz
	 * @return
	 * @author 李斌
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <T> List<T> multiGet(String key, List<?> hashKeys, Class<T> retObjClazz) {
		List<Object> objHashKeys = (List<Object>) hashKeys;
		List<Object> list = redisTemplate.opsForHash().multiGet(key, objHashKeys);
		// 去掉空元素
		list.removeAll(Collections.singleton(null)); 
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		return (List<T>) list;
	}
	
	/**
	 * 提供不带类型转换的批量获取方法
	 * 
	 * @param key
	 * @param hashKeys
	 * @return
	 * @author 李斌
	 */
	@Override
	public List<Object> multiGet(String key, List<Object> hashKeys) {
		List<Object> list = redisTemplate.opsForHash().multiGet(key, hashKeys);
		// 去掉空元素
		list.removeAll(Collections.singleton(null)); 
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list;
	}

}
