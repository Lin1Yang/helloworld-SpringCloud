package com.inossem.wms.model.dic;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.dic.DicWhStorageType", description="存储类型")
public class DicWhStorageType extends DicWhStorageTypeKey {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7705635451711830656L;

	private boolean click;
	
	@ApiModelProperty(value="存储类型")
    private String typeName;

	@ApiModelProperty(value="特殊存储类型标识，用作对存储类型的特殊分类，可以配合物料中的特殊存储类型标识使用，例如物料A在仓库号001下特殊存储类型标识为T01，可以放在标识为T01的存储类型下。")
    private String typeMarkCode;

	@ApiModelProperty(value="特殊存储类型标识描述")
    private String typeMarkName;

	@ApiModelProperty(value="启用存储单元")
    private Byte cellEnabled;

	@ApiModelProperty(value="混合存储激活")
    private Byte storageMixEnabled;
	
	@ApiModelProperty(value="入库能力检查激活")
    private Byte abilityInputEnabled;

	@ApiModelProperty(value="入库检验类型 1 根据仓位最大重量检验2 根据仓储单元最大重量检验3 根据仓位最大体积检验4 根据仓储单元最大体积检验")
    private String abilityInputType;

	@ApiModelProperty(value="入库策略-手工入库B-大容量仓储F-固定仓位I-增加现有库存L-下一个空仓位P-仓储单位类型")
    private String strategyInput;

	@ApiModelProperty(value="出库策略-手工出库A-最小数量先出F-先进先出H-质保到期日先出M-包括大/小数量P-固定仓位")
    private String strategyOutput;

	@ApiModelProperty(value="库存单位")
    private String stockUnitCode;

	@ApiModelProperty(value="最高库存")
    private BigDecimal stockMax;

	@ApiModelProperty(value="预警库存（高）")
    private BigDecimal stockMaxWarning;

	@ApiModelProperty(value="最低库存")
    private BigDecimal stockMin;

	@ApiModelProperty(value="预警库存（低）")
    private BigDecimal stockMinWarning;

	@ApiModelProperty(value="正常库存")
    private BigDecimal stockFit;

	@ApiModelProperty(value="是否 默认存储区   0 否   1 是")
	private Byte isDefault;
	
    private Byte isDelete;

    private Date createTime;

    private Date modifyTime;

    private Integer createUserId;

    private Integer modifyUserId;

    private String whStorageTypeExt0;

    private String whStorageTypeExt1;

    private String whStorageTypeExt2;

    private String whStorageTypeExt3;

    private String whStorageTypeExt4;

    private String whStorageTypeExt5;

    private String whStorageTypeExt6;

    private String whStorageTypeExt7;

    private String whStorageTypeExt8;

    private String whStorageTypeExt9;

    public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeMarkCode() {
        return typeMarkCode;
    }


	public Byte getCellEnabled() {
		return cellEnabled;
	}

	public void setCellEnabled(Byte cellEnabled) {
		this.cellEnabled = cellEnabled;
	}

	public void setTypeMarkCode(String typeMarkCode) {
        this.typeMarkCode = typeMarkCode == null ? null : typeMarkCode.trim();
    }

    public String getTypeMarkName() {
        return typeMarkName;
    }

    public void setTypeMarkName(String typeMarkName) {
        this.typeMarkName = typeMarkName == null ? null : typeMarkName.trim();
    }

    
	public Byte getStorageMixEnabled() {
        return storageMixEnabled;
    }

    public void setStorageMixEnabled(Byte storageMixEnabled) {
        this.storageMixEnabled = storageMixEnabled;
    }

    public Byte getAbilityInputEnabled() {
        return abilityInputEnabled;
    }

    public void setAbilityInputEnabled(Byte abilityInputEnabled) {
        this.abilityInputEnabled = abilityInputEnabled;
    }

    public String getAbilityInputType() {
		return abilityInputType;
	}

	public void setAbilityInputType(String abilityInputType) {
		this.abilityInputType = abilityInputType;
	}

	public String getStrategyInput() {
        return strategyInput;
    }

    public void setStrategyInput(String strategyInput) {
        this.strategyInput = strategyInput == null ? null : strategyInput.trim();
    }

    public String getStrategyOutput() {
        return strategyOutput;
    }

    public void setStrategyOutput(String strategyOutput) {
        this.strategyOutput = strategyOutput == null ? null : strategyOutput.trim();
    }

    public String getStockUnitCode() {
        return stockUnitCode;
    }

    public void setStockUnitCode(String stockUnitCode) {
        this.stockUnitCode = stockUnitCode == null ? null : stockUnitCode.trim();
    }

    public BigDecimal getStockMax() {
        return stockMax;
    }

    public void setStockMax(BigDecimal stockMax) {
        this.stockMax = stockMax;
    }

    public BigDecimal getStockMaxWarning() {
        return stockMaxWarning;
    }

    public void setStockMaxWarning(BigDecimal stockMaxWarning) {
        this.stockMaxWarning = stockMaxWarning;
    }

    public BigDecimal getStockMin() {
        return stockMin;
    }

    public void setStockMin(BigDecimal stockMin) {
        this.stockMin = stockMin;
    }

    public BigDecimal getStockMinWarning() {
        return stockMinWarning;
    }

    public void setStockMinWarning(BigDecimal stockMinWarning) {
        this.stockMinWarning = stockMinWarning;
    }

    public BigDecimal getStockFit() {
        return stockFit;
    }

    public void setStockFit(BigDecimal stockFit) {
        this.stockFit = stockFit;
    }

    public Byte getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Byte isDefault) {
		this.isDefault = isDefault;
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

    public String getWhStorageTypeExt0() {
        return whStorageTypeExt0;
    }

    public void setWhStorageTypeExt0(String whStorageTypeExt0) {
        this.whStorageTypeExt0 = whStorageTypeExt0 == null ? null : whStorageTypeExt0.trim();
    }

    public String getWhStorageTypeExt1() {
        return whStorageTypeExt1;
    }

    public void setWhStorageTypeExt1(String whStorageTypeExt1) {
        this.whStorageTypeExt1 = whStorageTypeExt1 == null ? null : whStorageTypeExt1.trim();
    }

    public String getWhStorageTypeExt2() {
        return whStorageTypeExt2;
    }

    public void setWhStorageTypeExt2(String whStorageTypeExt2) {
        this.whStorageTypeExt2 = whStorageTypeExt2 == null ? null : whStorageTypeExt2.trim();
    }

    public String getWhStorageTypeExt3() {
        return whStorageTypeExt3;
    }

    public void setWhStorageTypeExt3(String whStorageTypeExt3) {
        this.whStorageTypeExt3 = whStorageTypeExt3 == null ? null : whStorageTypeExt3.trim();
    }

    public String getWhStorageTypeExt4() {
        return whStorageTypeExt4;
    }

    public void setWhStorageTypeExt4(String whStorageTypeExt4) {
        this.whStorageTypeExt4 = whStorageTypeExt4 == null ? null : whStorageTypeExt4.trim();
    }

    public String getWhStorageTypeExt5() {
        return whStorageTypeExt5;
    }

    public void setWhStorageTypeExt5(String whStorageTypeExt5) {
        this.whStorageTypeExt5 = whStorageTypeExt5 == null ? null : whStorageTypeExt5.trim();
    }

    public String getWhStorageTypeExt6() {
        return whStorageTypeExt6;
    }

    public void setWhStorageTypeExt6(String whStorageTypeExt6) {
        this.whStorageTypeExt6 = whStorageTypeExt6 == null ? null : whStorageTypeExt6.trim();
    }

    public String getWhStorageTypeExt7() {
        return whStorageTypeExt7;
    }

    public void setWhStorageTypeExt7(String whStorageTypeExt7) {
        this.whStorageTypeExt7 = whStorageTypeExt7 == null ? null : whStorageTypeExt7.trim();
    }

    public String getWhStorageTypeExt8() {
        return whStorageTypeExt8;
    }

    public void setWhStorageTypeExt8(String whStorageTypeExt8) {
        this.whStorageTypeExt8 = whStorageTypeExt8 == null ? null : whStorageTypeExt8.trim();
    }

    public String getWhStorageTypeExt9() {
        return whStorageTypeExt9;
    }

    public void setWhStorageTypeExt9(String whStorageTypeExt9) {
        this.whStorageTypeExt9 = whStorageTypeExt9 == null ? null : whStorageTypeExt9.trim();
    }

	public boolean isClick() {
		return click;
	}

	public void setClick(boolean click) {
		this.click = click;
	}
}