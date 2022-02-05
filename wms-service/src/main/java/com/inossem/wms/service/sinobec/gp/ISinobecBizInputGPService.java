package com.inossem.wms.service.sinobec.gp;

import com.inossem.wms.model.sinobec.gp.ResponseInfo;
import com.inossem.wms.model.sinobec.gp.SinobecBizInputGP;

import java.util.List;

public interface ISinobecBizInputGPService {

    List<SinobecBizInputGP> getSinobecBizInputGP(SinobecBizInputGP gp);
    
    ResponseInfo synPoReceiverPartially(List<SinobecBizInputGP> inputList, int chunkSize, boolean needUpdateRid);
    
    ResponseInfo deleteInputDocuments(List<String> poCodes);

}
