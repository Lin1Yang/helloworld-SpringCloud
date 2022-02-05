package com.inossem.wms.model.biz;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.biz.BizReceiptAttachmentInfoCo", description="单据附件前端传输参数")
public class BizReceiptAttachmentInfoCo extends BizReceiptAttachmentCo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8179094777956734510L;

	@ApiModelProperty(value="单据附件表自增id", name="bizReceiptAttachmentId", example="1", required=true)
    private Integer bizReceiptAttachmentId;
	
	@ApiModelProperty(value="文件编码", name="fileCode", example="123456789", required=true)
    private String fileCode;

	public Integer getBizReceiptAttachmentId() {
		return bizReceiptAttachmentId;
	}

	public void setBizReceiptAttachmentId(Integer bizReceiptAttachmentId) {
		this.bizReceiptAttachmentId = bizReceiptAttachmentId;
	}

	public String getFileCode() {
		return fileCode;
	}

	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}
	
	
	
}
