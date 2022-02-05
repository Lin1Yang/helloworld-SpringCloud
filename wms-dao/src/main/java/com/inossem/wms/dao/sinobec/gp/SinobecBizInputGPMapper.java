package com.inossem.wms.dao.sinobec.gp;

import com.inossem.wms.model.sinobec.gp.SinobecBizInputGP;
import com.inossem.wms.model.sinobec.task.BundleQueryCo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SinobecBizInputGPMapper {
    int deleteByPrimaryKey(@Param("poCode") String poCode, @Param("shippingRef") String shippingRef, @Param("poRid") String poRid);
    int deleteByRid(@Param("poRid") String poRid);

    int insert(SinobecBizInputGP record);

    int insertSelective(SinobecBizInputGP record);

    SinobecBizInputGP selectByPrimaryKey(@Param("poCode") String poCode, @Param("shippingRef") String shippingRef, @Param("poRid") String poRid);

    int updateByPrimaryKeySelective(SinobecBizInputGP record);

    int updateByPrimaryKey(SinobecBizInputGP record);

    List<SinobecBizInputGP> selectList(SinobecBizInputGP cp);

    int insertList(List<SinobecBizInputGP> GP);

    /**
     * 删除GP
     * @param list
     * @return
     */
    int deleteByPoAndShipping(List<SinobecBizInputGP> list);

    List<String> selectRejectableByPoCodeAndStatus(List<String> poCodes);

    int deleteInputDocuments(List<String> poCodes);

    List<SinobecBizInputGP> selectIncomingListOnPaging(BundleQueryCo record);

    int updateReceiptStatusByKey(SinobecBizInputGP record);
    int updateReceiptStatusAndRidByKey(SinobecBizInputGP record);
    int updateRId();

}
