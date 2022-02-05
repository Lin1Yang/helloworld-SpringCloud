package com.inossem.wms.model.dic;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.dic.DicOutside", description="外部用户对应供应商和客户对象")
public class DicOutside {
	@ApiModelProperty(value="用户id", name="userId", example="0",required=true)
    private Integer userId;

	@ApiModelProperty(value="外部用户对应供应商和客户对象编码", name="outsideCode", example="0001",required=true)
    private String outsideCode;

	@ApiModelProperty(value="外部用户对应供应商和客户对象描述", name="outsideName", example="零零零一",required=true)
    private String outsideName;

	@ApiModelProperty(value="删除标识，0-否，1-是", name="isDelete", example="0", required=true)
    private Byte isDelete;

	@ApiModelProperty(value="创建时间", name="createTime", example="2018-12-24 12:24:24", required=true)
    private LocalDateTime createTime;

	@ApiModelProperty(value="修改时间", name="modifyTime", example="2018-12-24 12:24:24", required=true)
    private LocalDateTime modifyTime;

    private Integer createUserId;

    private Integer modifyUserId;

    private String outsideExt0;

    private String outsideExt1;

    private String outsideExt2;

    private String outsideExt3;

    private String outsideExt4;

    private String outsideExt5;

    private String outsideExt6;

    private String outsideExt7;

    private String outsideExt8;

    private String outsideExt9;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOutsideCode() {
        return outsideCode;
    }

    public void setOutsideCode(String outsideCode) {
        this.outsideCode = outsideCode == null ? null : outsideCode.trim();
    }

    public String getOutsideName() {
        return outsideName;
    }

    public void setOutsideName(String outsideName) {
        this.outsideName = outsideName == null ? null : outsideName.trim();
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
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

    public String getOutsideExt0() {
        return outsideExt0;
    }

    public void setOutsideExt0(String outsideExt0) {
        this.outsideExt0 = outsideExt0 == null ? null : outsideExt0.trim();
    }

    public String getOutsideExt1() {
        return outsideExt1;
    }

    public void setOutsideExt1(String outsideExt1) {
        this.outsideExt1 = outsideExt1 == null ? null : outsideExt1.trim();
    }

    public String getOutsideExt2() {
        return outsideExt2;
    }

    public void setOutsideExt2(String outsideExt2) {
        this.outsideExt2 = outsideExt2 == null ? null : outsideExt2.trim();
    }

    public String getOutsideExt3() {
        return outsideExt3;
    }

    public void setOutsideExt3(String outsideExt3) {
        this.outsideExt3 = outsideExt3 == null ? null : outsideExt3.trim();
    }

    public String getOutsideExt4() {
        return outsideExt4;
    }

    public void setOutsideExt4(String outsideExt4) {
        this.outsideExt4 = outsideExt4 == null ? null : outsideExt4.trim();
    }

    public String getOutsideExt5() {
        return outsideExt5;
    }

    public void setOutsideExt5(String outsideExt5) {
        this.outsideExt5 = outsideExt5 == null ? null : outsideExt5.trim();
    }

    public String getOutsideExt6() {
        return outsideExt6;
    }

    public void setOutsideExt6(String outsideExt6) {
        this.outsideExt6 = outsideExt6 == null ? null : outsideExt6.trim();
    }

    public String getOutsideExt7() {
        return outsideExt7;
    }

    public void setOutsideExt7(String outsideExt7) {
        this.outsideExt7 = outsideExt7 == null ? null : outsideExt7.trim();
    }

    public String getOutsideExt8() {
        return outsideExt8;
    }

    public void setOutsideExt8(String outsideExt8) {
        this.outsideExt8 = outsideExt8 == null ? null : outsideExt8.trim();
    }

    public String getOutsideExt9() {
        return outsideExt9;
    }

    public void setOutsideExt9(String outsideExt9) {
        this.outsideExt9 = outsideExt9 == null ? null : outsideExt9.trim();
    }
}