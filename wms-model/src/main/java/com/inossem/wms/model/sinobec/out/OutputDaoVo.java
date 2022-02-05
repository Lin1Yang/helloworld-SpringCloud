package com.inossem.wms.model.sinobec.out;

import com.inossem.wms.model.sinobec.SinobecBizOutput;
import com.inossem.wms.model.sinobec.SinobecStock;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 *  出库下级vo
 */
public class OutputDaoVo extends SinobecBizOutput implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4834062894231417422L;
	/**
     * 仓位信息
     */
    @ApiModelProperty(value = "仓位信息" )
    private List<SinobecStock> sinobecStocks;
    
    private String matName;
    
    private Integer totalCount;
    
    private Integer tempCount;

    private List<String> bundleList;
    
	
//    @ApiModelProperty(value = "Added for vin from SAP",example = "...")
//    private String ext0;
//    
//    @ApiModelProperty(value = "Added for engine from SAP",example = "...")
//    private String ext1;
    

    public List<String> getBundleList() {
        return bundleList;
    }

    public void setBundleList(List<String> bundleList) {
        this.bundleList = bundleList;
    }

    /**
     * 匹配结果
     */
    @ApiModelProperty(value = "匹配结果 》》》》 正常匹配 value=10  库存数量大于订单数量 value=20 库存数量小于订单数量 value=30 无法匹配 value=40" )
    private byte matchCase;

    public List<SinobecStock> getSinobecStocks() {
        return sinobecStocks;
    }

    public void setSinobecStocks(List<SinobecStock> sinobecStocks) {
        this.sinobecStocks = sinobecStocks;
    }

    public byte getMatchCase() {
        return matchCase;
    }

    public void setMatchCase(byte matchCase) {
        this.matchCase = matchCase;
    }

	public String getMatName() {
		return matName;
	}

	public void setMatName(String matName) {
		this.matName = matName;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTempCount() {
		return tempCount;
	}

	public void setTempCount(Integer tempCount) {
		this.tempCount = tempCount;
	}
    
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
    
}
