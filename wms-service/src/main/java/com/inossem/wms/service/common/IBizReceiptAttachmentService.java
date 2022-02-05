package com.inossem.wms.service.common;

import java.util.List;

import com.inossem.wms.common.exception.WMSException;
import com.inossem.wms.model.biz.BizReceiptAttachmentInfoCo;
import com.inossem.wms.model.biz.BizReceiptAttachmentSaveCo;
import com.inossem.wms.model.biz.BizReceiptAttachmentVo;

public interface IBizReceiptAttachmentService {

	/**
	 * 查询单据附件 
	 * 根据receiptType(单据类型)和 receiptCode(单据号)查询单据所有未删除的附件
	 * 
	 * @param receiptType(单据类型)
	 * @param receiptCode(单据号)
	 * @return
	 * @author 刘宇 2019-1-21 16:16:30
	 */
	List<BizReceiptAttachmentVo> getBizReceiptAttachmentVo(Integer receiptType, String receiptCode) throws WMSException;

	/**
	 * 保存单据附件 
	 * 新增的附件直接批量添加 
	 * 删除的附件如果当前登录人跟该单据该附件上传人一致可以删除,否则不可以删除。删除为逻辑删除
	 * 当想要删除全部附件的时候文件编码赋值空字符串,其余值正常传
	 * 
	 * @param cos
	 * @param userId-当前登录人id
	 * @return
	 * @author 刘宇 2019-1-22 14:18:40
	 */
	void saveBizReceiptAttachment(List<BizReceiptAttachmentInfoCo> cos,Integer receiptType, String receiptCode,Integer userId) throws WMSException;

	/**
	 * 添加单据附件
	 * 
	 * @param cos
	 * @param userId
	 * @return
	 * @author 刘宇 2019-1-22 16:13:43
	 */
	void saveAddBizReceiptAttachment(List<BizReceiptAttachmentSaveCo> cos, Integer userId) throws WMSException;

	/**
	 * 修改单据附件删除标识
	 * 
	 * @param cos
	 * @param userId
	 * @return
	 * @author 刘宇 2019-1-22 16:16:00
	 */
	void saveDeleteBizReceiptAttachment(List<BizReceiptAttachmentSaveCo> cos, Integer userId) throws WMSException;
	
	/**
	 * 获取保存前单据附件
	 * @param cos
	 * @return
	 * @author 刘宇2019-1-23 12:16:58
	 */
	List<BizReceiptAttachmentInfoCo> getBizReceiptAttachmentInfoCo(List<BizReceiptAttachmentInfoCo> cos) throws WMSException;

}
