package com.inossem.wms.vo.actor;

import java.util.List;

import com.inossem.wms.model.actor.ActorGroup;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 岗位组输出映射类
 * @author admin
 */
@ApiModel(value="com.inossem.wms.vo.actor.ActorGroupVo",description = "岗位组查询结果返回映射类")
public class ActorGroupVo extends ActorGroup {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2875564304537807433L;
	@ApiModelProperty(name="receiptName",value="单据类型描述")
    String receiptTypeName;   
    @ApiModelProperty(name="corpName",value="公司描述")
    String corpName;
    @ApiModelProperty(name="actorGroupPostVoList",value="公司经办组与岗位关联列表")
    List<ActorGroupPostVo> actorGroupPostVoList;
    @ApiModelProperty(name="actorGroupPostUserVoList",value="个人经办组岗位用户平级列表")
    List<ActorGroupPostUserVo> actorGroupPostUserVoList;
    @ApiModelProperty(name="actorPostUserVoList",value="个人经办组岗位用户分级列表")
    List<ActorPostUserVo> actorPostUserVoList;
   
    public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getReceiptTypeName() {
        return receiptTypeName;
    }

    public void setReceiptTypeName(String receiptTypeName) {
        this.receiptTypeName = receiptTypeName;
    }

    public List<ActorGroupPostVo> getActorGroupPostVoList() {
		return actorGroupPostVoList;
	}

	public void setActorGroupPostVoList(List<ActorGroupPostVo> actorGroupPostVoList) {
		this.actorGroupPostVoList = actorGroupPostVoList;
	}

	public List<ActorGroupPostUserVo> getActorGroupPostUserVoList() {
        return actorGroupPostUserVoList;
    }

    public void setActorGroupPostUserVoList(List<ActorGroupPostUserVo> actorGroupPostUserVoList) {
        this.actorGroupPostUserVoList = actorGroupPostUserVoList;
    }

    public List<ActorPostUserVo> getActorPostUserVoList() {
        return actorPostUserVoList;
    }

    public void setActorPostUserVoList(List<ActorPostUserVo> actorPostUserVoList) {
        this.actorPostUserVoList = actorPostUserVoList;
    }
}
