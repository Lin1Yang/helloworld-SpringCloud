package com.inossem.wms.vo.actor;

import com.inossem.wms.model.actor.ActorPost;
import com.inossem.wms.vo.sys.SysUserVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author Gyl
 */
@ApiModel(value="com.inossem.wms.vo.actor.ActorPostUserVo",description = "岗位和用户映射")
public class ActorPostUserVo extends ActorPost implements Serializable  {
	
	private static final long serialVersionUID = -1998840467620094747L;

	@ApiModelProperty(name="userList",value = "用户列表",required = true)
    List<SysUserVo> userList;

    @ApiModelProperty(name="required",value = "是否必须",required = true)
    Byte required;

    @ApiModelProperty(name="postIndex",value = "岗位排序",required = true)
    Integer postIndex;

    public List<SysUserVo> getUserList() {
		return userList;
	}

	public void setUserList(List<SysUserVo> userList) {
		this.userList = userList;
	}

	public Byte getRequired() {
        return required;
    }

    public void setRequired(Byte required) {
        this.required = required;
    }

    public Integer getPostIndex() {
        return postIndex;
    }

    public void setPostIndex(Integer postIndex) {
        this.postIndex = postIndex;
    }
}
