package com.inossem.wms.model.sinobec.take;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value="com.inossem.wms.model.sinobec.take.SinobecBizStockTakeMat")
public class SinobecBizStockTakeMat {
    @ApiModelProperty(value="stockTakeMatId")
    private Integer stockTakeMatId;

    @ApiModelProperty(value="stockTakeCode盘点凭证号")
    private String stockTakeCode;

    @ApiModelProperty(value="stockTakeRid行号")
    private String stockTakeRid;

    @ApiModelProperty(value="stockTakeBid")
    private Integer stockTakeBid;

    @ApiModelProperty(value="bundle捆号")
    private String bundleCode;

    @ApiModelProperty(value="whCode仓库号")
    private String whCode;

    @ApiModelProperty(value="typeCode存储区")
    private String typeCode;

    @ApiModelProperty(value="binCode仓位")
    private String binCode;

    @ApiModelProperty(value="matCode物料编码")
    private String matCode;

    @ApiModelProperty(value="批次")
    private String lotNumb;

    @ApiModelProperty(value="unitCode基本计量单位")
    private String unitCode;

    @ApiModelProperty(value="weightUnitCode重量单位")
    private String weightUnitCode;

    @ApiModelProperty(value="shippingRef传单号")
    private String shippingRef;

    @ApiModelProperty(value="heatCode高炉")
    private String heatCode;

    @ApiModelProperty(value="skidCodeskid")
    private String skidCode;

    @ApiModelProperty(value="stockStatus")
    private String stockStatus;

    @ApiModelProperty(value="库存ID")
    private Integer stockId;

    @ApiModelProperty(value="qty库存数量")
    private BigDecimal qty;

    @ApiModelProperty(value="weightQty重量")
    private BigDecimal weightQty;

    @ApiModelProperty(value="receiptQty重量")
    private BigDecimal receiptQty;

    @ApiModelProperty(value="stockTakeQty盘点数量")
    private BigDecimal stockTakeQty;

    @ApiModelProperty(value="stockTakeUser盘点人")
    private String stockTakeUser;

    @ApiModelProperty(value="moveDate移动日期")
    private Date moveDate;

    @ApiModelProperty(value="status状态：10-草稿,20-已提交")
    private Byte status;

    @ApiModelProperty(value="modifyStatus修改状态0否1是")
    private Byte modifyStatus;

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
    
    @ApiModelProperty(value = "Added for vin from SAP",example = "...")
    private String ext0;
    
    @ApiModelProperty(value = "Added for engine from SAP",example = "...")
    private String ext1;
    
    @ApiModelProperty(value = "Added for material type from SAP",example = "M or V")
    private String ext2;
    private String ext3;
    private String ext4;
    private String ext5;
    private String ext6;
    private String ext7;
    private String ext8;
    private String ext9;
    private String ext10;
    private String ext11;
    private String ext12;
    private String ext13;
    private String ext14;
    private String ext15;
    
    private Byte isRecount;
    
    

    public Byte getIsRecount() {
		return isRecount;
	}

	public void setIsRecount(Byte isRecount) {
		this.isRecount = isRecount;
	}

	public String getExt0() {
		return ext0;
	}

	public void setExt0(String ext0) {
		this.ext0 = ext0;
	}

	public String getExt1() {
		return ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	public String getExt2() {
		return ext2;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}

	public String getExt3() {
		return ext3;
	}

	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}

	public String getExt4() {
		return ext4;
	}

	public void setExt4(String ext4) {
		this.ext4 = ext4;
	}

	public String getExt5() {
		return ext5;
	}

	public void setExt5(String ext5) {
		this.ext5 = ext5;
	}

	public String getExt6() {
		return ext6;
	}

	public void setExt6(String ext6) {
		this.ext6 = ext6;
	}

	public String getExt7() {
		return ext7;
	}

	public void setExt7(String ext7) {
		this.ext7 = ext7;
	}

	public String getExt8() {
		return ext8;
	}

	public void setExt8(String ext8) {
		this.ext8 = ext8;
	}

	public String getExt9() {
		return ext9;
	}

	public void setExt9(String ext9) {
		this.ext9 = ext9;
	}

	public String getExt10() {
		return ext10;
	}

	public void setExt10(String ext10) {
		this.ext10 = ext10;
	}

	public String getExt11() {
		return ext11;
	}

	public void setExt11(String ext11) {
		this.ext11 = ext11;
	}

	public String getExt12() {
		return ext12;
	}

	public void setExt12(String ext12) {
		this.ext12 = ext12;
	}

	public String getExt13() {
		return ext13;
	}

	public void setExt13(String ext13) {
		this.ext13 = ext13;
	}

	public String getExt14() {
		return ext14;
	}

	public void setExt14(String ext14) {
		this.ext14 = ext14;
	}

	public String getExt15() {
		return ext15;
	}

	public void setExt15(String ext15) {
		this.ext15 = ext15;
	}

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
        this.stockTakeCode = stockTakeCode == null ? null : stockTakeCode.trim();
    }

    public String getStockTakeRid() {
        return stockTakeRid;
    }

    public void setStockTakeRid(String stockTakeRid) {
        this.stockTakeRid = stockTakeRid == null ? null : stockTakeRid.trim();
    }

    public Integer getStockTakeBid() {
        return stockTakeBid;
    }

    public void setStockTakeBid(Integer stockTakeBid) {
        this.stockTakeBid = stockTakeBid;
    }

    public String getBundleCode() {
        return bundleCode;
    }

    public void setBundleCode(String bundleCode) {
        this.bundleCode = bundleCode;
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

    public String getMatCode() {
        return matCode;
    }

    public void setMatCode(String matCode) {
        this.matCode = matCode == null ? null : matCode.trim();
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode == null ? null : unitCode.trim();
    }

    public String getShippingRef() {
        return shippingRef;
    }

    public void setShippingRef(String shippingRef) {
        this.shippingRef = shippingRef == null ? null : shippingRef.trim();
    }

    public String getHeatCode() {
        return heatCode;
    }

    public void setHeatCode(String heatCode) {
        this.heatCode = heatCode == null ? null : heatCode.trim();
    }

    public String getSkidCode() {
        return skidCode;
    }

    public void setSkidCode(String skidCode) {
        this.skidCode = skidCode == null ? null : skidCode.trim();
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

    public String getStockTakeUser() {
        return stockTakeUser;
    }

    public void setStockTakeUser(String stockTakeUser) {
        this.stockTakeUser = stockTakeUser == null ? null : stockTakeUser.trim();
    }

    public Date getMoveDate() {
        return moveDate;
    }

    public void setMoveDate(Date moveDate) {
        this.moveDate = moveDate;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getModifyStatus() {
        return modifyStatus;
    }

    public void setModifyStatus(Byte modifyStatus) {
        this.modifyStatus = modifyStatus;
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

    public String getWeightUnitCode() {
        return weightUnitCode;
    }

    public void setWeightUnitCode(String weightUnitCode) {
        this.weightUnitCode = weightUnitCode;
    }

    public BigDecimal getWeightQty() {
        return weightQty;
    }

    public void setWeightQty(BigDecimal weightQty) {
        this.weightQty = weightQty;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public String getLotNumb() {
        return lotNumb;
    }

    public void setLotNumb(String lotNumb) {
        this.lotNumb = lotNumb;
    }

    public String getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
    }

    public BigDecimal getReceiptQty() {
        return receiptQty;
    }

    public void setReceiptQty(BigDecimal receiptQty) {
        this.receiptQty = receiptQty;
    }
}