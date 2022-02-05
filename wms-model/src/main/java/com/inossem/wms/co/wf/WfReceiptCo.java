package com.inossem.wms.co.wf;

import java.io.Serializable;
import java.util.List;

import com.inossem.wms.model.wf.WfReceipt;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.co.wf.WfReceiptCo",description = "审批单据传入参数")
public class WfReceiptCo extends WfReceipt  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(name="status",value = "审批状态")
	private Integer status;
	@ApiModelProperty(name="statusList",value = "审批状态列表")
	private List<Integer> statusList;

	@ApiModelProperty(name="currentUserId",value = "当前审批人")
	private Integer currentUserId;
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<Integer> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<Integer> statusList) {
		this.statusList = statusList;
	}

	public Integer getCurrentUserId() {
		return currentUserId;
	}

	public void setCurrentUserId(Integer currentUserId) {
		this.currentUserId = currentUserId;
	}
	
}
