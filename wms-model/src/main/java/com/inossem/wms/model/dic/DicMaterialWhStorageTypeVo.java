package com.inossem.wms.model.dic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.dic.DicMaterialWhStorageTypeVo", description="物料仓库存储类型对象")
public class DicMaterialWhStorageTypeVo extends DicMaterialWhStorageType {

	@ApiModelProperty(value="存储类型数组", name="storageTypeCodes",example="['001','002']", required=true)
    private String[] storageTypeCodes;

	public String[] getStorageTypeCodes() {
		return storageTypeCodes;
	}

	public void setStorageTypeCodes(String[] storageTypeCodes) {
		this.storageTypeCodes = storageTypeCodes;
	}

}