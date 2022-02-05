package com.inossem.wms.dao.biz;

import java.util.List;

import com.inossem.wms.model.biz.BizReceiptAttachment;
import com.inossem.wms.model.biz.BizReceiptAttachmentCo;
import com.inossem.wms.model.biz.BizReceiptAttachmentSaveCo;
import com.inossem.wms.model.biz.BizReceiptAttachmentVo;

public interface BizReceiptAttachmentMapper {
    int deleteByPrimaryKey(Integer bizReceiptAttachmentId);

    int insert(BizReceiptAttachment record);

    int insertSelective(BizReceiptAttachment record);

    BizReceiptAttachment selectByPrimaryKey(Integer bizReceiptAttachmentId);

    int updateByPrimaryKeySelective(BizReceiptAttachment record);

    int updateByPrimaryKey(BizReceiptAttachment record); 
    
    /**
     * 根据单据类型和单据号查询单据所有未删除的附件
     * @param co
     * @return
     * @author 刘宇 2019-1-21 16:14:05
     */
    List<BizReceiptAttachmentVo> selectByReceiptCodeAndReceiptType(BizReceiptAttachmentCo co);
    
    /**
     * 批量添加单据附件
     * @param cos
     * @return
     * @author 刘宇 2019-1-22 15:11:20
     */
    int insertBizReceiptAttachments(List<BizReceiptAttachmentSaveCo> cos);
    
    /**
     * 批量逻辑删除单据附件
     * @param cos
     * @return
     * @author 刘宇 2019-1-22 15:14:42
     */
    int updateBizReceiptAttachments(List<BizReceiptAttachmentSaveCo> cos);
    
    
}