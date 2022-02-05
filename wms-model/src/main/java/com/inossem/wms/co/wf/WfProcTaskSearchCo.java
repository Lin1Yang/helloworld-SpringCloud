package com.inossem.wms.co.wf;

import java.util.List;

import com.inossem.wms.page.PageCommon;

import io.swagger.annotations.ApiModelProperty;

public class WfProcTaskSearchCo extends PageCommon {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "审批任务id")
	private String taskId;
	@ApiModelProperty(value = "审批任务名称")
    private String taskName;
    @ApiModelProperty(value = "审批用户id")
    private String userId;
    @ApiModelProperty(value = "创建时间")
    private String createTime;
    @ApiModelProperty(value = "修改时间")
    private String updateTime;
    @ApiModelProperty(value = "审批状态")
    private String taskStatus;
    @ApiModelProperty(value = "审批实例id")
    private String procinsId;
    @ApiModelProperty(value = "审批模版id")
    private String procdefId;
    @ApiModelProperty(value = "审批节点id")
    private String nodedefId;
    @ApiModelProperty(value = "开始时间")
    private String startUpTime;
    @ApiModelProperty(value = "结束时间")
    private String endUpTime;
    @ApiModelProperty(value = "单据类型")
    private Integer receiptType;
    @ApiModelProperty(value = "审批列表")
	private List<Integer> receiptTypeList;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getProcinsId() {
        return procinsId;
    }

    public void setProcinsId(String procinsId) {
        this.procinsId = procinsId;
    }

    public String getProcdefId() {
        return procdefId;
    }

    public void setProcdefId(String procdefId) {
        this.procdefId = procdefId;
    }

    public String getNodedefId() {
        return nodedefId;
    }

    public void setNodedefId(String nodedefId) {
        this.nodedefId = nodedefId;
    }

    public String getStartUpTime() {
        return startUpTime;
    }

    public void setStartUpTime(String startUpTime) {
        this.startUpTime = startUpTime;
    }

    public String getEndUpTime() {
        return endUpTime;
    }

    public void setEndUpTime(String endUpTime) {
        this.endUpTime = endUpTime;
    }

	public Integer getReceiptType() {
		return receiptType;
	}

	public void setReceiptType(Integer receiptType) {
		this.receiptType = receiptType;
	}

	public List<Integer> getReceiptTypeList() {
		return receiptTypeList;
	}

	public void setReceiptTypeList(List<Integer> receiptTypeList) {
		this.receiptTypeList = receiptTypeList;
	}
}
