package com.inossem.wms.co.dic;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;
import com.inossem.wms.model.dic.DicText;
import com.inossem.wms.model.dic.DicWhStorageBinKey;
import com.inossem.wms.page.PageCommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.co.dic.DicWhStorageBinListCo", description="仓位对象")
public class DicWhStorageBinListCo extends PageCommon{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value="仓库号", name="", example="")
	private String whCode;
	@ApiModelProperty(value="存储类型", name="", example="")
	private String typeCode;
	@ApiModelProperty(value="仓位", name="", example="")
	private String binCode;
	@ApiModelProperty(value="是否使用", name="", example="")
	private byte used;
	@ApiModelProperty(value="新增或修改标志", name="", example="")
	private byte saveOrUpdateFlag;
	@ApiModelProperty(value="开始时间", name="", example="")
	private String beginDate;
	@ApiModelProperty(value="截止时间", name="", example="")
	private String endDate;
	@ApiModelProperty(value="盘点类型", name="", example="")
	private byte stockTakeType;
	@ApiModelProperty(value="存储区", name="", example="")
	private String sectionCode;
	@ApiModelProperty(value="拣货区", name="", example="")
	private String pickingAreaCode;
	@ApiModelProperty(value="入库冻结", name="", example="")
	private byte freezeInput;
	@ApiModelProperty(value="冻结原因", name="", example="")
	private String freezeReasonCode;
	@ApiModelProperty(value="出库冻结", name="", example="")
	private byte freezeOutput;
	
	@JSONField(name="storageCellType") 
	@ApiModelProperty(value="存储单元类型", name="", example="")
	private String storageCellTypeCode;
	@ApiModelProperty(value="允许最大存储单元数量", name="", example="")
	private Integer storageCellMax;
	@ApiModelProperty(value="最大承重", name="", example="")
	private BigDecimal weightMax;
	@ApiModelProperty(value="承重单位", name="", example="")
	private String weightUnitCode;
	@ApiModelProperty(value="最大体积", name="", example="")
	private BigDecimal volumeMax;
	@ApiModelProperty(value="体积单位", name="", example="")
	private String volumeUnitCode;
	@ApiModelProperty(value="X", name="", example="")
	private BigDecimal xCoordinate;
	@ApiModelProperty(value="Y", name="", example="")
	private BigDecimal yCoordinate;
	@ApiModelProperty(value="Z", name="", example="")
	private BigDecimal zCoordinate;
	@ApiModelProperty(value="仓位列表", name="", example="")
	List<DicText> dicTextList;
	@ApiModelProperty(value="仓位类型", name="", example="")
	private String binTypeCode;
	@ApiModelProperty(value="冻结原因", name="", example="")
	private String reasonName;
	@ApiModelProperty(value="仓位类型名称", name="", example="")
	private String binTypeName;
	@ApiModelProperty(value="虚拟仓位")
	private byte virtualBin;
	@ApiModelProperty(value = "存储类型集合")
	protected Set<String> allTypeSet;
	@ApiModelProperty(value="仓位是否启用标识", name="", example="")
	private String binEnableFlag;
	@ApiModelProperty(value="登录人Code", name="", example="")
	private Integer loginCode;
	@ApiModelProperty(value = "存储类型集合")
	protected Set<String> typeSet;
	
	private String whStorageBinExt0;
	
	private String matCode;
	
	private String ext0;
	
	private String ext1;
	
	private String lotNumb;
	
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

	public String getBinCode() {
		return binCode;
	}

	public void setBinCode(String binCode) {
		this.binCode = binCode;
	}

	public byte getUsed() {
		return used;
	}

	public void setUsed(byte used) {
		this.used = used;
	}

	public byte getSaveOrUpdateFlag() {
		return saveOrUpdateFlag;
	}

	public void setSaveOrUpdateFlag(byte saveOrUpdateFlag) {
		this.saveOrUpdateFlag = saveOrUpdateFlag;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public byte getStockTakeType() {
		return stockTakeType;
	}

	public void setStockTakeType(byte stockTakeType) {
		this.stockTakeType = stockTakeType;
	}

	public String getSectionCode() {
		return sectionCode;
	}

	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	public String getPickingAreaCode() {
		return pickingAreaCode;
	}

	public void setPickingAreaCode(String pickingAreaCode) {
		this.pickingAreaCode = pickingAreaCode;
	}

	public byte getFreezeInput() {
		return freezeInput;
	}

	public void setFreezeInput(byte freezeInput) {
		this.freezeInput = freezeInput;
	}

	public String getFreezeReasonCode() {
		return freezeReasonCode;
	}

	public void setFreezeReasonCode(String freezeReasonCode) {
		this.freezeReasonCode = freezeReasonCode;
	}

	public byte getFreezeOutput() {
		return freezeOutput;
	}

	public void setFreezeOutput(byte freezeOutput) {
		this.freezeOutput = freezeOutput;
	}

	public String getStorageCellTypeCode() {
		return storageCellTypeCode;
	}

	public void setStorageCellTypeCode(String storageCellTypeCode) {
		this.storageCellTypeCode = storageCellTypeCode;
	}

	public Integer getStorageCellMax() {
		return storageCellMax;
	}

	public void setStorageCellMax(Integer storageCellMax) {
		this.storageCellMax = storageCellMax;
	}

	public BigDecimal getWeightMax() {
		return weightMax;
	}

	public void setWeightMax(BigDecimal weightMax) {
		this.weightMax = weightMax;
	}

	public String getWeightUnitCode() {
		return weightUnitCode;
	}

	public void setWeightUnitCode(String weightUnitCode) {
		this.weightUnitCode = weightUnitCode;
	}

	public BigDecimal getVolumeMax() {
		return volumeMax;
	}

	public void setVolumeMax(BigDecimal volumeMax) {
		this.volumeMax = volumeMax;
	}

	public String getVolumeUnitCode() {
		return volumeUnitCode;
	}

	public void setVolumeUnitCode(String volumeUnitCode) {
		this.volumeUnitCode = volumeUnitCode;
	}

	public BigDecimal getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(BigDecimal xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public BigDecimal getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(BigDecimal yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public BigDecimal getzCoordinate() {
		return zCoordinate;
	}

	public void setzCoordinate(BigDecimal zCoordinate) {
		this.zCoordinate = zCoordinate;
	}

	public List<DicText> getDicTextList() {
		return dicTextList;
	}

	public void setDicTextList(List<DicText> dicTextList) {
		this.dicTextList = dicTextList;
	}

	public String getBinTypeCode() {
		return binTypeCode;
	}

	public void setBinTypeCode(String binTypeCode) {
		this.binTypeCode = binTypeCode;
	}

	public String getReasonName() {
		return reasonName;
	}

	public void setReasonName(String reasonName) {
		this.reasonName = reasonName;
	}

	public String getBinTypeName() {
		return binTypeName;
	}

	public void setBinTypeName(String binTypeName) {
		this.binTypeName = binTypeName;
	}

	public byte getVirtualBin() {
		return virtualBin;
	}

	public void setVirtualBin(byte virtualBin) {
		this.virtualBin = virtualBin;
	}

	/**
	 * @Author WangDong
	 * @Date 2019/2/20 14:11
	 * @Param
	 * @return
	 * @Description //批量处理用到的联合主键
	 **/
	private List<DicWhStorageBinKey> keyList;

	public List<DicWhStorageBinKey> getKeyList() {
		return this.keyList;
	}

	public void setKeyList(final List<DicWhStorageBinKey> keyList) {
		this.keyList = keyList;
	}

	public Set<String> getAllTypeSet() {
		return allTypeSet;
	}

	public void setAllTypeSet(Set<String> allTypeSet) {
		this.allTypeSet = allTypeSet;
	}

	public String getBinEnableFlag() {
		return binEnableFlag;
	}

	public void setBinEnableFlag(String binEnableFlag) {
		this.binEnableFlag = binEnableFlag;
	}
	
	public Integer getLoginCode() {
		return loginCode;
	}

	public void setLoginCode(Integer loginCode) {
		this.loginCode = loginCode;
	}
	
	public Set<String> getTypeSet() {
		return typeSet;
	}

	public void setTypeSet(Set<String> typeSet) {
		this.typeSet = typeSet;
	}

	private String matGroupCode;

	public String getMatGroupCode() {
		return matGroupCode;
	}

	public void setMatGroupCode(String matGroupCode) {
		this.matGroupCode = matGroupCode;
	}

	@Override
	public String toString() {
		return "DicWhStorageBinListCo{" +
				"whCode='" + whCode + '\'' +
				", typeCode='" + typeCode + '\'' +
				", binCode='" + binCode + '\'' +
				", used=" + used +
				", saveOrUpdateFlag=" + saveOrUpdateFlag +
				", beginDate='" + beginDate + '\'' +
				", endDate='" + endDate + '\'' +
				", stockTakeType=" + stockTakeType +
				", sectionCode='" + sectionCode + '\'' +
				", pickingAreaCode='" + pickingAreaCode + '\'' +
				", freezeInput=" + freezeInput +
				", freezeReasonCode='" + freezeReasonCode + '\'' +
				", freezeOutput=" + freezeOutput +
				", storageCellTypeCode=" + storageCellTypeCode +
				", storageCellMax=" + storageCellMax +
				", weightMax=" + weightMax +
				", weightUnitCode='" + weightUnitCode + '\'' +
				", volumeMax=" + volumeMax +
				", volumeUnitCode='" + volumeUnitCode + '\'' +
				", xCoordinate=" + xCoordinate +
				", yCoordinate=" + yCoordinate +
				", zCoordinate=" + zCoordinate +
				", dicTextList=" + dicTextList +
				", binTypeCode='" + binTypeCode + '\'' +
				", reasonName='" + reasonName + '\'' +
				", binTypeName='" + binTypeName + '\'' +
				", virtualBin=" + virtualBin +
				", allTypeSet=" + allTypeSet +
				", keyList=" + keyList +
				'}';
	}

	public String getWhStorageBinExt0() {
		return whStorageBinExt0;
	}

	public void setWhStorageBinExt0(String whStorageBinExt0) {
		this.whStorageBinExt0 = whStorageBinExt0;
	}

	public String getMatCode() {
		return matCode;
	}

	public void setMatCode(String matCode) {
		this.matCode = matCode;
	}

	public String getLotNumb() {
		return lotNumb;
	}

	public void setLotNumb(String lotNumb) {
		this.lotNumb = lotNumb;
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

}
