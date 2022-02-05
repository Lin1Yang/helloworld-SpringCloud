package com.inossem.wms.vo.wf;

import com.inossem.wms.page.IPageResultCommon;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
public class WfProcTaskSearchVo  implements IPageResultCommon, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "总记录数", example = "0")
	private int totalCount;
	@ApiModelProperty(value = "审批任务id")
    private String taskId;
	@ApiModelProperty(value = "审批任务名称")
    private String  taskName;
	@ApiModelProperty(value = "审批用户id")
    private Long userId;
	@ApiModelProperty(value = "开始时间")
    private Date startTime;
	@ApiModelProperty(value = "创建时间")
    private Date createTime;
	@ApiModelProperty(value = "修改时间")
    private Date updateTime;
	@ApiModelProperty(value = "任务状态(0待审批2审批通过4审批驳回)")
    private String taskStatus;
	@ApiModelProperty(value = "流程实例id")
    private String procInsId;
    @ApiModelProperty(value = "流程模板id")
    private String procdefId;
    @ApiModelProperty(value = "流程节点id")
    private String nodedefId;
    @ApiModelProperty(value = "任务发起路径id")
    private String fromRouteId;
    @ApiModelProperty(value = "单据code")
    private String receiptCode;
    @ApiModelProperty(value = "审批用户名称")
    private String userName;
    @ApiModelProperty(value = "部门名称")
    private String deptName;
    @ApiModelProperty(value = "单据类型")
    private Integer receiptType;
    @ApiModelProperty(value = "单据类型名称")
    private String receiptTypeName;
    @ApiModelProperty(value = "单据数量")
    private Integer num;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getProcInsId() {
        return procInsId;
    }

    public void setProcInsId(String procInsId) {
        this.procInsId = procInsId;
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

    public String getFromRouteId() {
        return fromRouteId;
    }

    public void setFromRouteId(String fromRouteId) {
        this.fromRouteId = fromRouteId;
    }

    public String getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(String receiptCode) {
        this.receiptCode = receiptCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

	public Integer getReceiptType() {
		return receiptType;
	}

	public void setReceiptType(Integer receiptType) {
		this.receiptType = receiptType;
	}

	public String getReceiptTypeName() {
		return receiptTypeName;
	}

	public void setReceiptTypeName(String receiptTypeName) {
		this.receiptTypeName = receiptTypeName;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
}
