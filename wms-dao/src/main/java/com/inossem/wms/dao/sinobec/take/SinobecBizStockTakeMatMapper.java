package com.inossem.wms.dao.sinobec.take;

import com.inossem.wms.co.biz.BizStockTakeCo;
import com.inossem.wms.model.sinobec.take.SinobecBizStockTakeMat;
import com.inossem.wms.vo.take.BizStockTakeMatItemVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SinobecBizStockTakeMatMapper {

    void delete(BizStockTakeCo vo);

    void insertBizStockTakeMat(@Param("list") List<SinobecBizStockTakeMat> list);

    List<BizStockTakeMatItemVo> getStockTakeMatInfo(BizStockTakeCo co);
    List<BizStockTakeMatItemVo> getStockTakeMatInfoForReport(BizStockTakeCo co);
    List<BizStockTakeMatItemVo> getStockTakeMatInfoFromWMSCountForReport(BizStockTakeCo co);

    List<BizStockTakeMatItemVo> selectMaxBid(BizStockTakeCo co);

    BizStockTakeMatItemVo getStockTakeMatCountStatus(String stockTakeCode);

    void updateBizStockTakeMat(@Param("list")List<SinobecBizStockTakeMat> list);

    void updateSubmitStatus(BizStockTakeCo co);

    BizStockTakeMatItemVo getStockTakeMatForDraftStatus(String stockTakeCode);

    void updateStatusByStockTakeCode(BizStockTakeCo co);

    void updateCountStatus(BizStockTakeCo co);

    List<BizStockTakeMatItemVo> checkAllDataStatus(BizStockTakeCo co);

    List<BizStockTakeMatItemVo> getDifferenceList(BizStockTakeCo co);


}