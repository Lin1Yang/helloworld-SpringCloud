package com.inossem.wms.common;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.inossem.wms.constant.Const;
import com.inossem.wms.vo.BaseObject;

public class BeanJSONGenerator {

	/**
	 * 获取假接口的默认json
	 *
	 * @param object
	 *            需要生成JSON的对象
	 * @return
	 * @throws WMSException
	 */
	public static String getDefaultJSONString(Class<?> clasz) {

		return getDefaultJSON(clasz).toJSONString();

	}

	/**
	 * 获取假接口的默认json
	 *
	 * @param object
	 *            需要生成JSON的对象
	 * @return
	 * @throws WMSException
	 */
	public static JSON getDefaultJSON(Class<?> clasz) {
		JSONObject json = new JSONObject();
		// try {
		for (Class<?> clazz = (Class<? extends Object>) clasz; clazz != Object.class; clazz = clazz.getSuperclass()) {
			Field[] fields = clazz.getDeclaredFields();
			// 遍历目标类的所有属性
			for (Field field : fields) {
				// 遍历所有属性名
				Class<?> fieldType = field.getType();
				if (fieldType == String.class) {
					json.put(field.getName(), field.getName());
				} else if (List.class.isAssignableFrom(fieldType)) {
					Class<?> genericType = (Class<?>) ((ParameterizedType) field.getGenericType())
							.getActualTypeArguments()[0];
					JSONArray array = new JSONArray();
					if (genericType == String.class) {
						array.add(field.getName());
					} else {
						Object value = getValue(genericType);
						if (value == null) {
							array.add(getDefaultJSON(genericType));
						} else {
							array.add(value);
						}
					}
					json.put(field.getName(), array);
				} else {
					Object value = getValue(fieldType);
					if (value == null) {
						json.put(field.getName(), getDefaultJSON(fieldType));
					} else {
						json.put(field.getName(), value);
					}
				}
			}
		}

		return json;

	}

	private static Object getValue(Class<?> clasz) {
		if (clasz == Integer.class || clasz == int.class) {
			return 32;
		} else if (clasz == BigDecimal.class) {
			return new BigDecimal("12345678.12345678");
		} else if (clasz == Date.class) {
			LocalDateTime ldt = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			return ldt.format(Const.FORMATTER_DATETIME1);
		} else if (clasz == Byte.class || clasz == byte.class) {
			return (byte) 8;
		} else if (clasz == Long.class || clasz == long.class) {
			return 64L;
		} else if (clasz == Short.class || clasz == short.class) {
			return (short) 16;
		} else if (clasz == Float.class || clasz == float.class) {
			return 12345678.32F;
		} else if (clasz == Double.class || clasz == double.class) {
			return 12345678.64D;
		} else if (clasz == Character.class || clasz == char.class) {
			return 'c';
		} else if (clasz == Boolean.class || clasz == boolean.class) {
			return true;
		} else {
			return null;
		}
	}

	public static String getJsonResponseForAndroid(Class<?> clasz) {
		BaseObject<JSON> baseObject = new BaseObject<JSON>(getDefaultJSON(clasz));
		baseObject.setReturnMsg("成功");
		return JSON.toJSONString(baseObject);
	}

	public static String getJsonRequestForAndroid(Class<?> clasz) {
		return getDefaultJSONString(clasz);
	}

}
