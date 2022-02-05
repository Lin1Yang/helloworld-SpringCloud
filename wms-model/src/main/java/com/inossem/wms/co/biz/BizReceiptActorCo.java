package com.inossem.wms.co.biz;

import java.util.Date;
import java.util.List;

import com.inossem.wms.model.biz.BizReceiptActor;

public class BizReceiptActorCo extends BizReceiptActor {
    /**
	 * 
	 */
	private static final long serialVersionUID = 9115563818671428942L;
	private Date startSearchDate;
    private Date endSearchDate;
    private List<Integer> receiptTypeList;
    

    public List<Integer> getReceiptTypeList() {
		return receiptTypeList;
	}

	public void setReceiptTypeList(List<Integer> receiptTypeList) {
		this.receiptTypeList = receiptTypeList;
	}

	public Date getStartSearchDate() {
        return startSearchDate;
    }

    public void setStartSearchDate(Date startSearchDate) {
        this.startSearchDate = startSearchDate;
    }

    public Date getEndSearchDate() {
        return endSearchDate;
    }

    public void setEndSearchDate(Date endSearchDate) {
        this.endSearchDate = endSearchDate;
    }
}
