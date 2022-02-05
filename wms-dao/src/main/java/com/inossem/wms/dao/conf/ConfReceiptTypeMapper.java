package com.inossem.wms.dao.conf;

import com.inossem.wms.co.conf.DeleteConfReceiptTypeCo;
import com.inossem.wms.co.conf.QueryConfReceiptTypeCo;
import com.inossem.wms.model.conf.ConfReceiptType;
import com.inossem.wms.model.conf.ConfReceiptTypeKey;

import java.util.List;

public interface ConfReceiptTypeMapper {
    int deleteByPrimaryKey(ConfReceiptTypeKey key);

    /**
     * 删除配置
     * @param key
     * @return
     */
    int deleteByKeyList(DeleteConfReceiptTypeCo key);

    int insert(ConfReceiptType record);

    int insertSelective(ConfReceiptType record);

    ConfReceiptType selectByPrimaryKey(ConfReceiptTypeKey key);

    int updateByPrimaryKeySelective(ConfReceiptType record);

    int updateByPrimaryKey(ConfReceiptType record);
    
    List<ConfReceiptType> selectByCode(String confReceiptTypeCode);

    /**
     * 列表查询
     * @param co
     * @return
     */
    List<ConfReceiptType> selectAllReceiptTypeOnPaging(QueryConfReceiptTypeCo co);


}