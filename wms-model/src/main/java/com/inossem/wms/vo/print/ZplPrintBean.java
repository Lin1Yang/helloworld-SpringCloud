package com.inossem.wms.vo.print;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @program: wms
 * @description: 打印参数实体类
 * @author: Ailuoli
 * @create: 2019-06-25 18:07
 **/

@ApiModel(value = "com.inossem.wms.vo.print.ZplPrintBean",description = "rfid打印实体类")
public class ZplPrintBean {


    @ApiModelProperty(value = "打印次数")
    private Integer printNumber = 1;

    @ApiModelProperty(value = "库存地点名字")
    private String locationName;

    //物料编号
    @ApiModelProperty(value = "物料编码")
    private String matCode;

    //物料描述
    @ApiModelProperty(value = "物料描述")
    private String matName;

    //二维码值
    @ApiModelProperty(value = "二维码值")
    private String OrCodeValue;

    //采购单号
    @ApiModelProperty(value = "采购订单号")
    private String purchaseOrderNum;

    @ApiModelProperty(value = "采购订单行号")
    private String purchaseOrderRid;
    //物料批次
    @ApiModelProperty(value = "物料批次")
    private String materialBatchNum;

    //物料大类
    @ApiModelProperty(value = "物料大类")
    private String materialCategory;

    //物料单位
    @ApiModelProperty(value = "物料单位")
    private String materialUnit;

    @ApiModelProperty(value = "入库日期")
    private String inputDateName;

    //是否开启海关监管
    @ApiModelProperty(value = "海关监管批次")
    private String cusCustomsSupervisionBatch;

    @ApiModelProperty(value = "采购设施")
    private String platform;

    @ApiModelProperty(value = "工厂code")
    private String ftyCode;

    @ApiModelProperty(value = "单据号")
    private String receiptCode;

    @ApiModelProperty(value = "rid")
    private String receiptRid;

    @ApiModelProperty(value = "状态,0失败，1成功")
    private Byte status;

    @ApiModelProperty(value = "信息")
    private String msg;

    @ApiModelProperty(value = "rfid")
    private String rfidValue;

    @ApiModelProperty(value = "rfid打印方式")
    private String type;

    @ApiModelProperty(value = "打印机ip")
    private String zplHost;

    @ApiModelProperty(value = "打印机类型", example = "1小打印机（非抗金属），2（抗金属）")
    private Byte zplType = 1;
    
    @ApiModelProperty(value = "epc编码")
    private String epcCode;
    

    @ApiModelProperty(value = "打印机端口")
    private Integer port = 6101;
    
    @ApiModelProperty(value = "打印人")
    private Integer createUserId;


    public Integer getPrintNumber() {
        return printNumber;
    }

    public void setPrintNumber(Integer printNumber) {
        this.printNumber = printNumber;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getMatCode() {
        return matCode;
    }

    public void setMatCode(String matCode) {
        this.matCode = matCode;
    }

    public String getMatName() {
        return matName;
    }

    public void setMatName(String matName) {
        this.matName = matName;
    }

    public String getOrCodeValue() {
        return OrCodeValue;
    }

    public void setOrCodeValue(String orCodeValue) {
        OrCodeValue = orCodeValue;
    }

    public String getPurchaseOrderNum() {
        return purchaseOrderNum;
    }

    public void setPurchaseOrderNum(String purchaseOrderNum) {
        this.purchaseOrderNum = purchaseOrderNum;
    }

    public String getMaterialBatchNum() {
        return materialBatchNum;
    }

    public void setMaterialBatchNum(String materialBatchNum) {
        this.materialBatchNum = materialBatchNum;
    }

    public String getMaterialCategory() {
        return materialCategory;
    }

    public void setMaterialCategory(String materialCategory) {
        this.materialCategory = materialCategory;
    }

    public String getMaterialUnit() {
        return materialUnit;
    }

    public void setMaterialUnit(String materialUnit) {
        this.materialUnit = materialUnit;
    }

    public String getInputDateName() {
        return inputDateName;
    }

    public void setInputDateName(String inputDateName) {
        this.inputDateName = inputDateName;
    }

    public String getCusCustomsSupervisionBatch() {
        return cusCustomsSupervisionBatch;
    }

    public void setCusCustomsSupervisionBatch(String cusCustomsSupervisionBatch) {
        this.cusCustomsSupervisionBatch = cusCustomsSupervisionBatch;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getFtyCode() {
        return ftyCode;
    }

    public void setFtyCode(String ftyCode) {
        this.ftyCode = ftyCode;
    }

    public String getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(String receiptCode) {
        this.receiptCode = receiptCode;
    }

    public String getReceiptRid() {
        return receiptRid;
    }

    public void setReceiptRid(String receiptRid) {
        this.receiptRid = receiptRid;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRfidValue() {
        return rfidValue;
    }

    public void setRfidValue(String rfidValue) {
        this.rfidValue = rfidValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getZplHost() {
        return zplHost;
    }

    public void setZplHost(String zplHost) {
        this.zplHost = zplHost;
    }

    public Byte getZplType() {
        return zplType;
    }

    public void setZplType(Byte zplType) {
        this.zplType = zplType;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

	public String getEpcCode() {
		return epcCode;
	}

	public void setEpcCode(String epcCode) {
		this.epcCode = epcCode;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

    public String getPurchaseOrderRid() {
        return purchaseOrderRid;
    }

    public void setPurchaseOrderRid(String purchaseOrderRid) {
        this.purchaseOrderRid = purchaseOrderRid;
    }
}

