package com.inossem.wms.vo.take;

import java.io.Serializable;
import java.util.Date;

import com.inossem.wms.page.IPageResultCommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="com.inossem.wms.vo.take.BizStockTakeMatHeadVo", description="盘点对象")
public class BizStockTakeMatHeadVo implements IPageResultCommon, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "总记录数", example = "0")
	private int totalCount;
	@ApiModelProperty(value = "盘点 凭证id")
	private String stockTakeMatId;
	@ApiModelProperty(value = "盘点 凭证code")
	private String stockTakeCode;
	@ApiModelProperty(value = "盘点状态")
	private String stockTakeStatus;
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
	@ApiModelProperty(value = "保存或修改状态")
	private Byte saveOrUpdate;
	@ApiModelProperty(value = "单据状态")
	private Byte receiptStatus;
	@ApiModelProperty(value = "单据状态名称")
	private String receiptStatusName;
	@ApiModelProperty(value = "盘点类型：1-动态盘点，2-周期性盘点")
	private Byte stockTakeType;
	@ApiModelProperty(value = "盘点方法：1-明盘，2-盲盘")
	private Byte stockTakeMode;
	@ApiModelProperty(value = "盘点类型：1-动态盘点，2-周期性盘点")
	private String stockTakeTypeName;
	@ApiModelProperty(value = "盘点方法：1-明盘，2-盲盘")
	private String stockTakeModeName;
	@ApiModelProperty(value = "用户名")
	private String createUserName;
	@ApiModelProperty(value = "盘点日期")
	private Date stockTakeDate;
	@ApiModelProperty(value = "是否冻结标识")
	private Byte freezeStockTake;
	@ApiModelProperty(value = "是否冻结")
	private String freezeStockTakeName;
	@ApiModelProperty(value = "完成状态")
	private String complateStatus;
	@ApiModelProperty(value = "SAP doc #")
	private String docNum;
	
	private Byte isRecount;
	

	public Byte getIsRecount() {
		return isRecount;
	}

	public void setIsRecount(Byte isRecount) {
		this.isRecount = isRecount;
	}

	public String getDocNum() {
		return docNum;
	}

	public void setDocNum(String docNum) {
		this.docNum = docNum;
	}

	@Override
	public int getTotalCount() {
		return totalCount;
	}

	@Override
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public String getStockTakeMatId() {
		return stockTakeMatId;
	}

	public void setStockTakeMatId(String stockTakeMatId) {
		this.stockTakeMatId = stockTakeMatId;
	}

	public String getStockTakeCode() {
		return stockTakeCode;
	}

	public void setStockTakeCode(String stockTakeCode) {
		this.stockTakeCode = stockTakeCode;
	}

	public String getStockTakeStatus() {
		return stockTakeStatus;
	}

	public void setStockTakeStatus(String stockTakeStatus) {
		this.stockTakeStatus = stockTakeStatus;
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

	public Byte getSaveOrUpdate() {
		return saveOrUpdate;
	}

	public void setSaveOrUpdate(Byte saveOrUpdate) {
		this.saveOrUpdate = saveOrUpdate;
	}

	public Byte getReceiptStatus() {
		return receiptStatus;
	}

	public void setReceiptStatus(Byte receiptStatus) {
		this.receiptStatus = receiptStatus;
	}

	public String getReceiptStatusName() {
		return receiptStatusName;
	}

	public void setReceiptStatusName(String receiptStatusName) {
		this.receiptStatusName = receiptStatusName;
	}

	public Byte getStockTakeType() {
		return stockTakeType;
	}

	public void setStockTakeType(Byte stockTakeType) {
		this.stockTakeType = stockTakeType;
	}

	public Byte getStockTakeMode() {
		return stockTakeMode;
	}

	public void setStockTakeMode(Byte stockTakeMode) {
		this.stockTakeMode = stockTakeMode;
	}

	public String getStockTakeTypeName() {
		return stockTakeTypeName;
	}

	public void setStockTakeTypeName(String stockTakeTypeName) {
		this.stockTakeTypeName = stockTakeTypeName;
	}

	public String getStockTakeModeName() {
		return stockTakeModeName;
	}

	public void setStockTakeModeName(String stockTakeModeName) {
		this.stockTakeModeName = stockTakeModeName;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public Date getStockTakeDate() {
		return stockTakeDate;
	}

	public void setStockTakeDate(Date stockTakeDate) {
		this.stockTakeDate = stockTakeDate;
	}

	public Byte getFreezeStockTake() {
		return freezeStockTake;
	}

	public void setFreezeStockTake(Byte freezeStockTake) {
		this.freezeStockTake = freezeStockTake;
	}

	public String getFreezeStockTakeName() {
		return freezeStockTakeName;
	}

	public void setFreezeStockTakeName(String freezeStockTakeName) {
		this.freezeStockTakeName = freezeStockTakeName;
	}

	public String getComplateStatus() {
		return complateStatus;
	}

	public void setComplateStatus(String complateStatus) {
		this.complateStatus = complateStatus;
	}
}
