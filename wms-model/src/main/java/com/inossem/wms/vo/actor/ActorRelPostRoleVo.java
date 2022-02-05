package com.inossem.wms.vo.actor;

import com.inossem.wms.model.actor.ActorRelPostRole;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "com.inossem.wms.vo.actor.ActorRelPostRoleVo",description = "岗位角色关系出参对象")
public class ActorRelPostRoleVo extends ActorRelPostRole{
	@ApiModelProperty(name = "roleName",value ="角色描述")
	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	

}
