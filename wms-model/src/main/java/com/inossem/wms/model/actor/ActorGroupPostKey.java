package com.inossem.wms.model.actor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.actor.ActorGroupPostKey")
public class ActorGroupPostKey {
    @ApiModelProperty(name="groupCode",value="管理组编码",required = true)
    private String groupCode;

    @ApiModelProperty(name="postCode",value="岗位编码",required = true)
    private String postCode;

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode == null ? null : groupCode.trim();
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }
}