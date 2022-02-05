package com.inossem.wms.vo.take;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="com.inossem.wms.vo.take.BizStockTakeListDataVo", description="盘点列表集合对象")
public class BizStockTakeListDataVo {
	
	@ApiModelProperty(value="盘点列表集合对象", name="", example="", required=true)
	private List<BizStockTakeHeadVo> list;
	@ApiModelProperty(value = "记录数")
	private Integer totalCount;

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public List<BizStockTakeHeadVo> getList() {
		return list;
	}

	public void setList(List<BizStockTakeHeadVo> list) {
		this.list = list;
	}
}
