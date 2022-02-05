package com.inossem.wms.dao.sinobec;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.inossem.wms.co.sinobec.SinobecBizOutputListCo;
import com.inossem.wms.model.sinobec.SinobecBizOutput;
import com.inossem.wms.model.sinobec.SinobecInsDocBin;
import com.inossem.wms.model.sinobec.SinobecStock;
import com.inossem.wms.model.sinobec.out.OutputDaoVo;
import com.inossem.wms.model.sinobec.unload.UnLoadShelfQueryCo;

public interface SinobecBizOutputMapper {
    int deleteByPrimaryKey(Integer outputId);

    int insert(SinobecBizOutput record);

    int insertSelective(SinobecBizOutput record);

    SinobecBizOutput selectByPrimaryKey(Integer outputId);

    int updateByPrimaryKeySelective(SinobecBizOutput record);

    int updateByReceiptCode(OutputDaoVo vo);


    int updateByInsDoc(List<SinobecInsDocBin> sinobecInsDocBins);

    int updateByPrimaryKey(SinobecBizOutput record);

    /**
     * 根据单号，状态查询
     * @param receiptStatus
     * @return
     */
    List<OutputDaoVo> queryInfoByInfoAndStatus(@Param(value = "receiptCode") String receiptCode, @Param(value = "receiptStatus") byte receiptStatus);

    List<OutputDaoVo> queryInfoByReceiptCode(@Param(value = "receiptCode") String receiptCode);

    /**
     * 根据单号，状态查询
     * @param receiptStatus
     * @return
     */
    List<OutputDaoVo> queryInfoByCoAndStatus(@Param(value = "co") UnLoadShelfQueryCo co, @Param(value = "receiptStatus") byte receiptStatus);

    int insertList(List<OutputDaoVo> list);

    int outputDelete(List<SinobecStock> sinobecStocks);

    /**
     *
     * @param receiptStatus
     * @return
     */
    List<OutputDaoVo> queryListOnPaging(SinobecBizOutputListCo co);

    int deleteByReceiptCode(@Param("receiptCode") String receiptCode);

}
