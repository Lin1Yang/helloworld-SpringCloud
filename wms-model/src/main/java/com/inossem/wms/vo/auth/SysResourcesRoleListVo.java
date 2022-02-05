package com.inossem.wms.vo.auth;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.vo.auth.SysResourcesRoleListVo", description="所有权限对象")
public class SysResourcesRoleListVo {
	
	@ApiModelProperty(value="所有权限拓展信息集合", name="headList", required=true)
	private List<SysResourcesRoleVo> headList;

	public List<SysResourcesRoleVo> getHeadList() {
		return headList;
	}

	public void setHeadList(List<SysResourcesRoleVo> headList) {
		this.headList = headList;
	}
	
	

}
