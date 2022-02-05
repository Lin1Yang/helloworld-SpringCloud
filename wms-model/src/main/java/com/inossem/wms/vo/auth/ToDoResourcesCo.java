package com.inossem.wms.vo.auth;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.vo.auth.ToDoResourcesCo", description="选中的待办或快捷方式对象")
public class ToDoResourcesCo {
	
	@ApiModelProperty(value = "选中的待办或快捷方式reourcecode集合",example="[1,2]")
    private List<String> resourceCodes;

	@ApiModelProperty(value = "web端调用还是pad端",example="pad 1  web 0")
	private Integer resourcesType;
	
	@ApiModelProperty(value = "类型",example="10或20")
	private Integer type;
	@ApiModelProperty(value = "用户id",example="1")
	private String userId;
	@ApiModelProperty(value = "菜单code",example="1")
	private String resourcesCode;
	@ApiModelProperty(value = "代办标识",example="1")
	private Integer todolist;
	@ApiModelProperty(value = "快捷方式标识",example="1")
	private Integer shortcut;
	
	public List<String> getResourceCodes() {
		return resourceCodes;
	}

	public void setResourceCodes(List<String> resourceCodes) {
		this.resourceCodes = resourceCodes;
	}

	public Integer getResourcesType() {
		return resourcesType;
	}

	public void setResourcesType(Integer resourcesType) {
		this.resourcesType = resourcesType;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getResourcesCode() {
		return resourcesCode;
	}

	public void setResourcesCode(String resourcesCode) {
		this.resourcesCode = resourcesCode;
	}

	public Integer getTodolist() {
		return todolist;
	}

	public void setTodolist(Integer todolist) {
		this.todolist = todolist;
	}

	public Integer getShortcut() {
		return shortcut;
	}

	public void setShortcut(Integer shortcut) {
		this.shortcut = shortcut;
	}

	

    
    

  
}