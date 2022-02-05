package com.inossem.wms.common.exception.sinobec;

import com.inossem.wms.common.exception.WMSException;
import com.inossem.wms.enums.EnumReturnCode;
import com.inossem.wms.model.sinobec.SinobecStock;

/**
 * 库存不足异常
 * @author 86158
 *
 */
public class SinobecStockQtyNotEnoughException extends WMSException {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1954424981140796580L;

	public SinobecStockQtyNotEnoughException(SinobecStock key) {
		args = new String[5];
		args[0] = key.getBundleCode();
		args[1] = key.getShippingRef();
		args[2] = key.getWhCode();
		args[3] = key.getTypeCode();
		args[4] = key.getBinCode();

		errorCode = EnumReturnCode.RETURN_CODE_SINOBEC_STOCK_NOT_ENOUGH;

	}
}
