package com.inossem.wms.vo.wf;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "com.inossem.wms.vo.wf.WfNodeVo",description = "工作流审批节点信息")
public class WfNodeVo {
    @ApiModelProperty(name = "nodeId",value = "节点ID",required = true)
    private String nodeId;
    @ApiModelProperty(name = "nodeName",value = "节点名称",required = true)
    private String nodeName;
    @ApiModelProperty(name = "nodeOrder",value = "节点顺序",required = true)
    private Integer nodeOrder;
    @ApiModelProperty(name = "userId",value = "审批人员ID",required = true)
    private String userId;
    @ApiModelProperty(name = "userName",value = "审批人员名称",required = true)
    private String userName;
    @ApiModelProperty(name = "updateTime",value = "更新时间",required = true)
    private String updateTime;
    @ApiModelProperty(name = "taskStatus",value = "任务状态",required = true)
    private String taskStatus;
    @ApiModelProperty(name = "procinsId",value = "审批流实例ID",required = true)
    private String procinsId;
    @ApiModelProperty(name = "approveOpinion",value = "审批意见",required = false)
    private String approveOpinion;
    @ApiModelProperty(name = "deptName",value = "部门名称",required = false)
    private String deptName;
    @ApiModelProperty(name = "comment",value = "审批意见",required = false)
    private String comment;

    public WfNodeVo() {
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeId() {
        return this.nodeId;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeName() {
        return this.nodeName;
    }

    public Integer getNodeOrder() {
		return nodeOrder;
	}

	public void setNodeOrder(Integer nodeOrder) {
		this.nodeOrder = nodeOrder;
	}

	public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskStatus() {
        return this.taskStatus;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setProcinsId(String procinsId) {
        this.procinsId = procinsId;
    }

    public String getProcinsId() {
        return this.procinsId;
    }

	public String getApproveOpinion() {
		return approveOpinion;
	}

	public void setApproveOpinion(String approveOpinion) {
		this.approveOpinion = approveOpinion;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
