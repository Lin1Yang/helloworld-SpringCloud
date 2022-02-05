package com.inossem.wms.vo.wf;

import java.util.List;

import com.inossem.wms.model.dic.DicReceiptType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "com.inossem.wms.vo.wf.WfModular",description = "工作流审批节点信息")
public class WfModularVo {
    @ApiModelProperty(name = "receiptTypeList",value = "单据类型列表",required = true)
    private List<DicReceiptType> receiptTypeList;

	public List<DicReceiptType> getReceiptTypeList() {
		return receiptTypeList;
	}

	public void setReceiptTypeList(List<DicReceiptType> receiptTypeList) {
		this.receiptTypeList = receiptTypeList;
	}
}
