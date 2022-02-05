package com.inossem.wms.vo.auth;

import java.util.List;

import com.inossem.wms.model.sys.SysResources;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.vo.auth.ToDoResourcesVo", description="待办事项或快捷方式树形对象")
public class ToDoResourcesVo {
	
	//子集节点集合
	@ApiModelProperty(value = "子集待办或快捷方式")
    private List<SysResources> childrens;
	
	@ApiModelProperty(value = "父级代办或快捷方式名称")
	private String pName;

	public List<SysResources> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<SysResources> childrens) {
		this.childrens = childrens;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

    
    

  
}