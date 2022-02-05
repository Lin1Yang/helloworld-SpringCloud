package com.inossem.wms.co.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.co.sys.SysUserFreezeStatusCo", description="用户冻结状态对象")
public class SysUserFreezeStatusCo extends SysUserDeleteAndLockStatusCo{
		
	@ApiModelProperty(value="冻结标识 0-冻结，1-正常", name="freeze", example="0", required=true)
    private Byte freeze;

	public Byte getFreeze() {
		return freeze;
	}

	public void setFreeze(Byte freeze) {
		this.freeze = freeze;
	}
	

}
