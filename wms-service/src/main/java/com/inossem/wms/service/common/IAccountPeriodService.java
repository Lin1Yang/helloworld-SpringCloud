package com.inossem.wms.service.common;


import com.inossem.wms.common.exception.WMSException;

import java.util.Date;

/**
 * @Description 
 * @ClassName：IAccountPeriod :
 * @Package com.inossem.wms.service.common
 * @anthor：wyang
 * @date：2019/7/11
 * @版本：V1.0
 */
public interface IAccountPeriodService {

    /**
     * 判断过账日期是否在帐期内
     *
     * @param postingDate
     * @return
     * @throws WMSException
     */
    Date checkAndUpdateInPostDate(Date postingDate, Integer userId);

}
