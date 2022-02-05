package com.inossem.wms.dao.rel;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.inossem.wms.co.auth.ToDoReceiptListCo;
import com.inossem.wms.model.sys.SysResources;
import com.inossem.wms.vo.auth.ToDoReceiptVo;
import com.inossem.wms.vo.auth.ToDoResourcesCo;
import com.inossem.wms.vo.dic.DicWhUsageVo;
import com.inossem.wms.vo.index.TodolistCountVo;

public interface IndexMapper {

	/**
	 * 根据当前用户获取选中的代办
	 * @param userId
	 * @return
	 */
	 List<SysResources> selectCheckedByUserId(@Param("userId")String userId,@Param("resourcesType")Integer resourcesType) ;
	 
	 /**
	  * 获取代办中用户选中以及未选中的总集合
	  * @param param
	  * @return
	  */
	 List<SysResources> selectCurrentUserToDoResources(ToDoResourcesCo co) ;
	 
	 /**
	  * 获取每种单据的代办 
	  * @param param
	  * @return
	  */
	 int getEveryReceiptCountByParam(Map<String, Object> param);
	 
	 /**
	  * 删除当前用户待办
	  * @param param
	  */
	 void deleteCheckedResources(ToDoResourcesCo co);
	
	 /**
	  * 插入当前待办
	  * @param list
	  */
	 void insertCheckedResources(List<ToDoResourcesCo> list);
	 
	 /**
	  * 根据resources中的todolist_sql 查询 待办数量
	  * @param sql
	  * @return
	  */
	 List<TodolistCountVo> selectTodolistCountBySql(String sql);
	 
	 
	 /**
	  * 查询我的任务清单
	  * @param sql
	  * @return
	  */
	 List<ToDoReceiptVo> selectToDoReceiptList(Map<String, Object> param);

	/**
	 * 查询用户权限下的仓库使用情况
	 * @param userId
	 * @return
	 */
	List<DicWhUsageVo> selectDicWhUsageVoList(Integer userId);

	/**
	 * 查询用户权限下的某时间段内单据量
	 * @param userId
	 * @return
	 */
	List<ToDoReceiptVo> selectReceiptListRecently(ToDoReceiptListCo co);

	 
}
