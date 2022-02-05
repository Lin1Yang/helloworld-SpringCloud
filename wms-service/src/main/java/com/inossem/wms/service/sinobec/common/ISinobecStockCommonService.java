package com.inossem.wms.service.sinobec.common;

import com.inossem.wms.common.exception.WMSException;
import com.inossem.wms.vo.sinobec.SinobecInsMoveTypeVo;

public interface ISinobecStockCommonService {

	/**
	 * 
	 * @param insMoveTypePostTask
	 * @throws WMSException
	 */
	abstract void modifyStock(SinobecInsMoveTypeVo insMoveType) throws WMSException;
	
	
	/**
	 * 
	 * @param insMoveTypePostTask
	 * @throws WMSException
	 */
	abstract void modifyStockByStockTake(SinobecInsMoveTypeVo insMoveType) throws WMSException;
	
	
	
}
