package com.inossem.wms.model.sinobec.stock;

import com.inossem.wms.model.sinobec.SinobecStock;
import com.inossem.wms.page.IPageResultCommon;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

public class SinobecStockVo extends SinobecStock   implements IPageResultCommon {

	private String receiptCode;

	private String receiptRid;

	private Integer receiptType;

	private String heatCode;

	private String skidCode;

	private String matCode;
	
	private String matName;

	private String corpCode;

	private String itemNumb;

	private String lotNumb;

	private Date inputDate;

	@ApiModelProperty(value="在库天数", name="daysLibrary",  required=true)
	private Integer daysLibrary;

	private String stockStatus;
	
	private String binWeightUnitCode;
	
	private BigDecimal currentWeight;
	private BigDecimal weightMax;

	private int totalCount;
	
	private String typeName;

	private String aging;

	private String corpCodeIns;
	private String corpCodeGp;
	private BigDecimal weightQtyIns;
	private BigDecimal receiptQtyIns;
	private BigDecimal weightQtyGp;
	private BigDecimal receiptQtyGp;

	private String inputCode;
	private String remark;
	
	private String matGroupName;
	
    private String ext0;
    
    private String ext1;

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

	@Override
	public int getTotalCount() {
		return totalCount;
	}

	@Override
	public void setTotalCount(int totalCount) {
		this.totalCount=totalCount;
	}
	public Integer getDaysLibrary() {
		return daysLibrary;
	}

	public void setDaysLibrary(Integer daysLibrary) {
		this.daysLibrary = daysLibrary;
	}

	public String getReceiptCode() {
		return receiptCode;
	}

	public void setReceiptCode(String receiptCode) {
		this.receiptCode = receiptCode;
	}

	@Override
	public String getReceiptRid() {
		return receiptRid;
	}

	@Override
    public void setReceiptRid(String receiptRid) {
		this.receiptRid = receiptRid;
	}

	public Integer getReceiptType() {
		return receiptType;
	}

	public void setReceiptType(Integer receiptType) {
		this.receiptType = receiptType;
	}

	public String getHeatCode() {
		return heatCode;
	}

	public void setHeatCode(String heatCode) {
		this.heatCode = heatCode;
	}

	public String getSkidCode() {
		return skidCode;
	}

	public void setSkidCode(String skidCode) {
		this.skidCode = skidCode;
	}

	public String getMatCode() {
		return matCode;
	}

	public void setMatCode(String matCode) {
		this.matCode = matCode;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getItemNumb() {
		return itemNumb;
	}

	public void setItemNumb(String itemNumb) {
		this.itemNumb = itemNumb;
	}

	public String getLotNumb() {
		return lotNumb;
	}

	public void setLotNumb(String lotNumb) {
		this.lotNumb = lotNumb;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public String getStockStatus() {
		return stockStatus;
	}

	public void setStockStatus(String stockStatus) {
		this.stockStatus = stockStatus;
	}

	public String getBinWeightUnitCode() {
		return binWeightUnitCode;
	}

	public void setBinWeightUnitCode(String binWeightUnitCode) {
		this.binWeightUnitCode = binWeightUnitCode;
	}

	public BigDecimal getCurrentWeight() {
		return currentWeight;
	}

	public void setCurrentWeight(BigDecimal currentWeight) {
		this.currentWeight = currentWeight;
	}

	public BigDecimal getWeightMax() {
		return weightMax;
	}

	public void setWeightMax(BigDecimal weightMax) {
		this.weightMax = weightMax;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
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
	
	private boolean matched ;

	public boolean isMatched() {
		return matched;
	}

	public void setMatched(boolean matched) {
		this.matched = matched;
	}

	public String getMatName() {
		return matName;
	}

	public void setMatName(String matName) {
		this.matName = matName;
	}

	public String getAging() {
		return aging;
	}

	public void setAging(String aging) {
		this.aging = aging;
	}

	public String getCorpCodeIns() {
		return corpCodeIns;
	}

	public void setCorpCodeIns(String corpCodeIns) {
		this.corpCodeIns = corpCodeIns;
	}

	public String getCorpCodeGp() {
		return corpCodeGp;
	}

	public void setCorpCodeGp(String corpCodeGp) {
		this.corpCodeGp = corpCodeGp;
	}

	public BigDecimal getWeightQtyIns() {
		return weightQtyIns;
	}

	public void setWeightQtyIns(BigDecimal weightQtyIns) {
		this.weightQtyIns = weightQtyIns;
	}

	public BigDecimal getReceiptQtyIns() {
		return receiptQtyIns;
	}

	public void setReceiptQtyIns(BigDecimal receiptQtyIns) {
		this.receiptQtyIns = receiptQtyIns;
	}

	public BigDecimal getWeightQtyGp() {
		return weightQtyGp;
	}

	public void setWeightQtyGp(BigDecimal weightQtyGp) {
		this.weightQtyGp = weightQtyGp;
	}

	public BigDecimal getReceiptQtyGp() {
		return receiptQtyGp;
	}

	public void setReceiptQtyGp(BigDecimal receiptQtyGp) {
		this.receiptQtyGp = receiptQtyGp;
	}

	public String getInputCode() {
		return inputCode;
	}

	public void setInputCode(String inputCode) {
		this.inputCode = inputCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getMatGroupName() {
		return matGroupName;
	}

	public void setMatGroupName(String matGroupName) {
		this.matGroupName = matGroupName;
	}
}
