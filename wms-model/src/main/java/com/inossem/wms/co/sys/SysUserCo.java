package com.inossem.wms.co.sys;


import com.inossem.wms.page.PageCommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.co.sys.SysUserCo", description="用户入参对象")
public class SysUserCo extends PageCommon{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1892837645433833636L;

	@ApiModelProperty(value="用户列表查询条件-用户编码userCode或用户名称userName", name="condition",example="1", required=true)
	private String condition; //查询条件
		
	@ApiModelProperty(value="公司编码", name="corpCode", example="9000", required=true)
    private String corpCode;

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}
	
	
	
	
	
}
