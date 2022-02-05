package com.inossem.wms.model.biz;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.inossem.wms.constant.Const;

import io.swagger.annotations.ApiModelProperty;

public class BizStockTask implements Serializable{
 
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value="作业申请主键", name="", example="",required=false)
	private Integer stockTaskId;
	@ApiModelProperty(value="作业申请号", name="", example="",required=false)
    private String stockTaskCode;
	@ApiModelProperty(value="作业申请行项目序号", name="", example="",required=false)
    private String stockTaskRid;
	@ApiModelProperty(value="作业申请号", name="", example="",required=false)
    private String stockTaskReqCode;
	@ApiModelProperty(value="作业申请行项目序号", name="", example="",required=false)
    private String stockTaskReqRid;
	@ApiModelProperty(value="单据类型", name="", example="",required=false)
    private Integer receiptType;
	@ApiModelProperty(value="前续单据类型", name="", example="",required=false)
    private Integer preReceiptType;
	@ApiModelProperty(value="前续单据编号", name="", example="",required=false)
    private String preReceiptCode;
	@ApiModelProperty(value="前续单据行号", name="", example="",required=false)
    private String preReceiptRid;
	@ApiModelProperty(value="前续单据bid", name="", example="",required=false)
    private String preReceiptBid;
	@ApiModelProperty(value="head状态", name="", example="")
    private Byte receiptStatus;
	@ApiModelProperty(value="行项目状态", name="", example="")
    private Byte itemStatus;
	@ApiModelProperty(value="工厂", name="", example="")
    private String ftyCode;
	@ApiModelProperty(value="库存地点", name="", example="")
    private String locationCode;
	@ApiModelProperty(value="运输方式", name="", example="")
    private String shipType;
	@ApiModelProperty(value="司机", name="", example="")
    private String driver;
	@ApiModelProperty(value="理货员", name="", example="")
    private String tallyClerk;
	@ApiModelProperty(value="车辆", name="", example="")
    private String vehicle;
	
	@ApiModelProperty(value="叉车工", name="", example="")
	private String taskForkliftDriverCode;
	
	@ApiModelProperty(value="理货员", name="", example="")
	private String taskTallymanCode;
	
	@ApiModelProperty(value="仓库号", name="", example="")
    private String whCode;
	@ApiModelProperty(value="原存储类型", name="", example="")
    private String sourceTypeCode;
	@ApiModelProperty(value="原仓位", name="", example="")
    private String sourceBinCode;
	@ApiModelProperty(value="原存储单元", name="", example="")
    private String sourceCellCode;
	@ApiModelProperty(value="目标储存类型", name="", example="")
    private String targetTypeCode;
	@ApiModelProperty(value="目标储存区", name="", example="")
    private String targetBinCode;
	@ApiModelProperty(value="目标存储单元", name="", example="")
    private String targetCellCode;
	@ApiModelProperty(value="物料编码", name="", example="")
    private String matCode;
	@ApiModelProperty(value="库存状态 \\n10-非限制库存 ,20-在途库存,30-质量检验库存 ,40-冻结的库存\\ndebit_credit为S 时 目标库存状态  debit_credit 为H时 源库存状态", name="", example="")
    private Byte stockStatus;
	@ApiModelProperty(value="库存类型", name="", example="",required=false)
    private Byte stockType;
	@ApiModelProperty(value="批号", name="", example="")
    private String batch;
	@ApiModelProperty(value="erp批次", name="", example="")
    private String batchErp;
	@ApiModelProperty(value="生产批次", name="", example="")
    private String batchProduction;
	@ApiModelProperty(value="包装类型", name="", example="")
    private String packageType;
	@ApiModelProperty(value="特殊库存标识", name="", example="",required=false)
    private String specStock;
	@ApiModelProperty(value="特殊库存编号", name="", example="",required=false)
    private String specStockCode;
	@ApiModelProperty(value="特殊库存描述", name="", example="",required=false)
    private String specStockName;
	@ApiModelProperty(value="数量", name="", example="",required=false)
    private BigDecimal qty;
	@ApiModelProperty(value="原库存数量数量", name="", example="",required=false)
    private BigDecimal sourceQty;
	@ApiModelProperty(value="基本计量单位", name="", example="")
    private String unitCode;
	@ApiModelProperty(value="物料凭证编号", name="", example="",required=false)
    private Integer insDocCode;
	@ApiModelProperty(value="物料凭证中的项目", name="", example="",required=false)
    private String insDocRid;
	@ApiModelProperty(value="收货日期", name="", example="",required=false)
    private Date takeDeliveryDate;
	@ApiModelProperty(value="物料重量", name="", example="",required=false)
    private BigDecimal weight;
	@ApiModelProperty(value="重量单位", name="", example="",required=false)
    private String weightUnitCode;
	@ApiModelProperty(value="有效期止", name="", example="",required=false)
    private Date validityDate;
	@ApiModelProperty(value="采购订创建人", name="", example="",required=false)
    private String purchaseReceiptCreateUserName;
	@ApiModelProperty(value="采购订单创建时间", name="", example="",required=false)
    private Date purchaseReceiptCreateTime;
	@ApiModelProperty(value="采购订单号", name="", example="",required=false)
    private String purchaseReceiptCode;
	@ApiModelProperty(value="采购订单类型", name="", example="",required=false)
    private String purchaseReceiptType;
	@ApiModelProperty(value="采购订单类型描述", name="", example="",required=false)
    private String purchaseReceiptTypeName;
	@ApiModelProperty(value="采购组", name="", example="",required=false)
    private String purchaseGroupCode;
	@ApiModelProperty(value="采购组描述", name="", example="",required=false)
    private String purchaseGroupName;
	@ApiModelProperty(value="采购组织", name="", example="",required=false)
    private String purchaseOrganizationCode;
	@ApiModelProperty(value="采购组织描述", name="", example="",required=false)
    private String purchaseOrganizationName;
	@ApiModelProperty(value="合同编号", name="", example="",required=false)
    private String contractCode;
	@ApiModelProperty(value="合同描述", name="", example="",required=false)
    private String contractName;
	@ApiModelProperty(value="供应商代码", name="", example="",required=false) 
    private String supplierCode;
	@ApiModelProperty(value="供应商名称", name="", example="",required=false)
    private String supplierName;
	@ApiModelProperty(value="生产订单号", name="", example="",required=false)
    private String productionReceiptCode;
	@ApiModelProperty(value="生产订单类型", name="", example="",required=false)
    private String productionReceiptType;
	@ApiModelProperty(value="生产订单类型描述", name="", example="",required=false)
    private String productionReceiptTypeName;
	@ApiModelProperty(value="生产订单创建人", name="", example="",required=false)
    private String productionReceiptCreateUserName;
	@ApiModelProperty(value="生产订单创建日期", name="", example="",required=false)
    private Date productionReceiptCreateTime;
	@ApiModelProperty(value="MRP组code", name="", example="",required=false)
    private String mrpGroupCode;
	@ApiModelProperty(value="MRP组描述", name="", example="",required=false)
    private String mrpGroupName;
	@ApiModelProperty(value="计划员", name="", example="",required=false)
    private String planUserName;
	@ApiModelProperty(value="生产订单描述", name="", example="",required=false)
    private String productionReceiptDescription;
	@ApiModelProperty(value="外向交货单据号", name="", example="",required=false)
    private String deliveryOutwardCode;
	@ApiModelProperty(value="销售订单", name="", example="",required=false)
    private String saleReceiptCode;
	@ApiModelProperty(value="SAP预留单号", name="", example="",required=false)
    private String reserveCode;
	@ApiModelProperty(value="移动类型", name="", example="",required=false)
    private String moveTypeCode;
	@ApiModelProperty(value="移动类型特殊库存标识", name="", example="",required=false)
    private String moveTypeSpecStock;
	@ApiModelProperty(value="销售组", name="", example="",required=false)
    private String saleGroupCode;
	@ApiModelProperty(value="销售组描述", name="", example="",required=false)
    private String saleGroupName;
	@ApiModelProperty(value="销售组织编码", name="", example="",required=false)
    private String saleOrganizationCode;
	@ApiModelProperty(value="销售组织描述", name="", example="",required=false)
    private String saleOrganizationName;
	@ApiModelProperty(value="预留号:成本对象", name="", example="",required=false)
    private String reserveCostObjCode;
	@ApiModelProperty(value="预留号:成本对象描述", name="", example="",required=false)
    private String reserveCostObjName;
	@ApiModelProperty(value="成本中心编码", name="", example="",required=false)
    private String reserveCostCenterCode;
	@ApiModelProperty(value="成本中心描述", name="", example="",required=false)
    private String reserveCostCenterName;
	@ApiModelProperty(value="客户编号", name="", example="",required=false)
    private String customerCode;
	@ApiModelProperty(value="客户名称", name="", example="",required=false)
    private String customerName;
	@ApiModelProperty(value="收货方code", name="", example="",required=false)
    private String receivingPartyCode;
	@ApiModelProperty(value="收货方", name="", example="",required=false)
    private String receivingPartyName;
	@ApiModelProperty(value="销售单创建人", name="", example="",required=false)
    private String saleReceiptCreateUserName;
    @ApiModelProperty(value="销售单创建时间", name="", example="",required=false)
    private Date saleReceiptCreateTime;
    @ApiModelProperty(value="预留号:创建人", name="", example="",required=false)
    private String reserveCreateUser;
    @ApiModelProperty(value="预留号:创建日期", name="", example="",required=false)
    private Date reserveCreateTime;
    @ApiModelProperty(value="行项目备注", name="", example="",required=false)
    private String itemRemark;
    @ApiModelProperty(value=" 0 未冲销  1冲销", name="", example="",required=false)
    private Byte writeOff;
    @ApiModelProperty(value = "核销标识  0 未核销 1 已核销")
    private Byte debtOffset;
    @ApiModelProperty(value = "0web 1pda 2pad 3手机")
    private Byte requestSource;
    @ApiModelProperty(value = "指令code")
    private String instructionsCode;
    @ApiModelProperty(value = "指令rid")
    private String instructionsRid;
    @ApiModelProperty(value="删除标识，0正常，1已删除", name="", example="",required=false)
    private Byte isDelete;
    @ApiModelProperty(value="创建时间", name="", example="",required=false)
    private Date createTime;
    @ApiModelProperty(value="创建人id", name="", example="",required=false)
    private Integer createUserId;
    @ApiModelProperty(value="修改时间", name="", example="",required=false)
    private Date modifyTime;
    @ApiModelProperty(value="修改人id", name="", example="",required=false)
    private Integer modifyUserId;
    @ApiModelProperty(value="扩展字段0", name="", example="",required=false)
    private String stockTaskExt0;
    @ApiModelProperty(value="扩展字段1", name="", example="",required=false)
    private String stockTaskExt1;
    @ApiModelProperty(value="扩展字段2", name="", example="",required=false)
    private String stockTaskExt2;
    @ApiModelProperty(value="扩展字段3", name="", example="",required=false)
    private String stockTaskExt3;
    @ApiModelProperty(value="扩展字段4", name="", example="",required=false)
    private String stockTaskExt4;
    @ApiModelProperty(value="扩展字段5", name="", example="",required=false)
    private String stockTaskExt5;
    @ApiModelProperty(value="扩展字段6", name="", example="",required=false)
    private String stockTaskExt6;
    @ApiModelProperty(value="扩展字段7", name="", example="",required=false)
    private String stockTaskExt7;
    @ApiModelProperty(value="扩展字段8", name="", example="",required=false)
    private String stockTaskExt8;
    @ApiModelProperty(value="扩展字段9", name="", example="",required=false)
    private String stockTaskExt9;

    public Integer getStockTaskId() {
        return stockTaskId = stockTaskId == null ? Const.ZERO : stockTaskId;
    }

    public void setStockTaskId(Integer stockTaskId) {
        this.stockTaskId = stockTaskId;
    }

    public String getStockTaskCode() {
        return stockTaskCode = stockTaskCode == null ? Const.STRING_EMPTY : stockTaskCode;
    }

    public void setStockTaskCode(String stockTaskCode) {
        this.stockTaskCode = stockTaskCode == null ? null : stockTaskCode.trim();
    }

	public String getStockTaskRid() {
        return stockTaskRid = stockTaskRid == null ? Const.STRING_EMPTY : stockTaskRid;
    }

    public void setStockTaskRid(String stockTaskRid) {
        this.stockTaskRid = stockTaskRid == null ? null : stockTaskRid.trim();
    }

    public String getStockTaskReqCode() {
        return stockTaskReqCode = stockTaskReqCode == null ? Const.STRING_EMPTY : stockTaskReqCode;
    }

    public void setStockTaskReqCode(String stockTaskReqCode) {
        this.stockTaskReqCode = stockTaskReqCode == null ? null : stockTaskReqCode.trim();
    }

    public String getStockTaskReqRid() {
        return stockTaskReqRid = stockTaskReqRid == null ? Const.STRING_EMPTY : stockTaskReqRid;
    }

    public void setStockTaskReqRid(String stockTaskReqRid) {
        this.stockTaskReqRid = stockTaskReqRid == null ? null : stockTaskReqRid.trim();
    }

    public Integer getReceiptType() {
        return receiptType = receiptType == null ? Const.ZERO : receiptType;
    }

    public void setReceiptType(Integer receiptType) {
        this.receiptType = receiptType;
    }

    public Integer getPreReceiptType() {
        return preReceiptType = preReceiptType == null ? Const.ZERO : preReceiptType;
    }

    public void setPreReceiptType(Integer preReceiptType) {
        this.preReceiptType = preReceiptType;
    }

    public String getPreReceiptCode() {
        return preReceiptCode = preReceiptCode == null ? Const.STRING_EMPTY : preReceiptCode;
    }

    public void setPreReceiptCode(String preReceiptCode) {
        this.preReceiptCode = preReceiptCode == null ? null : preReceiptCode.trim();
    }

    public String getPreReceiptRid() {
        return preReceiptRid = preReceiptRid == null ? Const.STRING_EMPTY : preReceiptRid;
    }

    public void setPreReceiptRid(String preReceiptRid) {
        this.preReceiptRid = preReceiptRid == null ? null : preReceiptRid.trim();
    }

    public String getPreReceiptBid() {
		return preReceiptBid = preReceiptBid == null ? Const.STRING_EMPTY : preReceiptBid;
	}

	public void setPreReceiptBid(String preReceiptBid) {
		this.preReceiptBid = preReceiptBid;
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

    public String getFtyCode() {
        return ftyCode = ftyCode == null ? Const.STRING_EMPTY : ftyCode;
    }

    public void setFtyCode(String ftyCode) {
        this.ftyCode = ftyCode == null ? null : ftyCode.trim();
    }

    public String getLocationCode() {
        return locationCode = locationCode == null ? Const.STRING_EMPTY : locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode == null ? null : locationCode.trim();
    }

    public String getShipType() {
        return shipType = shipType == null ? Const.STRING_EMPTY : shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType == null ? null : shipType.trim();
    }

    public String getDriver() {
        return driver = driver == null ? Const.STRING_EMPTY : driver;
    }

    public void setDriver(String driver) {
        this.driver = driver == null ? null : driver.trim();
    }

    public String getVehicle() {
        return vehicle = vehicle == null ? Const.STRING_EMPTY : vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle == null ? null : vehicle.trim();
    }

    public String getTaskForkliftDriverCode() {
		return taskForkliftDriverCode = taskForkliftDriverCode == null ? Const.STRING_EMPTY : taskForkliftDriverCode;
	}

	public void setTaskForkliftDriverCode(String taskForkliftDriverCode) {
		this.taskForkliftDriverCode = taskForkliftDriverCode;
	}

	public String getTaskTallymanCode() {
		return taskTallymanCode = taskTallymanCode == null ? Const.STRING_EMPTY : taskTallymanCode;
	}

	public void setTaskTallymanCode(String taskTallymanCode) {
		this.taskTallymanCode = taskTallymanCode;
	}

	public String getWhCode() {
        return whCode = whCode == null ? Const.STRING_EMPTY : whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode == null ? null : whCode.trim();
    }

    public String getSourceTypeCode() {
        return sourceTypeCode = sourceTypeCode == null ? Const.STRING_EMPTY : sourceTypeCode;
    }

    public void setSourceTypeCode(String sourceTypeCode) {
        this.sourceTypeCode = sourceTypeCode == null ? null : sourceTypeCode.trim();
    }

    public String getSourceBinCode() {
        return sourceBinCode = sourceBinCode == null ? Const.STRING_EMPTY : sourceBinCode;
    }

    public void setSourceBinCode(String sourceBinCode) {
        this.sourceBinCode = sourceBinCode == null ? null : sourceBinCode.trim();
    }

    public String getSourceCellCode() {
        return sourceCellCode = sourceCellCode == null ? Const.STRING_EMPTY : sourceCellCode;
    }

    public void setSourceCellCode(String sourceCellCode) {
        this.sourceCellCode = sourceCellCode == null ? null : sourceCellCode.trim();
    }

    public String getTargetTypeCode() {
        return targetTypeCode = targetTypeCode == null ? Const.STRING_EMPTY : targetTypeCode;
    }

    public void setTargetTypeCode(String targetTypeCode) {
        this.targetTypeCode = targetTypeCode == null ? null : targetTypeCode.trim();
    }

    public String getTargetBinCode() {
        return targetBinCode = targetBinCode == null ? Const.STRING_EMPTY : targetBinCode;
    }

    public void setTargetBinCode(String targetBinCode) {
        this.targetBinCode = targetBinCode == null ? null : targetBinCode.trim();
    }

    public String getTargetCellCode() {
        return targetCellCode = targetCellCode == null ? Const.STRING_EMPTY : targetCellCode;
    }

    public void setTargetCellCode(String targetCellCode) {
        this.targetCellCode = targetCellCode == null ? null : targetCellCode.trim();
    }

    public String getMatCode() {
        return matCode = matCode == null ? Const.STRING_EMPTY : matCode;
    }

    public void setMatCode(String matCode) {
        this.matCode = matCode == null ? null : matCode.trim();
    }

    public Byte getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(Byte stockStatus) {
        this.stockStatus = stockStatus;
    }

    public Byte getStockType() {
        return stockType;
    }

    public void setStockType(Byte stockType) {
        this.stockType = stockType;
    }

    public String getBatch() {
        return batch = batch == null ? Const.STRING_EMPTY : batch;
    }

    public void setBatch(String batch) {
        this.batch = batch == null ? null : batch.trim();
    }

    public String getBatchErp() {
        return batchErp = batchErp == null ? Const.STRING_EMPTY : batchErp;
    }

    public void setBatchErp(String batchErp) {
        this.batchErp = batchErp == null ? null : batchErp.trim().toUpperCase();
    }

    public String getBatchProduction() {
        return batchProduction = batchProduction == null ? Const.STRING_EMPTY : batchProduction;
    }

    public void setBatchProduction(String batchProduction) {
        this.batchProduction = batchProduction == null ? null : batchProduction.trim();
    }

    public String getPackageType() {
        return packageType = packageType == null ? Const.STRING_EMPTY : packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType == null ? null : packageType.trim();
    }

    public String getSpecStock() {
        return specStock = specStock == null ? Const.STRING_EMPTY : specStock;
    }

    public void setSpecStock(String specStock) {
        this.specStock = specStock == null ? null : specStock.trim();
    }

    public String getSpecStockCode() {
        return specStockCode = specStockCode == null ? Const.STRING_EMPTY : specStockCode;
    }

    public void setSpecStockCode(String specStockCode) {
        this.specStockCode = specStockCode == null ? null : specStockCode.trim();
    }

    public String getSpecStockName() {
        return specStockName = specStockName == null ? Const.STRING_EMPTY : specStockName;
    }

    public void setSpecStockName(String specStockName) {
        this.specStockName = specStockName == null ? null : specStockName.trim();
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public String getUnitCode() {
        return unitCode = unitCode == null ? Const.STRING_EMPTY : unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode == null ? null : unitCode.trim();
    }

    public Integer getInsDocCode() {
        return insDocCode;
    }

    public void setInsDocCode(Integer insDocCode) {
        this.insDocCode = insDocCode;
    }

    public String getInsDocRid() {
        return insDocRid = insDocRid == null ? Const.STRING_EMPTY : insDocRid;
    }

    public void setInsDocRid(String insDocRid) {
        this.insDocRid = insDocRid == null ? null : insDocRid.trim();
    }

    public Date getTakeDeliveryDate() {
        return takeDeliveryDate;
    }

    public void setTakeDeliveryDate(Date takeDeliveryDate) {
        this.takeDeliveryDate = takeDeliveryDate;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getWeightUnitCode() {
        return weightUnitCode = weightUnitCode == null ? Const.STRING_EMPTY : weightUnitCode;
    }

    public void setWeightUnitCode(String weightUnitCode) {
        this.weightUnitCode = weightUnitCode == null ? null : weightUnitCode.trim();
    }

    public Date getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(Date validityDate) {
        this.validityDate = validityDate;
    }

    public String getPurchaseReceiptCreateUserName() {
        return purchaseReceiptCreateUserName = purchaseReceiptCreateUserName == null ? Const.STRING_EMPTY : purchaseReceiptCreateUserName;
    }

    public void setPurchaseReceiptCreateUserName(String purchaseReceiptCreateUserName) {
        this.purchaseReceiptCreateUserName = purchaseReceiptCreateUserName == null ? null : purchaseReceiptCreateUserName.trim();
    }

    public Date getPurchaseReceiptCreateTime() {
        return purchaseReceiptCreateTime;
    }

    public void setPurchaseReceiptCreateTime(Date purchaseReceiptCreateTime) {
        this.purchaseReceiptCreateTime = purchaseReceiptCreateTime;
    }

    public String getPurchaseReceiptCode() {
        return purchaseReceiptCode = purchaseReceiptCode == null ? Const.STRING_EMPTY : purchaseReceiptCode;
    }

    public void setPurchaseReceiptCode(String purchaseReceiptCode) {
        this.purchaseReceiptCode = purchaseReceiptCode == null ? null : purchaseReceiptCode.trim();
    }

    public String getPurchaseReceiptType() {
        return purchaseReceiptType = purchaseReceiptType == null ? Const.STRING_EMPTY : purchaseReceiptType;
    }

    public void setPurchaseReceiptType(String purchaseReceiptType) {
        this.purchaseReceiptType = purchaseReceiptType == null ? null : purchaseReceiptType.trim();
    }

    public String getPurchaseReceiptTypeName() {
        return purchaseReceiptTypeName = purchaseReceiptTypeName == null ? Const.STRING_EMPTY : purchaseReceiptTypeName;
    }

    public void setPurchaseReceiptTypeName(String purchaseReceiptTypeName) {
        this.purchaseReceiptTypeName = purchaseReceiptTypeName == null ? null : purchaseReceiptTypeName.trim();
    }

    public String getPurchaseGroupCode() {
        return purchaseGroupCode = purchaseGroupCode == null ? Const.STRING_EMPTY : purchaseGroupCode;
    }

    public void setPurchaseGroupCode(String purchaseGroupCode) {
        this.purchaseGroupCode = purchaseGroupCode == null ? null : purchaseGroupCode.trim();
    }

    public String getPurchaseGroupName() {
        return purchaseGroupName;
    }

    public void setPurchaseGroupName(String purchaseGroupName) {
        this.purchaseGroupName = purchaseGroupName == null ? null : purchaseGroupName.trim();
    }

    public String getPurchaseOrganizationCode() {
        return purchaseOrganizationCode = purchaseOrganizationCode == null ? Const.STRING_EMPTY : purchaseOrganizationCode;
    }

    public void setPurchaseOrganizationCode(String purchaseOrganizationCode) {
        this.purchaseOrganizationCode = purchaseOrganizationCode == null ? null : purchaseOrganizationCode.trim();
    }

    public String getPurchaseOrganizationName() {
        return purchaseOrganizationName = purchaseOrganizationName == null ? Const.STRING_EMPTY : purchaseOrganizationName;
    }

    public void setPurchaseOrganizationName(String purchaseOrganizationName) {
        this.purchaseOrganizationName = purchaseOrganizationName == null ? null : purchaseOrganizationName.trim();
    }

    public String getContractCode() {
        return contractCode = contractCode == null ? Const.STRING_EMPTY : contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode == null ? null : contractCode.trim();
    }

    public String getContractName() {
        return contractName = contractName == null ? Const.STRING_EMPTY : contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName == null ? null : contractName.trim();
    }

    public String getSupplierCode() {
		return supplierCode = supplierCode == null ? Const.STRING_EMPTY : supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getSupplierName() {
		return supplierName = supplierName == null ? Const.STRING_EMPTY : supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getProductionReceiptCode() {
        return productionReceiptCode = productionReceiptCode == null ? Const.STRING_EMPTY : productionReceiptCode;
    }

    public void setProductionReceiptCode(String productionReceiptCode) {
        this.productionReceiptCode = productionReceiptCode == null ? null : productionReceiptCode.trim();
    }

    public String getProductionReceiptType() {
        return productionReceiptType = productionReceiptType == null ? Const.STRING_EMPTY : productionReceiptType;
    }

    public void setProductionReceiptType(String productionReceiptType) {
        this.productionReceiptType = productionReceiptType == null ? null : productionReceiptType.trim();
    }

    public String getProductionReceiptTypeName() {
        return productionReceiptTypeName = productionReceiptTypeName == null ? Const.STRING_EMPTY : productionReceiptTypeName;
    }

    public void setProductionReceiptTypeName(String productionReceiptTypeName) {
        this.productionReceiptTypeName = productionReceiptTypeName == null ? null : productionReceiptTypeName.trim();
    }

    public String getProductionReceiptCreateUserName() {
        return productionReceiptCreateUserName = productionReceiptCreateUserName == null ? Const.STRING_EMPTY : productionReceiptCreateUserName;
    }

    public void setProductionReceiptCreateUserName(String productionReceiptCreateUserName) {
        this.productionReceiptCreateUserName = productionReceiptCreateUserName == null ? null : productionReceiptCreateUserName.trim();
    }

    public Date getProductionReceiptCreateTime() {
        return productionReceiptCreateTime;
    }

    public void setProductionReceiptCreateTime(Date productionReceiptCreateTime) {
        this.productionReceiptCreateTime = productionReceiptCreateTime;
    }

    public String getMrpGroupCode() {
        return mrpGroupCode = mrpGroupCode == null ? Const.STRING_EMPTY : mrpGroupCode;
    }

    public void setMrpGroupCode(String mrpGroupCode) {
        this.mrpGroupCode = mrpGroupCode == null ? null : mrpGroupCode.trim();
    }

    public String getMrpGroupName() {
        return mrpGroupName = mrpGroupName == null ? Const.STRING_EMPTY : mrpGroupName;
    }

    public void setMrpGroupName(String mrpGroupName) {
        this.mrpGroupName = mrpGroupName == null ? null : mrpGroupName.trim();
    }

    public String getPlanUserName() {
        return planUserName = planUserName == null ? Const.STRING_EMPTY : planUserName;
    }

    public void setPlanUserName(String planUserName) {
        this.planUserName = planUserName == null ? null : planUserName.trim();
    }

    public String getProductionReceiptDescription() {
        return productionReceiptDescription = productionReceiptDescription == null ? Const.STRING_EMPTY : productionReceiptDescription;
    }

    public void setProductionReceiptDescription(String productionReceiptDescription) {
        this.productionReceiptDescription = productionReceiptDescription == null ? null : productionReceiptDescription.trim();
    }

    public String getDeliveryOutwardCode() {
        return deliveryOutwardCode = deliveryOutwardCode == null ? Const.STRING_EMPTY : deliveryOutwardCode;
    }

    public void setDeliveryOutwardCode(String deliveryOutwardCode) {
        this.deliveryOutwardCode = deliveryOutwardCode == null ? null : deliveryOutwardCode.trim();
    }

    public String getSaleReceiptCode() {
        return saleReceiptCode = saleReceiptCode == null ? Const.STRING_EMPTY : saleReceiptCode;
    }

    public void setSaleReceiptCode(String saleReceiptCode) {
        this.saleReceiptCode = saleReceiptCode == null ? null : saleReceiptCode.trim();
    }

    public String getReserveCode() {
        return reserveCode = reserveCode == null ? Const.STRING_EMPTY : reserveCode;
    }

    public void setReserveCode(String reserveCode) {
        this.reserveCode = reserveCode == null ? null : reserveCode.trim();
    }

    public String getMoveTypeCode() {
        return moveTypeCode = moveTypeCode == null ? Const.STRING_EMPTY : moveTypeCode;
    }

    public void setMoveTypeCode(String moveTypeCode) {
        this.moveTypeCode = moveTypeCode == null ? null : moveTypeCode.trim();
    }

    public String getMoveTypeSpecStock() {
        return moveTypeSpecStock = moveTypeSpecStock == null ? Const.STRING_EMPTY : moveTypeSpecStock;
    }

    public void setMoveTypeSpecStock(String moveTypeSpecStock) {
        this.moveTypeSpecStock = moveTypeSpecStock == null ? null : moveTypeSpecStock.trim();
    }

    public String getSaleGroupCode() {
        return saleGroupCode = saleGroupCode == null ? Const.STRING_EMPTY : saleGroupCode;
    }

    public void setSaleGroupCode(String saleGroupCode) {
        this.saleGroupCode = saleGroupCode == null ? null : saleGroupCode.trim();
    }

    public String getSaleGroupName() {
        return saleGroupName = saleGroupName == null ? Const.STRING_EMPTY : saleGroupName;
    }

    public void setSaleGroupName(String saleGroupName) {
        this.saleGroupName = saleGroupName == null ? null : saleGroupName.trim();
    }

    public String getSaleOrganizationCode() {
        return saleOrganizationCode = saleOrganizationCode == null ? Const.STRING_EMPTY : saleOrganizationCode;
    }

    public void setSaleOrganizationCode(String saleOrganizationCode) {
        this.saleOrganizationCode = saleOrganizationCode == null ? null : saleOrganizationCode.trim();
    }

    public String getSaleOrganizationName() {
        return saleOrganizationName = saleOrganizationName == null ? Const.STRING_EMPTY : saleOrganizationName;
    }

    public void setSaleOrganizationName(String saleOrganizationName) {
        this.saleOrganizationName = saleOrganizationName == null ? null : saleOrganizationName.trim();
    }

    public String getReserveCostObjCode() {
        return reserveCostObjCode = reserveCostObjCode == null ? Const.STRING_EMPTY : reserveCostObjCode;
    }

    public void setReserveCostObjCode(String reserveCostObjCode) {
        this.reserveCostObjCode = reserveCostObjCode == null ? null : reserveCostObjCode.trim();
    }

    public String getReserveCostObjName() {
        return reserveCostObjName = reserveCostObjName == null ? Const.STRING_EMPTY : reserveCostObjName;
    }

    public void setReserveCostObjName(String reserveCostObjName) {
        this.reserveCostObjName = reserveCostObjName == null ? null : reserveCostObjName.trim();
    }

    public String getReserveCostCenterCode() {
        return reserveCostCenterCode = reserveCostCenterCode == null ? Const.STRING_EMPTY : reserveCostCenterCode;
    }

    public void setReserveCostCenterCode(String reserveCostCenterCode) {
        this.reserveCostCenterCode = reserveCostCenterCode == null ? null : reserveCostCenterCode.trim();
    }

    public String getReserveCostCenterName() {
        return reserveCostCenterName = reserveCostCenterName == null ? Const.STRING_EMPTY : reserveCostCenterName;
    }

    public void setReserveCostCenterName(String reserveCostCenterName) {
        this.reserveCostCenterName = reserveCostCenterName == null ? null : reserveCostCenterName.trim();
    }

    public String getCustomerCode() {
        return customerCode = customerCode == null ? Const.STRING_EMPTY : customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode == null ? null : customerCode.trim();
    }

    public String getCustomerName() {
        return customerName = customerName == null ? Const.STRING_EMPTY : customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getReceivingPartyCode() {
        return receivingPartyCode = receivingPartyCode == null ? Const.STRING_EMPTY : receivingPartyCode;
    }

    public void setReceivingPartyCode(String receivingPartyCode) {
        this.receivingPartyCode = receivingPartyCode == null ? null : receivingPartyCode.trim();
    }

    public String getReceivingPartyName() {
        return receivingPartyName = receivingPartyName == null ? Const.STRING_EMPTY : receivingPartyName;
    }

    public void setReceivingPartyName(String receivingPartyName) {
        this.receivingPartyName = receivingPartyName == null ? null : receivingPartyName.trim();
    }

    public String getSaleReceiptCreateUserName() {
        return saleReceiptCreateUserName = saleReceiptCreateUserName == null ? Const.STRING_EMPTY : saleReceiptCreateUserName;
    }

    public void setSaleReceiptCreateUserName(String saleReceiptCreateUserName) {
        this.saleReceiptCreateUserName = saleReceiptCreateUserName == null ? null : saleReceiptCreateUserName.trim();
    }

    public Date getSaleReceiptCreateTime() {
        return saleReceiptCreateTime;
    }

    public void setSaleReceiptCreateTime(Date saleReceiptCreateTime) {
        this.saleReceiptCreateTime = saleReceiptCreateTime;
    }

    public String getReserveCreateUser() {
        return reserveCreateUser = reserveCreateUser == null ? Const.STRING_EMPTY : reserveCreateUser;
    }

    public void setReserveCreateUser(String reserveCreateUser) {
        this.reserveCreateUser = reserveCreateUser == null ? null : reserveCreateUser.trim();
    }

    public Date getReserveCreateTime() {
        return reserveCreateTime;
    }

    public void setReserveCreateTime(Date reserveCreateTime) {
        this.reserveCreateTime = reserveCreateTime;
    }

    public String getItemRemark() {
        return itemRemark = itemRemark == null ? Const.STRING_EMPTY : itemRemark;
    }

    public void setItemRemark(String itemRemark) {
        this.itemRemark = itemRemark == null ? null : itemRemark.trim();
    }

    public Byte getWriteOff() {
		return writeOff;
	}

	public void setWriteOff(Byte writeOff) {
		this.writeOff = writeOff;
	}

	public Byte getDebtOffset() {
		return debtOffset;
	}

	public void setDebtOffset(Byte debtOffset) {
		this.debtOffset = debtOffset;
	}

	public Byte getRequestSource() {
		return requestSource;
	}

	public void setRequestSource(Byte requestSource) {
		this.requestSource = requestSource;
	}

	public String getInstructionsCode() {
		return instructionsCode = instructionsCode == null ? Const.STRING_EMPTY : instructionsCode;
	}

	public void setInstructionsCode(String instructionsCode) {
		this.instructionsCode = instructionsCode;
	}

	public String getInstructionsRid() {
		return instructionsRid = instructionsRid == null ? Const.STRING_EMPTY : instructionsRid;
	}

	public void setInstructionsRid(String instructionsRid) {
		this.instructionsRid = instructionsRid;
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

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Integer modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public String getStockTaskExt0() {
        return stockTaskExt0 = stockTaskExt0 == null ? Const.STRING_EMPTY : stockTaskExt0;
    }

    public void setStockTaskExt0(String stockTaskExt0) {
        this.stockTaskExt0 = stockTaskExt0 == null ? null : stockTaskExt0.trim();
    }

    public String getStockTaskExt1() {
        return stockTaskExt1 = stockTaskExt1 == null ? Const.STRING_EMPTY : stockTaskExt1;
    }

    public void setStockTaskExt1(String stockTaskExt1) {
        this.stockTaskExt1 = stockTaskExt1 == null ? null : stockTaskExt1.trim();
    }

    public String getStockTaskExt2() {
        return stockTaskExt2 = stockTaskExt2 == null ? Const.STRING_EMPTY : stockTaskExt2;
    }

    public void setStockTaskExt2(String stockTaskExt2) {
        this.stockTaskExt2 = stockTaskExt2 == null ? null : stockTaskExt2.trim();
    }

    public String getStockTaskExt3() {
        return stockTaskExt3 = stockTaskExt3 == null ? Const.STRING_EMPTY : stockTaskExt3;
    }

    public void setStockTaskExt3(String stockTaskExt3) {
        this.stockTaskExt3 = stockTaskExt3 == null ? null : stockTaskExt3.trim();
    }

    public String getStockTaskExt4() {
        return stockTaskExt4 = stockTaskExt4 == null ? Const.STRING_EMPTY : stockTaskExt4;
    }

    public void setStockTaskExt4(String stockTaskExt4) {
        this.stockTaskExt4 = stockTaskExt4 == null ? null : stockTaskExt4.trim();
    }

    public String getStockTaskExt5() {
        return stockTaskExt5 = stockTaskExt5 == null ? Const.STRING_EMPTY : stockTaskExt5;
    }

    public void setStockTaskExt5(String stockTaskExt5) {
        this.stockTaskExt5 = stockTaskExt5 == null ? null : stockTaskExt5.trim();
    }

    public String getStockTaskExt6() {
        return stockTaskExt6 = stockTaskExt6 == null ? Const.STRING_EMPTY : stockTaskExt6;
    }

    public void setStockTaskExt6(String stockTaskExt6) {
        this.stockTaskExt6 = stockTaskExt6 == null ? null : stockTaskExt6.trim();
    }

    public String getStockTaskExt7() {
        return stockTaskExt7;
    }

    public void setStockTaskExt7(String stockTaskExt7) {
        this.stockTaskExt7 = stockTaskExt7 == null ? null : stockTaskExt7.trim();
    }

    public String getStockTaskExt8() {
        return stockTaskExt8 = stockTaskExt8 == null ? Const.STRING_EMPTY : stockTaskExt8;
    }

    public void setStockTaskExt8(String stockTaskExt8) {
        this.stockTaskExt8 = stockTaskExt8 == null ? null : stockTaskExt8.trim();
    }

    public String getStockTaskExt9() {
        return stockTaskExt9 = stockTaskExt9 == null ? Const.STRING_EMPTY : stockTaskExt9;
    }

    public void setStockTaskExt9(String stockTaskExt9) {
        this.stockTaskExt9 = stockTaskExt9 == null ? null : stockTaskExt9.trim();
    }

	public String getTallyClerk() {
		return tallyClerk = tallyClerk == null ? Const.STRING_EMPTY : tallyClerk;
	}

	public void setTallyClerk(String tallyClerk) {
		this.tallyClerk = tallyClerk;
	}

	public BigDecimal getSourceQty() {
		return sourceQty;
	}

	public void setSourceQty(BigDecimal sourceQty) {
		this.sourceQty = sourceQty;
	}
}