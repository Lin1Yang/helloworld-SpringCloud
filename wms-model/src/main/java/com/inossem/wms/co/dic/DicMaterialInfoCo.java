package com.inossem.wms.co.dic;

import java.util.ArrayList;
import java.util.List;

import com.inossem.wms.model.dic.DicMaterial;
import com.inossem.wms.model.dic.DicMaterialImgKey;
import com.inossem.wms.model.dic.DicMaterialName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.co.dic.DicMaterialInfoCo", description="保存物料信息入参对象")
public class DicMaterialInfoCo extends DicMaterial{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -115030441832045734L;

	@ApiModelProperty(value = "是否添加 true-添加 false-修改", name = "isAdd", example = "false", required = true)
	private Boolean isAdd;
	
	@ApiModelProperty(value="语言版本", name="langCode",example="zh-CN", required=true)
	private String langCode;
	
	@ApiModelProperty(value="物料组描述", name="matGroupName", example="不知道为啥就想写个01", required=true)
    private String matGroupName;
	
	@ApiModelProperty(value="计量单位描述", name="unitName", example="千克", required=true)
    private String unitName;
	
	@ApiModelProperty(value="物料类型描述", name="matTypeName", example="物料类型1", required=true)
    private String matTypeName;
	
	@ApiModelProperty(value="多语言集合")
	private List<DicMaterialName> materialNameList = new ArrayList<DicMaterialName>();
	
	@ApiModelProperty(value="物料图片集合")
	List<DicMaterialImgKey> imgList =  new ArrayList<DicMaterialImgKey>();

	public Boolean getIsAdd() {
		return isAdd;
	}

	public void setIsAdd(Boolean isAdd) {
		this.isAdd = isAdd;
	}

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	public String getMatGroupName() {
		return matGroupName;
	}

	public void setMatGroupName(String matGroupName) {
		this.matGroupName = matGroupName;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getMatTypeName() {
		return matTypeName;
	}

	public void setMatTypeName(String matTypeName) {
		this.matTypeName = matTypeName;
	}

	public List<DicMaterialName> getMaterialNameList() {
		return materialNameList;
	}

	public void setMaterialNameList(List<DicMaterialName> materialNameList) {
		this.materialNameList = materialNameList;
	}

	public List<DicMaterialImgKey> getImgList() {
		return imgList;
	}

	public void setImgList(List<DicMaterialImgKey> imgList) {
		this.imgList = imgList;
	}
	
	
	
	

}
