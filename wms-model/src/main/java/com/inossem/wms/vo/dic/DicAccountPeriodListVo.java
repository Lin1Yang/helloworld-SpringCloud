package com.inossem.wms.vo.dic;

import java.util.List;

import io.swagger.annotations.ApiModel;

@ApiModel(value="com.inossem.wms.vo.dic.DicAccountPeriodListVo", description="账期出参分页对象")
public class DicAccountPeriodListVo {
	private int totalCount;
	
	private List<DicAccountPeriodVo> headList;
	
	

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<DicAccountPeriodVo> getHeadList() {
		return headList;
	}

	public void setHeadList(List<DicAccountPeriodVo> headList) {
		this.headList = headList;
	}
	
	

}
