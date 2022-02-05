package com.inossem.wms.model.conf;

import java.util.Date;

public class ConfWhAutoTask extends ConfWhAutoTaskKey {
    private Byte autoTask;

    private Byte autoCommit;

    private Date createTime;

    private Date modifyTime;

    private Integer createUserId;

    private Integer modifyUserId;

    public Byte getAutoTask() {
        return autoTask;
    }

    public void setAutoTask(Byte autoTask) {
        this.autoTask = autoTask;
    }

    public Byte getAutoCommit() {
        return autoCommit;
    }

    public void setAutoCommit(Byte autoCommit) {
        this.autoCommit = autoCommit;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Integer modifyUserId) {
        this.modifyUserId = modifyUserId;
    }
}