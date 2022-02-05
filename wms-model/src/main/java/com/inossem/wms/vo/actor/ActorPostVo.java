package com.inossem.wms.vo.actor;

import java.util.List;

import com.inossem.wms.model.actor.ActorGroupPostUser;
import com.inossem.wms.model.actor.ActorPost;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 岗位输出映射类
 * @author admin
 */
@ApiModel(value="com.inossem.wms.vo.actor.ActorPostVo",description = "岗位查询结果返回类")
public class ActorPostVo extends ActorPost {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8003633546467456433L;

	@ApiModelProperty(name="actorRelPostRoleVoList",value="岗位和角色映射",required = true)
    List<ActorRelPostRoleVo> actorRelPostRoleVoList;

    @ApiModelProperty(name="actorGroupPostUserList",value="岗位和角色和用户映射",required = true)
    List<ActorGroupPostUser> actorGroupPostUserList;


    @ApiModelProperty(name="corpName",value="公司描述",required = true)
    String corpName;
    
    @ApiModelProperty(name="createUserCode",value="创建人编码",required = true)
    String createUserCode;
    
    @ApiModelProperty(name="createUserName",value="创建人名称",required = true)
    String createUserName;
    
    @ApiModelProperty(name="required",value="是否必须：0-否，1-是",required = true,example = "0")
    private Byte required;
    
    

    public Byte getRequired() {
		return required;
	}

	public void setRequired(Byte required) {
		this.required = required;
	}

	public String getCreateUserCode() {
		return createUserCode;
	}

	public void setCreateUserCode(String createUserCode) {
		this.createUserCode = createUserCode;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}



    public List<ActorRelPostRoleVo> getActorRelPostRoleVoList() {
		return actorRelPostRoleVoList;
	}

	public void setActorRelPostRoleVoList(List<ActorRelPostRoleVo> actorRelPostRoleVoList) {
		this.actorRelPostRoleVoList = actorRelPostRoleVoList;
	}

	public List<ActorGroupPostUser> getActorGroupPostUserList() {
        return actorGroupPostUserList;
    }

    public void setActorGroupPostUserList(List<ActorGroupPostUser> actorGroupPostUserList) {
        this.actorGroupPostUserList = actorGroupPostUserList;
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }
}
