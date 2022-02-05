package com.inossem.wms.vo.dic;

import com.inossem.wms.model.dic.DicMaterial;

public class DicMaterialVo extends DicMaterial {

	/**
	 * 
	 */
	private static final long serialVersionUID = -677322964269646843L;
	private String matTypeName;
	private String unitName;
	private String decimalPlace;
	
	private boolean isClick;
	public String getMatTypeName() {
		return matTypeName;
	}
	public void setMatTypeName(String matTypeName) {
		this.matTypeName = matTypeName;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getDecimalPlace() {
		return decimalPlace;
	}
	public void setDecimalPlace(String decimalPlace) {
		this.decimalPlace = decimalPlace;
	}
	public boolean isClick() {
		return isClick;
	}
	public void setClick(boolean isClick) {
		this.isClick = isClick;
	}
	
}
