package com.inossem.wms.service.common;

import java.util.List;

import com.inossem.wms.model.biz.BizReceiptItemImg;
import com.inossem.wms.model.biz.BizReceiptItemImgVo;
import com.inossem.wms.model.biz.IBizReceiptItem;

public interface IBizReceiptItemImgService {
	
	/**
	 * 保存行项目对应的图片信息
	 * @param receiptType
	 * @param receiptCode
	 * @param receipt_rid
	 * @param file_code
	 * @param userid
	 * @author cdq
	 */
	void  addBizReceiptItemImg(Integer receiptType,String receiptCode,String receipt_rid,String file_code,Integer userid);
	
	/**
	 * 查询行项目对应的图片信息
	 * @param receiptType
	 * @param receiptCode
	 * @param receipt_rid
	 * @return
	 * @author cdq
	 */
	List<BizReceiptItemImgVo>  getBizReceiptItemImgList(Integer receiptType,String receiptCode,String receipt_rid);

	/**
	 * （批量）查询图片
	 * @param imgList
	 * @return
	 */
	List<BizReceiptItemImgVo>  getBizReceiptItemImgList(List<BizReceiptItemImg> imgList);

	/**
	 * 批量保存行项目对应的图片信息
	 * @param list
	 * @author cdq
	 */
	//void  batchSaveBizReceiptItemImg(List<BizReceiptItemImgVo> list,Integer receiptType, String receiptCode, String receiptRid,Integer userid);

	/**
	 * 批量保存行项目对应的图片信息
	 * @param list
	 * @author cdq
	 */
	void  insertBizReceiptItemImgList(List<BizReceiptItemImgVo> insertList);

	/**
	 * 批量删除行项目对应的图片信息
	 * @param list
	 * @author cdq
	 */
	void  deleteBizReceiptItemImgList(List<BizReceiptItemImgVo> deleteList);

	/**
	 * 填充行项目图片信息
	 *
	 * @param itemList 行项目列表
	 * @param receiptType
	 * @param receiptCode
	 * @return
	 * @author 李斌
	 */
	List<? extends IBizReceiptItem> fillBizReceiptItemImg(List<? extends IBizReceiptItem> itemList, Integer receiptType, String receiptCode);

	/**
	 * 保存行项目图片信息
	 *
	 * @param itemList 行项目列表
	 * @param receiptType
	 * @param receiptCode
	 * @param ridList 行项目号集合
	 * @param createUserId 创建人id
	 * @return
	 * @author lys
	 */
	List<? extends IBizReceiptItem> saveBizReceiptItemImg(List<? extends IBizReceiptItem> itemList, Integer receiptType, String receiptCode,List<String> ridList,Integer createUserId);
}
