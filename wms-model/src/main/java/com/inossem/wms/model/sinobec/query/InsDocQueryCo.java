package com.inossem.wms.model.sinobec.query;

import com.inossem.wms.page.PageCommon;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 功能描述: 〈Ins凭证查询〉
 *
 * @return:
 * @since: 1.0.0
 * @Author: cxq
 * @Date: 2020/3/31 0031 10:21
 */
@ApiModel(value="com.inossem.wms.model.sinobec.query.InsDocQueryCo", description="查询条件对象")
public class InsDocQueryCo  extends PageCommon {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5315666910180020005L;

	@ApiModelProperty(value = "开始时间" ,example = "")
    private String sdate;

    @ApiModelProperty(value = "结束时间" ,example = "")
    private String edate;

    @ApiModelProperty(value = "单号code" ,example = "out002")
    private String soCode;

    @ApiModelProperty(value = "传单号",example = "1")
    private String shippingRef;

    @ApiModelProperty(value="公司编码", name="corpCode",  required=true ,example = "A001")
    private String corpCode;

    @ApiModelProperty(value = "bundle编码" ,example = "")
    private String bundleCode;

    @ApiModelProperty(value = "仓位code" ,example = "")
    private String binCode;
    
    private String typeCode;
    
    private String whCode;
  
	private String condition;
    
    private String ext0;
    
    private String ext1;
    
    private String tranType;
    
    private String matCode;

    private String lotNumb;

    public String getLotNumb() {
        return lotNumb;
    }

    public void setLotNumb(String lotNumb) {
        this.lotNumb = lotNumb;
    }

    public String getTranType() {
		return tranType;
	}

	public void setTranType(String tranType) {
		this.tranType = tranType;
	}

	public String getMatCode() {
		return matCode;
	}

	public void setMatCode(String matCode) {
		this.matCode = matCode;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}


	public String getExt0() {
		return ext0;
	}

	public void setExt0(String ext0) {
		this.ext0 = ext0;
	}

	public String getExt1() {
		return ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	public String getBinCode() {
        return binCode;
    }

    public void setBinCode(String binCode) {
        this.binCode = binCode;
    }

    public String getBundleCode() {
        return bundleCode;
    }

    public void setBundleCode(String bundleCode) {
        this.bundleCode = bundleCode;
    }

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    public String getEdate() {
        return edate;
    }

    public void setEdate(String edate) {
        this.edate = edate;
    }

    public String getSoCode() {
        return soCode;
    }

    public void setSoCode(String soCode) {
        this.soCode = soCode;
    }

    public String getShippingRef() {
        return shippingRef;
    }

    public void setShippingRef(String shippingRef) {
        this.shippingRef = shippingRef;
    }

    public String getCorpCode() {
        return corpCode;
    }

    public void setCorpCode(String corpCode) {
        this.corpCode = corpCode;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

	public String getWhCode() {
		return whCode;
	}

	public void setWhCode(String whCode) {
		this.whCode = whCode;
	}
    
    
}
