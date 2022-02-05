package com.inossem.wms.co.dic;

import com.inossem.wms.page.PageCommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="com.inossem.wms.co.dic.DicNoticeCo", description="搜索条件 带分页")
public class DicNoticeCo extends PageCommon{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9214565650597008873L;
	//首页url列表  高级搜索条件
	@ApiModelProperty(value = "搜索条件",example="元旦")
	private String condition;
	@ApiModelProperty(value = "通知状态",example="0")
	private Integer status;

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}