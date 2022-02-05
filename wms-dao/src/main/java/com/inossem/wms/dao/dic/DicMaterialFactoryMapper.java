package com.inossem.wms.dao.dic;

import com.inossem.wms.co.dic.DicMaterialFactoryCo;
import com.inossem.wms.model.dic.DicMaterialFactory;
import com.inossem.wms.model.dic.DicMaterialFactoryKey;
import com.inossem.wms.vo.dic.DicMaterialFactoryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DicMaterialFactoryMapper {
    int deleteByPrimaryKey(DicMaterialFactoryKey key);

    int insert(DicMaterialFactory record);

    int insertSelective(DicMaterialFactory record);

    DicMaterialFactory selectByPrimaryKey(DicMaterialFactoryKey key);

    int updateByPrimaryKeySelective(DicMaterialFactory record);

    int updateByPrimaryKey(DicMaterialFactory record);

    List<DicMaterialFactoryVo> getDicMaterialFactoryListOnPaging(DicMaterialFactoryCo co);

    DicMaterialFactoryVo getDicMaterialDetail(@Param("matCode") String matCode);
    
    /**
     * 工厂物料移动平均价相关信息批量保存
     * @param matList
     */
	void insertOrUpdate(List<DicMaterialFactory> dicMaterialFactoryList);

	/**
	 * 查询全部 
	 * @return
	 */
	List<DicMaterialFactoryVo> selectAllMaterialFactory();
	
	
}
