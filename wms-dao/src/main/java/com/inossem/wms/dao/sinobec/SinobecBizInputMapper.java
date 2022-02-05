package com.inossem.wms.dao.sinobec;

import com.inossem.wms.co.sinobec.SinobecBizInputCo;
import com.inossem.wms.model.sinobec.input.SinobecBizInput;
import com.inossem.wms.vo.sinobec.SinobecBizInputVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SinobecBizInputMapper {
    int deleteByPrimaryKey(Integer inputId);

    int insert(SinobecBizInput record);

    int insertSelective(SinobecBizInput record);

    SinobecBizInput selectByPrimaryKey(Integer inputId);

    int updateByPrimaryKeySelective(SinobecBizInput record);

    int updateByPrimaryKey(SinobecBizInput record);

    List<SinobecBizInputVo> selectInputList(@Param("receiptCode")String receiptCode,@Param("receiptType") Integer receiptType,@Param("shippingRef") String shippingRef);

    List<SinobecBizInputVo> selectInputListByShipping(@Param("receiptType") Integer receiptType,@Param("shippingRef") String shippingRef);

    int insertInputList(List<SinobecBizInputVo> list);

    int updateActualWeightQty(List<SinobecBizInputVo> list);

    int updateActualWeightQtyAndStatus(List<SinobecBizInputVo> list);

    List<SinobecBizInputVo> selectInputListOnPaging(SinobecBizInputCo co);
    List<SinobecBizInputVo> selectInputListWithStockOnPaging(SinobecBizInputCo co);

    int deleteSavedOrderList(List<SinobecBizInputCo> list);
}
