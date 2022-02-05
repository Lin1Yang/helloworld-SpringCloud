package com.inossem.wms.dao.conf;

import com.inossem.wms.co.dic.DicMaterialWhInfoCo;
import com.inossem.wms.model.conf.ConfMaterialWh;

public interface ConfMaterialWhMapper {
    int deleteByPrimaryKey(String whCode);

    int insert(ConfMaterialWh record);

    int insertSelective(ConfMaterialWh record);

    ConfMaterialWh selectByPrimaryKey(String whCode);

    int updateByPrimaryKeySelective(ConfMaterialWh record);

    int updateByPrimaryKey(ConfMaterialWh record);

	void insertSelectiveByDic(DicMaterialWhInfoCo infoCo);
}