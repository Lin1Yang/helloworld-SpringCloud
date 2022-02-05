package com.inossem.wms.model.sinobec.gp;

import com.inossem.wms.page.IPageResultCommon;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

@ApiModel(value = "com.inossem.wms.model.sinobec.gp.SinobecBizInputGP",description = "假接口入库")
public class SinobecBizInputGP implements IPageResultCommon {

    @ApiModelProperty(value = "po号")
    private String poCode;

    @ApiModelProperty(value = "传单号")
    private String shippingRef;

    @ApiModelProperty(value = "单据行项目序号")
    private String poRid;

    @ApiModelProperty(value = "单据类型")
    private Integer receiptType;

    @ApiModelProperty(value = "物料编码")
    private String matCode;

    @ApiModelProperty(value = "高炉")
    private String heatCode;

    @ApiModelProperty(value = "skid")
    private String skidCode;

    @ApiModelProperty(value = "单位")
    private String unitCode;

    @ApiModelProperty(value = "捆code")
    private String bundleCode;

    @ApiModelProperty(value = "")
    private String corpCode;

    @ApiModelProperty(value = "")
    private String whCode;

    @ApiModelProperty(value = "库存状态")
    private String stockStatus;

    @ApiModelProperty(value = "")
    private String itemNumb;

    @ApiModelProperty(value = "")
    private String lotNumb;

    @ApiModelProperty(value = "")
    private Integer poType;

    @ApiModelProperty(value = "单据单位code",example = "...")
    private String receiptUnitCode;

    @ApiModelProperty(value = "单据数量",example = "0.000")
    private BigDecimal receiptQty;

    @ApiModelProperty(value = "重量单位",example = "...")
    private String weightUnitCode;

    @ApiModelProperty(value = "数量（库存数量）",example = "0.000")
    private BigDecimal weightQty;

    private String matName;
    
    private String matExt1;

    private Byte receiptStatus;

    private String inWhCode;
    
    private Byte iReceiptStatus;


    private int totalCount;
    
    @ApiModelProperty(value = "Added for adjustment-in from SAP",example = "...")
    private String note;

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
    

    public SinobecBizInputGP () {

    }
    public SinobecBizInputGP(String poCode, String shippingRef, String corpCode,Integer receiptType) {
        this.poCode = poCode;
        this.shippingRef = shippingRef;
        this.corpCode = corpCode;
        this.receiptType = receiptType;
    }

    /*********** 2021-10-07 新增加 ***********/
    public SinobecBizInputGP(String poCode, String shippingRef, String corpCode,Integer receiptType, String whCode) {
        this.poCode = poCode;
        this.shippingRef = shippingRef;
        this.corpCode = corpCode;
        this.receiptType = receiptType;
        this.whCode = whCode;
    }

    public SinobecBizInputGP(String corpCode, String whCode, String poCode, BigDecimal weightQty, BigDecimal receiptQty, String poRid,
			 String sku, String bundleCode, Integer receiptType, String receiptUnitCode,String weightUnitCode, String shippingRef, String lotNumb, 
			 String vendorCode, String vendorName, String heatCode, String skidCode, String stockStatus, String itemNumb, Integer poType) {
		this.corpCode = corpCode;
		this.whCode = whCode;
		this.poCode = poCode;
		this.weightQty = weightQty;
		this.receiptQty = receiptQty;
		this.poRid = poRid;
		this.matCode = sku;
		this.bundleCode = bundleCode;
		this.receiptType = receiptType;
		this.receiptUnitCode = receiptUnitCode;
		this.weightUnitCode = weightUnitCode;
		this.shippingRef = shippingRef;
		this.lotNumb = lotNumb;
		this.vendorCode = vendorCode;
		this.vendorName = vendorName;
		this.heatCode = heatCode;
		this.skidCode = skidCode;
		this.stockStatus = stockStatus;
		this.itemNumb = itemNumb;
		this.poType = poType;
	}
    
    public String getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
    }

    public Integer getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(Integer receiptType) {
        this.receiptType = receiptType;
    }

    public String getReceiptUnitCode() {
        return receiptUnitCode;
    }

    public void setReceiptUnitCode(String receiptUnitCode) {
        this.receiptUnitCode = receiptUnitCode;
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
        this.weightUnitCode = weightUnitCode;
    }

    public BigDecimal getWeightQty() {
        return weightQty;
    }

    public void setWeightQty(BigDecimal weightQty) {
        this.weightQty = weightQty;
    }

    public String getPoCode() {
        return poCode;
    }

    public void setPoCode(String poCode) {
        this.poCode = poCode == null ? null : poCode.trim();
    }

    public String getShippingRef() {
        return shippingRef;
    }

    public void setShippingRef(String shippingRef) {
        this.shippingRef = shippingRef == null ? null : shippingRef.trim();
    }

    public String getPoRid() {
        return poRid;
    }

    public void setPoRid(String poRid) {
        this.poRid = poRid == null ? null : poRid.trim();
    }

    public String getMatCode() {
        return matCode;
    }

    public void setMatCode(String matCode) {
        this.matCode = matCode == null ? null : matCode.trim();
    }

    
    public String getMatExt1() {
		return matExt1;
	}
	public void setMatExt1(String matExt1) {
		this.matExt1 = matExt1;
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

    public String getCorpCode() {
        return corpCode;
    }

    public void setCorpCode(String corpCode) {
        this.corpCode = corpCode == null ? null : corpCode.trim();
    }

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode == null ? null : whCode.trim();
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

    public Integer getPoType() {
        return poType;
    }

    public void setPoType(Integer poType) {
        this.poType = poType;
    }

    
    

	public Byte getiReceiptStatus() {
		return iReceiptStatus;
	}
	public void setiReceiptStatus(Byte iReceiptStatus) {
		this.iReceiptStatus = iReceiptStatus;
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SinobecBizInputGP)) return false;

        SinobecBizInputGP that = (SinobecBizInputGP) o;

        if (!getPoCode().equals(that.getPoCode())) return false;
        if (!getShippingRef().equals(that.getShippingRef())) return false;
        if (!getPoRid().equals(that.getPoRid())) return false;
        return getCorpCode().equals(that.getCorpCode());
    }

    @Override
    public int hashCode() {
        int result = getPoCode().hashCode();
        result = 31 * result + getShippingRef().hashCode();
        result = 31 * result + getPoRid().hashCode();
        result = 31 * result + getCorpCode().hashCode();
        return result;
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

    public String getMatName() {
        return matName;
    }

    public void setMatName(String matName) {
        this.matName = matName;
    }
    
    private String fromStockStatus;
    
    private String toStockStatus;
    
    private String formWhCode;
    
    private String toWhCode;

	public String getFromStockStatus() {
		return fromStockStatus;
	}
	public void setFromStockStatus(String fromStockStatus) {
		this.fromStockStatus = fromStockStatus;
	}
	public String getToStockStatus() {
		return toStockStatus;
	}
	public void setToStockStatus(String toStockStatus) {
		this.toStockStatus = toStockStatus;
	}
	public String getFormWhCode() {
		return formWhCode;
	}
	public void setFormWhCode(String formWhCode) {
		this.formWhCode = formWhCode;
	}
	public String getToWhCode() {
		return toWhCode;
	}
	public void setToWhCode(String toWhCode) {
		this.toWhCode = toWhCode;
	}

    public Byte getReceiptStatus() {
        return receiptStatus;
    }

    public void setReceiptStatus(Byte receiptStatus) {
        this.receiptStatus = receiptStatus;
    }

    @Override
    public int getTotalCount() {
        return totalCount;
    }

    @Override
    public void setTotalCount(int totalCount) {
        this.totalCount=totalCount;
    }

    public String getInWhCode() {
        return inWhCode;
    }

    public void setInWhCode(String inWhCode) {
        this.inWhCode = inWhCode;
    }
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
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

    
    
}
