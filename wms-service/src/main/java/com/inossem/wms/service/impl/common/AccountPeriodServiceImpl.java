package com.inossem.wms.service.impl.common;


import com.inossem.wms.common.util.UtilDate;
import com.inossem.wms.dao.dic.DicAccountPeriodMapper;
import com.inossem.wms.enums.EnumEnable;
import com.inossem.wms.model.dic.DicAccountPeriod;
import com.inossem.wms.service.common.IAccountPeriodService;
import com.inossem.wms.vo.auth.UserAccountPeriod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Description 
 * @ClassName：AccountPeriodServiceImpl :
 * @Package com.inossem.wms.service.impl.common
 * @anthor：wyang
 * @date：2019/7/11
 * @版本：V1.0
 */
@Component
public class AccountPeriodServiceImpl implements IAccountPeriodService {
    private static final Logger logger = LoggerFactory.getLogger(AccountPeriodServiceImpl.class);

    @Resource
    private DicAccountPeriodMapper accountPeriodDao;

    @Transactional
    @Override
    public Date checkAndUpdateInPostDate(Date postingDate, Integer userId) {
        postingDate = postingDate == null ? new Date() : postingDate;
        UserAccountPeriod accountPeriod = accountPeriodDao.selectByUserId(userId);
        if (accountPeriod == null) {
            logger.debug("过账日期返回当前时间{}", postingDate);
            return postingDate;
        }
        accountPeriod.setAccountPeriodList(accountPeriodDao.selectByCo(accountPeriod.getBoardCode(), accountPeriod.getCorpCode()));

        long docDate = Long.parseLong(UtilDate.getStringDateForDate(postingDate).trim().replaceAll("-", "").substring(0, 8));
        if (accountPeriod.getEnabled() == EnumEnable.ENABLE.getValue()) {
           /* if(accountPeriod.getEditable()==EnumEnable.ENABLE.getValue()){
                return postingDate;
            }*/
            List<DicAccountPeriod> accountPeriodList = accountPeriod.getAccountPeriodList();
            if (accountPeriodList.size() == 0) {
                logger.debug("过账日期返回当前时间{}", postingDate);
                return postingDate;
            }

            for (DicAccountPeriod accoutPeriod : accountPeriodList) {
                long beginDate = Long.parseLong(UtilDate.getStringDateForDate(accoutPeriod.getAccountBeginDate()).trim().replaceAll("-", "").substring(0, 8));
                long endDate = Long.parseLong(UtilDate.getStringDateForDate(accoutPeriod.getAccountEndDate()).trim().replaceAll("-", "").substring(0, 8));
                if (docDate <= endDate && docDate >= beginDate) return accoutPeriod.getAccountFactDate();
            }
        }

        return postingDate;
    }
}
