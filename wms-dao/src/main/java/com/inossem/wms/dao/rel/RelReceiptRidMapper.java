package com.inossem.wms.dao.rel;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inossem.wms.common.ReceiptKey;
import com.inossem.wms.model.rel.RelReceiptRidKey;
import com.inossem.wms.vo.rel.RelReceiptRidVo;

public interface RelReceiptRidMapper {
	int deleteByPrimaryKey(RelReceiptRidKey key);

	int insert(RelReceiptRidKey record);

	int insertSelective(RelReceiptRidKey record);

	/**
	 * 根据前续单据获取单据列表
	 * @param preReceiptType
	 * @param preReceiptCode
	 * @return
	 */
	List<ReceiptKey> selectByPreReceipt(@Param("preReceiptType") Integer preReceiptType,
			@Param("preReceiptCode") String preReceiptCode);

	/**
	 * 根据前续单据行获取单据行
	 * @param preReceiptType
	 * @param preReceiptCode
	 * @param preReceiptRidList
	 * @return
	 */
	List<RelReceiptRidVo> selectByPreReceiptRid(@Param("preReceiptType") Integer preReceiptType,
			@Param("preReceiptCode") String preReceiptCode, @Param("preReceiptRidList") List<String> preReceiptRidList);

	/**
	 * 根据当前单据获取前续单据
	 * @param receiptType
	 * @param receiptCode
	 * @return
	 */
	List<ReceiptKey> selectByReceipt(@Param("receiptType") Integer receiptType,
			@Param("receiptCode") String receiptCode);

	/**
	 * 根据当前当局行获取前续单据行
	 * @param receiptType
	 * @param receiptCode
	 * @param receiptRidList
	 * @return
	 */
	List<RelReceiptRidVo> selectByReceiptRid(@Param("receiptType") Integer receiptType,
			@Param("receiptCode") String receiptCode, @Param("receiptRidList") List<String> receiptRidList);

	/**
	 * 根据单据类型和单号删除单据流
	 * 
	 * @param receiptCode
	 * @param receiptType
	 */
	int deleteByTypeAndCode(@Param("receiptType") Integer receiptType, @Param("receiptCode") String receiptCode);
	
	/**
	 * 根据单据类型和单号和行号删除单据流
	 * 
	 * @param receiptCode
	 * @param receiptType
	 */
	int deleteByTypeAndCodeAndRidList(@Param("receiptType") Integer receiptType, @Param("receiptCode") String receiptCode, @Param("receiptRidList") List<String> receiptRidList);
	
	/**
	 * 批量插入单据流
	 * 
	 * @param List<RelReceiptRidKey>
	 * @param 
	 */
	int insertReceiptTree(List<RelReceiptRidKey> list);
}