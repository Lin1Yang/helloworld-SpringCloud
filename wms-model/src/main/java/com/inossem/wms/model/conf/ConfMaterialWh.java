package com.inossem.wms.model.conf;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModelProperty;

public class ConfMaterialWh {
	@ApiModelProperty(value="仓库号", name="whCode",example="S01", required=true)
    private String whCode;

	@ApiModelProperty(value="特殊存储类型标识", name="storageTypeMarkCode",example="Q1", required=true)
    private String storageTypeMarkCode;
	
	@ApiModelProperty(value="特殊存储类型描述", name="storageTypeMarkName",example="不知道为啥就想起个Q1", required=true)
    private String storageTypeMarkName;
	
	@ApiModelProperty(value="特殊仓储区标识", name="storageSectionMarkCode",example="W1", required=true)
    private String storageSectionMarkCode;
	
	@ApiModelProperty(value="特殊仓储区描述", name="storageSectionMarkName",example="不知道为啥就想起个W1", required=true)
    private String storageSectionMarkName;
	
	@ApiModelProperty(value="特殊移动标志", name="moveMark",example="M1", required=true)
    private String moveMark;
	
	@ApiModelProperty(value="批次特性分类", name="batchSpecificClassifyCode",example="ZBATCH01", required=true)
    private String batchSpecificClassifyCode;
	
	@ApiModelProperty(value="启用SN管理", name="snEnabled",example="0", required=true)
    private Byte snEnabled;
	
	@ApiModelProperty(value="启危险品标识", name="dangerous",example="0", required=true)
    private Byte dangerous;
	
	@ApiModelProperty(value="正常库存", name="stockFit",example="10", required=true)
    private BigDecimal stockFit;
	
	@ApiModelProperty(value="订货点数量", name="orderPoint",example="2", required=true)	
    private BigDecimal orderPoint;
	
	@ApiModelProperty(value="删除标志", name="isDelete",example="0", required=true)
    private Byte isDelete;
	
	@ApiModelProperty(value="创建时间", name="createTime",example="2019-01-03 15:43:46.358360", required=true)
    private LocalDateTime createTime;
	
	@ApiModelProperty(value="修改时间", name="modifyTime",example="2019-01-03 15:43:46.358360", required=true)
    private LocalDateTime modifyTime;
	
	@ApiModelProperty(value="创建人", name="createUserId",example="1", required=true)
    private Integer createUserId;
	
	@ApiModelProperty(value="修改人", name="modifyUserId",example="1", required=true)
    private Integer modifyUserId;

    private String matWhExt0;

    private String matWhExt1;

    private String matWhExt2;

    private String matWhExt3;

    private String matWhExt4;

    private String matWhExt5;

    private String matWhExt6;

    private String matWhExt7;

    private String matWhExt8;

    private String matWhExt9;

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode == null ? null : whCode.trim();
    }

    public String getStorageTypeMarkCode() {
        return storageTypeMarkCode;
    }

    public void setStorageTypeMarkCode(String storageTypeMarkCode) {
        this.storageTypeMarkCode = storageTypeMarkCode == null ? null : storageTypeMarkCode.trim();
    }

    public String getStorageTypeMarkName() {
        return storageTypeMarkName;
    }

    public void setStorageTypeMarkName(String storageTypeMarkName) {
        this.storageTypeMarkName = storageTypeMarkName == null ? null : storageTypeMarkName.trim();
    }

    public String getStorageSectionMarkCode() {
        return storageSectionMarkCode;
    }

    public void setStorageSectionMarkCode(String storageSectionMarkCode) {
        this.storageSectionMarkCode = storageSectionMarkCode == null ? null : storageSectionMarkCode.trim();
    }

    public String getStorageSectionMarkName() {
        return storageSectionMarkName;
    }

    public void setStorageSectionMarkName(String storageSectionMarkName) {
        this.storageSectionMarkName = storageSectionMarkName == null ? null : storageSectionMarkName.trim();
    }

    public String getMoveMark() {
        return moveMark;
    }

    public void setMoveMark(String moveMark) {
        this.moveMark = moveMark == null ? null : moveMark.trim();
    }

    public String getBatchSpecificClassifyCode() {
        return batchSpecificClassifyCode;
    }

    public void setBatchSpecificClassifyCode(String batchSpecificClassifyCode) {
        this.batchSpecificClassifyCode = batchSpecificClassifyCode == null ? null : batchSpecificClassifyCode.trim();
    }

    public Byte getSnEnabled() {
        return snEnabled;
    }

    public void setSnEnabled(Byte snEnabled) {
        this.snEnabled = snEnabled;
    }

    public Byte getDangerous() {
		return dangerous;
	}

	public void setDangerous(Byte dangerous) {
		this.dangerous = dangerous;
	}

	public BigDecimal getStockFit() {
        return stockFit;
    }

    public void setStockFit(BigDecimal stockFit) {
        this.stockFit = stockFit;
    }

    public BigDecimal getOrderPoint() {
		return orderPoint;
	}

	public void setOrderPoint(BigDecimal orderPoint) {
		this.orderPoint = orderPoint;
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

    public String getMatWhExt0() {
        return matWhExt0;
    }

    public void setMatWhExt0(String matWhExt0) {
        this.matWhExt0 = matWhExt0 == null ? null : matWhExt0.trim();
    }

    public String getMatWhExt1() {
        return matWhExt1;
    }

    public void setMatWhExt1(String matWhExt1) {
        this.matWhExt1 = matWhExt1 == null ? null : matWhExt1.trim();
    }

    public String getMatWhExt2() {
        return matWhExt2;
    }

    public void setMatWhExt2(String matWhExt2) {
        this.matWhExt2 = matWhExt2 == null ? null : matWhExt2.trim();
    }

    public String getMatWhExt3() {
        return matWhExt3;
    }

    public void setMatWhExt3(String matWhExt3) {
        this.matWhExt3 = matWhExt3 == null ? null : matWhExt3.trim();
    }

    public String getMatWhExt4() {
        return matWhExt4;
    }

    public void setMatWhExt4(String matWhExt4) {
        this.matWhExt4 = matWhExt4 == null ? null : matWhExt4.trim();
    }

    public String getMatWhExt5() {
        return matWhExt5;
    }

    public void setMatWhExt5(String matWhExt5) {
        this.matWhExt5 = matWhExt5 == null ? null : matWhExt5.trim();
    }

    public String getMatWhExt6() {
        return matWhExt6;
    }

    public void setMatWhExt6(String matWhExt6) {
        this.matWhExt6 = matWhExt6 == null ? null : matWhExt6.trim();
    }

    public String getMatWhExt7() {
        return matWhExt7;
    }

    public void setMatWhExt7(String matWhExt7) {
        this.matWhExt7 = matWhExt7 == null ? null : matWhExt7.trim();
    }

    public String getMatWhExt8() {
        return matWhExt8;
    }

    public void setMatWhExt8(String matWhExt8) {
        this.matWhExt8 = matWhExt8 == null ? null : matWhExt8.trim();
    }

    public String getMatWhExt9() {
        return matWhExt9;
    }

    public void setMatWhExt9(String matWhExt9) {
        this.matWhExt9 = matWhExt9 == null ? null : matWhExt9.trim();
    }
}