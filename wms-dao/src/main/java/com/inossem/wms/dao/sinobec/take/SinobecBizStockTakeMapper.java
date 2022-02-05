package com.inossem.wms.dao.sinobec.take;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inossem.wms.co.biz.BizStockTakeCo;
import com.inossem.wms.model.sinobec.take.SinobecBizStockTake;
import com.inossem.wms.vo.take.BizStockTakeHeadVo;
import com.inossem.wms.vo.take.BizStockTakeItemVo;

public interface SinobecBizStockTakeMapper {

    List <BizStockTakeHeadVo> getStockTakeListOnPaging(BizStockTakeCo co);

    List<BizStockTakeItemVo> getStockTakeInfo(BizStockTakeCo co);
    List<BizStockTakeItemVo> getStockTakeInfoForReport(BizStockTakeCo co);

    void delete(String stockTakeCode);

    void insertBizStockTake(@Param("list")List<SinobecBizStockTake> itemVoList);

    void updateAllStatusByStockTakeCode(BizStockTakeCo co);

    List<BizStockTakeItemVo> getStockTakeRid(BizStockTakeCo co);

    void updateStatusByStockTakeCode(BizStockTakeCo co);

    void updateOrderStatusByStockTakeCode(BizStockTakeCo co);

}