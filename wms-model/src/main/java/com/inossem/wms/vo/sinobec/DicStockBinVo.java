package com.inossem.wms.vo.sinobec;

import com.inossem.wms.model.dic.DicWhStorageBin;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

public class DicStockBinVo {

    @ApiModelProperty(value="仓位集合")
    List<DicWhStorageBin> binList = new ArrayList<DicWhStorageBin>();


    public List<DicWhStorageBin> getBinList() {
        return binList;
    }

    public void setBinList(List<DicWhStorageBin> binList) {
        this.binList = binList;
    }
}
