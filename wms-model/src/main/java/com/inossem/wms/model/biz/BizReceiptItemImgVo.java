package com.inossem.wms.model.biz;

import com.inossem.wms.model.file.ImgFile;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.biz.BizReceiptItemImgVo", description="行项目对应图片扩展对象")
public class BizReceiptItemImgVo extends ImgFile{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2850235699146510644L;
	@ApiModelProperty(value="主键", example="1")
    private Integer bizReceiptItemImgId;
	@ApiModelProperty(value="单据类型", example="22")
    private Integer receiptType;
	@ApiModelProperty(value="单据code", example="1000457454")
    private String receiptCode;
	@ApiModelProperty(value="行项目号", example="1")
    private String receiptRid;
	@ApiModelProperty(value="图片code", example="1")
    private String fileCode;
	@ApiModelProperty(value="绝对路径", example="D:\\img\\ss.png")
	private String absolutePath;
	
	@ApiModelProperty(value="状态", example="finished")
	private String status="finished";

    private String receiptItemImgExt0;

    private String receiptItemImgExt1;

    private String receiptItemImgExt2;

    private String receiptItemImgExt3;

    private String receiptItemImgExt4;

    private String receiptItemImgExt5;

    private String receiptItemImgExt6;

    private String receiptItemImgExt7;

    private String receiptItemImgExt8;

    private String receiptItemImgExt9;

    public Integer getBizReceiptItemImgId() {
        return bizReceiptItemImgId;
    }

    public void setBizReceiptItemImgId(Integer bizReceiptItemImgId) {
        this.bizReceiptItemImgId = bizReceiptItemImgId;
    }

    public Integer getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(Integer receiptType) {
        this.receiptType = receiptType;
    }

    public String getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(String receiptCode) {
        this.receiptCode = receiptCode == null ? null : receiptCode.trim();
    }

    public String getReceiptRid() {
        return receiptRid;
    }

    public void setReceiptRid(String receiptRid) {
        this.receiptRid = receiptRid == null ? null : receiptRid.trim();
    }

    public String getFileCode() {
        return fileCode;
    }

    public void setFileCode(String fileCode) {
        this.fileCode = fileCode == null ? null : fileCode.trim();
    }

	public String getAbsolutePath() {
		return absolutePath;
	}

	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReceiptItemImgExt0() {
		return receiptItemImgExt0;
	}

	public void setReceiptItemImgExt0(String receiptItemImgExt0) {
		this.receiptItemImgExt0 = receiptItemImgExt0;
	}

	public String getReceiptItemImgExt1() {
		return receiptItemImgExt1;
	}

	public void setReceiptItemImgExt1(String receiptItemImgExt1) {
		this.receiptItemImgExt1 = receiptItemImgExt1;
	}

	public String getReceiptItemImgExt2() {
		return receiptItemImgExt2;
	}

	public void setReceiptItemImgExt2(String receiptItemImgExt2) {
		this.receiptItemImgExt2 = receiptItemImgExt2;
	}

	public String getReceiptItemImgExt3() {
		return receiptItemImgExt3;
	}

	public void setReceiptItemImgExt3(String receiptItemImgExt3) {
		this.receiptItemImgExt3 = receiptItemImgExt3;
	}

	public String getReceiptItemImgExt4() {
		return receiptItemImgExt4;
	}

	public void setReceiptItemImgExt4(String receiptItemImgExt4) {
		this.receiptItemImgExt4 = receiptItemImgExt4;
	}

	public String getReceiptItemImgExt5() {
		return receiptItemImgExt5;
	}

	public void setReceiptItemImgExt5(String receiptItemImgExt5) {
		this.receiptItemImgExt5 = receiptItemImgExt5;
	}

	public String getReceiptItemImgExt6() {
		return receiptItemImgExt6;
	}

	public void setReceiptItemImgExt6(String receiptItemImgExt6) {
		this.receiptItemImgExt6 = receiptItemImgExt6;
	}

	public String getReceiptItemImgExt7() {
		return receiptItemImgExt7;
	}

	public void setReceiptItemImgExt7(String receiptItemImgExt7) {
		this.receiptItemImgExt7 = receiptItemImgExt7;
	}

	public String getReceiptItemImgExt8() {
		return receiptItemImgExt8;
	}

	public void setReceiptItemImgExt8(String receiptItemImgExt8) {
		this.receiptItemImgExt8 = receiptItemImgExt8;
	}

	public String getReceiptItemImgExt9() {
		return receiptItemImgExt9;
	}

	public void setReceiptItemImgExt9(String receiptItemImgExt9) {
		this.receiptItemImgExt9 = receiptItemImgExt9;
	}

	
}