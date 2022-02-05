package com.inossem.wms.dao.dic;

import java.util.List;

import com.inossem.wms.co.dic.DicMaterialWhCo;
import com.inossem.wms.model.dic.DicMaterialWh;
import com.inossem.wms.model.dic.DicMaterialWhKey;
import com.inossem.wms.vo.dic.DicMaterialWhVo;

public interface DicMaterialWhMapper {
    int deleteByPrimaryKey(DicMaterialWhKey key);

    int insert(DicMaterialWh record);

    int insertSelective(DicMaterialWh record);

    DicMaterialWh selectByPrimaryKey(DicMaterialWhKey key);

    int updateByPrimaryKeySelective(DicMaterialWh record);

    int updateByPrimaryKey(DicMaterialWh record);
    
   /**
    * 分页查询物料仓库储存类型
    */
    List<DicMaterialWhVo> selectDicMaterialWhOnPaging(DicMaterialWhCo co);

    /**
     * 查询物料仓库
     * @return
     */
    List<DicMaterialWh> selectDicMaterialWh();

    int insertList(List<DicMaterialWhKey> materialWhKeys);

    /**
     * 新增或修改
     * @param record
     * @return
     */
    int insertOrUpdateSelective(DicMaterialWh record);
}