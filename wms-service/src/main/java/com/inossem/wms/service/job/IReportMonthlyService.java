package com.inossem.wms.service.job;

import java.text.ParseException;

public interface IReportMonthlyService {

	
	
	/**
	 * 执行月期初数量
	 * @param SearchListCo 查询条件
	 * @return InsDocBinVo 仓位库存清单
	 * @author ylyun
	 * 
	 */
	void getMonthlyQtyAndMoney() throws ParseException;

}
