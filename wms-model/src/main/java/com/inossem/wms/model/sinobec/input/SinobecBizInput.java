package com.inossem.wms.model.sinobec.input;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.sinobec.input.SinobecBizInput")
public class SinobecBizInput {
    @ApiModelProperty(value="inputId")
    private Integer inputId;

    @ApiModelProperty(value="receiptCode单号code")
    private String receiptCode;

    @ApiModelProperty(value="receiptRid单据行项目序号")
    private String receiptRid;

    @ApiModelProperty(value="receiptTypeWMS参考单据类型")
    private Integer receiptType;

    @ApiModelProperty(value="receiptStatus单据状态 10 草稿  60 已完成 ")
    private Byte receiptStatus;

    @ApiModelProperty(value="matCode物料编码")
    private String matCode;
    
    private String matExt1;

    @ApiModelProperty(value="unitCode单位")
    private String unitCode;

    @ApiModelProperty(value="bundleCode捆code")
    private String bundleCode;

    @ApiModelProperty(value="shippingRef传单号")
    private String shippingRef;

    @ApiModelProperty(value="heatCode高炉")
    private String heatCode;

    @ApiModelProperty(value="skidCodeskid")
    private String skidCode;

    @ApiModelProperty(value="corpCode公司")
    private String corpCode;

    @ApiModelProperty(value="itemNumb")
    private String itemNumb;

    @ApiModelProperty(value="lotNumb批次")
    private String lotNumb;

    @ApiModelProperty(value="whCode仓库code")
    private String whCode;

    @ApiModelProperty(value="typeCode存储类型code")
    private String typeCode;

    @ApiModelProperty(value="binCode仓位code")
    private String binCode;

    @ApiModelProperty(value="receiptUnitCode单据单位code")
    private String receiptUnitCode;

    @ApiModelProperty(value="receiptQty单据数量  与unit_code对应")
    private BigDecimal receiptQty;

    @ApiModelProperty(value="weightUnitCode重量单位(单据传入重量单位)")
    private String weightUnitCode;

    @ApiModelProperty(value="weightQty数量   （库存数量）")
    private BigDecimal weightQty;

    @ApiModelProperty(value="actualWeightQty实际数量")
    private BigDecimal actualWeightQty;

    @ApiModelProperty(value="stockStatus库存状态")
    private String stockStatus;

    @ApiModelProperty(value="isDelete删除标识0-false, 1-true")
    private Byte isDelete;

    @ApiModelProperty(value="writeOff冲销标志0-false, 1-true")
    private Byte writeOff;

    @ApiModelProperty(value="createTime创建时间")
    private Date createTime;

    @ApiModelProperty(value="modifyTime修改时间")
    private Date modifyTime;

    @ApiModelProperty(value="createUserId创建人ID")
    private Integer createUserId;

    @ApiModelProperty(value="modifyUserId修改人ID")
    private Integer modifyUserId;
    
    private String remark;
    
    private Long status;
    
    private Long status1;
    
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
   
    
	public Long getStatus1() {
		return status1;
	}

	public void setStatus1(Long status1) {
		this.status1 = status1;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Integer getInputId() {
        return inputId;
    }

    public void setInputId(Integer inputId) {
        this.inputId = inputId;
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

    public String getReceiptUnitCode() {
        return receiptUnitCode;
    }

    public void setReceiptUnitCode(String receiptUnitCode) {
        this.receiptUnitCode = receiptUnitCode == null ? null : receiptUnitCode.trim();
    }

    public BigDecimal getReceiptQty() {
        return receiptQty;
    }

    public void setReceiptQty(BigDecimal receiptQty) {
        this.receiptQty = receiptQty;
    }

    public String getWeightUnitCode() {
        return weightUnitCode;
    }

    public void setWeightUnitCode(String weightUnitCode) {
        this.weightUnitCode = weightUnitCode == null ? null : weightUnitCode.trim();
    }

    public BigDecimal getWeightQty() {
        return weightQty;
    }

    public void setWeightQty(BigDecimal weightQty) {
        this.weightQty = weightQty;
    }

    public BigDecimal getActualWeightQty() {
        return actualWeightQty;
    }

    public void setActualWeightQty(BigDecimal actualWeightQty) {
        this.actualWeightQty = actualWeightQty;
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
    

    public String getMatExt1() {
		return matExt1;
	}

	public void setMatExt1(String matExt1) {
		this.matExt1 = matExt1;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SinobecBizInput)) return false;

        SinobecBizInput that = (SinobecBizInput) o;

        if (!getReceiptCode().equals(that.getReceiptCode())) return false;
        if (!getReceiptRid().equals(that.getReceiptRid())) return false;
        if (!getReceiptType().equals(that.getReceiptType())) return false;
        if (!getShippingRef().equals(that.getShippingRef())) return false;
        if (!getBundleCode().equals(that.getBundleCode())) return false;
        return getCorpCode().equals(that.getCorpCode());
    }

    @Override
    public int hashCode() {
        int result = getReceiptCode().hashCode();
        result = 31 * result + getReceiptRid().hashCode();
        result = 31 * result + getReceiptType().hashCode();
        result = 31 * result + getShippingRef().hashCode();
        result = 31 * result + getBundleCode().hashCode();
        result = 31 * result + getCorpCode().hashCode();
        return result;
    }
    
    /**
     * 差异数量
     */
    private BigDecimal difference;

	public BigDecimal getDifference() {
		return difference;
	}

	public void setDifference(BigDecimal difference) {
		this.difference = difference;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
