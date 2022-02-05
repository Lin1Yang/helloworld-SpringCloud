package com.inossem.wms.model.dic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.dic.DicMaterialWhKey", description="物料仓库数据表主键对象")
public class DicMaterialWhKey {
	
	@ApiModelProperty(value="仓库编码", name="whCode",example="S01", required=true)
    private String whCode;

	@ApiModelProperty(value="物料编码", name="matCode",example="60000001", required=true)
    private String matCode;

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode == null ? null : whCode.trim();
    }

    public String getMatCode() {
        return matCode;
    }

    public void setMatCode(String matCode) {
        this.matCode = matCode == null ? null : matCode.trim();
    }
}