package com.inossem.wms.co.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.co.sys.SysUserDeleteAndLockStatusCo", description="用户基础状态对象")
public class SysUserDeleteAndLockStatusCo {
	
	@ApiModelProperty(value="用户ID", name="userId",example="20", required=true)
	private Integer userId;
	
	@ApiModelProperty(value="修改人Id", name="modifyUserId", example="0", required=false)
    private Integer modifyUserId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getModifyUserId() {
		return modifyUserId;
	}

	public void setModifyUserId(Integer modifyUserId) {
		this.modifyUserId = modifyUserId;
	}
	
	

}
