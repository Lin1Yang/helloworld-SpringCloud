package com.inossem.wms.model.actor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.actor.ActorGroupPostUserKey")
public class ActorGroupPostUserKey {
    @ApiModelProperty(name="postCode",value = "岗位编号",required = true)
    private String postCode;

    @ApiModelProperty(name="userId",value = "用户ID",required = true)
    private String userId;

    @ApiModelProperty(name="groupCode",value = "岗位组编号",required = true)
    private String groupCode;

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode == null ? null : groupCode.trim();
    }
}