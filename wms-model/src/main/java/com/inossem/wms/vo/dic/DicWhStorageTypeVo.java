package com.inossem.wms.vo.dic;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.inossem.wms.model.dic.DicText;
import com.inossem.wms.model.dic.DicWhStorageType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.vo.dic.DicWhStorageTypeVo", description="存储类型扩展对象")
public class DicWhStorageTypeVo extends DicWhStorageType implements Serializable {
	
	private static final long serialVersionUID = -1301940897113611643L;

	@ApiModelProperty(value="仓库描述",example="大地仓库")
	private String whName;
	
	@ApiModelProperty(value="语言编码",example="cn-zh")
	private String langCode;
	
	@ApiModelProperty(value="汉子中文",example="是规范地方")
	private String text;
	
	@ApiModelProperty(value="总条数",example="20")
	private Integer totalCount;

	private String inputStrategyName;

	private String outputStrategyName;

	@ApiModelProperty(value="能力检查",example="库存容量")
	private String abilityInputTypeName;

	@ApiModelProperty(value="可编辑 0不可编辑 1可编辑",example="0")
	private Byte canEdit;

	private String createUserName;

	@ApiModelProperty(value="库存容量",example="库存容量")
	private BigDecimal qty;

	@ApiModelProperty(value="红色预警")
    private Integer gulesWarningNum;

	@ApiModelProperty(value="黄色预警")
    private Integer yellowWarningNum;

	@ApiModelProperty(value="最低数量")
    private Integer stockMinNum;

	@ApiModelProperty(value="正常数量")
    private Integer normalNum;

	@ApiModelProperty(value="仓位数量")
    private Integer num;

	@ApiModelProperty(value="仓位空置率")
    private BigDecimal binVacantRate;

	@ApiModelProperty(value="库存使用率")
    private BigDecimal stockBinUsedRate;

	@ApiModelProperty(value="单位名称")
    private String unitName;

	@ApiModelProperty(value = "仓位列表", name="", example="")
	private List<DicWhStorageBinVo> dicWhStorageBinVoList;
	


	public BigDecimal getQty() {
		return qty;
	}
	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}
	@ApiModelProperty(value="仓位名称列表", name="", example="")
    private List<DicText> dicTextList;

	private List<DicWhStorageBinVo> binList;

	/**
	 * wcs系统用的
	 */

	@ApiModelProperty(value="启用拣配")
	private Byte pickingEnabled;

	@ApiModelProperty(value="启用存储单元")
	private Byte cellEnabled;

	@ApiModelProperty(value="启用入库波次")
	private Byte waveInput;

	@ApiModelProperty(value="启用出库波次")
	private Byte waveOutput;

	@ApiModelProperty(value="入库作业方式")
	private Byte taskInput;

	@ApiModelProperty(value="出库作业方式")
	private Byte taskOutput;

	public Byte getPickingEnabled() {
		return pickingEnabled;
	}

	public void setPickingEnabled(Byte pickingEnabled) {
		this.pickingEnabled = pickingEnabled;
	}

	@Override
	public Byte getCellEnabled() {
		return cellEnabled;
	}

	@Override
	public void setCellEnabled(Byte cellEnabled) {
		this.cellEnabled = cellEnabled;
	}

	public Byte getWaveInput() {
		return waveInput;
	}

	public void setWaveInput(Byte waveInput) {
		this.waveInput = waveInput;
	}

	public Byte getWaveOutput() {
		return waveOutput;
	}

	public void setWaveOutput(Byte waveOutput) {
		this.waveOutput = waveOutput;
	}

	public Byte getTaskInput() {
		return taskInput;
	}

	public void setTaskInput(Byte taskInput) {
		this.taskInput = taskInput;
	}

	public Byte getTaskOutput() {
		return taskOutput;
	}

	public void setTaskOutput(Byte taskOutput) {
		this.taskOutput = taskOutput;
	}

	public String getWhName() {
		return whName;
	}
	public void setWhName(String whName) {
		this.whName = whName;
	}
	public String getLangCode() {
		return langCode;
	}
	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public List<DicText> getDicTextList() {
		return dicTextList;
	}
	public void setDicTextList(List<DicText> dicTextList) {
		this.dicTextList = dicTextList;
	}
	public String getInputStrategyName() {
		return inputStrategyName;
	}
	public void setInputStrategyName(String inputStrategyName) {
		this.inputStrategyName = inputStrategyName;
	}
	public String getOutputStrategyName() {
		return outputStrategyName;
	}
	public void setOutputStrategyName(String outputStrategyName) {
		this.outputStrategyName = outputStrategyName;
	}

	public Byte getCanEdit() {
		return canEdit;
	}
	public void setCanEdit(Byte canEdit) {
		this.canEdit = canEdit;
	}
	public String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	public List<DicWhStorageBinVo> getBinList() {
		return binList;
	}
	public void setBinList(List<DicWhStorageBinVo> binList) {
		this.binList = binList;
	}
	public Integer getGulesWarningNum() {
		return gulesWarningNum;
	}
	public void setGulesWarningNum(Integer gulesWarningNum) {
		this.gulesWarningNum = gulesWarningNum;
	}
	public Integer getYellowWarningNum() {
		return yellowWarningNum;
	}
	public void setYellowWarningNum(Integer yellowWarningNum) {
		this.yellowWarningNum = yellowWarningNum;
	}
	public Integer getStockMinNum() {
		return stockMinNum;
	}
	public void setStockMinNum(Integer stockMinNum) {
		this.stockMinNum = stockMinNum;
	}
	public Integer getNormalNum() {
		return normalNum;
	}
	public void setNormalNum(Integer normalNum) {
		this.normalNum = normalNum;
	}
	public BigDecimal getBinVacantRate() {
		return binVacantRate;
	}
	public void setBinVacantRate(BigDecimal binVacantRate) {
		this.binVacantRate = binVacantRate;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public BigDecimal getStockBinUsedRate() {
		return stockBinUsedRate;
	}
	public void setStockBinUsedRate(BigDecimal stockBinUsedRate) {
		this.stockBinUsedRate = stockBinUsedRate;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public List<DicWhStorageBinVo> getDicWhStorageBinVoList() {
		return dicWhStorageBinVoList;
	}
	public void setDicWhStorageBinVoList(List<DicWhStorageBinVo> dicWhStorageBinVoList) {
		this.dicWhStorageBinVoList = dicWhStorageBinVoList;
	}
	public String getAbilityInputTypeName() {
		return abilityInputTypeName;
	}
	public void setAbilityInputTypeName(String abilityInputTypeName) {
		this.abilityInputTypeName = abilityInputTypeName;
	}

}
