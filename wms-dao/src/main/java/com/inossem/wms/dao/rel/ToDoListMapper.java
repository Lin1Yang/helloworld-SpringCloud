package com.inossem.wms.dao.rel;

import java.util.List;

import com.inossem.wms.co.index.TodolistCountCo;
import com.inossem.wms.vo.index.TodolistCountVo;

public interface ToDoListMapper {

	/**
	 * 查询待办
	 * @param list
	 * @return
	 */
	List<TodolistCountVo> selectTodolistCount(List<TodolistCountCo> list);
	
	/**
	 * 查询待办
	 * @param 
	 * @return
	 */
	int selectTodoInfo(TodolistCountCo co);
}
