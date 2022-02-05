package com.inossem.wms.co.conf;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Description 
 * @ClassName：DeleteConfReceiptTypeCo :
 * @Package com.inossem.wms.co.conf
 * @anthor：wyang
 * @date：2019/7/19
 * @版本：V1.0
 */
@ApiModel(value="",description = "删除时使用的入参")
public class DeleteConfReceiptTypeCo {
    @ApiModelProperty(value = "coList",name = "删除的对象集合",required = true)
    private List<ConfReceiptTypeCo> coList;

    public List<ConfReceiptTypeCo> getCoList() {
        return coList;
    }

    public DeleteConfReceiptTypeCo setCoList(List<ConfReceiptTypeCo> coList) {
        this.coList = coList;
        return this;
    }
}
