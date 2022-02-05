package com.inossem.wms.util;

import com.alibaba.fastjson.JSONObject;

public class UtilEnum {
//	public static String getName(Object key, Enum<?> e) {
//		String name = "";
//
//		return name;
//	}
	/**
	 * 返回国际化信息
	 * 
	 * @param args
	 *            可以传多个字符串，第一个字符串是要显示的key名,其他而参数
	 * @return 国际化信息
	 */
	public static String getI18nText(String key, String... args) {
		JSONObject json = new JSONObject();
		json.put("0", key);
		for (int i = 0; i < args.length; i++) {
			json.put(String.valueOf(i + 1), args[i]);
		}
		return "i18n_" + json.toString() + "_msg";
	}
}
