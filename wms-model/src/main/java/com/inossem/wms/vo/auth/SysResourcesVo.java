package com.inossem.wms.vo.auth;

import java.util.List;

import com.inossem.wms.model.sys.SysResources;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.vo.auth.SysResourcesVo", description="菜单树形对象")
public class SysResourcesVo extends SysResources{
	
	//子集节点集合
	@ApiModelProperty(value = "子菜单集合")
    private List<SysResourcesVo> childrens;

	public List<SysResourcesVo> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<SysResourcesVo> childrens) {
		this.childrens = childrens;
	}

    
    

  
}