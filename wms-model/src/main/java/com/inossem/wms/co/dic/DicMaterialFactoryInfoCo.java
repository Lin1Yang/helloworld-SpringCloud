package com.inossem.wms.co.dic;

import com.inossem.wms.model.dic.DicMaterialFactory;

import io.swagger.annotations.ApiModel;


@ApiModel(value="com.inossem.wms.co.dic.DicMaterialCo", description="工厂物料列表保存对象")
public class DicMaterialFactoryInfoCo extends DicMaterialFactory {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6126550785221800536L;
	private Boolean isAdd;

	public Boolean getAdd() {
		return isAdd;
	}

	public void setAdd(Boolean add) {
		isAdd = add;
	}
}
