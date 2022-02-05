package com.inossem.wms.vo.sinobec;

import java.util.List;

import com.inossem.wms.model.sinobec.out.OutputDaoVo;

public class SinobecBizOutputListVo {

	private Integer totalCount;

    private List<OutputDaoVo> list;

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public List<OutputDaoVo> getList() {
		return list;
	}

	public void setList(List<OutputDaoVo> list) {
		this.list = list;
	}
    
}
