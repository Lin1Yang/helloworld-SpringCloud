package com.inossem.wms.model.dic;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.dic.DicMaterialGroup", description="物料组映射")
public class DicMaterialGroup {
	
	@ApiModelProperty(value="物料组编码", name="matGroupCode",example="01", required=true)
    private String matGroupCode;
	
	@ApiModelProperty(value="物料组描述", name="matGroupName",example="不知道为啥就想写01", required=true)
    private String matGroupName;
	
	@ApiModelProperty(value="批次特性分类", name="batchSpecificClassifyCode",example="ZBATCH01", required=true)
    private String batchSpecificClassifyCode;
	
	@ApiModelProperty(value="物料考核 0-不考核 1-考核", name="matCheck",example="1", required=true)
    private Byte matCheck;

	@ApiModelProperty(value="删除标记", name="isDelete", example="0", required=true)
    private Byte isDelete;
	
	@ApiModelProperty(value="创建时间", name="createTime", example="2018-11-27 16:37:34.741645", required=true)
    private LocalDateTime createTime;
	
	@ApiModelProperty(value="修改时间", name="modifyTime", example="2018-11-27 16:56:10.775559", required=true)
    private LocalDateTime modifyTime;
	
	@ApiModelProperty(value="创建人id", name="createUserId", example="1", required=true)
    private Integer createUserId;
	
	@ApiModelProperty(value="修改人id", name="modifyUserId", example="1", required=true)
    private Integer modifyUserId;

    private String matGroupExt0;

    private String matGroupExt1;

    private String matGroupExt2;

    private String matGroupExt3;

    private String matGroupExt4;

    private String matGroupExt5;

    private String matGroupExt6;

    private String matGroupExt7;

    private String matGroupExt8;

    private String matGroupExt9;

    public String getMatGroupCode() {
        return matGroupCode;
    }

    public void setMatGroupCode(String matGroupCode) {
        this.matGroupCode = matGroupCode == null ? null : matGroupCode.trim();
    }

    public String getMatGroupName() {
        return matGroupName;
    }

    public void setMatGroupName(String matGroupName) {
        this.matGroupName = matGroupName == null ? null : matGroupName.trim();
    }

    public String getBatchSpecificClassifyCode() {
        return batchSpecificClassifyCode;
    }

    public void setBatchSpecificClassifyCode(String batchSpecificClassifyCode) {
        this.batchSpecificClassifyCode = batchSpecificClassifyCode == null ? null : batchSpecificClassifyCode.trim();
    }

    public Byte getMatCheck() {
        return matCheck;
    }

    public void setMatCheck(Byte matCheck) {
        this.matCheck = matCheck;
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

    public String getMatGroupExt0() {
        return matGroupExt0;
    }

    public void setMatGroupExt0(String matGroupExt0) {
        this.matGroupExt0 = matGroupExt0 == null ? null : matGroupExt0.trim();
    }

    public String getMatGroupExt1() {
        return matGroupExt1;
    }

    public void setMatGroupExt1(String matGroupExt1) {
        this.matGroupExt1 = matGroupExt1 == null ? null : matGroupExt1.trim();
    }

    public String getMatGroupExt2() {
        return matGroupExt2;
    }

    public void setMatGroupExt2(String matGroupExt2) {
        this.matGroupExt2 = matGroupExt2 == null ? null : matGroupExt2.trim();
    }

    public String getMatGroupExt3() {
        return matGroupExt3;
    }

    public void setMatGroupExt3(String matGroupExt3) {
        this.matGroupExt3 = matGroupExt3 == null ? null : matGroupExt3.trim();
    }

    public String getMatGroupExt4() {
        return matGroupExt4;
    }

    public void setMatGroupExt4(String matGroupExt4) {
        this.matGroupExt4 = matGroupExt4 == null ? null : matGroupExt4.trim();
    }

    public String getMatGroupExt5() {
        return matGroupExt5;
    }

    public void setMatGroupExt5(String matGroupExt5) {
        this.matGroupExt5 = matGroupExt5 == null ? null : matGroupExt5.trim();
    }

    public String getMatGroupExt6() {
        return matGroupExt6;
    }

    public void setMatGroupExt6(String matGroupExt6) {
        this.matGroupExt6 = matGroupExt6 == null ? null : matGroupExt6.trim();
    }

    public String getMatGroupExt7() {
        return matGroupExt7;
    }

    public void setMatGroupExt7(String matGroupExt7) {
        this.matGroupExt7 = matGroupExt7 == null ? null : matGroupExt7.trim();
    }

    public String getMatGroupExt8() {
        return matGroupExt8;
    }

    public void setMatGroupExt8(String matGroupExt8) {
        this.matGroupExt8 = matGroupExt8 == null ? null : matGroupExt8.trim();
    }

    public String getMatGroupExt9() {
        return matGroupExt9;
    }

    public void setMatGroupExt9(String matGroupExt9) {
        this.matGroupExt9 = matGroupExt9 == null ? null : matGroupExt9.trim();
    }
}