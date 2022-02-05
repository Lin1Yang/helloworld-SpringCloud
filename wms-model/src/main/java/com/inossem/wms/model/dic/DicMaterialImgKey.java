package com.inossem.wms.model.dic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.dic.DicMaterialImgKey", description="物料图片组合键")
public class DicMaterialImgKey {
	@ApiModelProperty(value="物料编码", name="matCode", example="60000020", required=true)
    private String matCode;

	@ApiModelProperty(value="文件编码", name="fileCode", example="4d20282d1d9e4dc6abf0b5a92eb7c8bb.jpg", required=true)
    private String fileCode;
	
	@ApiModelProperty(value="图片编码", name="imgCode", example="0", required=true)
    private String imgCode;

    public String getMatCode() {
        return matCode;
    }

    public void setMatCode(String matCode) {
        this.matCode = matCode == null ? null : matCode.trim();
    }

    public String getFileCode() {
        return fileCode;
    }

    public void setFileCode(String fileCode) {
        this.fileCode = fileCode == null ? null : fileCode.trim();
    }

	public String getImgCode() {
		return imgCode;
	}

	public void setImgCode(String imgCode) {
		this.imgCode = imgCode;
	}
}