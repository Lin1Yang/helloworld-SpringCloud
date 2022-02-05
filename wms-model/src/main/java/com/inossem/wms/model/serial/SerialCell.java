package com.inossem.wms.model.serial;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="com.inossem.wms.model.serial.SerialCell", description="存储单元对象")
public class SerialCell {
	@ApiModelProperty(value="存储单元编码", name="cellCode", required=true)
    private String cellCode;
	@ApiModelProperty(value="仓库号", name="whCode", required=true)
    private String whCode;
	@ApiModelProperty(value="存储单元类型编码", name="cellTypeCode", required=true)
    private String cellTypeCode;
	@ApiModelProperty(value="存储单元类型描述", name="cellTypeName", required=true)
    private String cellTypeName;
	@ApiModelProperty(value="最大承重", name="weightMax", required=true)
    private BigDecimal weightMax;
	@ApiModelProperty(value="是否冻结0未冻结1已冻结", name="freeze", required=true)
    private Byte freeze;
	@ApiModelProperty(value="冻结原因", name="freezeReasonId", required=true)
    private Integer freezeReasonId;
	@ApiModelProperty(value="空存储单元标识 0 空，1 不空", name="used", required=true)
    private Byte used;
	@ApiModelProperty(value="删除标识 0 未删除，1 已删除", name="isDelete", required=true)
    private Byte isDelete;
	@ApiModelProperty(value="创建时间", name="createTime", required=true)
    private Date createTime;
	@ApiModelProperty(value="修改时间", name="modifyTime", required=true)
    private Date modifyTime;
	@ApiModelProperty(value="创建人id", name="createUserId", required=true)
    private Integer createUserId;
	@ApiModelProperty(value="修改人id", name="modifyUserId", required=true)
    private Integer modifyUserId;
	@ApiModelProperty(value="", name="cellExt0", required=true)
    private String cellExt0;
	@ApiModelProperty(value="", name="cellExt1", required=true)
    private String cellExt1;
	@ApiModelProperty(value="", name="cellExt2", required=true)
    private String cellExt2;
	@ApiModelProperty(value="", name="cellExt3", required=true)
    private String cellExt3;
	@ApiModelProperty(value="", name="cellExt4", required=true)
    private String cellExt4;
	@ApiModelProperty(value="", name="cellExt5", required=true)
    private String cellExt5;
	@ApiModelProperty(value="", name="cellExt6", required=true)
    private String cellExt6;
	@ApiModelProperty(value="", name="cellExt7", required=true)
    private String cellExt7;
	@ApiModelProperty(value="", name="cellExt8", required=true)
    private String cellExt8;
	@ApiModelProperty(value="", name="cellExt9", required=true)
    private String cellExt9;
	@ApiModelProperty(value="", name="isClick", required=true)
    private boolean isClick = false;

    public String getCellCode() {
        return cellCode;
    }

    public void setCellCode(String cellCode) {
        this.cellCode = cellCode == null ? null : cellCode.trim();
    }

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode == null ? null : whCode.trim();
    }

    public String getCellTypeCode() {
        return cellTypeCode;
    }

    public void setCellTypeCode(String cellTypeCode) {
        this.cellTypeCode = cellTypeCode == null ? null : cellTypeCode.trim();
    }

    public String getCellTypeName() {
        return cellTypeName;
    }

    public void setCellTypeName(String cellTypeName) {
        this.cellTypeName = cellTypeName == null ? null : cellTypeName.trim();
    }

    public BigDecimal getWeightMax() {
        return weightMax;
    }

    public void setWeightMax(BigDecimal weightMax) {
        this.weightMax = weightMax;
    }

    public Byte getFreeze() {
        return freeze;
    }

    public void setFreeze(Byte freeze) {
        this.freeze = freeze;
    }

    public Integer getFreezeReasonId() {
        return freezeReasonId;
    }

    public void setFreezeReasonId(Integer freezeReasonId) {
        this.freezeReasonId = freezeReasonId;
    }

    public Byte getUsed() {
        return used;
    }

    public void setUsed(Byte used) {
        this.used = used;
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

    public String getCellExt0() {
        return cellExt0;
    }

    public void setCellExt0(String cellExt0) {
        this.cellExt0 = cellExt0 == null ? null : cellExt0.trim();
    }

    public String getCellExt1() {
        return cellExt1;
    }

    public void setCellExt1(String cellExt1) {
        this.cellExt1 = cellExt1 == null ? null : cellExt1.trim();
    }

    public String getCellExt2() {
        return cellExt2;
    }

    public void setCellExt2(String cellExt2) {
        this.cellExt2 = cellExt2 == null ? null : cellExt2.trim();
    }

    public String getCellExt3() {
        return cellExt3;
    }

    public void setCellExt3(String cellExt3) {
        this.cellExt3 = cellExt3 == null ? null : cellExt3.trim();
    }

    public String getCellExt4() {
        return cellExt4;
    }

    public void setCellExt4(String cellExt4) {
        this.cellExt4 = cellExt4 == null ? null : cellExt4.trim();
    }

    public String getCellExt5() {
        return cellExt5;
    }

    public void setCellExt5(String cellExt5) {
        this.cellExt5 = cellExt5 == null ? null : cellExt5.trim();
    }

    public String getCellExt6() {
        return cellExt6;
    }

    public void setCellExt6(String cellExt6) {
        this.cellExt6 = cellExt6 == null ? null : cellExt6.trim();
    }

    public String getCellExt7() {
        return cellExt7;
    }

    public void setCellExt7(String cellExt7) {
        this.cellExt7 = cellExt7 == null ? null : cellExt7.trim();
    }

    public String getCellExt8() {
        return cellExt8;
    }

    public void setCellExt8(String cellExt8) {
        this.cellExt8 = cellExt8 == null ? null : cellExt8.trim();
    }

    public String getCellExt9() {
        return cellExt9;
    }

    public void setCellExt9(String cellExt9) {
        this.cellExt9 = cellExt9 == null ? null : cellExt9.trim();
    }

	public boolean isClick() {
		return isClick;
	}

	public void setClick(boolean isClick) {
		this.isClick = isClick;
	}
}