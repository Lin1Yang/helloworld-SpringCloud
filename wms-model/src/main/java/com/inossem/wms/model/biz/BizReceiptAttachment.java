package com.inossem.wms.model.biz;


import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="com.inossem.wms.model.biz.BizReceiptAttachment", description="单据附件表映射")
public class BizReceiptAttachment implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2947284408187311837L;

	@ApiModelProperty(value="单据附件表自增id", name="bizReceiptAttachmentId", example="1", required=true)
    private Integer bizReceiptAttachmentId;
	
	@ApiModelProperty(value="单据类型", name="receiptType", example="10", required=true)
    private Integer receiptType;
	
	@ApiModelProperty(value="单据编码", name="receiptCode", example="1000000001", required=true)
    private String receiptCode;
	
	@ApiModelProperty(value="文件编码", name="fileCode", example="123456789", required=true)
    private String fileCode;
	
	@ApiModelProperty(value="删除标识，0-否，1-是", name="isDelete", example="0", required=true)
    private Byte isDelete;
	
	@ApiModelProperty(value="创建时间", name="createTime", example="2018-12-24 12:24:24", required=true)
    private Date createTime;
	
	@ApiModelProperty(value="修改时间", name="modifyTime", example="2018-12-24 12:24:24", required=true)
    private Date modifyTime;
	
	@ApiModelProperty(value="单据附件创建人Id", name="createUserId", example="0", required=true)
    private Integer createUserId;
	
	@ApiModelProperty(value="单据附件修改人Id", name="modifyUserId", example="0", required=true)
    private Integer modifyUserId;

    private String receiptAttachmentExt0;

    private String receiptAttachmentExt1;

    private String receiptAttachmentExt2;

    private String receiptAttachmentExt3;

    private String receiptAttachmentExt4;

    private String receiptAttachmentExt5;

    private String receiptAttachmentExt6;

    private String receiptAttachmentExt7;

    private String receiptAttachmentExt8;

    private String receiptAttachmentExt9;

    public Integer getBizReceiptAttachmentId() {
        return bizReceiptAttachmentId;
    }

    public void setBizReceiptAttachmentId(Integer bizReceiptAttachmentId) {
        this.bizReceiptAttachmentId = bizReceiptAttachmentId;
    }

    public Integer getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(Integer receiptType) {
        this.receiptType = receiptType;
    }

    public String getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(String receiptCode) {
        this.receiptCode = receiptCode == null ? null : receiptCode.trim();
    }

    public String getFileCode() {
        return fileCode;
    }

    public void setFileCode(String fileCode) {
        this.fileCode = fileCode == null ? null : fileCode.trim();
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
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

    public String getReceiptAttachmentExt0() {
        return receiptAttachmentExt0;
    }

    public void setReceiptAttachmentExt0(String receiptAttachmentExt0) {
        this.receiptAttachmentExt0 = receiptAttachmentExt0 == null ? null : receiptAttachmentExt0.trim();
    }

    public String getReceiptAttachmentExt1() {
        return receiptAttachmentExt1;
    }

    public void setReceiptAttachmentExt1(String receiptAttachmentExt1) {
        this.receiptAttachmentExt1 = receiptAttachmentExt1 == null ? null : receiptAttachmentExt1.trim();
    }

    public String getReceiptAttachmentExt2() {
        return receiptAttachmentExt2;
    }

    public void setReceiptAttachmentExt2(String receiptAttachmentExt2) {
        this.receiptAttachmentExt2 = receiptAttachmentExt2 == null ? null : receiptAttachmentExt2.trim();
    }

    public String getReceiptAttachmentExt3() {
        return receiptAttachmentExt3;
    }

    public void setReceiptAttachmentExt3(String receiptAttachmentExt3) {
        this.receiptAttachmentExt3 = receiptAttachmentExt3 == null ? null : receiptAttachmentExt3.trim();
    }

    public String getReceiptAttachmentExt4() {
        return receiptAttachmentExt4;
    }

    public void setReceiptAttachmentExt4(String receiptAttachmentExt4) {
        this.receiptAttachmentExt4 = receiptAttachmentExt4 == null ? null : receiptAttachmentExt4.trim();
    }

    public String getReceiptAttachmentExt5() {
        return receiptAttachmentExt5;
    }

    public void setReceiptAttachmentExt5(String receiptAttachmentExt5) {
        this.receiptAttachmentExt5 = receiptAttachmentExt5 == null ? null : receiptAttachmentExt5.trim();
    }

    public String getReceiptAttachmentExt6() {
        return receiptAttachmentExt6;
    }

    public void setReceiptAttachmentExt6(String receiptAttachmentExt6) {
        this.receiptAttachmentExt6 = receiptAttachmentExt6 == null ? null : receiptAttachmentExt6.trim();
    }

    public String getReceiptAttachmentExt7() {
        return receiptAttachmentExt7;
    }

    public void setReceiptAttachmentExt7(String receiptAttachmentExt7) {
        this.receiptAttachmentExt7 = receiptAttachmentExt7 == null ? null : receiptAttachmentExt7.trim();
    }

    public String getReceiptAttachmentExt8() {
        return receiptAttachmentExt8;
    }

    public void setReceiptAttachmentExt8(String receiptAttachmentExt8) {
        this.receiptAttachmentExt8 = receiptAttachmentExt8 == null ? null : receiptAttachmentExt8.trim();
    }

    public String getReceiptAttachmentExt9() {
        return receiptAttachmentExt9;
    }

    public void setReceiptAttachmentExt9(String receiptAttachmentExt9) {
        this.receiptAttachmentExt9 = receiptAttachmentExt9 == null ? null : receiptAttachmentExt9.trim();
    }
}