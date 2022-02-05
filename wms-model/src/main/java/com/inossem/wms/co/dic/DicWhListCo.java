package com.inossem.wms.co.dic;

import java.util.List;

import com.inossem.wms.model.dic.DicText;
import com.inossem.wms.page.PageCommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="com.inossem.wms.co.dic.DicWhListCo", description="仓库对象")
public class DicWhListCo extends PageCommon{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value="仓库号", name="", example="")
	private String whCode;
	@ApiModelProperty(value="仓库名", name="", example="")
	private String whName;
	@ApiModelProperty(value="地址", name="", example="")
    private String whAddress;
	@ApiModelProperty(value="国家", name="", example="")
    private String country;
	@ApiModelProperty(value="城市", name="", example="")
    private String city;
	@ApiModelProperty(value="启用仓位", name="", example="")
    private Byte binEnabled;
	@ApiModelProperty(value="启用存储单元", name="", example="")
    private Byte cellEnabled;
	@ApiModelProperty(value="启用拣配", name="", example="")
    private Byte pickingEnabled;
	@ApiModelProperty(value="入库波次，入库计划", name="", example="")
    private Byte waveInput;
	@ApiModelProperty(value="出库波次，出库计划", name="", example="")
    private Byte waveOutput;
	@ApiModelProperty(value="入库顺序，10 先过账，20先作业，30同时", name="", example="")
    private Byte taskInput;
	@ApiModelProperty(value="出库顺序，10先过账，20先作业，30同时", name="", example="")
    private Byte taskOutput;
	@ApiModelProperty(value="创建者", name="", example="")
    private Integer createUserId;
	@ApiModelProperty(value="修改者", name="", example="")
    private Integer modifyUserId;
	@ApiModelProperty(value="仓位名称列表", name="", example="")
    private List<DicText> dicTextList;
	
	@ApiModelProperty(value="保存或修改标识", name="", example="")
	private Byte saveOrUpdateFlag;
	@ApiModelProperty(value="登录人Code", name="", example="")
	private Integer loginCode;
	@ApiModelProperty(value="仓位是否启用标识", name="", example="")
	private String binEnableFlag;
	@ApiModelProperty(value="存储类型Code", name="", example="")
	private String typeCode;
	
	/**
	 * 语言类型 zh-CN简体中文 en-US简体英文
	 */
	@ApiModelProperty(value="语言类型 不必传后台根据用户id获取", name="langCode")
	private String langCode;	

	public String getLangCode() {
		return langCode;
	}
	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}
	public String getWhCode() {
		return whCode;
	}
	public void setWhCode(String whCode) {
		this.whCode = whCode;
	}
	public String getWhName() {
		return whName;
	}
	public void setWhName(String whName) {
		this.whName = whName;
	}
	public String getWhAddress() {
		return whAddress;
	}
	public void setWhAddress(String whAddress) {
		this.whAddress = whAddress;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Byte getBinEnabled() {
		return binEnabled;
	}
	public void setBinEnabled(Byte binEnabled) {
		this.binEnabled = binEnabled;
	}
	public Byte getCellEnabled() {
		return cellEnabled;
	}
	public void setCellEnabled(Byte cellEnabled) {
		this.cellEnabled = cellEnabled;
	}
	public Byte getPickingEnabled() {
		return pickingEnabled;
	}
	public void setPickingEnabled(Byte pickingEnabled) {
		this.pickingEnabled = pickingEnabled;
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
	public List<DicText> getDicTextList() {
		return dicTextList;
	}
	public void setDicTextList(List<DicText> dicTextList) {
		this.dicTextList = dicTextList;
	}
	
	public Byte getSaveOrUpdateFlag() {
		return saveOrUpdateFlag;
	}
	public void setSaveOrUpdateFlag(Byte saveOrUpdateFlag) {
		this.saveOrUpdateFlag = saveOrUpdateFlag;
	}
	public Integer getLoginCode() {
		return loginCode;
	}
	public void setLoginCode(Integer loginCode) {
		this.loginCode = loginCode;
	}
	public String getBinEnableFlag() {
		return binEnableFlag;
	}
	public void setBinEnableFlag(String binEnableFlag) {
		this.binEnableFlag = binEnableFlag;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
}
