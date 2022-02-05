package com.inossem.wms.vo.auth;

import java.util.ArrayList;
import java.util.List;

import com.inossem.wms.model.dic.DicWhStorageBin;
import com.inossem.wms.model.dic.DicWhStorageType;
import com.inossem.wms.model.dic.DicWhStorageTypeKey;

public class DicWhStorageTypeTreeVo extends DicWhStorageType {
	/**
	 * 
	 */
	private static final long serialVersionUID = 582385427816938003L;

	private List<DicWhStorageBin> binList = new ArrayList<DicWhStorageBin>();

	private String whName;

	public String getWhName() {
		return whName;
	}

	public DicWhStorageTypeKey setWhName(String whName) {
		this.whName = whName;
		return this;
	}


	private boolean isClick = false;

	public List<DicWhStorageBin> getBinList() {
		return binList;
	}

	public void setBinList(List<DicWhStorageBin> binList) {
		this.binList = binList;
	}

	public boolean isClick() {
		return isClick;
	}

	public void setClick(boolean isClick) {
		this.isClick = isClick;
	}	
	
}
