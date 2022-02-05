package com.inossem.wms.model.sinobec.unload;

/**
 * FileName: ShelfLoadVoResult
 * Date:     2020/3/24 0024 10:00
 * Description: 返回提交结果
 *
 * @author cxq
 */
public class UnLoadShelfResultVo {
    /**
     * 单据code
     */
    private String receiptCode;

    public String getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(String receiptCode) {
        this.receiptCode = receiptCode;
    }

    public UnLoadShelfResultVo(String receiptCode) {
        this.receiptCode = receiptCode;
    }

    public UnLoadShelfResultVo() {
    }
}

