package com.inossem.wms.model.dic;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.dic.DicMaterial", description="物料主数据表映射")
public class DicMaterial implements Serializable {
	
	private static final long serialVersionUID = 7768553653078013530L;

	@ApiModelProperty(value="物料编码", name="matCode", example="60000020", required=true)
    private String matCode;
	
	@ApiModelProperty(value="物料描述", name="matName", example="刚", required=true)
    private String matName;
	
	@ApiModelProperty(value="冻结标识 1-冻结 0-正常", name="freeze", example="0", required=true)
    private Byte freeze;
	
	@ApiModelProperty(value="计量单位编码", name="unitCode", example="EA", required=true)
    private String unitCode;
	
	@ApiModelProperty(value="物料组编码", name="matGroupCode", example="01", required=true)
    private String matGroupCode;
	
	@ApiModelProperty(value="物料类型编码", name="matTypeCode", example="ZWL", required=true)
    private String matTypeCode;
	
	@ApiModelProperty(value="长度", name="length", example="0.000", required=true)
    private BigDecimal length;
	
	@ApiModelProperty(value="宽度", name="width", example="0.000", required=true)
    private BigDecimal width;
	
	@ApiModelProperty(value="高度", name="height", example="0.000", required=true)
    private BigDecimal height;
	
	@ApiModelProperty(value="长度/宽度/高度的单位编码", name="unitLength", example="M", required=true)
    private String unitLength;
	
	@ApiModelProperty(value="毛重", name="grossWeight", example="0.000", required=true)
    private BigDecimal grossWeight;
	
	@ApiModelProperty(value="净重", name="netWeight", example="0.000", required=true)
    private BigDecimal netWeight;
	
	@ApiModelProperty(value="重量的单位编码", name="unitWeight", example="KG", required=true)
    private String unitWeight;
	
	@ApiModelProperty(value="体积", name="volume", example="0.000", required=true)
    private BigDecimal volume;
	
	@ApiModelProperty(value="体积的单位编码", name="unitVolume", example="M3", required=true)
    private String unitVolume;
	
	@ApiModelProperty(value="保质期", name="shelfLife", example="180", required=true)
    private Integer shelfLife;
	
	@ApiModelProperty(value="总货架寿命", name="unitShelfLife", example="D", required=true)
    private String unitShelfLife;
	
	@ApiModelProperty(value="危险物料标示", name="dangerous", example="0", required=true)
    private Byte dangerous;
	
	@ApiModelProperty(value="启用erp批次", name="batchErpEnabled", example="0", required=true)
    private Byte batchErpEnabled;
	
	@ApiModelProperty(value = "erp批次类型    1 输入框  最长10位  3 带默认值的输入框  最长10位 4下拉框 ")
	private Byte batchErpType;
	
	
	
	@ApiModelProperty(value="启用生产批次", name="batchProductEnabled", example="0", required=true)
    private Byte batchProductEnabled;
	
	@ApiModelProperty(value="启用包", name="packageEnabled", example="0", required=true)
    private Byte packageEnabled;
	
	@ApiModelProperty(value="文件id", name="fid", example="0", required=true)
    private String fid;
	
	@ApiModelProperty(value="煤矿成本考核标识", name="costCheck", example="0", required=true)
    private Byte costCheck;
	
	@ApiModelProperty(value="删除标记", name="isDelete", example="0", required=true)
    private Byte isDelete;
	
	@ApiModelProperty(value="创建时间", name="createTime", example="2018-11-27 16:37:34.741645", required=true)
    private Date createTime;
	
	@ApiModelProperty(value="修改时间", name="modifyTime", example="2018-11-27 16:56:10.775559", required=true)
    private Date modifyTime;
	
	@ApiModelProperty(value="创建人id", name="createUserId", example="1", required=true)
    private Integer createUserId;
	
	@ApiModelProperty(value="修改人id", name="modifyUserId", example="1", required=true)
    private Integer modifyUserId;
	
	@ApiModelProperty(value="预留字段0", name="matExt0", example="预留字段", required=true)
    private String matExt0;
	
	@ApiModelProperty(value="预留字段1", name="matExt1", example="预留字段", required=true)
    private String matExt1;
	
	@ApiModelProperty(value="预留字段2", name="matExt2", example="预留字段", required=true)
    private String matExt2;
	
	@ApiModelProperty(value="预留字段3", name="matExt3", example="预留字段", required=true)
    private String matExt3;
	
	@ApiModelProperty(value="预留字段4", name="matExt4", example="预留字段", required=true)
    private String matExt4;
	
	@ApiModelProperty(value="预留字段5", name="matExt5", example="预留字段", required=true)
    private String matExt5;
	
	@ApiModelProperty(value="预留字段6", name="matExt6", example="预留字段", required=true)
    private String matExt6;
	
	@ApiModelProperty(value="预留字段7", name="matExt7", example="预留字段", required=true)
    private String matExt7;
	
	@ApiModelProperty(value="预留字段8", name="matExt8", example="预留字段", required=true)
    private String matExt8;
	
	@ApiModelProperty(value="预留字段9", name="matExt9", example="预留字段", required=true)
    private String matExt9;

    public String getMatCode() {
        return matCode;
    }

    public void setMatCode(String matCode) {
        this.matCode = matCode == null ? null : matCode.trim();
    }

    public String getMatName() {
        return matName;
    }

    public void setMatName(String matName) {
        this.matName = matName == null ? null : matName.trim();
    }

    public Byte getFreeze() {
        return freeze;
    }

    public void setFreeze(Byte freeze) {
        this.freeze = freeze;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode == null ? null : unitCode.trim();
    }

    public String getMatGroupCode() {
        return matGroupCode;
    }

    public void setMatGroupCode(String matGroupCode) {
        this.matGroupCode = matGroupCode == null ? null : matGroupCode.trim();
    }

    public String getMatTypeCode() {
        return matTypeCode;
    }

    public void setMatTypeCode(String matTypeCode) {
        this.matTypeCode = matTypeCode == null ? null : matTypeCode.trim();
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public String getUnitLength() {
        return unitLength;
    }

    public void setUnitLength(String unitLength) {
        this.unitLength = unitLength == null ? null : unitLength.trim();
    }

    public BigDecimal getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(BigDecimal grossWeight) {
        this.grossWeight = grossWeight;
    }

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    public String getUnitWeight() {
        return unitWeight;
    }

    public void setUnitWeight(String unitWeight) {
        this.unitWeight = unitWeight == null ? null : unitWeight.trim();
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public String getUnitVolume() {
        return unitVolume;
    }

    public void setUnitVolume(String unitVolume) {
        this.unitVolume = unitVolume == null ? null : unitVolume.trim();
    }

    public Integer getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Integer shelfLife) {
        this.shelfLife = shelfLife;
    }

    public String getUnitShelfLife() {
        return unitShelfLife;
    }

    public void setUnitShelfLife(String unitShelfLife) {
        this.unitShelfLife = unitShelfLife == null ? null : unitShelfLife.trim();
    }

    public Byte getDangerous() {
        return dangerous;
    }

    public void setDangerous(Byte dangerous) {
        this.dangerous = dangerous;
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

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid == null ? null : fid.trim();
    }

    public Byte getCostCheck() {
        return costCheck;
    }

    public void setCostCheck(Byte costCheck) {
        this.costCheck = costCheck;
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

    public String getMatExt0() {
        return matExt0;
    }

    public void setMatExt0(String matExt0) {
        this.matExt0 = matExt0 == null ? null : matExt0.trim();
    }

    public String getMatExt1() {
        return matExt1;
    }

    public void setMatExt1(String matExt1) {
        this.matExt1 = matExt1 == null ? null : matExt1.trim();
    }

    public String getMatExt2() {
        return matExt2;
    }

    public void setMatExt2(String matExt2) {
        this.matExt2 = matExt2 == null ? null : matExt2.trim();
    }

    public String getMatExt3() {
        return matExt3;
    }

    public void setMatExt3(String matExt3) {
        this.matExt3 = matExt3 == null ? null : matExt3.trim();
    }

    public String getMatExt4() {
        return matExt4;
    }

    public void setMatExt4(String matExt4) {
        this.matExt4 = matExt4 == null ? null : matExt4.trim();
    }

    public String getMatExt5() {
        return matExt5;
    }

    public void setMatExt5(String matExt5) {
        this.matExt5 = matExt5 == null ? null : matExt5.trim();
    }

    public String getMatExt6() {
        return matExt6;
    }

    public void setMatExt6(String matExt6) {
        this.matExt6 = matExt6 == null ? null : matExt6.trim();
    }

    public String getMatExt7() {
        return matExt7;
    }

    public void setMatExt7(String matExt7) {
        this.matExt7 = matExt7 == null ? null : matExt7.trim();
    }

    public String getMatExt8() {
        return matExt8;
    }

    public void setMatExt8(String matExt8) {
        this.matExt8 = matExt8 == null ? null : matExt8.trim();
    }

    public String getMatExt9() {
        return matExt9;
    }

    public void setMatExt9(String matExt9) {
        this.matExt9 = matExt9 == null ? null : matExt9.trim();
    }

	public Byte getBatchErpType() {
		return batchErpType;
	}

	public void setBatchErpType(Byte batchErpType) {
		this.batchErpType = batchErpType;
	}

	
    
}