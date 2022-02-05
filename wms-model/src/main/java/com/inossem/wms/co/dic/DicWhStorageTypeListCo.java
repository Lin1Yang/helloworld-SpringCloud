package com.inossem.wms.co.dic;

import java.math.BigDecimal;
import java.util.List;

import com.inossem.wms.model.dic.DicText;
import com.inossem.wms.page.PageCommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "com.inossem.wms.co.dic.DicWhStorageTypeListCo", description = "存储类型对象")
public class DicWhStorageTypeListCo extends PageCommon {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "仓库号", name = "", example = "")
    private String whCode;
    @ApiModelProperty(value = "存储类型", name = "", example = "")
    private String typeCode;
    @ApiModelProperty(value = "存储类型名称", name = "", example = "")
    private String typeName;
    @ApiModelProperty(value = "特殊存储类型标识", name = "", example = "")
    private String typeMarkCode;
    @ApiModelProperty(value = "特殊存储类型标识描述", name = "", example = "")
    private String typeMarkName;
    @ApiModelProperty(value = "存储单元激活", name = "", example = "")
    private byte cellEnabled;
    @ApiModelProperty(value = "混合存储激活", name = "", example = "")
    private byte storageMixEnabled;
    @ApiModelProperty(value = "入库能力检查激活", name = "", example = "")
    private byte abilityInputEnabled;
    @ApiModelProperty(value = "入库能力", name = "", example = "")
    private String abilityInputType;
    @ApiModelProperty(value = "入库策略", name = "", example = "")
    private String strategyInput;
    @ApiModelProperty(value = "出库策略", name = "", example = "")
    private String strategyOutput;
    @ApiModelProperty(value = "库存单位编码", name = "", example = "")
    private String stockUnitCode;
    @ApiModelProperty(value = "最高库存", name = "", example = "")
    private BigDecimal stockMax;
    @ApiModelProperty(value = "预警库存（高）", name = "", example = "")
    private BigDecimal stockMaxWarning;
    @ApiModelProperty(value = "最低库存", name = "", example = "")
    private BigDecimal stockMin;
    @ApiModelProperty(value = "预警库存（低）", name = "", example = "")
    private BigDecimal stockMinWarning;
    @ApiModelProperty(value = "正常库存", name = "", example = "")
    private BigDecimal stockFit;
    @ApiModelProperty(value = "存储类型语言列表", name = "", example = "")
    private List<DicText> dicTextList;
    @ApiModelProperty(value = "新增或修改标识", name = "", example = "")
    private byte saveOrUpdateFlag;
    @ApiModelProperty(value = "语言版本", name = "langCode", example = "zh-CN", required = true)
    private String langCode ;


    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeMarkCode() {
        return typeMarkCode;
    }

    public void setTypeMarkCode(String typeMarkCode) {
        this.typeMarkCode = typeMarkCode;
    }

    public String getTypeMarkName() {
        return typeMarkName;
    }

    public void setTypeMarkName(String typeMarkName) {
        this.typeMarkName = typeMarkName;
    }

    public byte getCellEnabled() {
        return cellEnabled;
    }

    public void setCellEnabled(byte cellEnabled) {
        this.cellEnabled = cellEnabled;
    }

    public byte getStorageMixEnabled() {
        return storageMixEnabled;
    }

    public void setStorageMixEnabled(byte storageMixEnabled) {
        this.storageMixEnabled = storageMixEnabled;
    }

    public byte getAbilityInputEnabled() {
        return abilityInputEnabled;
    }

    public void setAbilityInputEnabled(byte abilityInputEnabled) {
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
        this.strategyInput = strategyInput;
    }

    public String getStrategyOutput() {
        return strategyOutput;
    }

    public void setStrategyOutput(String strategyOutput) {
        this.strategyOutput = strategyOutput;
    }

    public String getStockUnitCode() {
        return stockUnitCode;
    }

    public void setStockUnitCode(String stockUnitCode) {
        this.stockUnitCode = stockUnitCode;
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

    public List<DicText> getDicTextList() {
        return dicTextList;
    }

    public void setDicTextList(List<DicText> dicTextList) {
        this.dicTextList = dicTextList;
    }

    public byte getSaveOrUpdateFlag() {
        return saveOrUpdateFlag;
    }

    public void setSaveOrUpdateFlag(byte saveOrUpdateFlag) {
        this.saveOrUpdateFlag = saveOrUpdateFlag;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }


}
