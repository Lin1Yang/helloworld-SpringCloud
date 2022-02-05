package com.inossem.wms.vo.dic;

import java.util.ArrayList;
import java.util.List;

import com.inossem.wms.model.dic.DicLanguage;
import com.inossem.wms.model.dic.DicMaterialGroup;
import com.inossem.wms.model.dic.DicMaterialImgVo;
import com.inossem.wms.model.dic.DicMaterialName;
import com.inossem.wms.model.dic.DicMaterialType;
import com.inossem.wms.model.dic.DicUnit;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.vo.dic.DicMaterialManageInfoVo", description="物料主数据详情对象")
public class DicMaterialManageInfoVo{
	
	@ApiModelProperty(value="物料主数据拓展信息对象")
	private DicMaterialManageVo manageVo = new DicMaterialManageVo();
	
	@ApiModelProperty(value="语言类型集合")
	private List<DicLanguage> languageList = new ArrayList<DicLanguage>();
	
	@ApiModelProperty(value="单位集合")
	private List<DicUnit> unitList = new ArrayList<DicUnit>();
	
	@ApiModelProperty(value="物料类型集合")
	private List<DicMaterialType> matTypeList = new ArrayList<DicMaterialType>();
	
	@ApiModelProperty(value="物料组集合")
	private List<DicMaterialGroup> matGroupList = new ArrayList<DicMaterialGroup>();
	
	@ApiModelProperty(value="多语言集合")
	private List<DicMaterialName> materialNameList = new ArrayList<DicMaterialName>();
	
	@ApiModelProperty(value="物料图片集合")
	private List<DicMaterialImgVo> imgList = new ArrayList<DicMaterialImgVo>();
				
	public DicMaterialManageVo getManageVo() {
		return manageVo;
	}

	public void setManageVo(DicMaterialManageVo manageVo) {
		this.manageVo = manageVo;
	}

	public List<DicLanguage> getLanguageList() {
		return languageList;
	}

	public void setLanguageList(List<DicLanguage> languageList) {
		this.languageList = languageList;
	}

	public List<DicUnit> getUnitList() {
		return unitList;
	}

	public void setUnitList(List<DicUnit> unitList) {
		this.unitList = unitList;
	}

	public List<DicMaterialType> getMatTypeList() {
		return matTypeList;
	}

	public void setMatTypeList(List<DicMaterialType> matTypeList) {
		this.matTypeList = matTypeList;
	}

	public List<DicMaterialGroup> getMatGroupList() {
		return matGroupList;
	}

	public void setMatGroupList(List<DicMaterialGroup> matGroupList) {
		this.matGroupList = matGroupList;
	}

	public List<DicMaterialName> getMaterialNameList() {
		return materialNameList;
	}

	public void setMaterialNameList(List<DicMaterialName> materialNameList) {
		this.materialNameList = materialNameList;
	}

	public List<DicMaterialImgVo> getImgList() {
		return imgList;
	}

	public void setImgList(List<DicMaterialImgVo> imgList) {
		this.imgList = imgList;
	}	
	
	
	
	

}
