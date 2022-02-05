package com.inossem.wms.service.job;


import com.inossem.wms.common.exception.WMSException;


/**
 * @Description 
 * @ClassName：IStockDiffService :
 * @Package com.inossem.wms.service.query
 * @anthor：wyang
 * @date：2019/2/27
 * @版本：V1.0
 */
public interface IErpStockJobService {

    /**
     * 缓存所有库存地点下物料库存
     * @param stockDifferenceCo
     * @param user
     * @throws WMSException
     */
    void bufAllMatQty() throws WMSException;
    
}

