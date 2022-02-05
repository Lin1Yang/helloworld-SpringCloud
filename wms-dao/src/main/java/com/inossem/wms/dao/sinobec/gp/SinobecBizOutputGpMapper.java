package com.inossem.wms.dao.sinobec.gp;

import com.inossem.wms.model.sinobec.gp.SinobecBizOutputGp;
import com.inossem.wms.model.sinobec.task.BundleQueryCo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SinobecBizOutputGpMapper {

    int deleteByPrimaryKey(@Param("soCode") String soCode, @Param("soRid") String soRid);

    SinobecBizOutputGp selectByPrimaryKey(@Param("soCode") String soCode, @Param("soRid") String soRid);

    List<SinobecBizOutputGp> selectBySoCode(@Param("receiptCode") String soCode);

   /* int updateByPrimaryKeySelective(SinobecBizOutputGp record);


    int updateByPrimaryKey(SinobecBizOutputGp record);*/

    List<SinobecBizOutputGp> selectList(SinobecBizOutputGp gp);

    List<String> selectRejectableBySoCodeAndStatus(List<String> soCodes);

    int insertList(List<SinobecBizOutputGp> list);

    int deleteBySo(List<SinobecBizOutputGp> list);
    int deleteOutputDocuments(List<String> soCodes);
    int deleteBySoCode(@Param("receiptCode")String receiptCode);

    int updateSoRidByBundleCode(@Param("receiptCode")String receiptCode);
    int updateReceiptStatusByKey(SinobecBizOutputGp record);
    int updateBundleCodebyRid(String bundleCode, String soRid);
    int updateTempCountByRid(Integer tempCount , String soRid);
    int updateRId();
    int updateBundleCodeBySoCodeAndMatCode(String bundleCode, String soCode,String matCode);
    int updateReceiptStatusBySoCode(@Param("receiptCode")String receiptCode);
    int updateLotNumByExt13(@Param("receiptCode")String receiptCode);

    List<SinobecBizOutputGp> selectInvoicedListOnPaging (BundleQueryCo gp);
    List<SinobecBizOutputGp> selectUncompletedInvoicedListOnPaging (BundleQueryCo gp);
    List<SinobecBizOutputGp> selectUncompletedDeliverListOnPaging (BundleQueryCo gp);

    List<String> selectAllMfgid();


}
