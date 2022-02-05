package com.inossem.wms.service.sinobec.gp;

import java.util.List;

import com.inossem.wms.co.dic.DicMaterialInfoCo;

public interface ISinobecGPService {

	/**
	 * 重新获取token
	 */
	String resetToken();
	
	/**
	 * 获取token  当token为空时 重新获取
	 * @return
	 */
	String getAndSetTokenifEmpty();


	Integer changeCorp();

	/**
	 * 同步采购
	 */
	Integer synPoreceive(String ShippingRef);
	
	/**
	 * 同步销售出
	 * 
	 */
	Integer synSodelivery(String SOPNumber);
	
	/**
	 * 同步转入
	 */
	Integer synTransferin(String DocumentCode);
	
	/**
	 * 同步转出
	 */
	Integer synTransferout(String DocumentCode);

	/**
	 * 同步分包入
	 */
	Integer synAdjustmentin(String DocumentCode);
	
	/**
	 * 同步分包出
	 */
	Integer synAdjustmentout(String DocumentCode);
	
	/**
	 * 同步库存
	 */
	Integer synGpinventory(String lotNumb);
	
	
	/**
	 * 同步物料
	 */
	Integer synMaterial (String Date,List<String> matCodeList);

	/**
	 * 测试用方法
	 * @throws Exception
	 */
	void synAll();
	
}
