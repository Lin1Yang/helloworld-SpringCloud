package com.inossem.wms.vo.sinobec;

import com.inossem.wms.model.sinobec.gp.SinobecBizInputGP;

import java.util.ArrayList;
import java.util.List;

public class SinobecBizInputGpVo {

    private List<SinobecBizInputGP> list = new ArrayList<SinobecBizInputGP>();

    private Integer totalCount;

    public List<SinobecBizInputGP> getList() {
        return list;
    }

    public void setList(List<SinobecBizInputGP> list) {
        this.list = list;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
