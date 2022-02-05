package com.inossem.wms.dao.wf;

import com.inossem.wms.model.wf.WfProcDef;

import java.util.List;

public interface WfProcDefMapper {
    int deleteByPrimaryKey(String procId);

    int insert(WfProcDef record);

    int insertSelective(WfProcDef record);

    WfProcDef selectByPrimaryKey(String procId);

    int updateByPrimaryKeySelective(WfProcDef record);

    int updateByPrimaryKey(WfProcDef record);

    List<WfProcDef> selectAllWfProcDef();
}