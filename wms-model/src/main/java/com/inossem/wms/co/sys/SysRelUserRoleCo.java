package com.inossem.wms.co.sys;

import com.inossem.wms.model.sys.SysRelUserRoleKey;

public class SysRelUserRoleCo extends SysRelUserRoleKey{
	
	private String condition; //查询条件

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

}
