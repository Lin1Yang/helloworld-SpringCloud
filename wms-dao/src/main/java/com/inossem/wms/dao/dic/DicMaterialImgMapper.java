package com.inossem.wms.dao.dic;

import java.util.List;

import com.inossem.wms.model.dic.DicMaterialImg;
import com.inossem.wms.model.dic.DicMaterialImgCo;
import com.inossem.wms.model.dic.DicMaterialImgKey;
import com.inossem.wms.model.dic.DicMaterialImgVo;

public interface DicMaterialImgMapper {
    int deleteByPrimaryKey(DicMaterialImgKey key);

    int insert(DicMaterialImg record);    

    int insertSelective(DicMaterialImg record);

    DicMaterialImg selectByPrimaryKey(DicMaterialImgKey key);

    int updateByPrimaryKeySelective(DicMaterialImg record);

    int updateByPrimaryKey(DicMaterialImg record);
    
    List<DicMaterialImgVo> selectByMatCode(String matCode);
    
    /**
     * 批量添加物料图片
     * @param cos
     * @return
     * @author 刘宇 2019-1-30 17:05:55
     */
    int insertDicMaterialImgs(List<DicMaterialImgCo> cos);
    
    /**
     * 批量逻辑删除物料图片
     * @param cos
     * @return
     * @author 刘宇 2019-1-30 17:05:58
     */
    int updateDicMaterialImgs(List<DicMaterialImgCo> cos);
    
}