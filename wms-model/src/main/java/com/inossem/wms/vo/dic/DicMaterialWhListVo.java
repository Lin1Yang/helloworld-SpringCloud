package com.inossem.wms.vo.dic;

import java.util.List;

import com.inossem.wms.page.IPageResultCommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.vo.dic.DicMaterialWhListVo", description="物料仓库拓展信息对象")
public class DicMaterialWhListVo implements IPageResultCommon{
	
	@ApiModelProperty(value="总数量", name="totalCount",example="100", required=true)
	private int totalCount; 
	
	@ApiModelProperty(value="物料仓库拓展信息集合", name="headList", required=true)
	private List<DicMaterialWhVo> headList;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<DicMaterialWhVo> getHeadList() {
		return headList;
	}

	public void setHeadList(List<DicMaterialWhVo> headList) {
		this.headList = headList;
	}
	
	


}
