package com.inossem.wms.vo.sys;

import com.inossem.wms.model.sys.SysRelUserRole;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.vo.sys.SysRelUserRoleVo", description="用户角色信息拓展对象")
public class SysRelUserRoleVo extends SysRelUserRole{
	
    @ApiModelProperty(value="用户编码", name="userCode",example="admin", required=true)
	private String userCode; 
    
    @ApiModelProperty(value="用户名称", name="userName",example="admin", required=true)
	private String userName; 
    
    @ApiModelProperty(value="角色名称", name="roleName",example="管理", required=true)
	private String roleName; 
    
    @ApiModelProperty(value="用户角色创建人编码", name="createUserCode",example="admin", required=true)
	private String createUserCode; 
    
    @ApiModelProperty(value="用户角色创建人名称", name="createUserName",example="admin", required=true)
	private String createUserName; 
    
    @ApiModelProperty(value="用户角色修改人编码", name="modifyUserCode",example="admin", required=true)
	private String modifyUserCode; 
    
    @ApiModelProperty(value="用户角色修改人名称", name="modifyUserName",example="admin", required=true)
	private String modifyUserName; 

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getCreateUserCode() {
		return createUserCode;
	}

	public void setCreateUserCode(String createUserCode) {
		this.createUserCode = createUserCode;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getModifyUserCode() {
		return modifyUserCode;
	}

	public void setModifyUserCode(String modifyUserCode) {
		this.modifyUserCode = modifyUserCode;
	}

	public String getModifyUserName() {
		return modifyUserName;
	}

	public void setModifyUserName(String modifyUserName) {
		this.modifyUserName = modifyUserName;
	}
	
	
	
}
