package com.inossem.wms.dao.dic;

import com.inossem.wms.model.dic.DicReceiptType;

import org.apache.ibatis.annotations.MapKey;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public interface DicReceiptTypeMapper {
    int deleteByPrimaryKey(Integer receiptType);

    int insert(DicReceiptType record);

    int insertSelective(DicReceiptType record);

    DicReceiptType selectByPrimaryKey(Integer receiptType);

    int updateByPrimaryKeySelective(DicReceiptType record);

    int updateByPrimaryKey(DicReceiptType record);

    List<DicReceiptType> getReceiptTypeList();
    
    @MapKey("receiptType")
    Map<Integer, DicReceiptType> getReceiptTypeMap();
}