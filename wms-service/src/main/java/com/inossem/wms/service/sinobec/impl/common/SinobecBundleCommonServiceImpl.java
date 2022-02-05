package com.inossem.wms.service.sinobec.impl.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.inossem.wms.common.exception.ParameterErrorException;
import com.inossem.wms.common.exception.WMSException;
import com.inossem.wms.dao.sinobec.dic.SinobecDicBundleInfoMapper;
import com.inossem.wms.model.sinobec.dic.SinobecDicBundleInfo;
import com.inossem.wms.service.sinobec.common.ISinobecBundleCommonService;

@Service
public class SinobecBundleCommonServiceImpl implements ISinobecBundleCommonService {

	@Autowired
	private SinobecDicBundleInfoMapper bundleDao;

	@Override
	public int insertOrUpdateList(List<SinobecDicBundleInfo> bundleList) throws WMSException {

		if (CollectionUtils.isEmpty(bundleList)) {
			throw new ParameterErrorException();
		}
		return bundleDao.insertOrUpdateList(bundleList);
	}

}
