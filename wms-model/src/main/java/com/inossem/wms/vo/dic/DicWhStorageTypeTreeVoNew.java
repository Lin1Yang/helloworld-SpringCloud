package com.inossem.wms.vo.dic;

import java.util.ArrayList;
import java.util.List;

import com.inossem.wms.model.dic.DicWhStorageBin;

public class DicWhStorageTypeTreeVoNew extends DicWhStorageTypeNew {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5576863695647944149L;

	private List<DicWhStorageBin> binList = new ArrayList<DicWhStorageBin>();
	
	private List<String> binCodeList = new ArrayList<String>();

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
	
	public List<String> getBinCodeList() {
		return binCodeList;
	}

	public void setBinCodeList(List<String> binCodeList) {
		this.binCodeList = binCodeList;
	}
	

}
