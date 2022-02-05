package com.inossem.wms.model.wf;

public class WfProcDef {
    private String procId;

    private String procName;

    private String procCategory;

    private String procDesp;

    private String createTime;

    private String createrId;

    private String procStatus;

    private String procVersion;

    public String getProcId() {
        return procId;
    }

    public void setProcId(String procId) {
        this.procId = procId == null ? null : procId.trim();
    }

    public String getProcName() {
        return procName;
    }

    public void setProcName(String procName) {
        this.procName = procName == null ? null : procName.trim();
    }

    public String getProcCategory() {
        return procCategory;
    }

    public void setProcCategory(String procCategory) {
        this.procCategory = procCategory == null ? null : procCategory.trim();
    }

    public String getProcDesp() {
        return procDesp;
    }

    public void setProcDesp(String procDesp) {
        this.procDesp = procDesp == null ? null : procDesp.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId == null ? null : createrId.trim();
    }

    public String getProcStatus() {
        return procStatus;
    }

    public void setProcStatus(String procStatus) {
        this.procStatus = procStatus == null ? null : procStatus.trim();
    }

    public String getProcVersion() {
        return procVersion;
    }

    public void setProcVersion(String procVersion) {
        this.procVersion = procVersion == null ? null : procVersion.trim();
    }
}