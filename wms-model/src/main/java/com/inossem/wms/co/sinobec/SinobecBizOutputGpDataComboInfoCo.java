package com.inossem.wms.co.sinobec;
import java.util.List;

import com.inossem.wms.model.sinobec.gp.SinobecBizOutputGp;
import com.inossem.wms.model.sinobec.unload.UnLoadShelfDaoVo;

import io.swagger.annotations.ApiModelProperty;

public class SinobecBizOutputGpDataComboInfoCo {
    private List<SinobecBizOutputGp> outputGPList;

    public List<SinobecBizOutputGp> getOutputGPList() {
        return outputGPList;
    }

    public void setOutputGPList(List<SinobecBizOutputGp> outputGPList) {
        this.outputGPList = outputGPList;
    }

    @ApiModelProperty(value = "创建单据返回集合", name = "shelfLoadDaoVos", required = true)
    private List<UnLoadShelfDaoVo> creteShelfLoadDaoVos;

    public List<UnLoadShelfDaoVo> getCreteShelfLoadDaoVos() {
        return creteShelfLoadDaoVos;
    }

    public void setCreteShelfLoadDaoVos(List<UnLoadShelfDaoVo> creteShelfLoadDaoVos) {
        this.creteShelfLoadDaoVos = creteShelfLoadDaoVos;
    }
}
