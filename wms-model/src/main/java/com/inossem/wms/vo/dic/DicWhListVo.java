package com.inossem.wms.vo.dic;

import java.util.List;

import com.inossem.wms.page.IPageResultCommon;
import com.inossem.wms.vo.auth.DicWhTreeVo;

public class DicWhListVo implements IPageResultCommon{
	
	private int totalCount;

	private List<DicWhTreeVo> headList;
	
	private List<DicWhStorageTypeVo> typeList;
	
	private List<DicWhStorageBinVo> binList;

	public List<DicWhTreeVo> getHeadList() {
		return headList;
	}

	public void setHeadList(List<DicWhTreeVo> headList) {
		this.headList = headList;
	}

	@Override
	public int getTotalCount() {
		return this.totalCount;
	}

	@Override
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<DicWhStorageTypeVo> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<DicWhStorageTypeVo> typeList) {
		this.typeList = typeList;
	}

	public List<DicWhStorageBinVo> getBinList() {
		return binList;
	}

	public void setBinList(List<DicWhStorageBinVo> binList) {
		this.binList = binList;
	}
}
