package com.inossem.wms.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inossem.wms.annotation.FieldAlias;
import com.inossem.wms.annotation.FieldImport;
import com.inossem.wms.common.exception.BeanCastException;
import com.inossem.wms.common.exception.WMSException;

public class UtilBean {
	/**
	 * 根据注解FieldAlias的解析bean到bean方法，Field类型必须相同
	 *
	 * @param sourceBean
	 *            原Bean
	 * @param targetBean
	 *            目标Bean
	 * @throws WMSException
	 */
	public static void getBean(Object sourceBean, Object targetBean) throws WMSException {
        getBean(sourceBean,targetBean,false);
	}

    /**
     * 根据注解FieldAlias的解析bean到bean方法，Field类型必须相同，并且可以设置是否忽略空值
     * @param sourceBean 数据源，用于取值的bean
     * @param targetBean 目标bean，需要被赋值的bean
     * @param ignoreNull 是否需要忽略null值，设置为true的时候，sourceBean中为null的属性不会被赋值到targetBean中
     * @throws WMSException
     */
    public static void getBean(Object sourceBean, Object targetBean,boolean ignoreNull) throws WMSException {
        try {
            // 获取原Bean的所有属性，含继承的属性
            HashMap<String, Class<?>> sourceBeanFieldMap = getSourceBeanFieldMap(sourceBean);

            for (Class<?> clazz = (Class<? extends Object>) targetBean.getClass(); clazz != Object.class; clazz = clazz
                    .getSuperclass()) {
                Field[] fields = clazz.getDeclaredFields();
                // 遍历目标类的所有属性
                for (Field targetField : fields) {
                    // 遍历所有别名及当前属性名
                    setTargetField(targetField, sourceBeanFieldMap, sourceBean, targetBean, false,ignoreNull);
                }
            }
        } catch (Exception e) {
            throw new BeanCastException();
        }
    }

    public static void getBeanForRecursion(Object sourceBean, Object targetBean) throws WMSException {
		try {
			// 获取原Bean的所有属性，含继承的属性
			HashMap<String, Class<?>> sourceBeanFieldMap = getSourceBeanFieldMap(sourceBean);

			for (Class<?> clazz = (Class<? extends Object>) targetBean.getClass(); clazz != Object.class; clazz = clazz
					.getSuperclass()) {
				Field[] fields = clazz.getDeclaredFields();
				// 遍历目标类的所有属性
				for (Field targetField : fields) {
					// 遍历所有别名及当前属性名
					setTargetField(targetField, sourceBeanFieldMap, sourceBean, targetBean, true);
				}
			}
		} catch (Exception e) {
			throw new BeanCastException();
		}
	}

	/**
	 * 获取原Bean的所有属性，含继承的属性
	 * 
	 * @param sourceBean
	 *            原Bean
	 * @return
	 */
	private static HashMap<String, Class<?>> getSourceBeanFieldMap(Object sourceBean) {
		HashMap<String, Class<?>> sourceBeanFieldMap = new HashMap<String, Class<?>>();

		// 循环源对象的类及其祖先类。直到Object
		for (Class<?> clazz = (Class<? extends Object>) sourceBean.getClass(); clazz != Object.class; clazz = clazz
				.getSuperclass()) {
			// 循环所有属性
			for (Field field : clazz.getDeclaredFields()) {
				// 如果属性不存在，在map中存储改属性，已存在，不操作
				if (!sourceBeanFieldMap.containsKey(field.getName())) {
                    sourceBeanFieldMap.put(field.getName(), clazz);
                }
			}
		}
		return sourceBeanFieldMap;
	}

	/**
	 * 获取目标Bean的属性或别名，属性在最后
	 * 
	 * @param targetField
	 *            目标Bean的属性
	 * @return
	 */
	private static List<String> getTargetFieldOrAlias(Field targetField) {
		FieldAlias alias = targetField.getAnnotation(FieldAlias.class);

		List<String> targetFieldNameList = new ArrayList<String>();

		if (alias != null && alias.value() != null && alias.value().length > 0) {
			for (String fieldAlias : alias.value()) {
				if (fieldAlias != null && fieldAlias.length() > 0) {
					targetFieldNameList.add(fieldAlias);
				}
			}
		}

		targetFieldNameList.add(targetField.getName());

		return targetFieldNameList;
	}

    /**
     * 目标Bean属性或原Bean的所有属性，给目标属性设置值
     * @param targetField
     * @param sourceBeanFieldMap
     * @param sourceBean
     * @param targetBean
     * @param recursion
     * @throws NoSuchFieldException
     * @throws SecurityException
     * @throws NoSuchMethodException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private static void setTargetField(Field targetField, HashMap<String, Class<?>> sourceBeanFieldMap,
                                       Object sourceBean, Object targetBean, boolean recursion) throws NoSuchFieldException, SecurityException,
            NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InstantiationException {
        setTargetField(targetField,sourceBeanFieldMap,sourceBean,targetBean,recursion,false);
    }

    /**
     * 目标Bean属性或原Bean的所有属性，给目标属性设置值
     * @param targetField
     * @param sourceBeanFieldMap
     * @param sourceBean
     * @param targetBean
     * @param recursion
     * @param ignoreNull
     * @throws NoSuchFieldException
     * @throws SecurityException
     * @throws NoSuchMethodException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */

	private static void setTargetField(Field targetField, HashMap<String, Class<?>> sourceBeanFieldMap,
			Object sourceBean, Object targetBean, boolean recursion,boolean ignoreNull) throws NoSuchFieldException, SecurityException,
			NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		// STATIC: 8 （二进制 0000 1000）
		// FINAL: 16 （二进制 0001 0000）
		// 过滤掉final 和static修饰的属性
		int modifiers = targetField.getModifiers();
		if ((modifiers & 8) == 8 || (modifiers & 16) == 16) {
			return;
		}
		// 循环目标Bean的属性或别名
		for (String targetFieldName : getTargetFieldOrAlias(targetField)) {

			// 不存在对应的原Bean属性，直接执行下一个
			if (sourceBeanFieldMap.containsKey(targetFieldName)) {
				// 根据原Field的名在原Field的map获取原Field，可能在原Bean的祖先类中
				Field sourceField = sourceBeanFieldMap.get(targetFieldName).getDeclaredField(targetFieldName);

				sourceField.setAccessible(true);
				targetField.setAccessible(true);
				// 获取到原值
				Object sourceFieldObject = sourceField.get(sourceBean);
				//如果忽略空值并且获取到的原值为空，直接返回
				if(ignoreNull && sourceFieldObject==null){
				    return;
                }
				if (sourceFieldObject instanceof List<?>) {
					// 原类型是列表
					// 判断目标类型
					if (targetField.getType().asSubclass(List.class) != null) {
						// 目标类型也是列表,原值强转成列表

						Class<?> sourceGeneric = (Class<?>) ((ParameterizedType) sourceField.getGenericType())
								.getActualTypeArguments()[0];
						Class<?> targetGeneric = (Class<?>) ((ParameterizedType) targetField.getGenericType())
								.getActualTypeArguments()[0];
						// 判断泛型关系
						if (!sourceGeneric.isAssignableFrom(targetGeneric)) {
							if (recursion) {

								List<?> sourceList = (List<?>) sourceFieldObject;
								List<Object> targetList = new ArrayList<>();

								for (Object object : sourceList) {
									Object item = targetGeneric.newInstance();
									targetList.add(item);
									getBean(object, item,ignoreNull);
								}
								// 列表递归好后，set值
								targetField.set(targetBean, targetList);
								// 遇到正确的立刻返回
								return;
							}
						} else {
							if (setField(sourceField, targetField, sourceBean, targetBean)) {
								// 遇到正确的立刻返回
								return;
							}
						}
					}

				} else {
					// 原类型不是列表，直接set值
					if (setField(sourceField, targetField, sourceBean, targetBean)) {
						// 遇到正确的立刻返回
						return;
					}
				}
			}
		}
	}

	private static boolean setField(Field sourceField, Field targetField, Object sourceBean, Object targetBean)
			throws IllegalArgumentException, IllegalAccessException {
		// 原类型不是列表，直接set值
		if (sourceField.getType() == targetField.getType()) {
			targetField.set(targetBean, sourceField.get(sourceBean));
			// 遇到正确的立刻返回
			return true;
		}

		return false;
	}

	/**
	 * 工具方法，将对象转成Map的键值对形式。 该方法会忽略属性值为null的属性
	 * 
	 * @param bean
	 * @return 以传入对象的属性为key,以对应属性值为value的map
	 * @throws WMSException
	 * @author libin
	 */
	public static Map<String, Object> beanToMap(Object bean) throws WMSException {
		Map<String, Object> map = new HashMap<String, Object>();
		// 得到类对象
		Class<? extends Object> cls = (Class<? extends Object>) bean.getClass();
		// 得到类中的所有属性集合
		Field[] fs = cls.getDeclaredFields();
		for (int i = 0; i < fs.length; i++) {
			Field f = fs[i];
			f.setAccessible(true); // 设置些属性是可以访问的
			Object val = new Object();
			try {
				val = f.get(bean);
				// 得到此属性的值,当值为非null时，将属性和值放入map
				if (val != null) {
					map.put(f.getName(), val);// 设置键值
				}
			} catch (Exception e) {
				throw new BeanCastException();
			}
		}
		return map;
	}

	/**
	 * 工具方法，将map转成指定的对象。
	 * 
	 * @param map
	 *            包含属性和属性值对应关系的map, 属性名为key, 属性值为value
	 * @param cls
	 *            目标类的class对象
	 * @return 目标类的实例
	 * @throws WMSException
	 * @author libin
	 */
	public static <T> T mapToBean(Map<String, Object> map, Class<T> cls) throws WMSException {
		T instance = null;
		try {
			instance = cls.newInstance();
			for (String key : map.keySet()) {
				try {
					Field field = null;
					field = cls.getDeclaredField(key);
					if (field != null) {
						// 找到对应的属性时，调用该属性的set方法
						instance.getClass().getMethod(("set" + toUpperCaseFirstLetter(key)), field.getType())
								.invoke(instance, map.get(key));
					}
				} catch (Exception e) {
					// 当map的key与指定的类属性无法映射、或属性设置失败，跳过该属性
					continue;
				}
			}
		} catch (Exception e) {
			throw new BeanCastException();
		}
		return instance;
	}

	/**
	 * 首字母转大写
	 * 
	 * @param s
	 * @return
	 * @author libin
	 */
	private static String toUpperCaseFirstLetter(String s) {
		if (Character.isUpperCase(s.charAt(0))) {
            return s;
        }
		else if (s.length() > 1) {
			return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
		} else {
			return String.valueOf(Character.toUpperCase(s.charAt(0)));
		}
	}
	
	
	public static void setField(String name,Object value,Object bean){
		try {
			for (Class<?> clazz = (Class<? extends Object>) bean.getClass(); clazz != Object.class; clazz = clazz
					.getSuperclass()) {
				Field[] fields = clazz.getDeclaredFields();
				// 遍历目标类的所有属性
				for (Field field : fields) {
					int modifiers = field.getModifiers();
					if ((modifiers & 8) == 8 || (modifiers & 16) == 16) {
						continue;
					}
					// 循环目标Bean的属性或别名
					for (String fieldName : getTargetFieldOrImport(field)) {
						if (name.equals(fieldName)) {
							field.setAccessible(true);
							field.set(bean, value);
							return;
						}
					}
				}
			}
		} catch (Exception e) {
			throw new BeanCastException();
		}
	}
	
	/**
	 * 获取目标Bean的属性或别名，属性在最后
	 * 
	 * @param targetField
	 *            目标Bean的属性
	 * @return
	 */
	private static List<String> getTargetFieldOrImport(Field field) {
		FieldImport alias = field.getAnnotation(FieldImport.class);

		List<String> targetFieldNameList = new ArrayList<String>();

		if (alias != null && alias.value() != null && alias.value().length > 0) {
			for (String fieldAlias : alias.value()) {
				if (fieldAlias != null && fieldAlias.length() > 0) {
					targetFieldNameList.add(fieldAlias);
				}
			}
		}

		targetFieldNameList.add(field.getName());

		return targetFieldNameList;
	}
}