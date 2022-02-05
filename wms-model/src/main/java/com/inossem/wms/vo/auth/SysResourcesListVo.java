package com.inossem.wms.vo.auth;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.vo.auth.SysResourcesListVo", description="菜单集合对象")
public class SysResourcesListVo {
	
	@ApiModelProperty(value = "菜单集合")
    private List<SysResourcesVo> menu;
	
	@ApiModelProperty(value = "用户ID")
	private Integer userId;
	
	@ApiModelProperty(value = "用户名编码")
	private String userCode;
	
	@ApiModelProperty(value = "用户名")
	private String userName;
	
	@ApiModelProperty(value="公司代码")
    private String corpCode;
	
    @ApiModelProperty(value="公司描述")
    private String corpName;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public List<SysResourcesVo> getMenu() {
		return menu;
	}

	public void setMenu(List<SysResourcesVo> menu) {
		this.menu = menu;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}


    
    

  
}