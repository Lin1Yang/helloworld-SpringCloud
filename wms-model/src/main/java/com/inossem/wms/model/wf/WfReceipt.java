package com.inossem.wms.model.wf;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
@ApiModel(description = "审批单据映射类")
public class WfReceipt extends WfReceiptKey  implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name="piId",value = "流程ID",required = true)
    private String piId;

    @ApiModelProperty(name="receiptUserId",value = "申请人ID",required = true)
    private String receiptUserId;

    @ApiModelProperty(name="approveStatus",value = "审批状态",required = true)
    private Byte approveStatus;
    
    @ApiModelProperty(name="approveOpinion",value = "审批意见",required = false)
    private String approveOpinion;

    @ApiModelProperty(name="createTime",value = "创建时间",required = true)
    private Date createTime;

    @ApiModelProperty(name="modifyTime",value = "修改时间",required = true)
    private Date modifyTime;

    public String getPiId() {
        return piId;
    }

    public void setPiId(String piId) {
        this.piId = piId == null ? null : piId.trim();
    }

    public String getReceiptUserId() {
        return receiptUserId;
    }

    public void setReceiptUserId(String receiptUserId) {
        this.receiptUserId = receiptUserId == null ? null : receiptUserId.trim();
    }

    public Byte getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(Byte approveStatus) {
        this.approveStatus = approveStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

	public String getApproveOpinion() {
		return approveOpinion;
	}

	public void setApproveOpinion(String approveOpinion) {
		this.approveOpinion = approveOpinion;
	}
}