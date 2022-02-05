package com.inossem.wms.model.biz;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class BizStockTakeMat implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "盘点 凭证id")
	private Integer stockTakeMatId;
	@ApiModelProperty(value = "盘点 凭证code")
	private String stockTakeCode;
	@ApiModelProperty(value = "盘点 凭证rid")
	private String stockTakeRid;
	@ApiModelProperty(value = "盘点 凭证bid")
	private String stockTakeBid;
	@ApiModelProperty(value = "盘点 凭证组")
	private String stockTakeGroup;
	@ApiModelProperty(value = "盘点库存凭证")
	private String stockTakeVoucher;
	@ApiModelProperty(value = "盘点物料凭证组")
	private String matVoucher;
	@ApiModelProperty(value = "仓库code")
	private String whCode;
	@ApiModelProperty(value = "批次")
	private String batch;
	@ApiModelProperty(value = "存储类型code")
	private String typeCode;
	@ApiModelProperty(value = "仓位code")
	private String binCode;
	@ApiModelProperty(value = "物料code")
	private String matCode;
	@ApiModelProperty(value = "基本计量单位")
	private String unitCode;
	@ApiModelProperty(value = "数量")
	private BigDecimal qty;
	@ApiModelProperty(value = "盘点数量")
	private BigDecimal stockTakeQty;
	@ApiModelProperty(value = "盘点状态")
	private String stockTakeStatus;
	@ApiModelProperty(value = "盘点人")
	private String stockTakeUser;
	@ApiModelProperty(value = "盘点日期")
	private Date stockTakeDate;
	@ApiModelProperty(value = "移动日期")
	private Date moveDate;
	@ApiModelProperty(value = "状态")
	private String status;
	@ApiModelProperty(value = "是否删除")
	private Integer isDelete;
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	@ApiModelProperty(value = "修改时间")
	private Date modifyTime;
	@ApiModelProperty(value = "创建人")
	private Integer createUserId;
	@ApiModelProperty(value = "修改人")
	private Integer modifyUserId;
	@ApiModelProperty(value = "修改状态")
	private Byte modifyStatus;

	public Integer getStockTakeMatId() {
		return stockTakeMatId;
	}

	public void setStockTakeMatId(Integer stockTakeMatId) {
		this.stockTakeMatId = stockTakeMatId;
	}

	public String getStockTakeCode() {
		return stockTakeCode;
	}

	public void setStockTakeCode(String stockTakeCode) {
		this.stockTakeCode = stockTakeCode;
	}

	public String getStockTakeRid() {
		return stockTakeRid;
	}

	public void setStockTakeRid(String stockTakeRid) {
		this.stockTakeRid = stockTakeRid;
	}

	public String getStockTakeBid() {
		return stockTakeBid;
	}

	public void setStockTakeBid(String stockTakeBid) {
		this.stockTakeBid = stockTakeBid;
	}

	public String getStockTakeGroup() {
		return stockTakeGroup;
	}

	public void setStockTakeGroup(String stockTakeGroup) {
		this.stockTakeGroup = stockTakeGroup;
	}

	public String getStockTakeVoucher() {
		return stockTakeVoucher;
	}

	public void setStockTakeVoucher(String stockTakeVoucher) {
		this.stockTakeVoucher = stockTakeVoucher;
	}

	public String getMatVoucher() {
		return matVoucher;
	}

	public void setMatVoucher(String matVoucher) {
		this.matVoucher = matVoucher;
	}

	public String getWhCode() {
		return whCode;
	}

	public void setWhCode(String whCode) {
		this.whCode = whCode;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getBinCode() {
		return binCode;
	}

	public void setBinCode(String binCode) {
		this.binCode = binCode;
	}

	public String getMatCode() {
		return matCode;
	}

	public void setMatCode(String matCode) {
		this.matCode = matCode;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public BigDecimal getQty() {
		return qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}

	public BigDecimal getStockTakeQty() {
		return stockTakeQty;
	}

	public void setStockTakeQty(BigDecimal stockTakeQty) {
		this.stockTakeQty = stockTakeQty;
	}

	public String getStockTakeStatus() {
		return stockTakeStatus;
	}

	public void setStockTakeStatus(String stockTakeStatus) {
		this.stockTakeStatus = stockTakeStatus;
	}

	public String getStockTakeUser() {
		return stockTakeUser;
	}

	public void setStockTakeUser(String stockTakeUser) {
		this.stockTakeUser = stockTakeUser;
	}

	public Date getStockTakeDate() {
		return stockTakeDate;
	}

	public void setStockTakeDate(Date stockTakeDate) {
		this.stockTakeDate = stockTakeDate;
	}

	public Date getMoveDate() {
		return moveDate;
	}

	public void setMoveDate(Date moveDate) {
		this.moveDate = moveDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
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

	public Byte getModifyStatus() {
		return modifyStatus;
	}

	public void setModifyStatus(Byte modifyStatus) {
		this.modifyStatus = modifyStatus;
	}
}