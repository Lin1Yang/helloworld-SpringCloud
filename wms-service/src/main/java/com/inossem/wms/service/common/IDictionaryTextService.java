//package com.inossem.wms.service.common;
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.lang.NonNull;
//
//import com.inossem.wms.enums.EnumLang;
//
//public interface IDictionaryTextService {
//	/**
//	 * 初始化
//	 * @return 
//	 */
//	Map<String, Map<String, String>> initTextCache();
//
//	/**
//	 * 获取名称
//	 * 
//	 * @param langCode
//	 *            语言码
//	 * @param tid
//	 *            国际化唯一id
//	 * @return
//	 */
//	String getTextCache(@NonNull EnumLang langCode, @NonNull String tid);
//
//	/**
//	 * 获取名称
//	 * 
//	 * @param langCode
//	 *            语言码
//	 * @param tid
//	 *            国际化唯一id
//	 * @return
//	 */
//	String getTextCache(@NonNull String langCode, @NonNull String tid);
//
//	/**
//	 * 更新国际化信息
//	 * 
//	 * @param langCode
//	 *            语言码
//	 * @param tid
//	 *            国际化唯一id
//	 * @param name
//	 *            名称
//	 */
//	void editTextCache(EnumLang langCode, String tid, String name);
//	
//	/**
//	 * 
//	 * @param langCode  语言码
//	 * @param tids 国际化唯一id列表
//	 */
//	void refreshTextCache(List<String> tids);
//}
