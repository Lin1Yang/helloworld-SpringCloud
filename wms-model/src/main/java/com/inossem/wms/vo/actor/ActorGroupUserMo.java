package com.inossem.wms.vo.actor;

/**
 * @author Gyl
 */
public class ActorGroupUserMo {
    String postCode;
    String postName;
    Integer postIndex;
    Byte required;
    Byte countersign;
    Integer userId;
    String userName;

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Integer getPostIndex() {
        return postIndex;
    }

    public void setPostIndex(Integer postIndex) {
        this.postIndex = postIndex;
    }

    public Byte getRequired() {
        return required;
    }

    public void setRequired(Byte required) {
        this.required = required;
    }

    public Integer getUserId() {
        return userId;
    }

    public Byte getCountersign() {
        return countersign;
    }

    public void setCountersign(Byte countersign) {
        this.countersign = countersign;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
