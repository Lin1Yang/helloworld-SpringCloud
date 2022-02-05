package com.inossem.wms.model.biz;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="com.inossem.wms.model.biz.BizReceiptItemImg", description="行项目对应图片对象")
public class BizReceiptItemImg {
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
	@ApiModelProperty(value="删除标识", example="0")
    private Byte isDelete;
	@ApiModelProperty(value="创建时间", example="2018-12-12 12:22:22")
    private Date createTime;
	@ApiModelProperty(value="修改时间", example="2018-12-12 12:22:22")
    private Date modifyTime;
	@ApiModelProperty(value="创建人", example="1")
    private Integer createUserId;
	@ApiModelProperty(value="修改人", example="1")
    private Integer modifyUserId;
	
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

    public String getReceiptItemImgExt0() {
        return receiptItemImgExt0;
    }

    public void setReceiptItemImgExt0(String receiptItemImgExt0) {
        this.receiptItemImgExt0 = receiptItemImgExt0 == null ? null : receiptItemImgExt0.trim();
    }

    public String getReceiptItemImgExt1() {
        return receiptItemImgExt1;
    }

    public void setReceiptItemImgExt1(String receiptItemImgExt1) {
        this.receiptItemImgExt1 = receiptItemImgExt1 == null ? null : receiptItemImgExt1.trim();
    }

    public String getReceiptItemImgExt2() {
        return receiptItemImgExt2;
    }

    public void setReceiptItemImgExt2(String receiptItemImgExt2) {
        this.receiptItemImgExt2 = receiptItemImgExt2 == null ? null : receiptItemImgExt2.trim();
    }

    public String getReceiptItemImgExt3() {
        return receiptItemImgExt3;
    }

    public void setReceiptItemImgExt3(String receiptItemImgExt3) {
        this.receiptItemImgExt3 = receiptItemImgExt3 == null ? null : receiptItemImgExt3.trim();
    }

    public String getReceiptItemImgExt4() {
        return receiptItemImgExt4;
    }

    public void setReceiptItemImgExt4(String receiptItemImgExt4) {
        this.receiptItemImgExt4 = receiptItemImgExt4 == null ? null : receiptItemImgExt4.trim();
    }

    public String getReceiptItemImgExt5() {
        return receiptItemImgExt5;
    }

    public void setReceiptItemImgExt5(String receiptItemImgExt5) {
        this.receiptItemImgExt5 = receiptItemImgExt5 == null ? null : receiptItemImgExt5.trim();
    }

    public String getReceiptItemImgExt6() {
        return receiptItemImgExt6;
    }

    public void setReceiptItemImgExt6(String receiptItemImgExt6) {
        this.receiptItemImgExt6 = receiptItemImgExt6 == null ? null : receiptItemImgExt6.trim();
    }

    public String getReceiptItemImgExt7() {
        return receiptItemImgExt7;
    }

    public void setReceiptItemImgExt7(String receiptItemImgExt7) {
        this.receiptItemImgExt7 = receiptItemImgExt7 == null ? null : receiptItemImgExt7.trim();
    }

    public String getReceiptItemImgExt8() {
        return receiptItemImgExt8;
    }

    public void setReceiptItemImgExt8(String receiptItemImgExt8) {
        this.receiptItemImgExt8 = receiptItemImgExt8 == null ? null : receiptItemImgExt8.trim();
    }

    public String getReceiptItemImgExt9() {
        return receiptItemImgExt9;
    }

    public void setReceiptItemImgExt9(String receiptItemImgExt9) {
        this.receiptItemImgExt9 = receiptItemImgExt9 == null ? null : receiptItemImgExt9.trim();
    }
}