package com.inossem.wms.vo.conf;

import java.util.List;

public class AppUpgradeListVo {
	
	private int totalCount;

	private List<AppUpgradeVo> upgradeFileList;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<AppUpgradeVo> getUpgradeFileList() {
		return upgradeFileList;
	}

	public void setUpgradeFileList(List<AppUpgradeVo> upgradeFileList) {
		this.upgradeFileList = upgradeFileList;
	}
	
}
