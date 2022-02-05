package com.inossem.wms.vo.auth;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author cdq
 *
 */
@ApiModel(value="com.inossem.wms.vo.auth.ToDoRecourceListVo", description="待办事项总对象")
public class ToDoResourceCountListVo {
	
	
	@ApiModelProperty(value = "代办事项数量对象集合")
	private List<ToDoResourceCountVo> toDoList;

	public List<ToDoResourceCountVo> getToDoList() {
		return toDoList;
	}

	public void setToDoList(List<ToDoResourceCountVo> toDoList) {
		this.toDoList = toDoList;
	}

	
	
	
    
    

  
}