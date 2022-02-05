package com.inossem.wms.dao.wf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.inossem.wms.model.wf.WfReceiptUser;
import com.inossem.wms.model.wf.WfReceiptUserExample;


@Repository
public interface WfReceiptUserMapper {
    int countByExample(WfReceiptUserExample example);

    int deleteByExample(WfReceiptUserExample example);

    int insert(WfReceiptUser record);

    int insertSelective(WfReceiptUser record);

    List<WfReceiptUser> selectByExample(WfReceiptUserExample example);


    int updateByExampleSelective(@Param("record") WfReceiptUser record, @Param("example") WfReceiptUserExample example);

    int updateByExample(@Param("record") WfReceiptUser record, @Param("example") WfReceiptUserExample example);

    int updateByPrimaryKeySelective(WfReceiptUser record);

    int insertOrUpdateSelective(WfReceiptUser record);
}