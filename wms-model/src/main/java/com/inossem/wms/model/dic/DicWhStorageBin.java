package com.inossem.wms.model.dic;

import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

import io.swagger.annotations.ApiModelProperty;

public class DicWhStorageBin extends DicWhStorageBinKey {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7745848220387629450L;

	@ApiModelProperty(value="存储区编码")
    private String sectionCode;
    
	@ApiModelProperty(value="存储区")
	private String sectionName;
	
	@ApiModelProperty(value="拣配区")
    private String pickingAreaCode;

	@ApiModelProperty(value="入库冻结")
    private Byte freezeInput;

	@ApiModelProperty(value="出库冻结")
    private Byte freezeOutput;
    
	@ApiModelProperty(value="冻结原因名称")
    private String reasonName;

	@ApiModelProperty(value="冻结原因编码")
    private String freezeReasonCode;
    
	@ApiModelProperty(value="仓位类型编码")
    private String binTypeCode;
    
	@ApiModelProperty(value="仓位类型描述")
    private String binTypeName;

	@JSONField(name="storageCellType") 
	@ApiModelProperty(value="存储单元类型")
    private String storageCellTypeCode;

	@ApiModelProperty(value="允许最大存储单元数量")
    private Integer storageCellMax;

	@ApiModelProperty(value="最大承重")
    private BigDecimal weightMax;

	@ApiModelProperty(value="称重单位")
    private String weightUnitCode;

	@ApiModelProperty(value="最大体积")
    private BigDecimal volumeMax;

	@ApiModelProperty(value="体积单元")
    private String volumeUnitCode;

	@ApiModelProperty(value="是否空仓位")
    private Byte used;
    @ApiModelProperty(value="当前载重")
	private BigDecimal currentWeight;

	private String whName;

	private String typeName;

    private String pickingAreaName;

    private BigDecimal xCoordinate;

    private BigDecimal yCoordinate;

    private BigDecimal zCoordinate;

    private Byte isDelete;

    private Date createTime;

    private Date modifyTime;

    private Integer createUserId;

    private Integer modifyUserId;

    private String whStorageBinExt0;

    private String whStorageBinExt1;

    private String whStorageBinExt2;

    private String whStorageBinExt3;

    private String whStorageBinExt4;

    private String whStorageBinExt5;

    private String whStorageBinExt6;

    private String whStorageBinExt7;

    private String whStorageBinExt8;

    private String whStorageBinExt9;
    
    private boolean isClick = false;
    
    private Date stockBinModifyTime;
    
    @ApiModelProperty(value="虚拟仓位")
    private byte virtualBin;

    public String getPickingAreaName() {
        return pickingAreaName;
    }

    public void setPickingAreaName(String pickingAreaName) {
        this.pickingAreaName = pickingAreaName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getWhName() {
        return whName;
    }

    public DicWhStorageBin setWhName(String whName) {
        this.whName = whName;
        return this;
    }

    public String getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(String sectionCode) {
        this.sectionCode = sectionCode == null ? null : sectionCode.trim();
    }

	public String getPickingAreaCode() {
		return pickingAreaCode;
	}

	public void setPickingAreaCode(String pickingAreaCode) {
		this.pickingAreaCode = pickingAreaCode;
	}

	public Byte getFreezeInput() {
        return freezeInput;
    }

    public void setFreezeInput(Byte freezeInput) {
        this.freezeInput = freezeInput;
    }

    public Byte getFreezeOutput() {
        return freezeOutput;
    }

    public void setFreezeOutput(Byte freezeOutput) {
        this.freezeOutput = freezeOutput;
    }

    public String getStorageCellTypeCode() {
        return storageCellTypeCode;
    }

    public void setStorageCellTypeCode(String storageCellTypeCode) {
        this.storageCellTypeCode = storageCellTypeCode;
    }

    public Integer getStorageCellMax() {
        return storageCellMax;
    }

    public void setStorageCellMax(Integer storageCellMax) {
        this.storageCellMax = storageCellMax;
    }

    public BigDecimal getWeightMax() {
        return weightMax;
    }

    public void setWeightMax(BigDecimal weightMax) {
        this.weightMax = weightMax;
    }

    public String getWeightUnitCode() {
        return weightUnitCode;
    }

    public void setWeightUnitCode(String weightUnitCode) {
        this.weightUnitCode = weightUnitCode == null ? null : weightUnitCode.trim();
    }

    public BigDecimal getVolumeMax() {
        return volumeMax;
    }

    public void setVolumeMax(BigDecimal volumeMax) {
        this.volumeMax = volumeMax;
    }

    public String getVolumeUnitCode() {
        return volumeUnitCode;
    }

    public void setVolumeUnitCode(String volumeUnitCode) {
        this.volumeUnitCode = volumeUnitCode == null ? null : volumeUnitCode.trim();
    }

    public Byte getUsed() {
        return used;
    }

    public void setUsed(Byte used) {
        this.used = used;
    }

    public BigDecimal getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(BigDecimal xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public BigDecimal getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(BigDecimal yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public BigDecimal getzCoordinate() {
		return zCoordinate;
	}

	public void setzCoordinate(BigDecimal zCoordinate) {
		this.zCoordinate = zCoordinate;
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

    public String getWhStorageBinExt0() {
        return whStorageBinExt0;
    }

    public void setWhStorageBinExt0(String whStorageBinExt0) {
        this.whStorageBinExt0 = whStorageBinExt0 == null ? null : whStorageBinExt0.trim();
    }

    public String getWhStorageBinExt1() {
        return whStorageBinExt1;
    }

    public void setWhStorageBinExt1(String whStorageBinExt1) {
        this.whStorageBinExt1 = whStorageBinExt1 == null ? null : whStorageBinExt1.trim();
    }

    public String getWhStorageBinExt2() {
        return whStorageBinExt2;
    }

    public void setWhStorageBinExt2(String whStorageBinExt2) {
        this.whStorageBinExt2 = whStorageBinExt2 == null ? null : whStorageBinExt2.trim();
    }

    public String getWhStorageBinExt3() {
        return whStorageBinExt3;
    }

    public void setWhStorageBinExt3(String whStorageBinExt3) {
        this.whStorageBinExt3 = whStorageBinExt3 == null ? null : whStorageBinExt3.trim();
    }

    public String getWhStorageBinExt4() {
        return whStorageBinExt4;
    }

    public void setWhStorageBinExt4(String whStorageBinExt4) {
        this.whStorageBinExt4 = whStorageBinExt4 == null ? null : whStorageBinExt4.trim();
    }

    public String getWhStorageBinExt5() {
        return whStorageBinExt5;
    }

    public void setWhStorageBinExt5(String whStorageBinExt5) {
        this.whStorageBinExt5 = whStorageBinExt5 == null ? null : whStorageBinExt5.trim();
    }

    public String getWhStorageBinExt6() {
        return whStorageBinExt6;
    }

    public void setWhStorageBinExt6(String whStorageBinExt6) {
        this.whStorageBinExt6 = whStorageBinExt6 == null ? null : whStorageBinExt6.trim();
    }

    public String getWhStorageBinExt7() {
        return whStorageBinExt7;
    }

    public void setWhStorageBinExt7(String whStorageBinExt7) {
        this.whStorageBinExt7 = whStorageBinExt7 == null ? null : whStorageBinExt7.trim();
    }

    public String getWhStorageBinExt8() {
        return whStorageBinExt8;
    }

    public void setWhStorageBinExt8(String whStorageBinExt8) {
        this.whStorageBinExt8 = whStorageBinExt8 == null ? null : whStorageBinExt8.trim();
    }

    public String getWhStorageBinExt9() {
        return whStorageBinExt9;
    }

    public void setWhStorageBinExt9(String whStorageBinExt9) {
        this.whStorageBinExt9 = whStorageBinExt9 == null ? null : whStorageBinExt9.trim();
    }

	public boolean isClick() {
		return isClick;
	}

	public void setClick(boolean isClick) {
		this.isClick = isClick;
	}

	public String getFreezeReasonCode() {
		return freezeReasonCode;
	}

	public void setFreezeReasonCode(String freezeReasonCode) {
		this.freezeReasonCode = freezeReasonCode;
	}
	
	public String getReasonName() {
		return reasonName;
	}

	public void setReasonName(String reasonName) {
		this.reasonName = reasonName;
	}
	
	public String getBinTypeCode() {
		return binTypeCode;
	}

	public void setBinTypeCode(String binTypeCode) {
		this.binTypeCode = binTypeCode;
	}

	public String getBinTypeName() {
		return binTypeName;
	}

	public void setBinTypeName(String binTypeName) {
		this.binTypeName = binTypeName;
	}

	public byte getVirtualBin() {
		return virtualBin;
	}

	public void setVirtualBin(byte virtualBin) {
		this.virtualBin = virtualBin;
	}

	public Date getStockBinModifyTime() {
		return stockBinModifyTime;
	}

	public void setStockBinModifyTime(Date stockBinModifyTime) {
		this.stockBinModifyTime = stockBinModifyTime;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

    public BigDecimal getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(BigDecimal currentWeight) {
        this.currentWeight = currentWeight;
    }
}