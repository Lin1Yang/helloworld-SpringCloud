package com.inossem.wms.dao.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inossem.wms.vo.rel.RelReceiptRidVo;

public interface BizStockInputMapper {
	
	/**
	 * 根据单据获取单据信息
	 * @param stockInputCode
	 * @return
	 */
	RelReceiptRidVo selectRelReceiptRidVoByReceipt(RelReceiptRidVo vo);
	/**
	 * 根据单据行获取单据行信息
	 * @param stockInputCode
	 * @return
	 */
	List<RelReceiptRidVo> selectRelReceiptRidVoByReceiptRid(@Param("receiptType") Integer receiptType,
			@Param("receiptCode") String receiptCode, @Param("receiptRidList") List<String> receiptRidList);
	
}