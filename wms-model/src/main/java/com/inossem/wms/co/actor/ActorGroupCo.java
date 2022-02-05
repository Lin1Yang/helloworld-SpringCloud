package com.inossem.wms.co.actor;

import java.util.List;

import com.inossem.wms.model.actor.ActorGroup;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 岗位组映射类
 */
@ApiModel(value = "com.inossem.wms.co.actor.ActorGroupCo",description = "岗位组映射类")
public class ActorGroupCo extends ActorGroup {

	private static final long serialVersionUID = -6937053068341911468L;

	@ApiModelProperty(name="isEdit",value="0新增  1修改")
    Byte isEdit;
	
	@ApiModelProperty(name="condition",value="经办组编码描述模糊查询")
    String condition;
	
    @ApiModelProperty(name="actorGroupPostCoList",value="公司经办组与岗位关联列表")
    List<ActorGroupPostCo> actorGroupPostCoList;

    @ApiModelProperty(name="actorGroupPostUserCoList",value="个人经办组岗位用户平级列表")
    List<ActorGroupPostUserCo> actorGroupPostUserCoList;
    
    List<String> groupCodeList;       

	public List<String> getGroupCodeList() {
		return groupCodeList;
	}

	public void setGroupCodeList(List<String> groupCodeList) {
		this.groupCodeList = groupCodeList;
	}

	public Byte getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Byte isEdit) {
		this.isEdit = isEdit;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public List<ActorGroupPostCo> getActorGroupPostCoList() {
        return actorGroupPostCoList;
    }

    public void setActorGroupPostCoList(List<ActorGroupPostCo> actorGroupPostCoList) {
        this.actorGroupPostCoList = actorGroupPostCoList;
    }

    public List<ActorGroupPostUserCo> getActorGroupPostUserCoList() {
        return actorGroupPostUserCoList;
    }

    public void setActorGroupPostUserCoList(List<ActorGroupPostUserCo> actorGroupPostUserCoList) {
        this.actorGroupPostUserCoList = actorGroupPostUserCoList;
    }

}
