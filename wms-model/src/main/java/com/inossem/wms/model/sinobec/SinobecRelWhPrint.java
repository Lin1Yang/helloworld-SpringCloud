package com.inossem.wms.model.sinobec;

import io.swagger.annotations.ApiModelProperty;

public class SinobecRelWhPrint {

    @ApiModelProperty(value="仓库号")
    private String whCode;

    @ApiModelProperty(value="打印机IP")
    private String printIp;

    @ApiModelProperty(value="打印机端口")
    private String printPort;

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    public String getPrintIp() {
        return printIp;
    }

    public void setPrintIp(String printIp) {
        this.printIp = printIp;
    }

    public String getPrintPort() {
        return printPort;
    }

    public void setPrintPort(String printPort) {
        this.printPort = printPort;
    }
}
