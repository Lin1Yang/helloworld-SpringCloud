package com.inossem.wms.model.sinobec.take;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

@ApiModel(value="com.inossem.wms.model.sinobec.take.SinobecBizStockTake")
public class SinobecBizStockTake {
    @ApiModelProperty(value="stockTakeId")
    private Integer stockTakeId;

    @ApiModelProperty(value="stockTakeCode单据号")
    private String stockTakeCode;

    @ApiModelProperty(value="stockTakeRid行号")
    private String stockTakeRid;

    @ApiModelProperty(value="whCode仓库号")
    private String whCode;

    @ApiModelProperty(value="typeCode存储类型")
    private String typeCode;

    @ApiModelProperty(value="binCode仓位")
    private String binCode;

    @ApiModelProperty(value="stockTakeType盘点类型：1-动态盘点，2-周期性盘点")
    private Byte stockTakeType;

    @ApiModelProperty(value="stockTakeMode盘点方法：1-明盘，2-盲盘")
    private Byte stockTakeMode;

    @ApiModelProperty(value="stockTakeUser盘点人")
    private String stockTakeUser;

    @ApiModelProperty(value="stockTakeDate盘点日期")
    private Date stockTakeDate;

    @ApiModelProperty(value="receiptType单据类型")
    private Integer receiptType;

    @ApiModelProperty(value="receiptStatus盘点表状态:10-草稿,20-已提交,50-已计数,90-已完成,4-待审批,5-审批通过,6-审批未通过,7-已过账")
    private Byte receiptStatus;

    @ApiModelProperty(value="itemStatus行项目状态")
    private Byte itemStatus;

    @ApiModelProperty(value="freezeStockTake是否冻结仓位。0:不冻结；1冻结")
    private Byte freezeStockTake;

    @ApiModelProperty(value="isDelete删除标识")
    private Byte isDelete;

    @ApiModelProperty(value="createTime创建时间")
    private Date createTime;

    @ApiModelProperty(value="modifyTime修改时间")
    private Date modifyTime;

    @ApiModelProperty(value="createUserId")
    private Integer createUserId;

    @ApiModelProperty(value="modifyUserId")
    private Integer modifyUserId;

    @ApiModelProperty(value="moveDate移动日期")
    private Date moveDate;
    
    @ApiModelProperty(value = "SAP document#")
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

	public Integer getStockTakeId() {
        return stockTakeId;
    }

    public void setStockTakeId(Integer stockTakeId) {
        this.stockTakeId = stockTakeId;
    }

    public String getStockTakeCode() {
        return stockTakeCode;
    }

    public void setStockTakeCode(String stockTakeCode) {
        this.stockTakeCode = stockTakeCode == null ? null : stockTakeCode.trim();
    }

    public String getStockTakeRid() {
        return stockTakeRid;
    }

    public void setStockTakeRid(String stockTakeRid) {
        this.stockTakeRid = stockTakeRid == null ? null : stockTakeRid.trim();
    }

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode == null ? null : whCode.trim();
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode == null ? null : typeCode.trim();
    }

    public String getBinCode() {
        return binCode;
    }

    public void setBinCode(String binCode) {
        this.binCode = binCode == null ? null : binCode.trim();
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

    public String getStockTakeUser() {
        return stockTakeUser;
    }

    public void setStockTakeUser(String stockTakeUser) {
        this.stockTakeUser = stockTakeUser == null ? null : stockTakeUser.trim();
    }

    public Date getStockTakeDate() {
        return stockTakeDate;
    }

    public void setStockTakeDate(Date stockTakeDate) {
        this.stockTakeDate = stockTakeDate;
    }

    public Integer getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(Integer receiptType) {
        this.receiptType = receiptType;
    }

    public Byte getReceiptStatus() {
        return receiptStatus;
    }

    public void setReceiptStatus(Byte receiptStatus) {
        this.receiptStatus = receiptStatus;
    }

    public Byte getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(Byte itemStatus) {
        this.itemStatus = itemStatus;
    }

    public Byte getFreezeStockTake() {
        return freezeStockTake;
    }

    public void setFreezeStockTake(Byte freezeStockTake) {
        this.freezeStockTake = freezeStockTake;
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

    public Date getMoveDate() {
        return moveDate;
    }

    public void setMoveDate(Date moveDate) {
        this.moveDate = moveDate;
    }
}