package com.inossem.wms.vo.sinobec;

import com.inossem.wms.model.sinobec.input.SinobecBizInput;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName SinobecBizInputVo
 * @Description 入库扩展类
 * @Author wsail
 * @Date 2020/3/24 12:06
 **/
public class SinobecBizInputVo extends SinobecBizInput {


    private Integer totalCount;

    private String receiptUnitName;

    private String weightUnitName;
    
    private Byte receiptDecimalPlace;
    
    private Byte weightDecimalPlace;

    private String matName;

    private String whCode;  //2021-10-07 新加
    
//    @ApiModelProperty(value = "Added for vin from SAP",example = "...")
//    private String ext0;
//    
//    @ApiModelProperty(value = "Added for engine from SAP",example = "...")
//    private String ext1;
//    
//    @ApiModelProperty(value = "Added for engine from SAP",example = "...")
//    private String ext2;

    public String getReceiptUnitName() {
        return receiptUnitName;
    }

    public void setReceiptUnitName(String receiptUnitName) {
        this.receiptUnitName = receiptUnitName;
    }

    public String getWeightUnitName() {
        return weightUnitName;
    }

    public void setWeightUnitName(String weightUnitName) {
        this.weightUnitName = weightUnitName;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

	public Byte getReceiptDecimalPlace() {
		return receiptDecimalPlace;
	}

	public void setReceiptDecimalPlace(Byte receiptDecimalPlace) {
		this.receiptDecimalPlace = receiptDecimalPlace;
	}

	public Byte getWeightDecimalPlace() {
		return weightDecimalPlace;
	}

	public void setWeightDecimalPlace(Byte weightDecimalPlace) {
		this.weightDecimalPlace = weightDecimalPlace;
	}
    
    private String colorClass;

	public String getColorClass() {
		return colorClass;
	}

	public void setColorClass(String colorClass) {
		this.colorClass = colorClass;
	}

    public String getMatName() {
        return matName;
    }

    public void setMatName(String matName) {
        this.matName = matName;
    }

    public String getWhCode() {
        return whCode;
    }  //2021-10-07 新加

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }  //2021-10-07 新加
    
//	public String getExt0() {
//		return ext0;
//	}
//	public void setExt0(String ext0) {
//		this.ext0 = ext0;
//	}
//	public String getExt1() {
//		return ext1;
//	}
//	public void setExt1(String ext1) {
//		this.ext1 = ext1;
//	}
//
//	public String getExt2() {
//		return ext2;
//	}
//
//	public void setExt2(String ext2) {
//		this.ext2 = ext2;
//	}
	
}
