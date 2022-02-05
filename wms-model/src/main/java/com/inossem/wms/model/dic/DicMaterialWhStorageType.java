package com.inossem.wms.model.dic;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.dic.DicMaterialWhStorageTypeKey", description="物料仓库存储类型对象")
public class DicMaterialWhStorageType extends DicMaterialWhStorageTypeKey {
	
	@ApiModelProperty(value="仓位", name="storageBinCode",example="S01", required=true)
    private String storageBinCode;
	
	@ApiModelProperty(value="库存上架策略B2 大容量仓储 F6 固定仓位 I9 增加现有库存 L12 下一个空仓位 P16 仓储单位类型, name=strategyShelfLoad",example="A", required=true)
    private String strategyShelfLoad;
	
	@ApiModelProperty(value="库存下架策略A1 最小数量先出F6 先进先出H8 货架寿命的到期日L12 后进先出, name=strategyShelfUnload",example="L", required=true)
    private String strategyShelfUnload;
	
	@ApiModelProperty(value="最大仓位数量", name="stockBinMax",example="10", required=true)
    private BigDecimal stockBinMax;
	
	@ApiModelProperty(value="最小仓位数量", name="stockBinMin",example="0", required=true)
    private BigDecimal stockBinMin;

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

    private String matWhStorageTypeExt0;

    private String matWhStorageTypeExt1;

    private String matWhStorageTypeExt2;

    private String matWhStorageTypeExt3;

    private String matWhStorageTypeExt4;

    private String matWhStorageTypeExt5;

    private String matWhStorageTypeExt6;

    private String matWhStorageTypeExt7;

    private String matWhStorageTypeExt8;

    private String matWhStorageTypeExt9;

    public String getStorageBinCode() {
        return storageBinCode;
    }

    public void setStorageBinCode(String storageBinCode) {
        this.storageBinCode = storageBinCode == null ? null : storageBinCode.trim();
    }

    public String getStrategyShelfLoad() {
        return strategyShelfLoad;
    }

    public void setStrategyShelfLoad(String strategyShelfLoad) {
        this.strategyShelfLoad = strategyShelfLoad == null ? null : strategyShelfLoad.trim();
    }

    public String getStrategyShelfUnload() {
        return strategyShelfUnload;
    }

    public void setStrategyShelfUnload(String strategyShelfUnload) {
        this.strategyShelfUnload = strategyShelfUnload == null ? null : strategyShelfUnload.trim();
    }

    public BigDecimal getStockBinMax() {
        return stockBinMax;
    }

    public void setStockBinMax(BigDecimal stockBinMax) {
        this.stockBinMax = stockBinMax;
    }

    public BigDecimal getStockBinMin() {
        return stockBinMin;
    }

    public void setStockBinMin(BigDecimal stockBinMin) {
        this.stockBinMin = stockBinMin;
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

    public String getMatWhStorageTypeExt0() {
        return matWhStorageTypeExt0;
    }

    public void setMatWhStorageTypeExt0(String matWhStorageTypeExt0) {
        this.matWhStorageTypeExt0 = matWhStorageTypeExt0 == null ? null : matWhStorageTypeExt0.trim();
    }

    public String getMatWhStorageTypeExt1() {
        return matWhStorageTypeExt1;
    }

    public void setMatWhStorageTypeExt1(String matWhStorageTypeExt1) {
        this.matWhStorageTypeExt1 = matWhStorageTypeExt1 == null ? null : matWhStorageTypeExt1.trim();
    }

    public String getMatWhStorageTypeExt2() {
        return matWhStorageTypeExt2;
    }

    public void setMatWhStorageTypeExt2(String matWhStorageTypeExt2) {
        this.matWhStorageTypeExt2 = matWhStorageTypeExt2 == null ? null : matWhStorageTypeExt2.trim();
    }

    public String getMatWhStorageTypeExt3() {
        return matWhStorageTypeExt3;
    }

    public void setMatWhStorageTypeExt3(String matWhStorageTypeExt3) {
        this.matWhStorageTypeExt3 = matWhStorageTypeExt3 == null ? null : matWhStorageTypeExt3.trim();
    }

    public String getMatWhStorageTypeExt4() {
        return matWhStorageTypeExt4;
    }

    public void setMatWhStorageTypeExt4(String matWhStorageTypeExt4) {
        this.matWhStorageTypeExt4 = matWhStorageTypeExt4 == null ? null : matWhStorageTypeExt4.trim();
    }

    public String getMatWhStorageTypeExt5() {
        return matWhStorageTypeExt5;
    }

    public void setMatWhStorageTypeExt5(String matWhStorageTypeExt5) {
        this.matWhStorageTypeExt5 = matWhStorageTypeExt5 == null ? null : matWhStorageTypeExt5.trim();
    }

    public String getMatWhStorageTypeExt6() {
        return matWhStorageTypeExt6;
    }

    public void setMatWhStorageTypeExt6(String matWhStorageTypeExt6) {
        this.matWhStorageTypeExt6 = matWhStorageTypeExt6 == null ? null : matWhStorageTypeExt6.trim();
    }

    public String getMatWhStorageTypeExt7() {
        return matWhStorageTypeExt7;
    }

    public void setMatWhStorageTypeExt7(String matWhStorageTypeExt7) {
        this.matWhStorageTypeExt7 = matWhStorageTypeExt7 == null ? null : matWhStorageTypeExt7.trim();
    }

    public String getMatWhStorageTypeExt8() {
        return matWhStorageTypeExt8;
    }

    public void setMatWhStorageTypeExt8(String matWhStorageTypeExt8) {
        this.matWhStorageTypeExt8 = matWhStorageTypeExt8 == null ? null : matWhStorageTypeExt8.trim();
    }

    public String getMatWhStorageTypeExt9() {
        return matWhStorageTypeExt9;
    }

    public void setMatWhStorageTypeExt9(String matWhStorageTypeExt9) {
        this.matWhStorageTypeExt9 = matWhStorageTypeExt9 == null ? null : matWhStorageTypeExt9.trim();
    }
}