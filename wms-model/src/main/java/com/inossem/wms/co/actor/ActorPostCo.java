package com.inossem.wms.co.actor;

import java.util.List;

import com.inossem.wms.model.actor.ActorPost;
import com.inossem.wms.model.actor.ActorRelPostRole;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 岗位映射类
 * @author admin
 */
@ApiModel(value = "com.inossem.wms.co.actor.ActorPostCo",description = "岗位映射类")
public class ActorPostCo extends ActorPost {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6315246331278655944L;

	@ApiModelProperty(name="isEdit",value="0新增  1修改")
    Byte isEdit;
	
	@ApiModelProperty(name="condition",value="岗位编码描述模糊查询")
    String condition;

    @ApiModelProperty(name = "roleList",value="岗位列表",required=true)
    List<ActorRelPostRole> roleList;

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

	public List<ActorRelPostRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<ActorRelPostRole> roleList) {
        this.roleList = roleList;
    }
}
