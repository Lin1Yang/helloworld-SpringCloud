package com.inossem.wms.co.wf;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author admin
 */
public class WfApproveCo  implements Serializable  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "单据类型")
	private String receiptType;
	@ApiModelProperty(value = "单据code")
    private String receiptCode;
    @ApiModelProperty(value = "审批实例id")
    private String processId;
    @ApiModelProperty(value = "审批节点id")
    private String nodeId;
    @ApiModelProperty(value = "审批用户id")
    private Integer userId;
    @ApiModelProperty(value = "审批状态")
    private String approveStatus;
    @ApiModelProperty(value = "审批意见")
    private String approveOpinion;
    @ApiModelProperty(value = "审批意见")
    private String comment;

    public String getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(String receiptType) {
        this.receiptType = receiptType;
    }

    public String getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(String receiptCode) {
        this.receiptCode = receiptCode;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(String approveStatus) {
        this.approveStatus = approveStatus;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

	public String getApproveOpinion() {
		return approveOpinion;
	}

	public void setApproveOpinion(String approveOpinion) {
		this.approveOpinion = approveOpinion;
	}
}
