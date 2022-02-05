package com.inossem.wms.vo.wf;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class WfProcTaskListVo{
	@ApiModelProperty(value = "记录数")
	private Integer totalCount;
	@ApiModelProperty(value="审批列表集合对象", name="", example="", required=true)
	private List<WfProcTaskSearchVo>itemList;
	@ApiModelProperty(value="审批列表集合对象", name="", example="", required=true)
	private List<WfNodeVo> wfList;
	
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public List<WfProcTaskSearchVo> getItemList() {
		return itemList;
	}
	public void setItemList(List<WfProcTaskSearchVo> itemList) {
		this.itemList = itemList;
	}
	public List<WfNodeVo> getWfList() {
		return wfList;
	}
	public void setWfList(List<WfNodeVo> wfList) {
		this.wfList = wfList;
	}
}
