package com.inossem.wms.model.dic;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.dic.DicDept", description="部门")
public class DicDept {
	
	@ApiModelProperty(value="部门编码", name="deptCode",example="1121", required=true)
    private String deptCode;

	@ApiModelProperty(value="公司编码", name="corpCode",example="9000", required=true)
    private String corpCode;

	@ApiModelProperty(value="部门名称", name="deptName",example="研发部门", required=true)
    private String deptName;
	
	@ApiModelProperty(value="删除标识，0-否，1-是", name="isDelete", example="0", required=true)
    private Byte isDelete;
	
	@ApiModelProperty(value="创建时间", name="createTime", example="2018-12-24 12:24:24", required=true)
    private LocalDateTime createTime;
	
	@ApiModelProperty(value="修改时间", name="modifyTime", example="2018-12-24 12:24:24", required=true)
    private LocalDateTime modifyTime;
	
	@ApiModelProperty(value="用户创建人Id", name="createUserId", example="0", required=true)
    private Integer createUserId;
	
	@ApiModelProperty(value="用户修改人Id", name="modifyUserId", example="0", required=true)
    private Integer modifyUserId;

    private String deptExt0;

    private String deptExt1;

    private String deptExt2;

    private String deptExt3;

    private String deptExt4;

    private String deptExt5;

    private String deptExt6;

    private String deptExt7;

    private String deptExt8;

    private String deptExt9;

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    public String getCorpCode() {
        return corpCode;
    }

    public void setCorpCode(String corpCode) {
        this.corpCode = corpCode == null ? null : corpCode.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
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

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getDeptExt0() {
        return deptExt0;
    }

    public void setDeptExt0(String deptExt0) {
        this.deptExt0 = deptExt0 == null ? null : deptExt0.trim();
    }

    public String getDeptExt1() {
        return deptExt1;
    }

    public void setDeptExt1(String deptExt1) {
        this.deptExt1 = deptExt1 == null ? null : deptExt1.trim();
    }

    public String getDeptExt2() {
        return deptExt2;
    }

    public void setDeptExt2(String deptExt2) {
        this.deptExt2 = deptExt2 == null ? null : deptExt2.trim();
    }

    public String getDeptExt3() {
        return deptExt3;
    }

    public void setDeptExt3(String deptExt3) {
        this.deptExt3 = deptExt3 == null ? null : deptExt3.trim();
    }

    public String getDeptExt4() {
        return deptExt4;
    }

    public void setDeptExt4(String deptExt4) {
        this.deptExt4 = deptExt4 == null ? null : deptExt4.trim();
    }

    public String getDeptExt5() {
        return deptExt5;
    }

    public void setDeptExt5(String deptExt5) {
        this.deptExt5 = deptExt5 == null ? null : deptExt5.trim();
    }

    public String getDeptExt6() {
        return deptExt6;
    }

    public void setDeptExt6(String deptExt6) {
        this.deptExt6 = deptExt6 == null ? null : deptExt6.trim();
    }

    public String getDeptExt7() {
        return deptExt7;
    }

    public void setDeptExt7(String deptExt7) {
        this.deptExt7 = deptExt7 == null ? null : deptExt7.trim();
    }

    public String getDeptExt8() {
        return deptExt8;
    }

    public void setDeptExt8(String deptExt8) {
        this.deptExt8 = deptExt8 == null ? null : deptExt8.trim();
    }

    public String getDeptExt9() {
        return deptExt9;
    }

    public void setDeptExt9(String deptExt9) {
        this.deptExt9 = deptExt9 == null ? null : deptExt9.trim();
    }
}