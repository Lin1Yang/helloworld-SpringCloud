package com.inossem.wms.model.sinobec.gp;

import com.inossem.wms.page.IPageResultCommon;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = " com.inossem.wms.model.sinobec.gp.SinobecBizOutputGp", description = "出库假接口")
public class SinobecBizOutputGp   implements IPageResultCommon {

	@ApiModelProperty(value = "单号code", example = "out002")
	private String soCode;

	@ApiModelProperty(value = "单据行项目序号", example = "1")
	private String soRid;

	@ApiModelProperty(value = "物料编码", example = "8000001")
	private String matCode;
	private String matExt1;

	@ApiModelProperty(value = "高炉", example = "SXA180000")
	private String heatCode;

	@ApiModelProperty(value = "skid", example = "18-P101T-2-051")
	private String skidCode;

	@ApiModelProperty(value = "单位编码", example = "捆")
	private String unitCode;

	@ApiModelProperty(value = "bundle编码", example = "K000001")
	private String bundleCode;

	@ApiModelProperty(value = "传单号", example = "1")
	private String shippingRef;

	@ApiModelProperty(value = "数量", example = "1")
	private BigDecimal qty;

	@ApiModelProperty(value = "公司编码", name = "corpCode", required = true, example = "A001")
	private String corpCode;

	@ApiModelProperty(value = "仓库编号", example = "S01")
	private String whCode;

	@ApiModelProperty
	private String itemNumb;

	@ApiModelProperty(value = "批次号", example = "1")
	private String lotNumb;

	@ApiModelProperty(value = "WMS参考单据类型", example = "201")
	private Integer soType;

	@ApiModelProperty(value = "单据单位code", example = "...")
	private String receiptUnitCode;

	@ApiModelProperty(value = "单据数量", example = "0.000")
	private BigDecimal receiptQty;

	@ApiModelProperty(value = "重量单位", example = "...")
	private String weightUnitCode;

	@ApiModelProperty(value = "数量（库存数量）", example = "0.000")
	private BigDecimal weightQty;

	@ApiModelProperty(value = "库存状态", example = "6")
	private String stockStatus;

	private String matName;

	private Byte receiptStatus;

	private String receiptStatusName;

	private String soTypeName;

	private String typeCode;

	private String binCode;

	private int totalCount;

	private int tempCount;

	private List<String> bundleList;

	private List<String> bundleCodeList;

	@ApiModelProperty(value = "Added for vin from SAP",example = "...")
    private String ext0;

    @ApiModelProperty(value = "Added for engine from SAP",example = "...")
    private String ext1;

    @ApiModelProperty(value = "Added for engine from SAP",example = "...")
    private String ext2;

	@ApiModelProperty(value = "Added for batch)new from SAP",example = "...")
	private String ext3;

	@ApiModelProperty(value = "Added for uom table display",example = "box: 100, pallet: 1")
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

    private String s;//用于取得是否已经保存的状态，如果s=20表示已经部分保存，如果s=null表示未开始



	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public SinobecBizOutputGp(String corpCode, String whCode, String soCode, BigDecimal weightQty, BigDecimal receiptQty, String soRid,
			  String sku, String bundleCode, Integer receiptType, String receiptUnitCode, String weightUnitCode,
			  String shippingRef, String lotNumb, String vendorCode, String vendorName,
			  String heatCode, String skidCode) {
		this.corpCode = corpCode;
		this.whCode = whCode;
		this.soCode = soCode;
		this.weightQty = weightQty;
		this.receiptQty = receiptQty;
		this.soRid = soRid;
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
	}

	public List<String> getBundleList() {
		return bundleList;
	}

	public void setBundleList(List<String> bundleList) {
		this.bundleList = bundleList;
	}

	public String getStockStatus() {
		return stockStatus;
	}

	public void setStockStatus(String stockStatus) {
		this.stockStatus = stockStatus;
	}

	public SinobecBizOutputGp(String soCode, String corpCode, Integer receiptType) {
		this.soCode = soCode;
		this.corpCode = corpCode;
		this.receiptType = receiptType;
	}


	/*************** 2021-10-08 新加*************/
	public SinobecBizOutputGp(String soCode, String corpCode, Integer receiptType, String whCode) {
		this.soCode = soCode;
		this.corpCode = corpCode;
		this.receiptType = receiptType;
		this.whCode = whCode;
	}
	/*************** 2021-10-08 新加*************/

	public SinobecBizOutputGp() {
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

	public String getShippingRef() {
		return shippingRef;
	}

	public void setShippingRef(String shippingRef) {
		this.shippingRef = shippingRef;
	}

	public String getSoCode() {
		return soCode;
	}

	public void setSoCode(String soCode) {
		this.soCode = soCode;
	}

	public String getSoRid() {
		return soRid;
	}

	public void setSoRid(String soRid) {
		this.soRid = soRid;
	}

	public String getMatCode() {
		return matCode;
	}

	public void setMatCode(String matCode) {
		this.matCode = matCode;
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

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getBundleCode() {
		return bundleCode;
	}

	public void setBundleCode(String bundleCode) {
		this.bundleCode = bundleCode;
	}

	public BigDecimal getQty() {
		return qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getWhCode() {
		return whCode;
	}

	public void setWhCode(String whCode) {
		this.whCode = whCode;
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

	public Integer getSoType() {
		return soType;
	}

	public void setSoType(Integer soType) {
		this.soType = soType;
	}

	private Integer receiptType;

	public Integer getReceiptType() {
		return receiptType;
	}

	public void setReceiptType(Integer receiptType) {
		this.receiptType = receiptType;
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




	private boolean findByShippingRef ;
	private boolean findByPallet;

	public boolean isFindByShippingRef() {
		return findByShippingRef;
	}

	public void setFindByShippingRef(boolean findByShippingRef) {
		this.findByShippingRef = findByShippingRef;
	}

	public boolean isFindByPallet() {
		return findByPallet;
	}

	public void setFindByPallet(boolean findByPallet) {
		this.findByPallet = findByPallet;
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

	public String getReceiptStatusName() {
		return receiptStatusName;
	}

	public void setReceiptStatusName(String receiptStatusName) {
		this.receiptStatusName = receiptStatusName;
	}

	public String getSoTypeName() {
		return soTypeName;
	}

	public void setSoTypeName(String soTypeName) {
		this.soTypeName = soTypeName;
	}

	@Override
	public int getTotalCount() {
		return totalCount;
	}

	@Override
	public void setTotalCount(int totalCount) {
		this.totalCount=totalCount;
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

	public List<String> getBundleCodeList() {
		return bundleCodeList;
	}

	public void setBundleCodeList(List<String> bundleCodeList) {
		this.bundleCodeList = bundleCodeList;
	}

	public int getTempCount() {
		return tempCount;
	}

	public void setTempCount(int tempCount) {
		this.tempCount = tempCount;
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

	public String getMatExt1() {
		return matExt1;
	}

	public void setMatExt1(String matExt1) {
		this.matExt1 = matExt1;
	}
	
	
}
