package com.inossem.wms.model.dic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value="com.inossem.wms.model.dic.DicMaterialFactory", description="工厂物料信息")
public class DicMaterialFactory extends DicMaterialFactoryKey {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6297855284578228131L;

	@ApiModelProperty(value = "批次特性分类编码", name="batchSpecificClassifyCode", example="ZBATCH01", required=true)
    private String batchSpecificClassifyCode;

    @ApiModelProperty(value = "计价方式： V-移动平均 S-标准价", name="priceMethod", example="V", required=true)
    private String priceMethod;

    @ApiModelProperty(value = "移动平均价", name="moveAvgPrice", example="0.000", required=true)
    private BigDecimal moveAvgPrice;

    @ApiModelProperty(value = "标准价格", name="standardPrice", example="0.000", required=true)
    private BigDecimal standardPrice;

    @ApiModelProperty(value = "价格单位", name="priceUnit", example="100", required=true)
    private Integer priceUnit;

    @ApiModelProperty(value = "保质期", name="shelfLife", example="0", required=true)
    private Integer shelfLife;

    @ApiModelProperty(value = "临期预警天数", name="remindDay", example="0", required=true)
    private Integer remindDay;

    @ApiModelProperty(value = "安全库存数量", name="securityQty", example="0.000", required=true)
    private BigDecimal securityQty;

    @ApiModelProperty(value = "订货点数量", name="orderPointQty", example="0.000", required=true)
    private BigDecimal orderPointQty;

    @ApiModelProperty(value = "启用序列：0.不启用 1.启用", name="serialNumberEnabled", example="0", required=true)
    private Byte serialNumberEnabled;

    @ApiModelProperty(value = "启用ERP批次：0.不启用 1.启用", name="batchErpEnabled", example="0", required=true)
    private Byte batchErpEnabled;

    @ApiModelProperty(value = "启用生产批次：0.不启用 1.启用", name="batchProductEnabled", example="0", required=true)
    private Byte batchProductEnabled;

    @ApiModelProperty(value = "启用包装类型：0.不启用 1.启用", name="packageEnabled", example="0", required=true)
    private Byte packageEnabled;

    @ApiModelProperty(value = "是否启用序列号：0.不启用 1.启用", name="packageEnabled", example="0", required=true)
    private Byte serialIsEnabled;
    
    @ApiModelProperty(value = "校验规则", name="packageEnabled", example="0", required=true)
    private String serialCheckRule;

    @ApiModelProperty(value="创建人id", name="createUserId", example="1", required=true)
    private Integer createUserId;

    @ApiModelProperty(value="修改人id", name="modifyUserId", example="1", required=true)
    private Integer modifyUserId;

    @ApiModelProperty(value="创建时间", name="createTime", example="2018-11-27 16:37:34.741645", required=true)
    private Date createTime;

    @ApiModelProperty(value="修改时间", name="modifyTime", example="2018-11-27 16:56:10.775559", required=true)
    private Date modifyTime;

    @ApiModelProperty(value="预留字段0", name="matFtyExt0", example="预留字段", required=true)
    private String matFtyExt0;

    @ApiModelProperty(value="预留字段1", name="matFtyExt1", example="预留字段", required=true)
    private String matFtyExt1;

    @ApiModelProperty(value="预留字段2", name="matFtyExt2", example="预留字段", required=true)
    private String matFtyExt2;

    @ApiModelProperty(value="预留字段3", name="matFtyExt3", example="预留字段", required=true)
    private String matFtyExt3;

    @ApiModelProperty(value="预留字段4", name="matFtyExt4", example="预留字段", required=true)
    private String matFtyExt4;

    @ApiModelProperty(value="预留字段5", name="matFtyExt5", example="预留字段", required=true)
    private String matFtyExt5;

    @ApiModelProperty(value="预留字段6", name="matFtyExt6", example="预留字段", required=true)
    private String matFtyExt6;

    @ApiModelProperty(value="预留字段7", name="matFtyExt7", example="预留字段", required=true)
    private String matFtyExt7;

    @ApiModelProperty(value="预留字段8", name="matFtyExt8", example="预留字段", required=true)
    private String matFtyExt8;

    @ApiModelProperty(value="预留字段9", name="matFtyExt9", example="预留字段", required=true)
    private String matFtyExt9;
    
    @ApiModelProperty(value="启用标签计数：0.不启用 1.启用", name="labelCountEnabled", example="0", required=true)
    private Byte labelCountEnabled;
    

    public Byte getLabelCountEnabled() {
		return labelCountEnabled;
	}

	public void setLabelCountEnabled(Byte labelCountEnabled) {
		this.labelCountEnabled = labelCountEnabled;
	}

	public String getBatchSpecificClassifyCode() {
        return batchSpecificClassifyCode;
    }

    public void setBatchSpecificClassifyCode(String batchSpecificClassifyCode) {
        this.batchSpecificClassifyCode = batchSpecificClassifyCode == null ? null : batchSpecificClassifyCode.trim();
    }

    public String getPriceMethod() {
        return priceMethod;
    }

    public void setPriceMethod(String priceMethod) {
        this.priceMethod = priceMethod == null ? null : priceMethod.trim();
    }

    public BigDecimal getMoveAvgPrice() {
        return moveAvgPrice;
    }

    public void setMoveAvgPrice(BigDecimal moveAvgPrice) {
        this.moveAvgPrice = moveAvgPrice;
    }

    public BigDecimal getStandardPrice() {
        return standardPrice;
    }

    public void setStandardPrice(BigDecimal standardPrice) {
        this.standardPrice = standardPrice;
    }

    public Integer getPriceUnit() {
		return priceUnit;
	}

	public void setPriceUnit(Integer priceUnit) {
		this.priceUnit = priceUnit;
	}

	public Integer getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Integer shelfLife) {
        this.shelfLife = shelfLife;
    }

    public Integer getRemindDay() {
        return remindDay;
    }

    public void setRemindDay(Integer remindDay) {
        this.remindDay = remindDay;
    }

    public BigDecimal getSecurityQty() {
        return securityQty;
    }

    public void setSecurityQty(BigDecimal securityQty) {
        this.securityQty = securityQty;
    }

    public BigDecimal getOrderPointQty() {
        return orderPointQty;
    }

    public void setOrderPointQty(BigDecimal orderPointQty) {
        this.orderPointQty = orderPointQty;
    }

    public Byte getSerialNumberEnabled() {
        return serialNumberEnabled;
    }

    public void setSerialNumberEnabled(Byte serialNumberEnabled) {
        this.serialNumberEnabled = serialNumberEnabled;
    }

    public Byte getBatchErpEnabled() {
        return batchErpEnabled;
    }

    public void setBatchErpEnabled(Byte batchErpEnabled) {
        this.batchErpEnabled = batchErpEnabled;
    }

    public Byte getBatchProductEnabled() {
        return batchProductEnabled;
    }

    public void setBatchProductEnabled(Byte batchProductEnabled) {
        this.batchProductEnabled = batchProductEnabled;
    }

    public Byte getPackageEnabled() {
        return packageEnabled;
    }

    public void setPackageEnabled(Byte packageEnabled) {
        this.packageEnabled = packageEnabled;
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

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMatFtyExt0() {
        return matFtyExt0;
    }

    public void setMatFtyExt0(String matFtyExt0) {
        this.matFtyExt0 = matFtyExt0 == null ? null : matFtyExt0.trim();
    }

    public String getMatFtyExt1() {
        return matFtyExt1;
    }

    public void setMatFtyExt1(String matFtyExt1) {
        this.matFtyExt1 = matFtyExt1 == null ? null : matFtyExt1.trim();
    }

    public String getMatFtyExt2() {
        return matFtyExt2;
    }

    public void setMatFtyExt2(String matFtyExt2) {
        this.matFtyExt2 = matFtyExt2 == null ? null : matFtyExt2.trim();
    }

    public String getMatFtyExt3() {
        return matFtyExt3;
    }

    public void setMatFtyExt3(String matFtyExt3) {
        this.matFtyExt3 = matFtyExt3 == null ? null : matFtyExt3.trim();
    }

    public String getMatFtyExt4() {
        return matFtyExt4;
    }

    public void setMatFtyExt4(String matFtyExt4) {
        this.matFtyExt4 = matFtyExt4 == null ? null : matFtyExt4.trim();
    }

    public String getMatFtyExt5() {
        return matFtyExt5;
    }

    public void setMatFtyExt5(String matFtyExt5) {
        this.matFtyExt5 = matFtyExt5 == null ? null : matFtyExt5.trim();
    }

    public String getMatFtyExt6() {
        return matFtyExt6;
    }

    public void setMatFtyExt6(String matFtyExt6) {
        this.matFtyExt6 = matFtyExt6 == null ? null : matFtyExt6.trim();
    }

    public String getMatFtyExt7() {
        return matFtyExt7;
    }

    public void setMatFtyExt7(String matFtyExt7) {
        this.matFtyExt7 = matFtyExt7 == null ? null : matFtyExt7.trim();
    }

    public String getMatFtyExt8() {
        return matFtyExt8;
    }

    public void setMatFtyExt8(String matFtyExt8) {
        this.matFtyExt8 = matFtyExt8 == null ? null : matFtyExt8.trim();
    }

    public String getMatFtyExt9() {
        return matFtyExt9;
    }

    public void setMatFtyExt9(String matFtyExt9) {
        this.matFtyExt9 = matFtyExt9 == null ? null : matFtyExt9.trim();
    }

	public Byte getSerialIsEnabled() {
		return serialIsEnabled;
	}

	public void setSerialIsEnabled(Byte serialIsEnabled) {
		this.serialIsEnabled = serialIsEnabled;
	}

	public String getSerialCheckRule() {
		return serialCheckRule;
	}

	public void setSerialCheckRule(String serialCheckRule) {
		this.serialCheckRule = serialCheckRule;
	}
}
