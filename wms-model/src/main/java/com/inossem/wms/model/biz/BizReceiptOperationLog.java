package com.inossem.wms.model.biz;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="com.inossem.wms.model.biz.BizReceiptOperationLog", description="操作日志对象")
public class BizReceiptOperationLog implements Serializable  {

	private static final long serialVersionUID = -6484150815148286435L;
	@ApiModelProperty(value="操作日志id", example="1")
	private Integer receiptLogId;
	@ApiModelProperty(value="单据类型值", example="1")
	private Integer receiptType;
	@ApiModelProperty(value="单据code", example="0212")
	private String receiptCode;
	@ApiModelProperty(value="操作类型值", example="10")
	private Byte receiptOperationType;
	@ApiModelProperty(value="操作类型描述", example="创建")
	private String receiptOperationTypeName;
	@ApiModelProperty(value="操作日志备注", example="出库日志")
	private String logRemark;
	@ApiModelProperty(value="删除标识", example="0")
	private Byte isDelete;
	@ApiModelProperty(value="创建时间", example="2018-01-01")
	private Date createTime;
	@ApiModelProperty(value="修改时间", example="2018-01-01")
	private Date modifyTime;
	@ApiModelProperty(value="创建人id", example="1")
	private Integer createUserId;
	@ApiModelProperty(value="修改人id", example="1")
	private Integer modifyUserId;
	@ApiModelProperty(value="创建人code", example="001")
	private String createUserCode;
	@ApiModelProperty(value="创建人名称", example="李四")
	private String createUserName;
	@ApiModelProperty(value="部门code", example="A001")
	private String deptCode;
	@ApiModelProperty(value="部门名称", example="研发部")
	private String deptName;
	@ApiModelProperty(value="扩展字段")
	private String receiptOperationLogExt0;
	@ApiModelProperty(value="扩展字段")
	private String receiptOperationLogExt1;
	@ApiModelProperty(value="扩展字段")
	private String receiptOperationLogExt2;
	@ApiModelProperty(value="扩展字段")
	private String receiptOperationLogExt3;
	@ApiModelProperty(value="扩展字段")
	private String receiptOperationLogExt4;
	@ApiModelProperty(value="扩展字段")
	private String receiptOperationLogExt5;
	@ApiModelProperty(value="扩展字段")
	private String receiptOperationLogExt6;
	@ApiModelProperty(value="扩展字段")
	private String receiptOperationLogExt7;
	@ApiModelProperty(value="扩展字段")
	private String receiptOperationLogExt8;
	@ApiModelProperty(value="扩展字段")
	private String receiptOperationLogExt9;

	public Integer getReceiptLogId() {
		return receiptLogId;
	}

	public void setReceiptLogId(Integer receiptLogId) {
		this.receiptLogId = receiptLogId;
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

	public Byte getReceiptOperationType() {
		return receiptOperationType;
	}

	public void setReceiptOperationType(Byte receiptOperationType) {
		this.receiptOperationType = receiptOperationType;
	}

	public String getReceiptOperationTypeName() {
		return receiptOperationTypeName;
	}

	public void setReceiptOperationTypeName(String receiptOperationTypeName) {
		this.receiptOperationTypeName = receiptOperationTypeName;
	}

	public String getLogRemark() {
		return logRemark;
	}

	public void setLogRemark(String logRemark) {
		this.logRemark = logRemark;
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

	public String getCreateUserCode() {
		return createUserCode;
	}

	public void setCreateUserCode(String createUserCode) {
		this.createUserCode = createUserCode;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getReceiptOperationLogExt0() {
		return receiptOperationLogExt0;
	}

	public void setReceiptOperationLogExt0(String receiptOperationLogExt0) {
		this.receiptOperationLogExt0 = receiptOperationLogExt0 == null ? null : receiptOperationLogExt0.trim();
	}

	public String getReceiptOperationLogExt1() {
		return receiptOperationLogExt1;
	}

	public void setReceiptOperationLogExt1(String receiptOperationLogExt1) {
		this.receiptOperationLogExt1 = receiptOperationLogExt1 == null ? null : receiptOperationLogExt1.trim();
	}

	public String getReceiptOperationLogExt2() {
		return receiptOperationLogExt2;
	}

	public void setReceiptOperationLogExt2(String receiptOperationLogExt2) {
		this.receiptOperationLogExt2 = receiptOperationLogExt2 == null ? null : receiptOperationLogExt2.trim();
	}

	public String getReceiptOperationLogExt3() {
		return receiptOperationLogExt3;
	}

	public void setReceiptOperationLogExt3(String receiptOperationLogExt3) {
		this.receiptOperationLogExt3 = receiptOperationLogExt3 == null ? null : receiptOperationLogExt3.trim();
	}

	public String getReceiptOperationLogExt4() {
		return receiptOperationLogExt4;
	}

	public void setReceiptOperationLogExt4(String receiptOperationLogExt4) {
		this.receiptOperationLogExt4 = receiptOperationLogExt4 == null ? null : receiptOperationLogExt4.trim();
	}

	public String getReceiptOperationLogExt5() {
		return receiptOperationLogExt5;
	}

	public void setReceiptOperationLogExt5(String receiptOperationLogExt5) {
		this.receiptOperationLogExt5 = receiptOperationLogExt5 == null ? null : receiptOperationLogExt5.trim();
	}

	public String getReceiptOperationLogExt6() {
		return receiptOperationLogExt6;
	}

	public void setReceiptOperationLogExt6(String receiptOperationLogExt6) {
		this.receiptOperationLogExt6 = receiptOperationLogExt6 == null ? null : receiptOperationLogExt6.trim();
	}

	public String getReceiptOperationLogExt7() {
		return receiptOperationLogExt7;
	}

	public void setReceiptOperationLogExt7(String receiptOperationLogExt7) {
		this.receiptOperationLogExt7 = receiptOperationLogExt7 == null ? null : receiptOperationLogExt7.trim();
	}

	public String getReceiptOperationLogExt8() {
		return receiptOperationLogExt8;
	}

	public void setReceiptOperationLogExt8(String receiptOperationLogExt8) {
		this.receiptOperationLogExt8 = receiptOperationLogExt8 == null ? null : receiptOperationLogExt8.trim();
	}

	public String getReceiptOperationLogExt9() {
		return receiptOperationLogExt9;
	}

	public void setReceiptOperationLogExt9(String receiptOperationLogExt9) {
		this.receiptOperationLogExt9 = receiptOperationLogExt9 == null ? null : receiptOperationLogExt9.trim();
	}
}