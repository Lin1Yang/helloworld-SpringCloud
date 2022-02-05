package com.inossem.wms.co.actor;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "com.inossem.wms.co.actor.ActorPostListCo",description = "岗位集合查询入参对象")
public class ActorPostListCo {
	
	/**
     * 岗位编码集合
     */
    @ApiModelProperty(name = "postCodeList",value="岗位编码集合",required=true)
    List<String> postCodeList;


	public List<String> getPostCodeList() {
		return postCodeList;
	}

	public void setPostCodeList(List<String> postCodeList) {
		this.postCodeList = postCodeList;
	}

}
