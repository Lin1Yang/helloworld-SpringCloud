package com.inossem.wms.vo.dic;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class DicStockLocationAndWhTreeVoNew {

	@ApiModelProperty(value="仓库")
	private List<DicWhTreeVoNew> whList = new ArrayList<DicWhTreeVoNew>();
	

	

	public List<DicWhTreeVoNew> getWhList() {
		return whList;
	}

	public void setWhList(List<DicWhTreeVoNew> whList) {
		this.whList = whList;
	}


}
