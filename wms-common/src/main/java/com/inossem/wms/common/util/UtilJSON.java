package com.inossem.wms.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.inossem.wms.annotation.FieldAlias;

public class UtilJSON {
	/**
	 * 根据注解FieldAlias的解析bean到bean方法，Field类型必须相同
	 * 
	 * @param sourceBean
	 *            原Bean
	 * @param targetBean
	 *            目标Bean
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static void getBean(JSONObject source, Object targetBean) throws NoSuchMethodException, SecurityException,
			NoSuchFieldException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		// Set<Map.Entry<String, Object>> set = source.entrySet();
		Class<? extends Object> targetBeanClass = (Class<? extends Object>) targetBean.getClass();
		Field[] fields = targetBeanClass.getDeclaredFields();
		List<String> targetFieldNameList = new ArrayList<String>();

		for (Field targetField : fields) {
			FieldAlias alias = targetField.getAnnotation(FieldAlias.class);

			targetFieldNameList.clear();

			if (alias != null && alias.value() != null && alias.value().length > 0) {
				for (String fieldAlias : alias.value()) {
					if (fieldAlias != null && fieldAlias.length() > 0) {
						targetFieldNameList.add(fieldAlias);
					}
				}
			}
			for (String targetFieldName : targetFieldNameList) {
				Object targetFieldObject = source.get(targetFieldName);

				if (targetFieldObject instanceof JSONObject) {
					Class<? extends Object> targetFieldClass = targetField.getType();
					targetField.setAccessible(true);
					targetField.set(targetBean, targetFieldClass.newInstance());
					getBean((JSONObject) targetFieldObject, targetField.get(targetBean));
				} else if (targetFieldObject instanceof JSONArray) {
					Class<?> targetFieldClass = targetField.getType();
					if (targetFieldClass.asSubclass(List.class) != null) {
						JSONArray jsonArray = (JSONArray) targetFieldObject;
						ArrayList<Object> list = new ArrayList<>();
						Type genericType = targetField.getGenericType();
						// 如果是泛型参数的类型
						if (genericType != null && genericType instanceof ParameterizedType) {
							// 得到泛型里的class类型对象
							Class<?> listClass = (Class<?>) ((ParameterizedType) genericType)
									.getActualTypeArguments()[0];
							for (Object object : jsonArray) {
								Object aa = listClass.newInstance();
								list.add(aa);
								getBean((JSONObject) object, aa);
							}
							targetField.setAccessible(true);
							targetField.set(targetBean, list);
						}
					}
				} else {
					targetField.setAccessible(true);
					targetField.set(targetBean, targetFieldObject);
				}
				break;
			}
		}
	}

	/**
	 * json对象或数组的key转成大写
	 * @param json
	 */
	public static void convertUpperCodeKey(Object json) {
		if (json instanceof JSONObject) {
			JSONObject object = (JSONObject) json;
			
			for (String key : object.keySet().stream().collect(Collectors.toList())) {
				object.put(key.toUpperCase(), object.remove(key));
			}
		} else if (json instanceof JSONArray) {
			JSONArray ary = (JSONArray) json;
			for (int i = 0; i < ary.size(); i++) {
				convertUpperCodeKey(ary.get(i));
			}
		}
	}
}
