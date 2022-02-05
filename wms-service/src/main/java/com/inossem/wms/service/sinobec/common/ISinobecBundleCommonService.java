package com.inossem.wms.service.sinobec.common;

import java.util.List;

import com.inossem.wms.common.exception.WMSException;
import com.inossem.wms.model.sinobec.dic.SinobecDicBundleInfo;

public interface ISinobecBundleCommonService {

	/**
	 * 批量插入bundle信息 如果已经存在 则根据主键更新
	 * @param bundleList
	 * @return
	 */
	int insertOrUpdateList(List<SinobecDicBundleInfo> bundleList) throws WMSException;
	
}
