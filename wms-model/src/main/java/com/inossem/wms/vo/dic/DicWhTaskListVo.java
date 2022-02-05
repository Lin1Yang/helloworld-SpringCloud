package com.inossem.wms.vo.dic;

import java.util.List;

import com.inossem.wms.page.IPageResultCommon;

import io.swagger.annotations.ApiModelProperty;

public class DicWhTaskListVo implements IPageResultCommon{
	
	private int totalCount;
	
	@ApiModelProperty(value="入库顺序", name="", example="")
    private List<DicWhDropDownCodeVo> taskInputList;
	
	@ApiModelProperty(value="出库顺序", name="", example="")
    private List<DicWhDropDownCodeVo> taskOutputList;

	public List<DicWhDropDownCodeVo> getTaskInputList() {
		return taskInputList;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<DicWhDropDownCodeVo> getTaskOutputList() {
		return taskOutputList;
	}

	public void setTaskOutputList(List<DicWhDropDownCodeVo> taskOutputList) {
		this.taskOutputList = taskOutputList;
	}

	public void setTaskInputList(List<DicWhDropDownCodeVo> taskInputList) {
		this.taskInputList = taskInputList;
	}
}
