package com.inossem.wms.co.dic;

import java.util.List;

import com.inossem.wms.model.dic.DicMaterialWh;
import com.inossem.wms.model.dic.DicMaterialWhStorageType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.co.dic.DicMaterialWhInfoCo", description="物料仓库信息添加或修改入参对象")
public class DicMaterialWhInfoCo extends DicMaterialWh {
	@ApiModelProperty(value = "是否添加 true-添加 false-修改", name = "isAdd", example = "false", required = true)
	private Boolean isAdd;
    
	@ApiModelProperty(value="物料描述", name="matName",example="钢", required=true)
    private String matName;
	
	@ApiModelProperty(value="物料组描述", name="matGroupName",example="钢材组", required=true)
    private String matGroupName;
	
	@ApiModelProperty(value="仓库描述", name="whName",example="库", required=true)
    private String whName;

	@ApiModelProperty(value="基本计量单位", name="unitCode",example="CDM", required=true)
	private String unitCode;

	@ApiModelProperty(value="基本计量单位描述", name="unitName",example="千克", required=true)
	private String unitName;

	@ApiModelProperty(value="仓库计量单位描述", name="unitName",example="千克", required=true)
	private String whUnitName;

	@ApiModelProperty(value = "存储类型列表", name = "storageTypeList", required = true)
	private List<DicMaterialWhStorageType> storageTypeList;
	
	public Boolean getIsAdd() {
		return isAdd;
	}

	public void setIsAdd(Boolean isAdd) {
		this.isAdd = isAdd;
	}

	public String getMatName() {
		return matName;
	}

	public void setMatName(String matName) {
		this.matName = matName;
	}

	public String getMatGroupName() {
		return matGroupName;
	}

	public void setMatGroupName(String matGroupName) {
		this.matGroupName = matGroupName;
	}

	public String getWhName() {
		return whName;
	}

	public void setWhName(String whName) {
		this.whName = whName;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getWhUnitName() {
		return whUnitName;
	}

	public void setWhUnitName(String whUnitName) {
		this.whUnitName = whUnitName;
	}

	public List<DicMaterialWhStorageType> getStorageTypeList() {
		return storageTypeList;
	}

	public void setStorageTypeList(List<DicMaterialWhStorageType> storageTypeList) {
		this.storageTypeList = storageTypeList;
	}

}
