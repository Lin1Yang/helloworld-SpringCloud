package com.inossem.wms.vo.dic;

import com.inossem.wms.model.dic.DicMaterial;
import com.inossem.wms.page.IPageResultCommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.vo.dic.DicMaterialManageVo", description="物料主数据拓展信息对象")
public class DicMaterialManageVo extends DicMaterial implements IPageResultCommon{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1503962666785188642L;

	@ApiModelProperty(value="总数量", name="totalCount",example="100", required=true)
	private int totalCount; 
	
	@ApiModelProperty(value="物料组描述", name="matGroupName",example="ddd", required=true)
	private String matGroupName;
	
	@ApiModelProperty(value="物料类型描述", name="matTypeName",example="物料类型", required=true)
	private String matTypeName; 
	
	@ApiModelProperty(value="语言类型编码", name="langCode",example="zh-CN", required=true)
	private String langCode; 
	
	@ApiModelProperty(value="计量单位描述", name="unitName",example="千克", required=true)
	private String unitName;
	
	@ApiModelProperty(value="计量单位精度", name="decimalPlace",example="3", required=true)
	private Byte decimalPlace;
	
	@ApiModelProperty(value="长度/宽度/高度的单位描述", name="unitLengthName",example="米", required=true)
	private String unitLengthName;
	
	@ApiModelProperty(value="长度/宽度/高度的单位精度", name="decimalPlaceLength",example="0", required=true)
	private Byte decimalPlaceLength;
	
	@ApiModelProperty(value="重量的单位描述", name="unitWeightName",example="千克", required=true)
	private String unitWeightName;
	
	@ApiModelProperty(value="重量的单位精度", name="decimalPlaceWeight",example="3", required=true)
	private Byte decimalPlaceWeight;
	
	@ApiModelProperty(value="体积的单位描述", name="unitVolumeName",example="立方米", required=true)
	private String unitVolumeName;
	
	@ApiModelProperty(value="体积的单位精度", name="decimalPlaceVolume",example="0", required=true)
	private Byte decimalPlaceVolume;
	
	@ApiModelProperty(value="国际化序号", name="tid",example="i18n_0000000022_mid", required=true)
	private String tid;
	
	
	
	

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public String getMatGroupName() {
		return matGroupName;
	}

	public void setMatGroupName(String matGroupName) {
		this.matGroupName = matGroupName;
	}

	public String getMatTypeName() {
		return matTypeName;
	}

	public void setMatTypeName(String matTypeName) {
		this.matTypeName = matTypeName;
	}

	
	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}
		

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public Byte getDecimalPlace() {
		return decimalPlace;
	}

	public void setDecimalPlace(Byte decimalPlace) {
		this.decimalPlace = decimalPlace;
	}

	public String getUnitLengthName() {
		return unitLengthName;
	}

	public void setUnitLengthName(String unitLengthName) {
		this.unitLengthName = unitLengthName;
	}

	public Byte getDecimalPlaceLength() {
		return decimalPlaceLength;
	}

	public void setDecimalPlaceLength(Byte decimalPlaceLength) {
		this.decimalPlaceLength = decimalPlaceLength;
	}

	public String getUnitWeightName() {
		return unitWeightName;
	}

	public void setUnitWeightName(String unitWeightName) {
		this.unitWeightName = unitWeightName;
	}

	public Byte getDecimalPlaceWeight() {
		return decimalPlaceWeight;
	}

	public void setDecimalPlaceWeight(Byte decimalPlaceWeight) {
		this.decimalPlaceWeight = decimalPlaceWeight;
	}

	public String getUnitVolumeName() {
		return unitVolumeName;
	}

	public void setUnitVolumeName(String unitVolumeName) {
		this.unitVolumeName = unitVolumeName;
	}

	public Byte getDecimalPlaceVolume() {
		return decimalPlaceVolume;
	}

	public void setDecimalPlaceVolume(Byte decimalPlaceVolume) {
		this.decimalPlaceVolume = decimalPlaceVolume;
	}	

}
