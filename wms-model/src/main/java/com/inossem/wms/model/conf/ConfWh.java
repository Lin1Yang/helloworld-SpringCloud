package com.inossem.wms.model.conf;

import java.util.Date;

public class ConfWh {
    private String confWhCode;

    private String defaultTypeCode;

    private String defaultBinCode;

    private Byte outputEnabled;

    private Date createTime;

    private Date modifyTime;

    private Integer createUserId;

    private Integer modifyUserId;

    public String getConfWhCode() {
        return confWhCode;
    }

    public void setConfWhCode(String confWhCode) {
        this.confWhCode = confWhCode == null ? null : confWhCode.trim();
    }

    public String getDefaultTypeCode() {
        return defaultTypeCode;
    }

    public void setDefaultTypeCode(String defaultTypeCode) {
        this.defaultTypeCode = defaultTypeCode == null ? null : defaultTypeCode.trim();
    }

    public String getDefaultBinCode() {
        return defaultBinCode;
    }

    public void setDefaultBinCode(String defaultBinCode) {
        this.defaultBinCode = defaultBinCode == null ? null : defaultBinCode.trim();
    }

    public Byte getOutputEnabled() {
        return outputEnabled;
    }

    public void setOutputEnabled(Byte outputEnabled) {
        this.outputEnabled = outputEnabled;
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