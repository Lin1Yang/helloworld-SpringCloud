package com.inossem.wms.vo.sys;

import java.util.List;

import com.inossem.wms.page.IPageResultCommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="com.inossem.wms.vo.sys.SysRoleListVo", description="角色信息拓展集合对象")
public class SysRoleListVo implements IPageResultCommon{
	
	@ApiModelProperty(value="总数量", name="totalCount",example="100", required=true)
	private int totalCount; 
	
	@ApiModelProperty(value="角色信息拓展对象", name="headList", required=true)
	private List<SysRoleVo> headList;

	public List<SysRoleVo> getHeadList() {
		return headList;
	}

	public void setHeadList(List<SysRoleVo> headList) {
		this.headList = headList;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	

}
