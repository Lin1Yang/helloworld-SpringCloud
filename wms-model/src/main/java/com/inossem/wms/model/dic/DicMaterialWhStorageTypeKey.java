package com.inossem.wms.model.dic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.dic.DicMaterialWhStorageTypeKey", description="物料仓库存储类型表主键对象")
public class DicMaterialWhStorageTypeKey {
	
	@ApiModelProperty(value="仓库编码", name="whCode",example="S01", required=true)
    private String whCode;

	@ApiModelProperty(value="物料编码", name="matCode",example="60000001", required=true)
    private String matCode;

	@ApiModelProperty(value="存储类型", name="storageTypeCode",example="001", required=true)
    private String storageTypeCode;

    public String getMatCode() {
        return matCode;
    }

    public void setMatCode(String matCode) {
        this.matCode = matCode == null ? null : matCode.trim();
    }

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode == null ? null : whCode.trim();
    }

    public String getStorageTypeCode() {
        return storageTypeCode;
    }

    public void setStorageTypeCode(String storageTypeCode) {
        this.storageTypeCode = storageTypeCode == null ? null : storageTypeCode.trim();
    }

    public DicMaterialWhStorageTypeKey(String whCode, String matCode, String storageTypeCode) {
        this.whCode = whCode;
        this.matCode = matCode;
        this.storageTypeCode = storageTypeCode;
    }

    public DicMaterialWhStorageTypeKey() {
    }

    @Override
    public String toString() {
        return "DicMaterialWhStorageTypeKey{" +
                "whCode='" + whCode + '\'' +
                ", matCode='" + matCode + '\'' +
                ", storageTypeCode='" + storageTypeCode + '\'' +
                '}';
    }
}