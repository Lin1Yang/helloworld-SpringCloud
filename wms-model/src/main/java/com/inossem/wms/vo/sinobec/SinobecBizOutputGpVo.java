package com.inossem.wms.vo.sinobec;

import com.inossem.wms.model.sinobec.gp.SinobecBizOutputGp;

import java.util.ArrayList;
import java.util.List;

public class SinobecBizOutputGpVo {

    List<SinobecBizOutputGp> list = new ArrayList<SinobecBizOutputGp>();

    private Integer totalCount;

    public List<SinobecBizOutputGp> getList() {
        return list;
    }

    public void setList(List<SinobecBizOutputGp> list) {
        this.list = list;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
