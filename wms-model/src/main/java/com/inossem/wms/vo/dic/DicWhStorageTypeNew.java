package com.inossem.wms.vo.dic;

import java.math.BigDecimal;
import java.util.Date;

import com.inossem.wms.model.dic.DicWhStorageTypeKey;

import io.swagger.annotations.ApiModelProperty;

public class DicWhStorageTypeNew extends DicWhStorageTypeKey {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8243834127074947971L;

	private boolean click;
	
	@ApiModelProperty(value="存储类型")
    private String typeName;

	@ApiModelProperty(value="特殊存储类型标识，用作对存储类型的特殊分类，可以配合物料中的特殊存储类型标识使用，例如物料A在仓库号001下特殊存储类型标识为T01，可以放在标识为T01的存储类型下。")
    private String typeMarkCode;

	@ApiModelProperty(value="特殊存储类型标识描述")
    private String typeMarkName;

	@ApiModelProperty(value="启用存储单元")
    private int cellEnabled;

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

    private Byte isDelete;

    private Date createTime;

    private Date modifyTime;

    private Integer createUserId;

    private Integer modifyUserId;

    

    public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeMarkCode() {
        return typeMarkCode;
    }

    public int getCellEnabled() {
		return cellEnabled;
	}

	public void setCellEnabled(int cellEnabled) {
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


	public boolean isClick() {
		return click;
	}

	public void setClick(boolean click) {
		this.click = click;
	}

}
