package com.inossem.wms.model.sinobec.out;

import io.swagger.annotations.ApiModelProperty;

/**
  * 功能描述: 〈〉
  *
  * @return:
  * @since: 1.0.0
  * @Author: cxq
  * @Date: 2020/3/26 0026 11:01
  */
public class OutputResultVo {
    /**
     * 单据code
     */
    @ApiModelProperty(value = "单据code" )
    private String receiptCode;

    public String getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(String receiptCode) {
        this.receiptCode = receiptCode;
    }

    public OutputResultVo(String receiptCode) {
        this.receiptCode = receiptCode;
    }

    public OutputResultVo() {
    }

}

