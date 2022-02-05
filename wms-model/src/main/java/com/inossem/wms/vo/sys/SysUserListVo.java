package com.inossem.wms.vo.sys;

import java.util.List;

import com.inossem.wms.page.IPageResultCommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="com.inossem.wms.vo.sys.SysUserListVo", description="多名用户信息拓展对象")
public class SysUserListVo  implements IPageResultCommon{
	
	@ApiModelProperty(value="总数量", name="totalCount",example="100", required=true)
	private int totalCount; 
	
	 @ApiModelProperty(value="多名用户信息拓展", name="headList", required=true)
	private List<SysUserVo> headList;

	public List<SysUserVo> getHeadList() {
		return headList;
	}

	public void setHeadList(List<SysUserVo> headList) {
		this.headList = headList;
	}
	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

}
