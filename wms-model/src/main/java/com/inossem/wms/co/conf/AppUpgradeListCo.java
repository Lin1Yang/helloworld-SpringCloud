package com.inossem.wms.co.conf;

import java.util.Date;

import com.inossem.wms.page.PageCommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.co.conf.AppUpgradeListCo", description="app升级包列表查询对象")
public class AppUpgradeListCo extends PageCommon {
	
	private static final long serialVersionUID = -3400035326506822811L;

	@ApiModelProperty(value="查询起始日期", example="2018-12-22", required=false)
	private Date createTimeStart;
	
	@ApiModelProperty(value="查询截至日期", example="2018-12-23", required=false)
	private Date createTimeEnd;

	public Date getCreateTimeStart() {
		return createTimeStart;
	}

	public void setCreateTimeStart(Date createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	public Date getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(Date createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}
	
}
