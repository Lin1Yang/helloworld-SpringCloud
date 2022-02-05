package com.inossem.wms.service.common;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.lang.NonNull;

import com.inossem.wms.enums.EnumLang;
import com.inossem.wms.model.dic.DicCorp;
import com.inossem.wms.model.dic.DicLanguage;
import com.inossem.wms.model.dic.DicMaterial;
import com.inossem.wms.model.dic.DicMaterialFactoryKey;
import com.inossem.wms.model.dic.DicMaterialName;
import com.inossem.wms.model.dic.DicUnit;
import com.inossem.wms.model.dic.DicWh;
import com.inossem.wms.model.dic.DicWhStorageBinKey;
import com.inossem.wms.model.dic.DicWhStorageSectionKey;
import com.inossem.wms.model.dic.DicWhStorageTypeKey;
import com.inossem.wms.model.rel.RelUnit;
import com.inossem.wms.model.rel.RelUnitKey;
import com.inossem.wms.vo.dic.DicMaterialFactoryVo;
import com.inossem.wms.vo.dic.DicWhStorageSectionVo;
import com.inossem.wms.vo.dic.DicWhStorageTypeVo;

public interface IDictionaryService {


	/**
	 * 初始化公司
	 * @return 
	 */
	public Map<String, DicCorp> initCorpCache();
	
	/**
	 * 获取所有公司map
	 * @return
	 */
	public Map<String, DicCorp> getAllCorpCache();
	
	/**
	 * 根据公司代码获取公司对象
	 * @param corpCode
	 * @return
	 */
	public DicCorp getCorpCacheByCode(String corpCode);
	
	/**
	 * 刷新公司缓存
	 */
	public void refreshAllCorpCache();

	/**
	 * 删除公司缓存
	 */
	public void deleteCorpCacheByCode(String corpCode);
	
	
	
	
	
	
	
	
	
	

	
	
	/**
	 * 初始化仓库
	 * @return 
	 */
	public Map<String, DicWh> initWhCache();
	
	/**
	 * 获取仓库map
	 * @return
	 */
	public Map<String, DicWh> getAllWhCache();
	
	/**
	 * 根据仓库号获取仓库对象
	 * @param whCode
	 * @return
	 */
	public DicWh getWhCacheByCode(String whCode);
	
	/**
	 * 刷新仓库缓存
	 */
	public void refreshWhCache();

	/**
	 * 删除仓库缓存
	 * @param whCode
	 */
	public void deleteWhCacheByCode(String whCode);
	
	/**
	 * 初始化存储区
	 * @return 
	 */
	public Map<DicWhStorageSectionKey, DicWhStorageSectionVo> initStorageSectionCache();
	
	/**
	 * 获取存储区map
	 * @return
	 */
	public Map<DicWhStorageSectionKey, DicWhStorageSectionVo> getAllStorageSectionCache();
	
	/**
	 * 根据仓库号 存储类型  存储区号 获取 存储区对象
	 * @param whCode	仓库code
	 * @param typeCode	存储类型code
	 * @param sectionCode	存储区code
	 * @return
	 */
	public DicWhStorageSectionVo getStorageSectionCacheByPrimaryKey(String whCode , String typeCode,String sectionCode);
	
	/**
	 * 刷新存储区缓存
	 */
	public void refreshStorageSectionCache();

	/**
	 * 删除存储区缓存
	 * @param whCode
	 * @param typeCode
	 * @param sectionCode
	 */
	public void deleteStorageSectionCache(String whCode , String typeCode,String sectionCode);
	
	/**
	 * 初始化存储类型
	 * @return 
	 */
	public Map<DicWhStorageTypeKey, DicWhStorageTypeVo> initStorageTypeCache();
	
	/**
	 * 获取存储类型map
	 * @return
	 */
	public Map<DicWhStorageTypeKey, DicWhStorageTypeVo> getTypeUniqueCodeMap();
	
	/**
	 * 根据 仓库号 存储类型code 获取存储类型对象
	 * @param whCode	仓库code
	 * @param typeCode	存储类型code
	 * @return
	 */
	public DicWhStorageTypeVo getStorageTypeCacheByPrimaryKey(String whCode , String typeCode);
	
	/**
	 * 刷新存储类型缓存
	 */
	public void refreshStorageTypeCache();

	/**
	 * 删除存储类型缓存
	 * @param whCode
	 * @param typeCode
	 */
	public void deleteStorageTypeCache(String whCode , String typeCode);
	
	/**
	 * 初始化单位
	 * @return 
	 */
	public Map<String, DicUnit> initUnitCache();
	
	/**
	 * 获取单位map
	 * @return
	 */
	public Map<String, DicUnit> getAllUnitCache();
	
	/**
	 * 根据单位code获取单位对象
	 * @param unitCode
	 * @return
	 */
	public DicUnit getUnitCacheByCode(String unitCode);
	
	/**
	 * 刷新单位缓存
	 */
	public void refreshUnitCache();

	/**
	 * 删除单位缓存
	 * @param unitCode
	 */
	public void deleteUnitCache(String unitCode);
	
	/**
	 * 初始化单位关系
	 * @return 
	 */
	public Map<RelUnitKey, RelUnit> initRelUnitCache();
	/**
	 * 获取单位关系map
	 * @return
	 */
	public Map<RelUnitKey, RelUnit> getAllRelUnitCache();
	/**
	 * 根据单位code获取单位对象
	 * @param key
	 * @return
	 */
	public RelUnit getRelUnitCacheByPrimaryKey(RelUnitKey key);
	
	/**
	 * 刷新单位缓存
	 */
	public void refreshRelUnitCache();

	/**
	 * 删除单位缓存
	 * @param key
	 */
	public void deleteRelUnitCache(RelUnitKey key);
	
	/**
	 * 初始化语言
	 * @return 
	 */
	public Map<String, DicLanguage> initLanguageCache();
	
	/**
	 * 获取语言对象
	 * @return
	 */
	public Map<String, DicLanguage> getAllLanguageCache();
	
	/**
	 * 根据语言code获取语言对象
	 * @param languageCode
	 * @return
	 */
	public DicLanguage getLanguageCacheByCode(String languageCode);
	
	/**
	 * 刷新语言缓存
	 */
	public void refreshLanguageCache();

	/**
	 * 删除语言缓存
	 * @param languageCode
	 */
	public void deleteLanguageCache(String languageCode);

	public Set<DicWhStorageBinKey> initBinCache();
	
	public Set<DicWhStorageBinKey> getAllBinCache();

	DicWhStorageBinKey getBinCacheByPrimaryKey(String whCode, String typeCode, String binCode);
	
	public void refreshBinCache();

	public void deleteBinCache(String whCode , String typeCode , String binCode);
	
	/**
	 * 批量查询物料，该方法会优先从缓存中获取。
	 * 并将未命中缓存的物料信息加载到缓存中
	 * 
	 * @param list
	 * @return
	 * @author 李斌
	 */
	public Map<String, DicMaterial> getMatMapByMatCodeList(@NonNull List<String> list);
	
	/**
	 * 根据物料编码查物料，该方法会优先从缓存中获取物料信息。
	 * 并将未命中缓存的物料信息加载到缓存中。
	 * 
	 * @param matCode
	 * @return
	 * @author libin
	 */
	public DicMaterial getMatByMatCode(String matCode);
	
	
	
	

	
	
	/**
	 * 初始化物料工厂信息
	 * @return 
	 */
	public Map<DicMaterialFactoryKey, DicMaterialFactoryVo> initDicMaterialFactoryCache();
	
	/**
	 * 刷新物料工厂信息
	 */
	public void refreshDicMaterialFactoryCache();
	
	/**
	 * 获取物料工厂信息Map
	 * 
	 * @return
	 */
	Map<DicMaterialFactoryKey, DicMaterialFactoryVo> getAllMaterialFactoryCache();

	/**
	 * 获取物料工厂信息
	 * @param ftyCode
	 * @param matCode
	 * @return
	 */
	public DicMaterialFactoryVo getDicMaterialFactoryByUniqueKey(String ftyCode, String matCode);

	/**
	 * 删除物料工厂缓存
	 * @param ftyCode
	 * @param matCode
	 */
	public void deleteDicMaterialFactory(String ftyCode, String matCode);

	/**
	 * 更新物料信息缓存
	 * 
	 * @param matCode
	 * @author 李斌
	 */
	void refreshMatCacheByCode(String matCode);
	
	/**
	 * 根据物料编码列表更新物料信息缓存
	 * 
	 * @param matCodeList
	 * @author 李斌
	 */
	void refreshMatCacheByCodeList(List<String> matCodeList);

	/**
	 * 初始化物料国际化描述缓存
	 * 
	 * @author 李斌
	 */
	void initMatI18nNameCache();

	/**
	 * 根据语言枚举类查找物料国际化描述缓存
	 * 
	 * @param langCode
	 * @param tid
	 * @return
	 * @author 李斌
	 */
	String getMatI18nNameCache(EnumLang langCode, String tid);

	/**
	 * 根据语言字符串查找物料国际化描述缓存
	 * 
	 * @param langCode
	 * @param tid
	 * @return
	 * @author 李斌
	 */
	String getMatI18nNameCache(String langCode, String tid);

	/**
	 * 根据指定条件刷新物料国际化描述缓存
	 * 
	 * @param langCode
	 * @param tid
	 * @param name
	 * @author 李斌
	 */
	void refreshMatI18nNameCache(String langCode, String tid, String name);

	/**
	 * 根据物料描述对象列表刷新物料描述国际化描述缓存
	 * 
	 * @param matNameList
	 * @author 李斌
	 */
	void refreshMatI18nNameCache(List<DicMaterialName> matNameList);
	
	/**
	 * 初始化
	 * @return 
	 */
	Map<String, Map<String, String>> initTextCache();

	/**
	 * 获取名称
	 * 
	 * @param langCode
	 *            语言码
	 * @param tid
	 *            国际化唯一id
	 * @return
	 */
	String getTextCache(@NonNull EnumLang langCode, @NonNull String tid);

	/**
	 * 获取名称
	 * 
	 * @param langCode
	 *            语言码
	 * @param tid
	 *            国际化唯一id
	 * @return
	 */
	String getTextCache(@NonNull String langCode, @NonNull String tid);

	/**
	 * 更新国际化信息
	 * 
	 * @param langCode
	 *            语言码
	 * @param tid
	 *            国际化唯一id
	 * @param name
	 *            名称
	 */
	void editTextCache(EnumLang langCode, String tid, String name);
	
	/**
	 * 更新国际化描述
	 * @param langCode  语言码
	 * @param tids 国际化唯一id列表
	 */
	void refreshTextCache(List<String> tids);

}
