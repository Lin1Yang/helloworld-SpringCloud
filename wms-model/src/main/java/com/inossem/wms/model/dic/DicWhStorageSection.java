package com.inossem.wms.model.dic;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="com.inossem.wms.model.dic.DicWhStorageSection", description="这是存储区映射类")
public class DicWhStorageSection extends DicWhStorageSectionKey {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6449485469418769228L;

	@ApiModelProperty(value = "存储区描述", example = "存储区1")
    private String sectionName;

	@ApiModelProperty(value = "特殊存储区标识", example = "t1")
    private String sectionMarkCode;
	@ApiModelProperty(value = "特殊存储区描述", example = "m1")
    private String sectionMarkName;

	@ApiModelProperty(value = "删除标识", example = "0")
    private Byte isDelete;
	@ApiModelProperty(value = "创建时间", example = "2018-12-12 10:12:21")
    private Date createTime;
	@ApiModelProperty(value = "修改时间", example = "2018-12-12 10:12:21")
    private Date modifyTime;
	@ApiModelProperty(value = "创建人id", example = "20")
    private Integer createUserId;
	@ApiModelProperty(value = "修改人id", example = "20")
    private Integer modifyUserId;
	@ApiModelProperty(value = "扩展字段")
    private String whStorageSectionExt0;
	@ApiModelProperty(value = "扩展字段")
    private String whStorageSectionExt1;
	@ApiModelProperty(value = "扩展字段")
    private String whStorageSectionExt2;
	@ApiModelProperty(value = "扩展字段")
    private String whStorageSectionExt3;
	@ApiModelProperty(value = "扩展字段")
    private String whStorageSectionExt4;
	@ApiModelProperty(value = "扩展字段")
    private String whStorageSectionExt5;
	@ApiModelProperty(value = "扩展字段")
    private String whStorageSectionExt6;
	@ApiModelProperty(value = "扩展字段")
    private String whStorageSectionExt7;
	@ApiModelProperty(value = "扩展字段")
    private String whStorageSectionExt8;
	@ApiModelProperty(value = "扩展字段")
    private String whStorageSectionExt9;

    public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getSectionMarkCode() {
        return sectionMarkCode;
    }

    public void setSectionMarkCode(String sectionMarkCode) {
        this.sectionMarkCode = sectionMarkCode == null ? null : sectionMarkCode.trim();
    }

    public String getSectionMarkName() {
        return sectionMarkName;
    }

    public void setSectionMarkName(String sectionMarkName) {
        this.sectionMarkName = sectionMarkName == null ? null : sectionMarkName.trim();
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
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

    public String getWhStorageSectionExt0() {
        return whStorageSectionExt0;
    }

    public void setWhStorageSectionExt0(String whStorageSectionExt0) {
        this.whStorageSectionExt0 = whStorageSectionExt0 == null ? null : whStorageSectionExt0.trim();
    }

    public String getWhStorageSectionExt1() {
        return whStorageSectionExt1;
    }

    public void setWhStorageSectionExt1(String whStorageSectionExt1) {
        this.whStorageSectionExt1 = whStorageSectionExt1 == null ? null : whStorageSectionExt1.trim();
    }

    public String getWhStorageSectionExt2() {
        return whStorageSectionExt2;
    }

    public void setWhStorageSectionExt2(String whStorageSectionExt2) {
        this.whStorageSectionExt2 = whStorageSectionExt2 == null ? null : whStorageSectionExt2.trim();
    }

    public String getWhStorageSectionExt3() {
        return whStorageSectionExt3;
    }

    public void setWhStorageSectionExt3(String whStorageSectionExt3) {
        this.whStorageSectionExt3 = whStorageSectionExt3 == null ? null : whStorageSectionExt3.trim();
    }

    public String getWhStorageSectionExt4() {
        return whStorageSectionExt4;
    }

    public void setWhStorageSectionExt4(String whStorageSectionExt4) {
        this.whStorageSectionExt4 = whStorageSectionExt4 == null ? null : whStorageSectionExt4.trim();
    }

    public String getWhStorageSectionExt5() {
        return whStorageSectionExt5;
    }

    public void setWhStorageSectionExt5(String whStorageSectionExt5) {
        this.whStorageSectionExt5 = whStorageSectionExt5 == null ? null : whStorageSectionExt5.trim();
    }

    public String getWhStorageSectionExt6() {
        return whStorageSectionExt6;
    }

    public void setWhStorageSectionExt6(String whStorageSectionExt6) {
        this.whStorageSectionExt6 = whStorageSectionExt6 == null ? null : whStorageSectionExt6.trim();
    }

    public String getWhStorageSectionExt7() {
        return whStorageSectionExt7;
    }

    public void setWhStorageSectionExt7(String whStorageSectionExt7) {
        this.whStorageSectionExt7 = whStorageSectionExt7 == null ? null : whStorageSectionExt7.trim();
    }

    public String getWhStorageSectionExt8() {
        return whStorageSectionExt8;
    }

    public void setWhStorageSectionExt8(String whStorageSectionExt8) {
        this.whStorageSectionExt8 = whStorageSectionExt8 == null ? null : whStorageSectionExt8.trim();
    }

    public String getWhStorageSectionExt9() {
        return whStorageSectionExt9;
    }

    public void setWhStorageSectionExt9(String whStorageSectionExt9) {
        this.whStorageSectionExt9 = whStorageSectionExt9 == null ? null : whStorageSectionExt9.trim();
    }
}