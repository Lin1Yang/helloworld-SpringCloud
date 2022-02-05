package com.inossem.wms.model.sinobec.query;

import java.util.List;

import io.swagger.annotations.ApiModel;
@ApiModel(value="com.inossem.wms.model.sinobec.query.StockInfoVo",description="库存查询返回对象")
public class StockInfoVo {

	private List<StockBinVo> binList;

	private Integer totalCount;

	public List<StockBinVo> getBinList() {
		return binList;
	}

	public void setBinList(List<StockBinVo> binList) {
		this.binList = binList;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
}
