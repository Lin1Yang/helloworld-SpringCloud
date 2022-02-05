package com.inossem.wms.model.biz;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class BizStockTake implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "盘点 凭证id")
    private Integer stockTakeId;
    @ApiModelProperty(value = "盘点 凭证code")
    private String stockTakeCode;
    @ApiModelProperty(value = "盘点 凭证rid")
    private String stockTakeRid;
    @ApiModelProperty(value = "仓库code")
    private String whCode;
    @ApiModelProperty(value = "存储类型code")
    private String typeCode;
    @ApiModelProperty(value = "仓位code")
    private String binCode;
    @ApiModelProperty(value = "盘点类型：1-动态盘点，2-周期性盘点")
    private Byte stockTakeType;
    @ApiModelProperty(value = "盘点方法：1-明盘，2-盲盘")
    private Byte stockTakeMode;
    @ApiModelProperty(value = "盘点人")
    private String stockTakeUser;
    @ApiModelProperty(value = "移动日期")
    private Date moveDate;
    @ApiModelProperty(value = "盘点日期")
    private Date stockTakeDate;
    @ApiModelProperty(value = "单据类型")
    private Integer receiptType;
    @ApiModelProperty(value = "盘点状态")
    private Byte receiptStatus;
    @ApiModelProperty(value = "是否冻结0否1是")
    private Byte freezeStockTake;
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
    @ApiModelProperty(value = "盘点行项目状态")
    private Byte itemStatus;

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
        this.stockTakeCode = stockTakeCode;
    }

    public String getStockTakeRid() {
        return stockTakeRid;
    }

    public void setStockTakeRid(String stockTakeRid) {
        this.stockTakeRid = stockTakeRid;
    }

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
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
        this.stockTakeUser = stockTakeUser;
    }

    public Date getMoveDate() {
        return moveDate;
    }

    public void setMoveDate(Date moveDate) {
        this.moveDate = moveDate;
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

    public Byte getFreezeStockTake() {
        return freezeStockTake;
    }

    public void setFreezeStockTake(Byte freezeStockTake) {
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

    public Byte getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(Byte itemStatus) {
        this.itemStatus = itemStatus;
    }
}