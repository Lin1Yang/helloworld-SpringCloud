package com.inossem.wms.model.sinobec.out;

import com.inossem.wms.model.sinobec.gp.SinobecBizOutputGp;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * FileName: QueryShelfLoadCo
 * Date:     2020/3/20 0020 15:25
 * Description: 下架单查询Co
 *
 * @author cxq
 */
public class OutputQueryCo extends SinobecBizOutputGp implements Serializable  {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1445366112424459509L;

	/**
     * 单据类型
      销售出库单 411
      转出到其他仓库 611
      委外加工转出 711
     */
    @ApiModelProperty(value="单据类型", name="receiptType",  required=true ,example = "411")
    private Integer receiptType;

    @ApiModelProperty(value="销售订单号/Sales Order Number", name="salesOrderNumber",  required=true ,example = "out001")
    private String salesOrderNumber;


    @ApiModelProperty(value="是否创建", name="create",  required=true)
    private Boolean create;

    private String sdate;

    private String edate;

    public Integer getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(Integer receiptType) {
        this.receiptType = receiptType;
    }

    public String getSalesOrderNumber() {
        return salesOrderNumber;
    }

    public void setSalesOrderNumber(String salesOrderNumber) {
        this.salesOrderNumber = salesOrderNumber;
    }

    public Boolean getCreate() {
        return create;
    }

    public void setCreate(Boolean create) {
        this.create = create;
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
}
