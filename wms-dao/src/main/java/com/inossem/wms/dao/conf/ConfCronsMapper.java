package com.inossem.wms.dao.conf;

import java.util.List;

import com.inossem.wms.co.conf.ConfCronsCo;
import com.inossem.wms.vo.conf.ConfCronsVo;

public interface ConfCronsMapper {


	/**
	 * 查询频率
	 * @author yly
	 * 
	 * @param 
	 */
	List<ConfCronsVo> selectCronInfo(ConfCronsCo cronCo);
	
	
	void updateCron(ConfCronsCo cronCo);
}