package com.inossem.wms.model.dic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "com.inossem.wms.model.dic.DicText",description = "区域语言映射类")
public class DicText extends DicTextKey implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 600471204012689851L;
	@ApiModelProperty(value="语言文本，对应地区语言",name = "tid",example = "i18n_0000000001_tid",required = true)
    private String text;
    @ApiModelProperty(value="删除标识",name = "isDelete")
    private Byte isDelete;
    @ApiModelProperty(value="创建时间",name = "createTime")
    private Date createTime;
    @ApiModelProperty(value="编辑时间",name = "modifyTime")
    private Date modifyTime;
    @ApiModelProperty(value="创建人员ID",name = "createUserId")
    private Integer createUserId;
    @ApiModelProperty(value="编辑人员ID",name = "modifyUserId")
    private Integer modifyUserId;
    @ApiModelProperty(value="预留字段",name = "textExt0")
    private String textExt0;

    @ApiModelProperty(value="预留字段",name = "textExt1")
    private String textExt1;

    @ApiModelProperty(value="预留字段",name = "textExt2")
    private String textExt2;

    @ApiModelProperty(value="预留字段",name = "textExt3")
    private String textExt3;

    @ApiModelProperty(value="预留字段",name = "textExt4")
    private String textExt4;

    @ApiModelProperty(value="预留字段",name = "textExt5")
    private String textExt5;

    @ApiModelProperty(value="预留字段",name = "textExt6")
    private String textExt6;
    @ApiModelProperty(value="预留字段",name = "textExt7")
    private String textExt7;

    @ApiModelProperty(value="预留字段",name = "textExt8")
    private String textExt8;

    @ApiModelProperty(value="预留字段",name = "textExt9")
    private String textExt9;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
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

    public String getTextExt0() {
        return textExt0;
    }

    public void setTextExt0(String textExt0) {
        this.textExt0 = textExt0 == null ? null : textExt0.trim();
    }

    public String getTextExt1() {
        return textExt1;
    }

    public void setTextExt1(String textExt1) {
        this.textExt1 = textExt1 == null ? null : textExt1.trim();
    }

    public String getTextExt2() {
        return textExt2;
    }

    public void setTextExt2(String textExt2) {
        this.textExt2 = textExt2 == null ? null : textExt2.trim();
    }

    public String getTextExt3() {
        return textExt3;
    }

    public void setTextExt3(String textExt3) {
        this.textExt3 = textExt3 == null ? null : textExt3.trim();
    }

    public String getTextExt4() {
        return textExt4;
    }

    public void setTextExt4(String textExt4) {
        this.textExt4 = textExt4 == null ? null : textExt4.trim();
    }

    public String getTextExt5() {
        return textExt5;
    }

    public void setTextExt5(String textExt5) {
        this.textExt5 = textExt5 == null ? null : textExt5.trim();
    }

    public String getTextExt6() {
        return textExt6;
    }

    public void setTextExt6(String textExt6) {
        this.textExt6 = textExt6 == null ? null : textExt6.trim();
    }

    public String getTextExt7() {
        return textExt7;
    }

    public void setTextExt7(String textExt7) {
        this.textExt7 = textExt7 == null ? null : textExt7.trim();
    }

    public String getTextExt8() {
        return textExt8;
    }

    public void setTextExt8(String textExt8) {
        this.textExt8 = textExt8 == null ? null : textExt8.trim();
    }

    public String getTextExt9() {
        return textExt9;
    }

    public void setTextExt9(String textExt9) {
        this.textExt9 = textExt9 == null ? null : textExt9.trim();
    }
}