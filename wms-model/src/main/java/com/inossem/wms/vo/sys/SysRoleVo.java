package com.inossem.wms.vo.sys;

import com.inossem.wms.model.sys.SysRole;
import com.inossem.wms.page.IPageResultCommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.vo.sys.SysRoleVo", description="角色信息-拓展")
public class SysRoleVo extends SysRole implements IPageResultCommon{
	
	@ApiModelProperty(value="总数量", name="totalCount",example="100", required=true)
	private int totalCount; 
	
	@ApiModelProperty(value="角色创建人编码", name="createUserCode",example="00021", required=true)
	private String createUserCode; 
	
	@ApiModelProperty(value="角色创建人描述", name="createUserName",example="阿萨德", required=true)
	private String createUserName; 
	
	@ApiModelProperty(value="角色修改人编码", name="modifyUserCode",example="00022", required=true)
	private String modifyUserCode; 
	
	@ApiModelProperty(value="角色修改人描述", name="modifyUserName",example="自行车", required=true)
	private String modifyUserName; 

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

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	
	

}
