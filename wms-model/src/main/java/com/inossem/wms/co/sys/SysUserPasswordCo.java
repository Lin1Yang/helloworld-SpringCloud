package com.inossem.wms.co.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.co.sys.SysUserPasswordCo", description="用户密码对象")
public class SysUserPasswordCo extends SysUserDeleteAndLockStatusCo{
	
	@ApiModelProperty(value="用户密码", name="password", example="123456", required=true)
    private String password;
	
	@ApiModelProperty(value="用户编码", name="userCode", example="CS000015", required=true)
    private String userCode;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
		

}
