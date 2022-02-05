//package com.inossem.wms.service.impl.common;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.util.CollectionUtils;
//
//import com.inossem.wms.common.exception.PrimaryKeyNotExistException;
//import com.inossem.wms.constant.Const;
//import com.inossem.wms.dao.dic.DicLanguageMapper;
//import com.inossem.wms.dao.dic.DicTextMapper;
//import com.inossem.wms.enums.EnumLang;
//import com.inossem.wms.enums.EnumReturnCode;
//import com.inossem.wms.model.dic.DicLanguage;
//import com.inossem.wms.model.dic.DicText;
//import com.inossem.wms.service.common.ICacheCommonService;
//import com.inossem.wms.service.common.IDictionaryTextService;
//
///**
// * 说明: 将国际化语言信息加入到缓存中处理
// * 
// * @author 李斌
// * 创建时间: 2020年2月19日
// */
//@Component
//public class DictionaryTextServiceImpl implements IDictionaryTextService {
//	
//	protected static final Logger logger = LoggerFactory.getLogger(DictionaryTextServiceImpl.class);
//
//	@Autowired
//	protected DicLanguageMapper langDao;
//
//	@Autowired
//	protected DicTextMapper textDao;
//	
//	@Autowired
//    protected ICacheCommonService cache;
//
//	@Override
//	public Map<String, Map<String, String>> initTextCache() {
//		cache.delete(Const.CACHE_LANGUAGE_I18N_TEXT);
//		Map<String, Map<String, String>> map = new HashMap<String, Map<String, String>>();
//
//		// 所有语言
//		List<DicLanguage> langList = langDao.selectAllLanguageList();
//
//		for (DicLanguage dicLanguage : langList) {
//			map.put(dicLanguage.getLangCode(), new HashMap<String, String>());
//		}
//
//		// 共用国际化文本列表
//		List<DicText> textList = textDao.select();
//
//		for (DicText text : textList) {
//			if (!map.containsKey(text.getLangCode())) {
//				continue;
//			}
//			map.get(text.getLangCode()).put(text.getTid(), text.getText());
//		}
//
//		map.forEach((k, v) -> cache.put(Const.CACHE_LANGUAGE_I18N_TEXT, k, v));
//		return map;
//	}
//
//	@Override
//	public String getTextCache(EnumLang langCode, String tid) {
//		return this.getTextCache(langCode.getValue(), tid);
//	}
//
//	@Override
//	@SuppressWarnings("unchecked")
//	public String getTextCache(String langCode, String tid) {
//		Map<String, String> map = (Map<String, String>) cache.get(Const.CACHE_LANGUAGE_I18N_TEXT, langCode);
//		if (CollectionUtils.isEmpty(map)) {
//			map = initTextCache().get(langCode);
//		}
//		if (CollectionUtils.isEmpty(map)) {
//			logger.error("PrimaryKeyNotExistException  langCode:{}, tid:{}", langCode, tid);
//			throw new PrimaryKeyNotExistException(EnumReturnCode.RETURN_CODE_LANGUAGE_NOT_EXIST, langCode);
//		}
//
//		String name = map.get(tid);
//
//		if (name == null) {
//			name = Const.STRING_EMPTY;
//		}
//		return name;
//	}
//
//	@Override
//	@SuppressWarnings("unchecked")
//	public void editTextCache(EnumLang langCode, String tid, String name) {
//		if (name == null) {
//			return;
//		}
//
//		Map<String, String> map = (Map<String, String>) cache.get(Const.CACHE_LANGUAGE_I18N_TEXT, langCode);
//		if (CollectionUtils.isEmpty(map)) {
//			throw new PrimaryKeyNotExistException(EnumReturnCode.RETURN_CODE_LANGUAGE_NOT_EXIST, langCode.getValue());
//		}
//
//		map.put(tid, name);
//		cache.put(Const.CACHE_LANGUAGE_I18N_TEXT, langCode, map);
//	}
//	
//	@Override
//	@SuppressWarnings("unchecked")
//	public synchronized void refreshTextCache(List<String> tids) {
//		// 所有语言
//		List<DicText> textList = textDao.selectListByTids(tids);
//		if (textList == null) {
//			return;
//		}
//		
//		Map<String, Map<String, String>> map = (Map<String, Map<String, String>>) cache.get(Const.CACHE_LANGUAGE_I18N_TEXT);
//		if (CollectionUtils.isEmpty(map)) {
//			initTextCache();
//			return;
//		}
//		
//		// 移除旧的缓存
//		for (String langCode : map.keySet()) {
//			Map<String, String> innerMap = map.get(langCode);
//			for (DicText dicText : textList) {
//				if (innerMap.containsKey(dicText.getTid())) {
//					innerMap.remove(dicText.getTid());
//				}
//			}
//		}
//		
//		for (DicText dicText : textList) {
//			map.get(dicText.getLangCode()).put(dicText.getTid(), dicText.getText());
//		}
//		map.forEach((k, v) -> cache.put(Const.CACHE_LANGUAGE_I18N_TEXT, k, v));
//	}
//}
