package com.inossem.wms.vo.conf;


import com.inossem.wms.model.conf.ConfReceiptType;
import com.inossem.wms.model.wf.WfProcDef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Description 
 * @ClassName：ConfReceiptTypeVo :
 * @Package com.inossem.wms.vo.conf
 * @anthor：wyang
 * @date：2019/7/18
 * @版本：V1.0
 */
@ApiModel(value = "com.inossem.wms.vo.conf.ConfReceiptTypeVo",description = "配置出参")
public class ConfReceiptTypeVo {
    @ApiModelProperty(value = "总页数")
    private Integer totalCount = 0;

    @ApiModelProperty(value = "配置列表集合")
    private List<ConfReceiptType> headlist;

    @ApiModelProperty(value = "模板集合")
    private List<WfProcDef> procDefList;
    @ApiModelProperty(value = "配置类型")
    private String ReceiptTypeCode;
    @ApiModelProperty(value = "业务类型")
    private Integer receiptType;

    public List<ConfReceiptType> getHeadlist() {
        return headlist;
    }

    public ConfReceiptTypeVo setHeadlist(List<ConfReceiptType> headlist) {
        this.headlist = headlist;
        return this;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public ConfReceiptTypeVo setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    public List<WfProcDef> getProcDefList() {
        return procDefList;
    }

    public ConfReceiptTypeVo setProcDefList(List<WfProcDef> procDefList) {
        this.procDefList = procDefList;
        return this;
    }

    public String getReceiptTypeCode() {
        return ReceiptTypeCode;
    }

    public ConfReceiptTypeVo setReceiptTypeCode(String receiptTypeCode) {
        ReceiptTypeCode = receiptTypeCode;
        return this;
    }

    public Integer getReceiptType() {
        return receiptType;
    }

    public ConfReceiptTypeVo setReceiptType(Integer receiptType) {
        this.receiptType = receiptType;
        return this;
    }
}
