package com.inossem.wms.service.impl.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.collections4.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.inossem.wms.common.exception.PrimaryKeyNotExistException;
import com.inossem.wms.constant.Const;
import com.inossem.wms.dao.dic.DicCorpMapper;
import com.inossem.wms.dao.dic.DicLanguageMapper;
import com.inossem.wms.dao.dic.DicMaterialFactoryMapper;
import com.inossem.wms.dao.dic.DicMaterialMapper;
import com.inossem.wms.dao.dic.DicMaterialNameMapper;
import com.inossem.wms.dao.dic.DicTextMapper;
import com.inossem.wms.dao.dic.DicUnitMapper;
import com.inossem.wms.dao.dic.DicWhMapper;
import com.inossem.wms.dao.dic.DicWhStorageBinMapper;
import com.inossem.wms.dao.dic.DicWhStorageSectionMapper;
import com.inossem.wms.dao.dic.DicWhStorageTypeMapper;
import com.inossem.wms.dao.rel.RelUnitMapper;
import com.inossem.wms.enums.EnumLang;
import com.inossem.wms.enums.EnumReturnCode;
import com.inossem.wms.model.dic.DicCorp;
import com.inossem.wms.model.dic.DicLanguage;
import com.inossem.wms.model.dic.DicMaterial;
import com.inossem.wms.model.dic.DicMaterialFactoryKey;
import com.inossem.wms.model.dic.DicMaterialName;
import com.inossem.wms.model.dic.DicText;
import com.inossem.wms.model.dic.DicUnit;
import com.inossem.wms.model.dic.DicWh;
import com.inossem.wms.model.dic.DicWhStorageBinKey;
import com.inossem.wms.model.dic.DicWhStorageSectionKey;
import com.inossem.wms.model.dic.DicWhStorageTypeKey;
import com.inossem.wms.model.rel.RelUnit;
import com.inossem.wms.model.rel.RelUnitKey;
import com.inossem.wms.service.common.ICacheCommonService;
import com.inossem.wms.service.common.IDictionaryService;
import com.inossem.wms.vo.dic.DicCorpVo;
import com.inossem.wms.vo.dic.DicMaterialFactoryVo;
import com.inossem.wms.vo.dic.DicWhStorageSectionVo;
import com.inossem.wms.vo.dic.DicWhStorageTypeVo;

/**
 * ??????: ?????????????????????
 * ???????????????????????????????????????????????????????????????redis???????????????
 * 
 * @author ??????
 * ????????????: 2020???2???19???
 */
@Component
public class DictionaryServiceImpl implements IDictionaryService {

    private static Logger logger = LoggerFactory.getLogger(DictionaryServiceImpl.class);

    @Autowired
    protected ICacheCommonService cache;

    @Autowired
    protected DicCorpMapper corpDao;



   

    @Autowired
    protected DicWhMapper whDao;

    @Autowired
    protected DicWhStorageSectionMapper whStorageSectionDao;

    @Autowired
    protected DicWhStorageTypeMapper whStorageTypeDao;

    @Autowired
    protected DicUnitMapper unitDao;

    @Autowired
    protected RelUnitMapper relunitDao;

    @Autowired
    protected DicLanguageMapper languageDao;
    
    @Autowired
	protected DicTextMapper textDao;

    @Autowired
    protected DicWhStorageBinMapper whStorageBinDao;

    @Autowired
    protected DicMaterialMapper materialDao;
    
    @Autowired
	protected DicMaterialNameMapper dicMaterialNameDao;

   

   

    @Autowired
    protected DicMaterialFactoryMapper dicMaterialFactoryDao;

   

   
    
    /* ******************** ????????????????????? ************************ */
    @Override
    public Map<String, DicCorp> initCorpCache() {
        cache.delete(Const.CACHE_CORP);
        List<DicCorpVo> corpList = corpDao.selectAllCorpList();
        if (!CollectionUtils.isEmpty(corpList)) {
            for (DicCorp corp : corpList) {
                cache.put(Const.CACHE_CORP, corp.getCorpCode().toUpperCase(), corp);
            }
            // TODO refreshTextCache ???????????????????????????tid?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
			this.refreshTextCache(corpList, "getCorpName"); 
            return corpList.stream().collect(Collectors.toMap(DicCorp::getCorpCode, Function.identity()));
        }
        return null;

    }

	@Override
	@SuppressWarnings("unchecked")
    public Map<String, DicCorp> getAllCorpCache() {
        Map<String, DicCorp> map = (Map<String, DicCorp>) (cache.get(Const.CACHE_CORP));
        if (CollectionUtils.isEmpty(map)) {
        	// ????????????????????????????????????????????????????????????
        	return initCorpCache();
        }
        return map;
    }

    @Override
    public DicCorp getCorpCacheByCode(String corpCode) {
        if (corpCode == null) {
            return null;
        }
        return (DicCorp) (cache.get(Const.CACHE_CORP, corpCode.toUpperCase()));
    }

    @Override
    public void refreshAllCorpCache() {
        initCorpCache();
    }
    
    public void refreshCorpCacheByCode(String corpCode) {
    	cache.delete(Const.CACHE_CORP, corpCode.toUpperCase());
    	DicCorpVo corp = corpDao.selectByPrimaryKey(corpCode);
    	if (corp != null) {
    		cache.put(Const.CACHE_CORP, corp.getCorpCode().toUpperCase(), corp);
    	}
    }

    @Override
    public void deleteCorpCacheByCode(String corpCode) {
        if (StringUtils.hasText(corpCode)) {
            cache.delete(Const.CACHE_CORP, corpCode.toUpperCase());
        }
    }

   

    

    /* ******************** ???????????????????????? ************************ */
    @Override
    public Map<String, DicWh> initWhCache() {
        cache.delete(Const.CACHE_WH);
        List<DicWh> whList = whDao.selectAllWhList();
        if (!CollectionUtils.isEmpty(whList)) {
            for (DicWh wh : whList) {
                cache.put(Const.CACHE_WH, wh.getWhCode().toUpperCase(), wh);
            }
            // TODO refreshTextCache ???????????????????????????tid?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
            this.refreshTextCache(whList, "getWhName");
            return whList.stream().collect(Collectors.toMap(DicWh::getWhCode, Function.identity()));
        }
        return null;
    }

	@Override
	@SuppressWarnings("unchecked")
    public Map<String, DicWh> getAllWhCache() {
        Map<String, DicWh> map = (Map<String, DicWh>) (cache.get(Const.CACHE_WH));
        if (CollectionUtils.isEmpty(map)) {
        	return initWhCache();
        }
        return map;
    }

    @Override
    public DicWh getWhCacheByCode(String whCode) {
        if (whCode == null) {
            return null;
        }
        return (DicWh) (cache.get(Const.CACHE_WH, whCode.toUpperCase()));
    }

    @Override
    public void refreshWhCache() {
        initWhCache();
    }

    @Override
    public void deleteWhCacheByCode(String whCode) {
        if (whCode != null) {
            cache.delete(Const.CACHE_WH, whCode.toUpperCase());
        }
    }

    /* ******************** ???????????????????????? ************************ */
    @Override
    public Map<DicWhStorageSectionKey, DicWhStorageSectionVo> initStorageSectionCache() {
        cache.delete(Const.CACHE_SECTION);
        List<DicWhStorageSectionVo> sectionList = whStorageSectionDao.selectAllSectionList();
        if (!CollectionUtils.isEmpty(sectionList)) {
            for (DicWhStorageSectionVo section : sectionList) {
            	if (StringUtils.hasText(section.getWhCode()) && StringUtils.hasText(section.getTypeCode()) && StringUtils.hasText(section.getSectionCode())) {
            		DicWhStorageSectionKey key = new DicWhStorageSectionKey(section.getWhCode(), section.getTypeCode(), section.getSectionCode());
            		cache.put(Const.CACHE_SECTION, key, section);
            	} else {
                	logger.error("?????????????????????????????????????????????????????????????????????");
                }
            }
			// ?????????????????????
            Map<DicWhStorageSectionKey, DicWhStorageSectionVo> map = new HashedMap<>();
			sectionList.stream().forEach(section -> {
				DicWhStorageSectionKey key = new DicWhStorageSectionKey(section.getWhCode(), section.getTypeCode(), section.getSectionCode());
				if (!map.containsKey(key)) {
					map.put(key, section);
				} else {
					logger.error("?????????????????????????????????????????????????????????????????????");
				}
			});
			// TODO refreshTextCache ???????????????????????????tid?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
			this.refreshTextCache(sectionList, "getSectionName");
			return map;
        }
        return null;
    }

	@Override
	@SuppressWarnings("unchecked")
    public Map<DicWhStorageSectionKey, DicWhStorageSectionVo> getAllStorageSectionCache() {
    	Map<DicWhStorageSectionKey, DicWhStorageSectionVo> map = (Map<DicWhStorageSectionKey, DicWhStorageSectionVo>) (cache.get(Const.CACHE_SECTION));
    	if (CollectionUtils.isEmpty(map)) {
        	return initStorageSectionCache();
        }
        return map;
    }

    @Override
    public DicWhStorageSectionVo getStorageSectionCacheByPrimaryKey(String whCode, String typeCode, String sectionCode) {
        if (whCode == null || typeCode == null || sectionCode == null) {
            return null;
        }
        return (DicWhStorageSectionVo) (cache.get(Const.CACHE_SECTION, new DicWhStorageSectionKey(whCode, typeCode, sectionCode)));
    }

    @Override
    public void refreshStorageSectionCache() {
        initStorageSectionCache();
    }

    @Override
    public void deleteStorageSectionCache(String whCode, String typeCode, String sectionCode) {
        if (whCode != null && typeCode != null && sectionCode != null) {
            cache.delete(Const.CACHE_SECTION, new DicWhStorageSectionKey(whCode, typeCode, sectionCode));
        }
    }

    /* ******************** ??????????????????????????? ************************ */
    @Override
    public Map<DicWhStorageTypeKey, DicWhStorageTypeVo> initStorageTypeCache() {
        cache.delete(Const.CACHE_STORAGE_TYPE);
        List<DicWhStorageTypeVo> typeList = whStorageTypeDao.selectAllTypeList();
        if (!CollectionUtils.isEmpty(typeList)) {
            for (DicWhStorageTypeVo type : typeList) {
            	if (StringUtils.hasText(type.getWhCode()) && StringUtils.hasText(type.getTypeCode())) {
            		DicWhStorageTypeKey key = new DicWhStorageTypeKey(type.getWhCode(), type.getTypeCode());
            		cache.put(Const.CACHE_STORAGE_TYPE, key, type);
            	} else {
                	logger.error("????????????????????????????????????????????????????????????????????????");
                }
            }
			// ?????????????????????
            Map<DicWhStorageTypeKey, DicWhStorageTypeVo> map = new HashedMap<>();
            typeList.stream().forEach(type -> {
            	DicWhStorageTypeKey key = new DicWhStorageTypeKey(type.getWhCode(), type.getTypeCode());
				if (!map.containsKey(key)) {
					map.put(key, type);
				} else {
					logger.error("????????????????????????????????????????????????????????????????????????");
				}
			});
            // TODO refreshTextCache ???????????????????????????tid?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
            this.refreshTextCache(typeList, "getTypeName");
			return map;
        }
        return null;
    }

	@Override
	@SuppressWarnings("unchecked")
    public Map<DicWhStorageTypeKey, DicWhStorageTypeVo> getTypeUniqueCodeMap() {
		Map<DicWhStorageTypeKey, DicWhStorageTypeVo> map = (Map<DicWhStorageTypeKey, DicWhStorageTypeVo>) (cache.get(Const.CACHE_STORAGE_TYPE));
		if (CollectionUtils.isEmpty(map)) {
			return initStorageTypeCache();
		}
        return map;
    }

    @Override
    public DicWhStorageTypeVo getStorageTypeCacheByPrimaryKey(String whCode, String typeCode) {
        if (whCode == null || typeCode == null) {
            return null;
        }
        return (DicWhStorageTypeVo) (cache.get(Const.CACHE_STORAGE_TYPE, new DicWhStorageTypeKey(whCode, typeCode)));
    }

    @Override
    public void refreshStorageTypeCache() {
        initStorageTypeCache();
    }

    @Override
    public void deleteStorageTypeCache(String whCode, String typeCode) {
        if (whCode != null && typeCode != null) {
            cache.delete(Const.CACHE_STORAGE_TYPE, new DicWhStorageTypeKey(whCode, typeCode));
        }
    }

    /* ******************** ??????????????????????????? ************************ */
    @Override
    public Map<String, DicUnit> initUnitCache() {
        cache.delete(Const.CACHE_UNIT);
        List<DicUnit> unitList = unitDao.selectAllUnitList();
        if (!CollectionUtils.isEmpty(unitList)) {
            for (DicUnit unit : unitList) {
                cache.put(Const.CACHE_UNIT, unit.getUnitCode().toUpperCase(), unit);
            }
            // TODO refreshTextCache ???????????????????????????tid?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
            this.refreshTextCache(unitList, "getUnitName");
            return unitList.stream().collect(Collectors.toMap(DicUnit::getUnitCode, Function.identity()));
        }
        return null;
    }

	@Override
	@SuppressWarnings("unchecked")
    public Map<String, DicUnit> getAllUnitCache() {
        Map<String, DicUnit> map = (Map<String, DicUnit>) (cache.get(Const.CACHE_UNIT));
        if (CollectionUtils.isEmpty(map)) {
        	return initUnitCache();
        }
        return map;
    }

    @Override
    public DicUnit getUnitCacheByCode(String unitCode) {
        if (unitCode == null) {
            return null;
        }
        return (DicUnit) (cache.get(Const.CACHE_UNIT, unitCode.toUpperCase()));
    }

    @Override
    public void refreshUnitCache() {
        initUnitCache();

    }

    @Override
    public void deleteUnitCache(String unitCode) {
        if (unitCode != null) {
            cache.delete(Const.CACHE_UNIT, unitCode.toUpperCase());
        }
    }

    /* ******************** ?????????????????????????????? ************************ */
    @Override
    public Map<RelUnitKey, RelUnit> initRelUnitCache() {
        cache.delete(Const.CACHE_RELUNIT);
        List<RelUnit> relUnitList = relunitDao.selectAllRelUnitList();
        if (!CollectionUtils.isEmpty(relUnitList)) {
            for (RelUnit relUnit : relUnitList) {
				if (StringUtils.hasText(relUnit.getSourceUnitCode())
				        && StringUtils.hasText(relUnit.getTargetUnitCode()) && StringUtils.hasText(relUnit.getMatCode())) {
					RelUnitKey key = new RelUnitKey(relUnit.getFtyCode(), relUnit.getSourceUnitCode(), relUnit.getTargetUnitCode(), relUnit.getMatCode());
					cache.put(Const.CACHE_RELUNIT, key, relUnit);
				} else {
                	logger.error("?????????????????????????????????????????????????????????????????????");
                }
            }
			// ?????????????????????
            Map<RelUnitKey, RelUnit> map = new HashedMap<>();
            relUnitList.stream().forEach(relUnit -> {
            	RelUnitKey key = new RelUnitKey(relUnit.getFtyCode(), relUnit.getSourceUnitCode(), relUnit.getTargetUnitCode(), relUnit.getMatCode());
				if (!map.containsKey(key)) {
					map.put(key, relUnit);
				} else {
					logger.error("?????????????????????????????????????????????????????????????????????");
				}
			});
			return map;
        }
        return null;
    }

	@Override
	@SuppressWarnings("unchecked")
    public Map<RelUnitKey, RelUnit> getAllRelUnitCache() {
    	Map<RelUnitKey, RelUnit> map = (Map<RelUnitKey, RelUnit>) (cache.get(Const.CACHE_RELUNIT));
        if (CollectionUtils.isEmpty(map)) {
        	return initRelUnitCache();
        }
        return map;
    }

    @Override
    public RelUnit getRelUnitCacheByPrimaryKey(RelUnitKey key) {
        if (key == null) {
            return null;
        }
        return (RelUnit) (cache.get(Const.CACHE_RELUNIT, key));
    }

    @Override
    public void refreshRelUnitCache() {
        initRelUnitCache();
    }

    @Override
    public void deleteRelUnitCache(RelUnitKey key) {
        if (key != null) {
            cache.delete(Const.CACHE_RELUNIT, key);
        }
    }

    /* ******************** ??????????????????????????? ************************ */
    @Override
    public Map<String, DicLanguage> initLanguageCache() {
        cache.delete(Const.CACHE_LANGUAGE);
        List<DicLanguage> languageList = languageDao.selectAllLanguageList();
        if (!CollectionUtils.isEmpty(languageList)) {
            for (DicLanguage language : languageList) {
                cache.put(Const.CACHE_LANGUAGE, language.getLangCode().toUpperCase(), language);
            }
            // TODO refreshTextCache ???????????????????????????tid?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
            this.refreshTextCache(languageList, "getLangName");
            return languageList.stream().collect(Collectors.toMap(DicLanguage::getLangCode, Function.identity()));
        }
        return null;
    }

	@Override
	@SuppressWarnings("unchecked")
    public Map<String, DicLanguage> getAllLanguageCache() {
        Map<String, DicLanguage> map = (Map<String, DicLanguage>) (cache.get(Const.CACHE_LANGUAGE));
        if (CollectionUtils.isEmpty(map)) {
        	return initLanguageCache();
        }
        return map;
    }

    @Override
    public DicLanguage getLanguageCacheByCode(String languageCode) {
        if (languageCode == null) {
            return null;
        }
        return (DicLanguage) (cache.get(Const.CACHE_LANGUAGE, languageCode.toUpperCase()));
    }

    @Override
    public void refreshLanguageCache() {
        initLanguageCache();
    }

    @Override
    public void deleteLanguageCache(String languageCode) {
        if (languageCode != null) {
            cache.delete(Const.CACHE_LANGUAGE, languageCode.toUpperCase());
        }
    }

    
    /* ******************** ????????????????????? ************************ */
    @Override
    public Set<DicWhStorageBinKey> initBinCache() {
    	cache.delete(Const.CACHE_BIN);
        Set<DicWhStorageBinKey> binSet = new HashSet<DicWhStorageBinKey>();
        binSet = whStorageBinDao.selectAllBinList();
        if (!CollectionUtils.isEmpty(binSet)) {
            for (DicWhStorageBinKey bin : binSet) {
                cache.put(Const.CACHE_BIN, bin, bin);
            }
            return binSet;
        }
        return null;
    }

	@Override
	@SuppressWarnings("unchecked")
    public Set<DicWhStorageBinKey> getAllBinCache() {
        Map<String, DicWhStorageBinKey> map = (Map<String, DicWhStorageBinKey>) (cache.get(Const.CACHE_BIN));
        if (CollectionUtils.isEmpty(map)) {
        	return initBinCache();
        }
        return new HashSet<>(map.values());
    }

    @Override
    public DicWhStorageBinKey getBinCacheByPrimaryKey(String whCode, String typeCode, String binCode) {
        if (whCode == null || typeCode == null || binCode == null) {
            return null;
        }
        return (DicWhStorageBinKey) cache.get(Const.CACHE_BIN, new DicWhStorageBinKey(whCode, typeCode, binCode));
    }

    @Override
    public void refreshBinCache() {
        initBinCache();
    }

    @Override
    public void deleteBinCache(String whCode, String typeCode, String binCode) {
        if (whCode != null && typeCode != null && binCode != null) {
            cache.delete(Const.CACHE_BIN, new DicWhStorageBinKey(whCode, typeCode, binCode));
        }
    }
    
    /* ******************** ????????????????????? ************************ */
    /** 
     * 1??????????????????????????????????????????
     * 2??????????????????????????????????????????????????????
     * 
     * @author ??????
     * @date 2020/02/17
     * @see com.inossem.wms.service.common.IDictionaryService#getMatMapByMatCodeList(java.util.List)
     */
    @Override
    public Map<String, DicMaterial> getMatMapByMatCodeList(List<String> matCodeList) {
    	List<DicMaterial> cachedList = cache.multiGet(Const.CACHE_MATERIAL, matCodeList, DicMaterial.class);
    	if (CollectionUtils.isEmpty(cachedList)) {
    		// ???????????????????????????????????????????????????????????????????????????
    		List<DicMaterial> matList = materialDao.selectByPrimaryKeyList(matCodeList);
    		Map<String, DicMaterial> map = new HashedMap<>();
    		for (DicMaterial mat : matList) {
    			cache.put(Const.CACHE_MATERIAL, mat.getMatCode(), mat);
    			map.put(mat.getMatCode(), mat);
			}
    		return map;
    	}
    	if (matCodeList.size() == cachedList.size()) {
    		// ??????????????????????????????????????????
    		Map<String, DicMaterial> map = new HashedMap<>();
    		for (DicMaterial mat : cachedList) {
    			map.put(mat.getMatCode(), mat);
			}
    		return map;
    	} else {
    		// ??????????????????????????????????????????????????????????????????????????????
    		// ????????????????????????
    		List<String> missedKeyList = new ArrayList<String>(matCodeList);
    		List<String> cachedListKeys = cachedList.stream().map(DicMaterial::getMatCode).collect(Collectors.toList());
    		missedKeyList.removeAll(cachedListKeys);
    		
    		List<DicMaterial> matList = materialDao.selectByPrimaryKeyList(missedKeyList);
    		Map<String, DicMaterial> map = new HashedMap<>();
    		for (DicMaterial mat : matList) {
    			cache.put(Const.CACHE_MATERIAL, mat.getMatCode(), mat);
    			map.put(mat.getMatCode(), mat);
			}
    		return map;
    	}
    }

    @Override
    public DicMaterial getMatByMatCode(String matCode) {
    	DicMaterial mat = (DicMaterial) cache.get(Const.CACHE_MATERIAL, matCode);
    	if (mat == null) {
    		// ???????????????????????????????????????
    		mat = materialDao.selectByPrimaryKey(matCode);
    		if (mat == null) {
    			return null;
    		}
    		cache.put(Const.CACHE_MATERIAL, matCode, mat);
    		return mat;
    	}
    	return mat;
    }
    
    @Override
    public void refreshMatCacheByCode(String matCode) {
    	DicMaterial mat = materialDao.selectByPrimaryKey(matCode);
    	if (mat != null) {
    		cache.delete(Const.CACHE_MATERIAL, matCode);
    		cache.put(Const.CACHE_MATERIAL, matCode, mat);
    	}
    }
    
    @Override
	public void refreshMatCacheByCodeList(List<String> matCodeList) {
    	List<DicMaterial> matList = materialDao.selectByPrimaryKeyList(matCodeList);
    	if (!CollectionUtils.isEmpty(matList)) {
    		for (DicMaterial mat : matList) {
    			cache.delete(Const.CACHE_MATERIAL, mat.getMatCode());
    			cache.put(Const.CACHE_MATERIAL, mat.getMatCode(), mat);
    		}
    	}
	}

    /* ??????????????????????????? 
     * ?????????????????????????????????????????????????????????????????????????????????????????????????????????dic_material_name???
     * ?????????????????????????????????
     * 
     * @author ??????
     * @see com.inossem.wms.service.common.IDictionaryService#initMatI18nNameCache()
     */
    @Override
    public void initMatI18nNameCache() {
    	cache.delete(Const.CACHE_MATERIAL_I18N_NAME);
		Map<String, Map<String, String>> map = new HashMap<String, Map<String, String>>();
		// ????????????
		List<DicLanguage> langList = languageDao.selectAllLanguageList();
		// ???????????????????????????
		List<DicMaterialName> dicMaterialNameList = dicMaterialNameDao.select();

		for (DicLanguage dicLanguage : langList) {
			map.put(dicLanguage.getLangCode(), new HashMap<String, String>());
		}
		for (DicMaterialName dicMaterialName : dicMaterialNameList) {
			if (!map.containsKey(dicMaterialName.getLangCode())) {
				continue;
			}
			Map<String, String> tidMap = map.get(dicMaterialName.getLangCode());
			tidMap.put(dicMaterialName.getTid(), dicMaterialName.getMatName());
		}
		
		// ?????????????????????
		for (String langCode : map.keySet()) {
			cache.put(Const.CACHE_MATERIAL_I18N_NAME, langCode, map.get(langCode));
		}
	}
    
    @Override
	public String getMatI18nNameCache(EnumLang langCode, String tid) {
		return this.getMatI18nNameCache(langCode.getValue(), tid);
	}

    @Override
	@SuppressWarnings("unchecked")
	public String getMatI18nNameCache(String langCode, String tid) {
		Map<String, String> map = (Map<String, String>) cache.get(Const.CACHE_MATERIAL_I18N_NAME, langCode);
		
		if (CollectionUtils.isEmpty(map) || map.get(tid) == null) {
			return null;
		}
		return map.get(tid);
	}
	
    @Override
	public void refreshMatI18nNameCache(String langCode, String tid, String name) {
		if (!StringUtils.hasText(name)) {
			return;
		}

		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) cache.get(Const.CACHE_MATERIAL_I18N_NAME, langCode);
		if (CollectionUtils.isEmpty(map)) {
			throw new PrimaryKeyNotExistException(EnumReturnCode.RETURN_CODE_LANGUAGE_NOT_EXIST, langCode);
		}
		map.put(tid, name);
		cache.put(Const.CACHE_MATERIAL_I18N_NAME, langCode, map);
	}
	
    @Override
	public void refreshMatI18nNameCache(List<DicMaterialName> matNameList) {
		if (CollectionUtils.isEmpty(matNameList)) {
			return;
		}
		// ???nameList??????langCode??????
		Map<String, List<DicMaterialName>> map = matNameList.stream()
		        .collect(Collectors.groupingBy(DicMaterialName::getLangCode));
		for (String langCode : map.keySet()) {
			for (DicMaterialName name : map.get(langCode)) {
				@SuppressWarnings("unchecked")
				Map<String, String> cacheMap = (Map<String, String>) cache.get(Const.CACHE_MATERIAL_I18N_NAME, langCode);
				cacheMap.put(name.getTid(), name.getMatName());
				cache.put(Const.CACHE_MATERIAL_I18N_NAME, langCode, cacheMap);
			}
		}
	}
    
    
    

    
    /* ******************** erp?????????????????? ************************ */
    

    

    

   

    
    /* ******************** ??????????????????????????? ************************ */
    @Override
    public Map<DicMaterialFactoryKey, DicMaterialFactoryVo> initDicMaterialFactoryCache() {
        cache.delete(Const.CACHE_DICMATERIALFACTORY);
        List<DicMaterialFactoryVo> materialFactoryList = dicMaterialFactoryDao.selectAllMaterialFactory();
        if (!CollectionUtils.isEmpty(materialFactoryList)) {
            for (DicMaterialFactoryVo dicMaterialFactory : materialFactoryList) {
    			if (StringUtils.hasText(dicMaterialFactory.getFtyCode()) && StringUtils.hasText(dicMaterialFactory.getMatCode())) {
    				DicMaterialFactoryKey key = new DicMaterialFactoryKey(dicMaterialFactory.getMatCode(), dicMaterialFactory.getFtyCode());
    				cache.put(Const.CACHE_DICMATERIALFACTORY, key, dicMaterialFactory);
    			} else {
                	logger.error("???????????????????????????????????????????????????????????????");
                }
            }
    		// ?????????????????????
            Map<DicMaterialFactoryKey, DicMaterialFactoryVo> map = new HashedMap<>();
            materialFactoryList.stream().forEach(dicMaterialFactory -> {
            	DicMaterialFactoryKey key = new DicMaterialFactoryKey(dicMaterialFactory.getFtyCode(), dicMaterialFactory.getMatCode());
    			if (!map.containsKey(key)) {
    				map.put(key, dicMaterialFactory);
    			} else {
    				logger.error("erp?????????????????????????????????????????????????????????");
    			}
    		});
    		return map;
        }
        return null;
    }

    @Override
    public void refreshDicMaterialFactoryCache() {
        initDicMaterialFactoryCache();

    }

	@Override
	@SuppressWarnings("unchecked")
    public Map<DicMaterialFactoryKey, DicMaterialFactoryVo> getAllMaterialFactoryCache() {
		Map<DicMaterialFactoryKey, DicMaterialFactoryVo> map = (Map<DicMaterialFactoryKey, DicMaterialFactoryVo>)(cache.get(Const.CACHE_DICMATERIALFACTORY));
		if (CollectionUtils.isEmpty(map)) {
        	return initDicMaterialFactoryCache();
        }
        return map;
    }

    @Override
    public DicMaterialFactoryVo getDicMaterialFactoryByUniqueKey(String ftyCode, String matCode) {
        if (ftyCode == null || matCode == null) {
            return null;
        }
        return (DicMaterialFactoryVo) cache.get(Const.CACHE_DICMATERIALFACTORY, new DicMaterialFactoryKey(ftyCode, matCode));
    }

    @Override
    public void deleteDicMaterialFactory(String ftyCode, String matCode) {
        if (ftyCode != null && matCode != null) {
            cache.delete(Const.CACHE_DICMATERIALFACTORY, new DicMaterialFactoryKey(ftyCode, matCode));
        }
    }

    
    /**
     * ?????????????????????????????????
     * ????????????????????????????????????????????????????????????????????????tid??????
     * ??????????????????????????????
     * 
     * @param objList ?????????????????????????????????????????????
     * @param methodName ?????????????????????tid????????????????????????
     * @author ??????
     */
    private <T> void refreshTextCache(List<T> objList, String methodName) {
        // ?????????????????????
        List<String> tidList = new ArrayList<String>();
        for (T o : objList) {
        	String tid = null;
        	try {
        		tid = (String) o.getClass().getMethod(methodName).invoke(o);
        	} catch (Exception e) {
				break;
			}
        	tidList.add(tid);
        }
        this.refreshTextCache(tidList);
    }
    
    
    @Override
	public Map<String, Map<String, String>> initTextCache() {
		cache.delete(Const.CACHE_LANGUAGE_I18N_TEXT);
		Map<String, Map<String, String>> map = new HashMap<String, Map<String, String>>();

		// ????????????
		List<DicLanguage> langList = languageDao.selectAllLanguageList();

		for (DicLanguage dicLanguage : langList) {
			map.put(dicLanguage.getLangCode(), new HashMap<String, String>());
		}

		// ???????????????????????????
		List<DicText> textList = textDao.select();

		for (DicText text : textList) {
			if (!map.containsKey(text.getLangCode())) {
				continue;
			}
			map.get(text.getLangCode()).put(text.getTid(), text.getText());
		}

		map.forEach((k, v) -> cache.put(Const.CACHE_LANGUAGE_I18N_TEXT, k, v));
		return map;
	}

	@Override
	public String getTextCache(EnumLang langCode, String tid) {
		return this.getTextCache(langCode.getValue(), tid);
	}

	@Override
	@SuppressWarnings("unchecked")
	public String getTextCache(String langCode, String tid) {
		Map<String, String> map = (Map<String, String>) cache.get(Const.CACHE_LANGUAGE_I18N_TEXT, langCode);
		if (CollectionUtils.isEmpty(map)) {
			map = initTextCache().get(langCode);
		}
		if (CollectionUtils.isEmpty(map)) {
			logger.error("PrimaryKeyNotExistException  langCode:{}, tid:{}", langCode, tid);
			throw new PrimaryKeyNotExistException(EnumReturnCode.RETURN_CODE_LANGUAGE_NOT_EXIST, langCode);
		}

		String name = map.get(tid);

		if (name == null) {
			name = Const.STRING_EMPTY;
		}
		return name;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void editTextCache(EnumLang langCode, String tid, String name) {
		if (name == null) {
			return;
		}

		Map<String, String> map = (Map<String, String>) cache.get(Const.CACHE_LANGUAGE_I18N_TEXT, langCode);
		if (CollectionUtils.isEmpty(map)) {
			throw new PrimaryKeyNotExistException(EnumReturnCode.RETURN_CODE_LANGUAGE_NOT_EXIST, langCode.getValue());
		}

		map.put(tid, name);
		cache.put(Const.CACHE_LANGUAGE_I18N_TEXT, langCode, map);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public synchronized void refreshTextCache(List<String> tids) {
		// ????????????
		List<DicText> textList = textDao.selectListByTids(tids);
		if (textList == null) {
			return;
		}
		
		Map<String, Map<String, String>> map = (Map<String, Map<String, String>>) cache.get(Const.CACHE_LANGUAGE_I18N_TEXT);
		if (CollectionUtils.isEmpty(map)) {
			initTextCache();
			return;
		}
		
		// ??????????????????
		for (String langCode : map.keySet()) {
			Map<String, String> innerMap = map.get(langCode);
			for (DicText dicText : textList) {
				if (innerMap.containsKey(dicText.getTid())) {
					innerMap.remove(dicText.getTid());
				}
			}
		}
		
		for (DicText dicText : textList) {
			map.get(dicText.getLangCode()).put(dicText.getTid(), dicText.getText());
		}
		map.forEach((k, v) -> cache.put(Const.CACHE_LANGUAGE_I18N_TEXT, k, v));
	}

    
}

