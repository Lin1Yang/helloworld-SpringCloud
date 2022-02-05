package com.inossem.wms.service.impl.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inossem.wms.common.exception.WMSException;
import com.inossem.wms.common.util.UtilBean;
import com.inossem.wms.common.util.UtilString;
import com.inossem.wms.constant.Const;
import com.inossem.wms.dao.biz.BizReceiptAttachmentMapper;
import com.inossem.wms.enums.EnumReturnCode;
import com.inossem.wms.model.biz.BizReceiptAttachment;
import com.inossem.wms.model.biz.BizReceiptAttachmentCo;
import com.inossem.wms.model.biz.BizReceiptAttachmentInfoCo;
import com.inossem.wms.model.biz.BizReceiptAttachmentSaveCo;
import com.inossem.wms.model.biz.BizReceiptAttachmentVo;
import com.inossem.wms.service.common.IBizReceiptAttachmentService;

@Transactional
@Service
public class BizReceiptAttachmentServiceImpl implements IBizReceiptAttachmentService {

	@Autowired
	protected BizReceiptAttachmentMapper bizReceiptAttachmentDao;

	@Override
	public List<BizReceiptAttachmentVo> getBizReceiptAttachmentVo(Integer receiptType, String receiptCode)
			throws WMSException {
		List<BizReceiptAttachmentVo> vo = null;
		if (null == receiptType || 0 == receiptType.intValue()) {
			throw new WMSException(EnumReturnCode.RETURN_CODE_RECEIPT_TYPE_CAN_NOT_BE_EMPTY);
		} else if (UtilString.isNullOrEmpty(receiptCode)) {
			throw new WMSException(EnumReturnCode.RETURN_CODE_RECEIPT_CODE_CAN_NOT_BE_EMPTY);
		} else {
			BizReceiptAttachmentCo co = new BizReceiptAttachmentCo();
			co.setReceiptType(receiptType);
			co.setReceiptCode(receiptCode);
			vo = bizReceiptAttachmentDao.selectByReceiptCodeAndReceiptType(co);
		}
		return vo;
	}

	@Override
	public void saveBizReceiptAttachment(List<BizReceiptAttachmentInfoCo> cos, Integer receiptType, String receiptCode,
			Integer userId) throws WMSException {

		if (null != cos && Const.ZERO != cos.size()) {
			if (null == receiptType || 0 == receiptType.intValue()) {
				throw new WMSException(EnumReturnCode.RETURN_CODE_RECEIPT_TYPE_CAN_NOT_BE_EMPTY);
			} else if (UtilString.isNullOrEmpty(receiptCode)) {
				throw new WMSException(EnumReturnCode.RETURN_CODE_RECEIPT_CODE_CAN_NOT_BE_EMPTY);
			} else {
				for (BizReceiptAttachmentInfoCo infoCo : cos) {
					infoCo.setReceiptType(receiptType);
					infoCo.setReceiptCode(receiptCode);
				}
				List<BizReceiptAttachmentInfoCo> nowListDelete = this.getBizReceiptAttachmentInfoCo(cos);

				List<BizReceiptAttachmentSaveCo> saveAddList = new ArrayList<BizReceiptAttachmentSaveCo>();// 保存新增单据附件集合
				List<BizReceiptAttachmentSaveCo> saveDeleteList = new ArrayList<BizReceiptAttachmentSaveCo>();// 保存删除单据附件集合

				// 需要删除的单据附件
				for (BizReceiptAttachmentInfoCo infoCo : cos) {
					Iterator<BizReceiptAttachmentInfoCo> iterator = nowListDelete.listIterator();
					while (iterator.hasNext()) {
						BizReceiptAttachmentInfoCo nowInfoCo = iterator.next();
						if (infoCo.getBizReceiptAttachmentId() !=null && nowInfoCo.getBizReceiptAttachmentId() !=null && infoCo.getBizReceiptAttachmentId().equals(nowInfoCo.getBizReceiptAttachmentId())) {
							iterator.remove();
						}
					}
				}

				List<BizReceiptAttachmentInfoCo> nowListAdd = this.getBizReceiptAttachmentInfoCo(cos);
				// 需要新增的单据附件
				for (BizReceiptAttachmentInfoCo infoCo : nowListAdd) {
					Iterator<BizReceiptAttachmentInfoCo> iterator = cos.listIterator();
					while (iterator.hasNext()) {
						BizReceiptAttachmentInfoCo nowInfoCo = iterator.next();
						if (infoCo.getBizReceiptAttachmentId() !=null && nowInfoCo.getBizReceiptAttachmentId() !=null && infoCo.getBizReceiptAttachmentId().equals(nowInfoCo.getBizReceiptAttachmentId())) {
							iterator.remove();
						}
					}
				}

				List<BizReceiptAttachmentInfoCo> deleteList = new ArrayList<BizReceiptAttachmentInfoCo>(nowListDelete);// 删除单据附件集合
				List<BizReceiptAttachmentInfoCo> addList = new ArrayList<BizReceiptAttachmentInfoCo>(cos);// 新增单据附件集合

				for (BizReceiptAttachmentInfoCo infoCo : addList) {
					BizReceiptAttachmentSaveCo saveCo = new BizReceiptAttachmentSaveCo();
					UtilBean.getBean(infoCo, saveCo);
					saveAddList.add(saveCo);
				}
				for (BizReceiptAttachmentInfoCo infoCo : deleteList) {
					BizReceiptAttachmentSaveCo saveCo = new BizReceiptAttachmentSaveCo();
					UtilBean.getBean(infoCo, saveCo);
					saveDeleteList.add(saveCo);
				}
				this.saveAddBizReceiptAttachment(saveAddList, userId);

				this.saveDeleteBizReceiptAttachment(saveDeleteList, userId);

			}
		}
	}

	@Override
	public void saveAddBizReceiptAttachment(List<BizReceiptAttachmentSaveCo> cos, Integer userId) throws WMSException {
		//如果文件编码为空,不添加,视为删除该单据的全部附件
		if (null != cos && Const.ZERO != cos.size() && !UtilString.isNullOrEmpty(cos.get(0).getFileCode())) {
			for (BizReceiptAttachmentSaveCo saveAdd : cos) {
				saveAdd.setCreateUserId(userId);
				saveAdd.setModifyUserId(userId);
			}
			/**
			 * 添加单据附件
			 */
			bizReceiptAttachmentDao.insertBizReceiptAttachments(cos);
		}

	}

	@Override
	public void saveDeleteBizReceiptAttachment(List<BizReceiptAttachmentSaveCo> cos, Integer userId)
			throws WMSException {
		if (null != cos && Const.ZERO != cos.size()) {
			Iterator<BizReceiptAttachmentSaveCo> iterator = cos.listIterator();
			while (iterator.hasNext()) {
				BizReceiptAttachmentSaveCo saveCo = iterator.next();
				BizReceiptAttachment attachment = bizReceiptAttachmentDao
						.selectByPrimaryKey(saveCo.getBizReceiptAttachmentId());
				Integer createUserId = attachment.getCreateUserId();
				// 当前登录人和附件上传人是一个人次可以删除 否者 不可以删除单据上的附件
				if (createUserId.intValue() == userId.intValue()) {
					saveCo.setIsDelete((byte) 1);
					saveCo.setModifyUserId(userId);
				} else {
					iterator.remove();
				}
			}
			/**
			 * 修改单据附件删除标识
			 */
			if (null != cos && Const.ZERO != cos.size()) {
				bizReceiptAttachmentDao.updateBizReceiptAttachments(cos);
			}
		}

	}

	@Override
	public List<BizReceiptAttachmentInfoCo> getBizReceiptAttachmentInfoCo(List<BizReceiptAttachmentInfoCo> cos)
			throws WMSException {
		List<BizReceiptAttachmentVo> voList = new ArrayList<BizReceiptAttachmentVo>();// 现在数据库里的单据附件结果集合
		voList = this.getBizReceiptAttachmentVo(cos.get(0).getReceiptType(), cos.get(0).getReceiptCode());

		List<BizReceiptAttachmentInfoCo> nowList = new ArrayList<BizReceiptAttachmentInfoCo>();// 现在数据库里的单据附件入参集合
		for (BizReceiptAttachmentVo vo : voList) {
			BizReceiptAttachmentInfoCo infoCo = new BizReceiptAttachmentInfoCo();
			UtilBean.getBean(vo, infoCo);
			nowList.add(infoCo);
		}
		return nowList;
	}
}
