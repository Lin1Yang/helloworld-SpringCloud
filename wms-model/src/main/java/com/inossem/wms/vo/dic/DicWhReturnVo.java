package com.inossem.wms.vo.dic;

import java.util.List;

import com.inossem.wms.model.dic.DicWh;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="com.inossem.wms.vo.dic.DicWhReturnVo", description="仓库返回的总对象")
public class DicWhReturnVo  {
	
	@ApiModelProperty(value="仓库集合")
	private List<DicWh> whList;

	public List<DicWh> getWhList() {
		return whList;
	}

	public void setWhList(List<DicWh> whList) {
		this.whList = whList;
	}

}
