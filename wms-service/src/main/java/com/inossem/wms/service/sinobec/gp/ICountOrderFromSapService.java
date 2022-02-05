package com.inossem.wms.service.sinobec.gp;

import com.inossem.wms.model.sinobec.gp.CountOrderFromSap;
import com.inossem.wms.model.sinobec.gp.ResponseInfo;

import java.util.List;

public interface ICountOrderFromSapService {

    List<CountOrderFromSap> getCountOrder(CountOrderFromSap countOrderFromSap);
    
    ResponseInfo startCountOrders(List<CountOrderFromSap> inputList, int chunkSize);
    
    ResponseInfo deleteCountOrders(List<String> countOrders);

}
