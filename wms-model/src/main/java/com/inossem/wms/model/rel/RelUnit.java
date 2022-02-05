package com.inossem.wms.model.rel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.rel.RelUnit", description="物料计量单位换算对象")
public class RelUnit extends RelUnitKey implements Serializable {
	
	private static final long serialVersionUID = -1328270637826256006L;
	@ApiModelProperty(value="源单位数量")
    private BigDecimal sourceQty;
	@ApiModelProperty(value="目标单位数量")
    private BigDecimal targetQty;

    private Byte isDelete;

    private Date createTime;

    private Date modifyTime;

    private Integer createUserId;

    private Integer modifyUserId;

    private String relUnitExt0;

    private String relUnitExt1;

    private String relUnitExt2;

    private String relUnitExt3;

    private String relUnitExt4;

    private String relUnitExt5;

    private String relUnitExt6;

    private String relUnitExt7;

    private String relUnitExt8;

    private String relUnitExt9;

    public BigDecimal getSourceQty() {
        return sourceQty;
    }

    public void setSourceQty(BigDecimal sourceQty) {
        this.sourceQty = sourceQty;
    }

    public BigDecimal getTargetQty() {
        return targetQty;
    }

    public void setTargetQty(BigDecimal targetQty) {
        this.targetQty = targetQty;
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

    public String getRelUnitExt0() {
        return relUnitExt0;
    }

    public void setRelUnitExt0(String relUnitExt0) {
        this.relUnitExt0 = relUnitExt0 == null ? null : relUnitExt0.trim();
    }

    public String getRelUnitExt1() {
        return relUnitExt1;
    }

    public void setRelUnitExt1(String relUnitExt1) {
        this.relUnitExt1 = relUnitExt1 == null ? null : relUnitExt1.trim();
    }

    public String getRelUnitExt2() {
        return relUnitExt2;
    }

    public void setRelUnitExt2(String relUnitExt2) {
        this.relUnitExt2 = relUnitExt2 == null ? null : relUnitExt2.trim();
    }

    public String getRelUnitExt3() {
        return relUnitExt3;
    }

    public void setRelUnitExt3(String relUnitExt3) {
        this.relUnitExt3 = relUnitExt3 == null ? null : relUnitExt3.trim();
    }

    public String getRelUnitExt4() {
        return relUnitExt4;
    }

    public void setRelUnitExt4(String relUnitExt4) {
        this.relUnitExt4 = relUnitExt4 == null ? null : relUnitExt4.trim();
    }

    public String getRelUnitExt5() {
        return relUnitExt5;
    }

    public void setRelUnitExt5(String relUnitExt5) {
        this.relUnitExt5 = relUnitExt5 == null ? null : relUnitExt5.trim();
    }

    public String getRelUnitExt6() {
        return relUnitExt6;
    }

    public void setRelUnitExt6(String relUnitExt6) {
        this.relUnitExt6 = relUnitExt6 == null ? null : relUnitExt6.trim();
    }

    public String getRelUnitExt7() {
        return relUnitExt7;
    }

    public void setRelUnitExt7(String relUnitExt7) {
        this.relUnitExt7 = relUnitExt7 == null ? null : relUnitExt7.trim();
    }

    public String getRelUnitExt8() {
        return relUnitExt8;
    }

    public void setRelUnitExt8(String relUnitExt8) {
        this.relUnitExt8 = relUnitExt8 == null ? null : relUnitExt8.trim();
    }

    public String getRelUnitExt9() {
        return relUnitExt9;
    }

    public void setRelUnitExt9(String relUnitExt9) {
        this.relUnitExt9 = relUnitExt9 == null ? null : relUnitExt9.trim();
    }
}