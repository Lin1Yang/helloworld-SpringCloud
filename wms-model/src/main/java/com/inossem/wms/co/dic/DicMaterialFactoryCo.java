package com.inossem.wms.co.dic;

import com.inossem.wms.page.PageCommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.co.dic.DicMaterialFactoryCo", description="工厂物料列表查询条件对象")
public class DicMaterialFactoryCo extends PageCommon{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8138523213513596018L;

	@ApiModelProperty(value="物料编码", name="matCode",example="82500000002", required=true)
	private String matCode;

	@ApiModelProperty(value="工厂编码", name="ftyCode",example="9030", required=true)
	private String ftyCode;

	public String getMatCode() {
		return matCode;
	}

	public void setMatCode(String matCode) {
		this.matCode = matCode;
	}

	public String getFtyCode() {
		return ftyCode;
	}

	public void setFtyCode(String ftyCode) {
		this.ftyCode = ftyCode;
	}
}
