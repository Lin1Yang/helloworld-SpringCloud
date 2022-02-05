package com.inossem.wms.vo.conf;

import java.util.List;

public class MqRetryReturnVo {
	
	private int totalCount;

	private List<MqRetryVo> retryList;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<MqRetryVo> getRetryList() {
		return retryList;
	}

	public void setRetryList(List<MqRetryVo> retryList) {
		this.retryList = retryList;
	}
	
}
