package com.inossem.wms.vo.dic;

import java.util.List;

import com.inossem.wms.page.IPageResultCommon;

public class DicWhStorageBinListVo implements IPageResultCommon{
	
	private int totalCount;

	private List<DicWhStorageBinVo> headList;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<DicWhStorageBinVo> getHeadList() {
		return headList;
	}

	public void setHeadList(List<DicWhStorageBinVo> headList) {
		this.headList = headList;
	}
}
