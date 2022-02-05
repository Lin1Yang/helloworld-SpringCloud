/** 
 * 文件名: IBizReceiptItem.java 
 * 
 * Copyright (c) 2019 Inossem All rights reserved. 
 */ 
package com.inossem.wms.model.biz;

import java.util.List;

/**
 * 说明: 业务单据行项目的接口，用于处理所有业务单据行项目的公共行为
 * 
 * @author 李斌
 * 创建时间: 2019年12月12日
 */
public interface IBizReceiptItem {
	
	/**
	 * 获取单据号
	 * 
	 * @return
	 * @author 李斌
	 */
	String getReceiptCode();
	
	/**
	 * 返回行项目rid
	 * 
	 * @return
	 * @author 李斌
	 */
	String getReceiptItemRid();
	
	/**
	 * 获取单据类型
	 * 
	 * @return
	 * @author 李斌
	 */
	Integer getReceiptType();
	
	/**
	 * 设置行项目图片列表
	 * 
	 * @param imgList
	 * @author 李斌
	 */
	void setImgList(List<BizReceiptItemImgVo> imgList);

	/**
	 * 获取行项目图片列表
	 * 
	 * @author lys
	 */
	List<BizReceiptItemImgVo> getImgList();

}
