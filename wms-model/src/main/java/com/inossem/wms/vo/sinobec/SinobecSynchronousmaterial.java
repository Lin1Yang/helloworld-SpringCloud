package com.inossem.wms.vo.sinobec;

import com.inossem.wms.page.PageCommon;

public class SinobecSynchronousmaterial{
    private static final long serialVersionUID = 111887853717384866L;

    private Integer result;
    private String ShippingRef;
    private String SOPNumber;
    private String DocumentCode;
    private String lotNumb;
    private String Date;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getShippingRef() {
        return ShippingRef;
    }

    public void setShippingRef(String shippingRef) {
        ShippingRef = shippingRef;
    }

    public String getSOPNumber() {
        return SOPNumber;
    }

    public void setSOPNumber(String SOPNumber) {
        this.SOPNumber = SOPNumber;
    }

    public String getDocumentCode() {
        return DocumentCode;
    }

    public void setDocumentCode(String documentCode) {
        DocumentCode = documentCode;
    }

    public String getLotNumb() {
        return lotNumb;
    }

    public void setLotNumb(String lotNumb) {
        this.lotNumb = lotNumb;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

}
