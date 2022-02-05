package com.inossem.wms.service.sinobec.gp;

import com.inossem.wms.model.sinobec.gp.ResponseInfo;
import com.inossem.wms.model.sinobec.gp.SinobecBizOutputGp;

import java.util.List;

public interface ISinobecBizOutputGPService {

    List<SinobecBizOutputGp> getSinobecBizOutputGP(SinobecBizOutputGp gp);

    ResponseInfo synSoDeliveryPartially(List<SinobecBizOutputGp> outputList, int chunkSize, boolean needUpdateRid);

    ResponseInfo deleteOutputDocuments(List<String> soCodes);


}
