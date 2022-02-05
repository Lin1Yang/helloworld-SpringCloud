package com.inossem.wms.co.conf;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Description 
 * @ClassName：ConfReceiptTypeCo :
 * @Package com.inossem.wms.co.conf
 * @anthor：wyang
 * @date：2019/7/19
 * @版本：V1.0
 */
@ApiModel(value = "ConfReceiptTypeCo" ,description = "新增或删除配置的入参")
public class ConfReceiptTypeCo {

    @ApiModelProperty(value = "配置类型",name = "confReceiptTypeCode",required = true)
    private String confReceiptTypeCode;

    @ApiModelProperty(name = "receiptType",value = "业务类型",required = true)
    private Integer receiptType;

    @ApiModelProperty(name = "procId",value = "模板id",required = false)
    private String procId;

    @ApiModelProperty(name = "createTime",value = "创建时间",required = false)
    private Date createTime;

    @ApiModelProperty(name = "modifyTime",value = "修改时间",required = false)
    private Date modifyTime;

    @ApiModelProperty(name = "createUserId",value = "创建人id",required = false)
    private Integer createUserId;

    @ApiModelProperty(name = "modifyUserId",value = "修改人id",required = false)
    private Integer modifyUserId;

    @ApiModelProperty(name = "type",value = "新增或删除",required = true,example = "1表示新增,2表示修改")
    private byte type;


    public String getConfReceiptTypeCode() {
        return confReceiptTypeCode;
    }

    public ConfReceiptTypeCo setConfReceiptTypeCode(String confReceiptTypeCode) {
        this.confReceiptTypeCode = confReceiptTypeCode;
        return this;
    }

    public Integer getReceiptType() {
        return receiptType;
    }

    public ConfReceiptTypeCo setReceiptType(Integer receiptType) {
        this.receiptType = receiptType;
        return this;
    }

    public String getProcId() {
        return procId;
    }

    public ConfReceiptTypeCo setProcId(String procId) {
        this.procId = procId;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public ConfReceiptTypeCo setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public ConfReceiptTypeCo setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public ConfReceiptTypeCo setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
        return this;
    }

    public Integer getModifyUserId() {
        return modifyUserId;
    }

    public ConfReceiptTypeCo setModifyUserId(Integer modifyUserId) {
        this.modifyUserId = modifyUserId;
        return this;
    }

    public byte getType() {
        return type;
    }

    public ConfReceiptTypeCo setType(byte type) {
        this.type = type;
        return this;
    }
}
