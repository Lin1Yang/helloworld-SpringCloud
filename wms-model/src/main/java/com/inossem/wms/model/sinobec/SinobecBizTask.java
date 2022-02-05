package com.inossem.wms.model.sinobec;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
/**
 * 功能描述: 〈下架实体类〉
 *
 * @return:
 * @since: 1.0.0
 * @Author: cxq
 * @Date: 2020/3/23 0023 11:23
 */
public class SinobecBizTask {
    private Integer taskId;
    
    private Integer taskType;

    private String receiptCode;

    private String receiptRid;

    private String receiptBid;

    private Integer receiptType;

    private Byte receiptStatus;

    private String matCode;
    
    private String matExt1;

    private String unitCode;

    private String bundleCode;

    private String shippingRef;

    private String heatCode;

    private String skidCode;

    private String corpCode;

    private String itemNumb;

    private String lotNumb;

    private String whCode;

    private String sourceTypeCode;

    private String sourceBinCode;

    private Integer sourceStockId;

    private String targetTypeCode;

    private String targetBinCode;

    private BigDecimal receiptQty;

    private BigDecimal weightQty;

    private String receiptUnitCode;

    private String weightUnitCode;

    private String stockStatus;

    private Byte isDelete;

    private Byte writeOff;

    public Byte getIsRecount() {
        return isRecount;
    }

    public void setIsRecount(Byte isRecount) {
        this.isRecount = isRecount;
    }

    private Byte isRecount;

    private Date createTime;

    private Date modifyTime;

    private Integer createUserId;

    private Integer modifyUserId;
    
    private Integer tempCount;
    
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

    // this field is used for identifying status of frozen or unfrozen
    // true represents frozen, false represents unfrozen
    private boolean frozen;
    
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

	public Integer getSourceStockId() {
        return sourceStockId;
    }

    public void setSourceStockId(Integer sourceStockId) {
        this.sourceStockId = sourceStockId;
    }

    public void setWeightQty(BigDecimal weightQty) {
        this.weightQty = weightQty;
    }

    public BigDecimal getWeightQty() {
        return weightQty;
    }

    public String getReceiptUnitCode() {
        return receiptUnitCode;
    }

    public void setReceiptUnitCode(String receiptUnitCode) {
        this.receiptUnitCode = receiptUnitCode;
    }

    public String getWeightUnitCode() {
        return weightUnitCode;
    }

    public void setWeightUnitCode(String weightUnitCode) {
        this.weightUnitCode = weightUnitCode;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getTaskType() {
		return taskType;
	}

	public void setTaskType(Integer taskType) {
		this.taskType = taskType;
	}

	public String getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(String receiptCode) {
        this.receiptCode = receiptCode == null ? null : receiptCode.trim();
    }

    public String getReceiptRid() {
        return receiptRid;
    }

    public void setReceiptRid(String receiptRid) {
        this.receiptRid = receiptRid == null ? null : receiptRid.trim();
    }

    public String getReceiptBid() {
        return receiptBid;
    }

    public void setReceiptBid(String receiptBid) {
        this.receiptBid = receiptBid == null ? null : receiptBid.trim();
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

    public String getMatCode() {
        return matCode;
    }

    public void setMatCode(String matCode) {
        this.matCode = matCode == null ? null : matCode.trim();
    }

    public String getUnitCode() {
        return unitCode;
    }
    
    

    public String getMatExt1() {
		return matExt1;
	}

	public void setMatExt1(String matExt1) {
		this.matExt1 = matExt1;
	}

	public void setUnitCode(String unitCode) {
        this.unitCode = unitCode == null ? null : unitCode.trim();
    }

    public String getBundleCode() {
        return bundleCode;
    }

    public void setBundleCode(String bundleCode) {
        this.bundleCode = bundleCode == null ? null : bundleCode.trim();
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

    public String getCorpCode() {
        return corpCode;
    }

    public void setCorpCode(String corpCode) {
        this.corpCode = corpCode == null ? null : corpCode.trim();
    }

    public String getItemNumb() {
        return itemNumb;
    }

    public void setItemNumb(String itemNumb) {
        this.itemNumb = itemNumb == null ? null : itemNumb.trim();
    }

    public String getLotNumb() {
        return lotNumb;
    }

    public void setLotNumb(String lotNumb) {
        this.lotNumb = lotNumb == null ? null : lotNumb.trim();
    }

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode == null ? null : whCode.trim();
    }

    public String getSourceTypeCode() {
        return sourceTypeCode;
    }

    public void setSourceTypeCode(String sourceTypeCode) {
        this.sourceTypeCode = sourceTypeCode == null ? null : sourceTypeCode.trim();
    }

    public String getSourceBinCode() {
        return sourceBinCode;
    }

    public void setSourceBinCode(String sourceBinCode) {
        this.sourceBinCode = sourceBinCode == null ? null : sourceBinCode.trim();
    }

    public String getTargetTypeCode() {
        return targetTypeCode;
    }

    public void setTargetTypeCode(String targetTypeCode) {
        this.targetTypeCode = targetTypeCode == null ? null : targetTypeCode.trim();
    }

    public String getTargetBinCode() {
        return targetBinCode;
    }

    public void setTargetBinCode(String targetBinCode) {
        this.targetBinCode = targetBinCode == null ? null : targetBinCode.trim();
    }

    public BigDecimal getReceiptQty() {
        return receiptQty;
    }

    public void setReceiptQty(BigDecimal receiptQty) {
        this.receiptQty = receiptQty;
    }


    public String getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus == null ? null : stockStatus.trim();
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Byte getWriteOff() {
        return writeOff;
    }

    public void setWriteOff(Byte writeOff) {
        this.writeOff = writeOff;
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
    
    private String vendorCode;

	private String vendorName;

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public Integer getTempCount() {
		return tempCount;
	}

	public void setTempCount(Integer tempCount) {
		this.tempCount = tempCount;
	}

	public boolean isFrozen() {
		return frozen;
	}

	public void setFrozen(boolean frozen) {
		this.frozen = frozen;
	}

}