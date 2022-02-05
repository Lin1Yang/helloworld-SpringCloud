package com.inossem.wms.co.actor;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "com.inossem.wms.co.actor.ActorGroupListCo",description = "经办人组集合查询对象")
public class ActorGroupListCo {
	
	@ApiModelProperty(name="groupPostCodeList",value="经办人组集合",required = true)
    List<String> groupCodeList;

	public List<String> getGroupCodeList() {
		return groupCodeList;
	}

	public void setGroupCodeList(List<String> groupCodeList) {
		this.groupCodeList = groupCodeList;
	}

	
	
	

}
