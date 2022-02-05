package com.inossem.wms.model.sinobec.unload;

import com.inossem.wms.model.sinobec.SinobecBizTask;
import com.inossem.wms.model.sinobec.SinobecStock;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 下架下级vo
 */
public class UnLoadShelfDaoVo extends SinobecBizTask implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8558760364048123564L;
	/**
     * 仓位信息
     */
    @ApiModelProperty(value = "仓位信息" )
    private List<SinobecStock> sinobecStocks;
    /**
     * 匹配结果
     */
    @ApiModelProperty(value = "匹配结果 》》》》 正常匹配 value=10  库存数量大于订单数量 value=20 库存数量小于订单数量 value=30 无法匹配 value=40" )
    private byte matchCase;
    
//    @ApiModelProperty(value = "Added for vin from SAP",example = "...")
//    private String ext0;
//    
//    @ApiModelProperty(value = "Added for engine from SAP",example = "...")
//    private String ext1;

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
    
    private String matName;

	public String getMatName() {
		return matName;
	}

	public void setMatName(String matName) {
		this.matName = matName;
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
