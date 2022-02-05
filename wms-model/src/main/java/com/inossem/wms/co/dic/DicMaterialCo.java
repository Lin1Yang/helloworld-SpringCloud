package com.inossem.wms.co.dic;

import com.inossem.wms.page.PageCommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.co.dic.DicMaterialCo", description="物料列表查询条件对象")
public class DicMaterialCo extends PageCommon{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3544234318464350917L;

	@ApiModelProperty(value="物料列表查询条件-物料编码或者物料描述", name="condition",example="1", required=true)
	private String condition; //查询条件
	
	@ApiModelProperty(value="语言版本", name="langCode",example="zh-CN", required=true)
	private String langCode;
	
	

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	
	
}
