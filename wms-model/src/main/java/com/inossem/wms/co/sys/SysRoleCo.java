package com.inossem.wms.co.sys;

import com.inossem.wms.page.PageCommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="com.inossem.wms.co.sys.SysRoleCo", description="角色对象查询对象")
public class SysRoleCo extends PageCommon{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 6648783197762731571L;
	@ApiModelProperty(value="角色列表查询条件", name="condition",example="123", required=true)
	private String condition; 

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	
}
