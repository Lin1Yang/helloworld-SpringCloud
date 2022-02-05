package com.inossem.wms.vo.sinobec;

import java.io.Serializable;
import java.util.List;

import com.inossem.wms.model.sinobec.SinobecInsDocBin;

public class SinobecInsMoveTypeVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2080136920269623373L;
	
	
	private List<SinobecInsDocBin> insDocBinList;
	
	


	public List<SinobecInsDocBin> getInsDocBinList() {
		return insDocBinList;
	}


	public void setInsDocBinList(List<SinobecInsDocBin> insDocBinList) {
		this.insDocBinList = insDocBinList;
	}


	

	
}
