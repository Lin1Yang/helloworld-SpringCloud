package com.inossem.wms.model.conf;

import com.inossem.wms.page.IPageResultCommon;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel()
public class ConfReceiptType extends ConfReceiptTypeKey implements IPageResultCommon {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1186231465466478317L;
	private String procId;
    @ApiModelProperty(value = "模块名称")
    private String procName;
    @ApiModelProperty(value = "模块描述")
    private String procDesp;

    private Date createTime;

    private Date modifyTime;

    private Integer createUserId;

    private Integer modifyUserId;

    private String receiptTypeName;

    public String getReceiptTypeName() {
        return receiptTypeName;
    }

    public ConfReceiptType setReceiptTypeName(String receiptTypeName) {
        this.receiptTypeName = receiptTypeName;
        return this;
    }

    public String getProcId() {
        return procId;
    }

    public void setProcId(String procId) {
        this.procId = procId;
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

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Integer modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public String getProcName() {
        return procName;
    }

    public ConfReceiptType setProcName(String procName) {
        this.procName = procName;
        return this;
    }

    public String getProcDesp() {
        return procDesp;
    }

    public ConfReceiptType setProcDesp(String procDesp) {
        this.procDesp = procDesp;
        return this;
    }
}