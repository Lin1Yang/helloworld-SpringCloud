package com.inossem.wms.vo.rel;

import java.util.List;

import io.swagger.annotations.ApiModel;

@ApiModel(value="com.inossem.wms.vo.rel.RelUnitListVo", description="物料计量单位换算出参对象")
public class RelUnitListVo{
	
	private List<RelUnitVo> headList;
	
	private Integer totalCount;

	public List<RelUnitVo> getHeadList() {
		return headList;
	}

	public void setHeadList(List<RelUnitVo> headList) {
		this.headList = headList;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	
	

}
