package com.inossem.wms.vo.auth;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.vo.auth.ToDoResourcesListVo", description="待办事项总对象")
public class ToDoResourcesListVo {
	
	//子集节点集合
	@ApiModelProperty(value = "代办列表集合")
    private List<ToDoResourcesVo> list;

	public List<ToDoResourcesVo> getList() {
		return list;
	}

	public void setList(List<ToDoResourcesVo> list) {
		this.list = list;
	}

	


    
    

  
}