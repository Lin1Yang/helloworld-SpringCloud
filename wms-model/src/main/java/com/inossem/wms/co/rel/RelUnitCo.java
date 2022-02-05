package com.inossem.wms.co.rel;

import com.inossem.wms.model.rel.RelUnit;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="com.inossem.wms.co.rel.RelUnitCo", description="物料计量单位换算入参对象")
public class RelUnitCo extends RelUnit {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4154405463211812261L;

	@ApiModelProperty(value="查询条件")
	private String condition;
	
	@ApiModelProperty(name="isEdit",value="0新增  1修改")
	private Byte isEdit;
	
	/**
	 * 语言类型 zh-CN简体中文 en-US简体英文
	 */
	@ApiModelProperty(value="语言类型 不必传后台根据用户id获取", name="langCode")
	private String langCode;	

	public Byte getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Byte isEdit) {
		this.isEdit = isEdit;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}
	
	

}
