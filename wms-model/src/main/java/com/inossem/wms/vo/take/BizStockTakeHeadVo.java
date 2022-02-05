package com.inossem.wms.vo.take;

import java.io.Serializable;
import java.util.Date;

import com.inossem.wms.page.IPageResultCommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="com.inossem.wms.vo.take.BizStockTakeHeadVo", description="盘点对象")
public class BizStockTakeHeadVo implements IPageResultCommon, Serializable {

	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "总记录数", example = "0")
	private int totalCount;

	@ApiModelProperty(value = "盘点 凭证id")
	private String stockTakeId;
	@ApiModelProperty(value = "盘点 凭证code")
	private String stockTakeCode;
	@ApiModelProperty(value = "盘点类型：1-动态盘点，2-周期性盘点")
	private byte stockTakeType;
	@ApiModelProperty(value = "盘点方法：1-明盘，2-盲盘")
	private byte stockTakeMode;
	@ApiModelProperty(value = "盘点日期")
	private Date stockTakeDate;
	@ApiModelProperty(value = "盘点状态")
	private String StockTakeStatus;
	@ApiModelProperty(value = "是否冻结0否1是")
	private byte freezeStockTake;
	@ApiModelProperty(value = "是否删除")
	private Integer isDelete;
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	@ApiModelProperty(value = "创建人")
	private String createUserId;

	@ApiModelProperty(value = "单据状态")
	private Byte receiptStatus;
	@ApiModelProperty(value = "单据类型")
	private Integer receiptType;
	@ApiModelProperty(value = "单据状态名称")
	private String receiptStatusName;
	@ApiModelProperty(value = "保存或修改状态")
	private Byte saveOrUpdate;
	@ApiModelProperty(value="创建者", name="", example="", required=true)
    private String createUserName;
	@ApiModelProperty(value = "盘点类型名称")
	private String stockTakeTypeName;
	@ApiModelProperty(value = "盘点方式名称")
	private String stockTakeModeName;
	@ApiModelProperty(value = "是否冻结0否1是")
	private String freezeStockTakeName;
	@ApiModelProperty(value = "仓库code")
	private String whCode;
	@ApiModelProperty(value = "仓库名称")
	private String whName;
	@ApiModelProperty(value = "SAP document#")
	private String docNum;


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

	public String getStockTakeId() {
		return stockTakeId;
	}

	public void setStockTakeId(String stockTakeId) {
		this.stockTakeId = stockTakeId;
	}

	public String getStockTakeCode() {
		return stockTakeCode;
	}

	public void setStockTakeCode(String stockTakeCode) {
		this.stockTakeCode = stockTakeCode;
	}

	public byte getStockTakeType() {
		return stockTakeType;
	}

	public void setStockTakeType(byte stockTakeType) {
		this.stockTakeType = stockTakeType;
	}

	public byte getStockTakeMode() {
		return stockTakeMode;
	}

	public void setStockTakeMode(byte stockTakeMode) {
		this.stockTakeMode = stockTakeMode;
	}

	public Date getStockTakeDate() {
		return stockTakeDate;
	}

	public void setStockTakeDate(Date stockTakeDate) {
		this.stockTakeDate = stockTakeDate;
	}

	public String getStockTakeStatus() {
		return StockTakeStatus;
	}

	public void setStockTakeStatus(String stockTakeStatus) {
		StockTakeStatus = stockTakeStatus;
	}

	public byte getFreezeStockTake() {
		return freezeStockTake;
	}

	public void setFreezeStockTake(byte freezeStockTake) {
		this.freezeStockTake = freezeStockTake;
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

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public Byte getReceiptStatus() {
		return receiptStatus;
	}

	public void setReceiptStatus(Byte receiptStatus) {
		this.receiptStatus = receiptStatus;
	}

	public Integer getReceiptType() {
		return receiptType;
	}

	public void setReceiptType(Integer receiptType) {
		this.receiptType = receiptType;
	}

	public String getReceiptStatusName() {
		return receiptStatusName;
	}

	public void setReceiptStatusName(String receiptStatusName) {
		this.receiptStatusName = receiptStatusName;
	}

	public Byte getSaveOrUpdate() {
		return saveOrUpdate;
	}

	public void setSaveOrUpdate(Byte saveOrUpdate) {
		this.saveOrUpdate = saveOrUpdate;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
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

	public String getFreezeStockTakeName() {
		return freezeStockTakeName;
	}

	public void setFreezeStockTakeName(String freezeStockTakeName) {
		this.freezeStockTakeName = freezeStockTakeName;
	}

	public String getWhCode() {
		return whCode;
	}

	public void setWhCode(String whCode) {
		this.whCode = whCode;
	}

	public String getWhName() {
		return whName;
	}

	public void setWhName(String whName) {
		this.whName = whName;
	}
}
