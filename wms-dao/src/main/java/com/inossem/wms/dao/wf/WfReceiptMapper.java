package com.inossem.wms.dao.wf;

import com.inossem.wms.co.wf.WfProcTaskSearchCo;
import com.inossem.wms.co.wf.WfReceiptCo;
import com.inossem.wms.model.wf.WfReceipt;
import com.inossem.wms.model.wf.WfReceiptExample;
import com.inossem.wms.model.wf.WfReceiptKey;
import com.inossem.wms.vo.wf.WfNodeVo;
import com.inossem.wms.vo.wf.WfProcTaskSearchVo;
import com.inossem.wms.vo.wf.WfReceiptVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WfReceiptMapper {
    int countByExample(WfReceiptExample example);

    int deleteByExample(WfReceiptExample example);

    int deleteByPrimaryKey(WfReceiptKey key);

    int insert(WfReceipt record);

    int insertSelective(WfReceipt record);

    List<WfReceipt> selectByExample(WfReceiptExample example);

    WfReceipt selectByPrimaryKey(WfReceiptKey key);

    int updateByExampleSelective(@Param("record") WfReceipt record, @Param("example") WfReceiptExample example);

    int updateByExample(@Param("record") WfReceipt record, @Param("example") WfReceiptExample example);

    int updateByPrimaryKeySelective(WfReceipt record);

    int updateByPrimaryKey(WfReceipt record);

    List<WfReceiptVo> selectSelective(WfReceiptCo wfReceiptCo);

    void saveOrUpdate(WfReceiptCo wfReceiptCo);

    List<WfNodeVo> selectRealTimeNodeByProcId(String procInsId);

    List<WfProcTaskSearchVo> selectTaskBySearchInfoOnPaging(WfProcTaskSearchCo searchTask);
    
    WfReceipt selectTaskStartTime(String procInsId);
    
    List<WfProcTaskSearchVo> selectAgencyTaskList(WfReceiptCo wfReceiptCo);
}