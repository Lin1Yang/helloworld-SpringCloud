package com.inossem.wms.model.dic;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.dic.DicMaterialImg", description="物料图片映射")
public class DicMaterialImg extends DicMaterialImgKey {
	@ApiModelProperty(value="删除标记", name="isDelete", example="0", required=true)
    private Byte isDelete;
	
	@ApiModelProperty(value="创建时间", name="createTime", example="2018-11-27 16:37:34.741645", required=true)
    private Date createTime;
	
	@ApiModelProperty(value="修改时间", name="modifyTime", example="2018-11-27 16:56:10.775559", required=true)
    private Date modifyTime;
	
	@ApiModelProperty(value="创建人id", name="createUserId", example="1", required=true)
    private Integer createUserId;
	
	@ApiModelProperty(value="修改人id", name="modifyUserId", example="1", required=true)
    private Integer modifyUserId;

    private String materialImgExt0;

    private String materialImgExt1;

    private String materialImgExt2;

    private String materialImgExt3;

    private String materialImgExt4;

    private String materialImgExt5;

    private String materialImgExt6;

    private String materialImgExt7;

    private String materialImgExt8;

    private String materialImgExt9;

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

    public String getMaterialImgExt0() {
        return materialImgExt0;
    }

    public void setMaterialImgExt0(String materialImgExt0) {
        this.materialImgExt0 = materialImgExt0 == null ? null : materialImgExt0.trim();
    }

    public String getMaterialImgExt1() {
        return materialImgExt1;
    }

    public void setMaterialImgExt1(String materialImgExt1) {
        this.materialImgExt1 = materialImgExt1 == null ? null : materialImgExt1.trim();
    }

    public String getMaterialImgExt2() {
        return materialImgExt2;
    }

    public void setMaterialImgExt2(String materialImgExt2) {
        this.materialImgExt2 = materialImgExt2 == null ? null : materialImgExt2.trim();
    }

    public String getMaterialImgExt3() {
        return materialImgExt3;
    }

    public void setMaterialImgExt3(String materialImgExt3) {
        this.materialImgExt3 = materialImgExt3 == null ? null : materialImgExt3.trim();
    }

    public String getMaterialImgExt4() {
        return materialImgExt4;
    }

    public void setMaterialImgExt4(String materialImgExt4) {
        this.materialImgExt4 = materialImgExt4 == null ? null : materialImgExt4.trim();
    }

    public String getMaterialImgExt5() {
        return materialImgExt5;
    }

    public void setMaterialImgExt5(String materialImgExt5) {
        this.materialImgExt5 = materialImgExt5 == null ? null : materialImgExt5.trim();
    }

    public String getMaterialImgExt6() {
        return materialImgExt6;
    }

    public void setMaterialImgExt6(String materialImgExt6) {
        this.materialImgExt6 = materialImgExt6 == null ? null : materialImgExt6.trim();
    }

    public String getMaterialImgExt7() {
        return materialImgExt7;
    }

    public void setMaterialImgExt7(String materialImgExt7) {
        this.materialImgExt7 = materialImgExt7 == null ? null : materialImgExt7.trim();
    }

    public String getMaterialImgExt8() {
        return materialImgExt8;
    }

    public void setMaterialImgExt8(String materialImgExt8) {
        this.materialImgExt8 = materialImgExt8 == null ? null : materialImgExt8.trim();
    }

    public String getMaterialImgExt9() {
        return materialImgExt9;
    }

    public void setMaterialImgExt9(String materialImgExt9) {
        this.materialImgExt9 = materialImgExt9 == null ? null : materialImgExt9.trim();
    }
}