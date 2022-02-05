package com.inossem.wms.vo.dic;

import com.inossem.wms.enums.EnumPriceMethod;
import com.inossem.wms.model.dic.DicMaterialFactory;
import com.inossem.wms.page.IPageResultCommon;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import org.springframework.util.StringUtils;

/**
 * @author : sw
 * @date : 2019/2/20
 */
@ApiModel(value="com.inossem.wms.vo.dic.DicMaterialFactoryVo", description="工厂物料信息拓展对象")
public class DicMaterialFactoryVo extends DicMaterialFactory implements IPageResultCommon, Serializable {

	private static final long serialVersionUID = 3201908258971124048L;

	@ApiModelProperty(value ="总数量", name = "totalCount",example = "100", required = true)
    private int totalCount;

    @ApiModelProperty(value = "物料描述", name = "matName", example = "板/δ3*1500*6000/Q235B", required = true)
    private String matName;

    @ApiModelProperty(value = "物料类型编码", name = "matTypeCode", example = "ROH", required = true)
    private String matTypeCode;

    @ApiModelProperty(value = "物料类型描述", name = "matTypeName", example = "原材料", required = true)
    private String matTypeName;

    @ApiModelProperty(value = "计量单位编码", name = "unitCode", example = "KG", required = true)
    private String unitCode;

    @ApiModelProperty(value = "计量单位描述", name = "matName", example = "千克", required = true)
    private String unitName;

    @ApiModelProperty(value = "小数位", name = "decimalPlace" ,example = "1" ,required = true)
    private Integer decimalPlace;

    @ApiModelProperty(value = "物料组编码", name = "matGroupCode", example = "01", required = true)
    private String matGroupCode;

    @ApiModelProperty(value= "物料组描述", name="matGroupName", example="物料组1", required = true)
    private String matGroupName;

    @ApiModelProperty(value = "工厂描述", name = "ftyName",example = "工厂1", required = true)
    private String ftyName;

    @ApiModelProperty(value = "计价方式描述", name = "priceMethodName", example = "移动平均", required = true)
    private String priceMethodName;

    @ApiModelProperty(value = "批次特性分类描述", name="batchSpecificClassifyName", example="物料批次分类特性01", required=true)
    private String batchSpecificClassifyName;

    @ApiModelProperty(value = "物料ERP批次启用", name="matBatchErpEnabled", example="0", required=true)
    private Byte matBatchErpEnabled;

    @ApiModelProperty(value = "物料生产批次启用", name="matBatchProductEnabled", example="0", required=true)
    private Byte matBatchProductEnabled;

    @ApiModelProperty(value = "物料包装物启用", name="matPackageEnabled", example="0", required=true)
    private Byte matPackageEnabled;

    public Byte getMatBatchErpEnabled() {
        return matBatchErpEnabled;
    }

    public void setMatBatchErpEnabled(Byte matBatchErpEnabled) {
        this.matBatchErpEnabled = matBatchErpEnabled;
    }

    public Byte getMatBatchProductEnabled() {
        return matBatchProductEnabled;
    }

    public void setMatBatchProductEnabled(Byte matBatchProductEnabled) {
        this.matBatchProductEnabled = matBatchProductEnabled;
    }

    public Byte getMatPackageEnabled() {
        return matPackageEnabled;
    }

    public void setMatPackageEnabled(Byte matPackageEnabled) {
        this.matPackageEnabled = matPackageEnabled;
    }

    public Integer getDecimalPlace() {
        return decimalPlace;
    }

    public void setDecimalPlace(Integer decimalPlace) {
        this.decimalPlace = decimalPlace;
    }

    @Override
    public int getTotalCount() {
        return totalCount;
    }

    @Override
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public String getMatName() {
        return matName;
    }

    public void setMatName(String matName) {
        this.matName = matName;
    }

    public String getMatTypeCode() {
        return matTypeCode;
    }

    public void setMatTypeCode(String matTypeCode) {
        this.matTypeCode = matTypeCode;
    }

    public String getMatTypeName() {
        return matTypeName;
    }

    public void setMatTypeName(String matTypeName) {
        this.matTypeName = matTypeName;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getMatGroupCode() {
        return matGroupCode;
    }

    public void setMatGroupCode(String matGroupCode) {
        this.matGroupCode = matGroupCode;
    }

    public String getMatGroupName() {
        return matGroupName;
    }

    public void setMatGroupName(String matGroupName) {
        this.matGroupName = matGroupName;
    }

    public String getFtyName() {
        return ftyName;
    }

    public void setFtyName(String ftyName) {
        this.ftyName = ftyName;
    }

    public String getPriceMethodName() {
        if(StringUtils.hasText(this.getPriceMethod())){
            return EnumPriceMethod.getNameByValue(this.getPriceMethod());
        } else {
            return "";
        }
    }

    public void setPriceMethodName(String priceMethodName) {
        this.priceMethodName = priceMethodName;
    }

    public String getBatchSpecificClassifyName() {
        return batchSpecificClassifyName;
    }

    public void setBatchSpecificClassifyName(String batchSpecificClassifyName) {
        this.batchSpecificClassifyName = batchSpecificClassifyName;
    }
}
