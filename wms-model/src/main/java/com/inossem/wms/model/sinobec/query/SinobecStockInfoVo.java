package com.inossem.wms.model.sinobec.query;

import com.inossem.wms.model.sinobec.stock.SinobecStockVo;

import java.util.List;

/**
 * FileName: InsDocInfoVo
 * Date:     2020/3/31 0031 10:26
 * Description: Ins凭证查询VO
 *
 * @author cxq
 */
public class SinobecStockInfoVo {

    private List<SinobecStockVo> sinobecStockVos;

    private Integer totalCount;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<SinobecStockVo> getSinobecStockVos() {
        return sinobecStockVos;
    }

    public void setSinobecStockVos(List<SinobecStockVo> sinobecStockVos) {
        this.sinobecStockVos = sinobecStockVos;
    }
}
