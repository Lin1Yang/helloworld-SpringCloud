package com.inossem.wms.co.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.co.sys.SysUserNewPassWordCo", description="用户密码对象")
public class SysUserNewPassWordCo extends SysUserPasswordCo{
	
	@ApiModelProperty(value="用户新密码", name="newPassWord",example="123456", required=true)
	private String newPassWord;
	
	@ApiModelProperty(value="用户新密码确认", name="newPassWordConfirm",example="123456", required=true)
	private String newPassWordConfirm;

	public String getNewPassWord() {
		return newPassWord;
	}

	public void setNewPassWord(String newPassWord) {
		this.newPassWord = newPassWord;
	}

	public String getNewPassWordConfirm() {
		return newPassWordConfirm;
	}

	public void setNewPassWordConfirm(String newPassWordConfirm) {
		this.newPassWordConfirm = newPassWordConfirm;
	}
	
	

}
