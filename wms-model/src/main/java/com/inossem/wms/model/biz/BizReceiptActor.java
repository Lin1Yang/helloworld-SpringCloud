package com.inossem.wms.model.biz;

import java.util.Date;

public class BizReceiptActor extends BizReceiptActorKey {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2006447429558148394L;

	private String fileCode;
	
	private Byte receiptStatus;
	
    private Integer postIndex;
    
    private Integer approverId;
    
    private Date approveTime;
    
    private Byte processStatus;

    private Byte isDelete;

    private Date arriveTime;

    private Date createTime;

    private Date modifyTime;

    private Integer createUserId;

    private Integer modifyUserId;

    private String receiptActorExt0;

    private String receiptActorExt1;

    private String receiptActorExt2;

    private String receiptActorExt3;

    private String receiptActorExt4;

    private String receiptActorExt5;

    private String receiptActorExt6;

    private String receiptActorExt7;

    private String receiptActorExt8;

    private String receiptActorExt9;

    public Integer getApproverId() {
		return approverId;
	}

	public void setApproverId(Integer approverId) {
		this.approverId = approverId;
	}

	public Date getApproveTime() {
		return approveTime;
	}

	public void setApproveTime(Date approveTime) {
		this.approveTime = approveTime;
	}

	public Byte getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(Byte processStatus) {
		this.processStatus = processStatus;
	}

	public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }    

    public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Integer modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public String getReceiptActorExt0() {
        return receiptActorExt0;
    }

    public void setReceiptActorExt0(String receiptActorExt0) {
        this.receiptActorExt0 = receiptActorExt0 == null ? null : receiptActorExt0.trim();
    }

    public String getReceiptActorExt1() {
        return receiptActorExt1;
    }

    public void setReceiptActorExt1(String receiptActorExt1) {
        this.receiptActorExt1 = receiptActorExt1 == null ? null : receiptActorExt1.trim();
    }

    public String getReceiptActorExt2() {
        return receiptActorExt2;
    }

    public void setReceiptActorExt2(String receiptActorExt2) {
        this.receiptActorExt2 = receiptActorExt2 == null ? null : receiptActorExt2.trim();
    }

    public String getReceiptActorExt3() {
        return receiptActorExt3;
    }

    public void setReceiptActorExt3(String receiptActorExt3) {
        this.receiptActorExt3 = receiptActorExt3 == null ? null : receiptActorExt3.trim();
    }

    public String getReceiptActorExt4() {
        return receiptActorExt4;
    }

    public void setReceiptActorExt4(String receiptActorExt4) {
        this.receiptActorExt4 = receiptActorExt4 == null ? null : receiptActorExt4.trim();
    }

    public String getReceiptActorExt5() {
        return receiptActorExt5;
    }

    public void setReceiptActorExt5(String receiptActorExt5) {
        this.receiptActorExt5 = receiptActorExt5 == null ? null : receiptActorExt5.trim();
    }

    public String getReceiptActorExt6() {
        return receiptActorExt6;
    }

    public void setReceiptActorExt6(String receiptActorExt6) {
        this.receiptActorExt6 = receiptActorExt6 == null ? null : receiptActorExt6.trim();
    }

    public String getReceiptActorExt7() {
        return receiptActorExt7;
    }

    public void setReceiptActorExt7(String receiptActorExt7) {
        this.receiptActorExt7 = receiptActorExt7 == null ? null : receiptActorExt7.trim();
    }

    public String getReceiptActorExt8() {
        return receiptActorExt8;
    }

    public void setReceiptActorExt8(String receiptActorExt8) {
        this.receiptActorExt8 = receiptActorExt8 == null ? null : receiptActorExt8.trim();
    }

    public String getReceiptActorExt9() {
        return receiptActorExt9;
    }

    public void setReceiptActorExt9(String receiptActorExt9) {
        this.receiptActorExt9 = receiptActorExt9 == null ? null : receiptActorExt9.trim();
    }


    public String getFileCode() {
		return fileCode;
	}

	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}

	public Byte getReceiptStatus() {
		return receiptStatus;
	}

	public void setReceiptStatus(Byte receiptStatus) {
		this.receiptStatus = receiptStatus;
	}

	public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Integer getPostIndex() {
        return postIndex;
    }

    public void setPostIndex(Integer postIndex) {
        this.postIndex = postIndex;
    }
}