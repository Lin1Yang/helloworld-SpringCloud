package com.inossem.wms.vo.dic;

import java.util.List;

import com.inossem.wms.page.IPageResultCommon;


public class DicWhStorageTypeListVo implements IPageResultCommon{
	
	private int totalCount;

	private List<DicWhStorageTypeVo> headList;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<DicWhStorageTypeVo> getHeadList() {
		return headList;
	}

	public void setHeadList(List<DicWhStorageTypeVo> headList) {
		this.headList = headList;
	}
}
