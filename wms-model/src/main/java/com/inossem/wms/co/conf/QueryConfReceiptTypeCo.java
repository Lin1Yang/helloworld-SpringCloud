package com.inossem.wms.co.conf;


import com.inossem.wms.page.PageCommon;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description 
 * @ClassName：ConfReceiptType :
 * @Package com.inossem.wms.co.conf
 * @anthor：wyang
 * @date：2019/7/18
 * @版本：V1.0
 */
@ApiModel(value="com.inossem.wms.co.conf.ConfReceiptType",description = "查询入参")
public class QueryConfReceiptTypeCo extends PageCommon {

    private static final long serialVersionUID = -7016975831049575172L;

    @ApiModelProperty(value = "条件", name = "condition", example = "actor", required = true)
    private String condition;

    @ApiModelProperty(value = "业务类型", name = "receiptType", example = "414",required = false)
    private Integer receiptType;

    public Integer getReceiptType() {
        return receiptType;
    }

    public QueryConfReceiptTypeCo setReceiptType(Integer receiptType) {
        this.receiptType = receiptType;
        return this;
    }

    public String getCondition() {
        return condition;
    }

    public QueryConfReceiptTypeCo setCondition(String condition) {
        this.condition = condition;
        return this;
    }
}
