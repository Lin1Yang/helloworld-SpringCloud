package com.inossem.wms.vo.actor;

import com.inossem.wms.model.actor.ActorGroupPostUser;
import io.swagger.annotations.ApiModel;

/**
 * @author Gyl
 */
@ApiModel(value="com.inossem.wms.vo.actor.ActorGroupPostUserVo")
public class ActorGroupPostUserVo extends ActorGroupPostUser {
    private String userName;
    private String postName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }
}
