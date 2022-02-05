package com.inossem.wms.co.dic;

import java.util.List;

import com.inossem.wms.vo.dic.DicAccountPeriodVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.co.dic.DicAccountPeriodListCo", description="账期入参对象")
public class DicAccountPeriodListCo {
	
	@ApiModelProperty(value = "删除复制详情传accountPeriodId集合")
	private List<Integer> idList;
	
	@ApiModelProperty(value = "新增修改传DicAccountPeriodVo对象集合")
	private List<DicAccountPeriodVo> periodList;


	public List<Integer> getIdList() {
		return idList;
	}

	public void setIdList(List<Integer> idList) {
		this.idList = idList;
	}

	public List<DicAccountPeriodVo> getPeriodList() {
		return periodList;
	}

	public void setPeriodList(List<DicAccountPeriodVo> periodList) {
		this.periodList = periodList;
	}
	
	

}
