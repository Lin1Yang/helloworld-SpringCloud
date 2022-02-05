package com.inossem.wms.vo;

import io.swagger.annotations.ApiModelProperty;

public class ButtonVo {
	@ApiModelProperty(value = "保存按钮是否显示 0不显示 1显示")
	private byte buttonSave;

	@ApiModelProperty(value = "提交按钮是否显示 0不显示 1显示")
	private byte buttonSubmit;

	@ApiModelProperty(value = "过账按钮是否显示 0不显示 1显示")
	private byte buttonPost;

	@ApiModelProperty(value = "删除按钮是否显示 0不显示 1显示")
	private byte buttonDelete;

	@ApiModelProperty(value = "冲销按钮是否显示 0不显示 1显示")
	private byte buttonWriteOff;

	@ApiModelProperty(value = "核销按钮是否显示 0不显示 1显示")
	private byte buttonDebtOffset;

	@ApiModelProperty(value = "返回按钮是否显示 0不显示 1显示")
	private byte buttonReturn;

	@ApiModelProperty(value = "添加物料按钮是否显示 0不显示 1显示")
	private byte buttonAddMat;

	@ApiModelProperty(value = "审批按钮是否显示 0不显示 1显示")
	private byte buttonApproval;

	@ApiModelProperty(value = "更多信息按钮是否显示 0不显示 1显示")
	private byte buttonMoreInfo;

	@ApiModelProperty(value = "提交并过账按钮是否显示 0不显示 1显示")
	private byte buttonSubmitAndPost;

	@ApiModelProperty(value = "确认按钮是否显示 0不显示 1显示")
	private byte buttonOK;

    public byte getButtonSave() {
        return buttonSave;
    }

    public void setButtonSave(byte buttonSave) {
        this.buttonSave = buttonSave;
    }

    public byte getButtonSubmit() {
        return buttonSubmit;
    }

    public void setButtonSubmit(byte buttonSubmit) {
        this.buttonSubmit = buttonSubmit;
    }

    public byte getButtonPost() {
        return buttonPost;
    }

    public void setButtonPost(byte buttonPost) {
        this.buttonPost = buttonPost;
    }

    public byte getButtonDelete() {
        return buttonDelete;
    }

    public void setButtonDelete(byte buttonDelete) {
        this.buttonDelete = buttonDelete;
    }

    public byte getButtonWriteOff() {
        return buttonWriteOff;
    }

    public void setButtonWriteOff(byte buttonWriteOff) {
        this.buttonWriteOff = buttonWriteOff;
    }

    public byte getButtonDebtOffset() {
        return buttonDebtOffset;
    }

    public void setButtonDebtOffset(byte buttonDebtOffset) {
        this.buttonDebtOffset = buttonDebtOffset;
    }

    public byte getButtonReturn() {
        return buttonReturn;
    }

    public void setButtonReturn(byte buttonReturn) {
        this.buttonReturn = buttonReturn;
    }

    public byte getButtonAddMat() {
        return buttonAddMat;
    }

    public void setButtonAddMat(byte buttonAddMat) {
        this.buttonAddMat = buttonAddMat;
    }

    public byte getButtonApproval() {
        return buttonApproval;
    }

    public void setButtonApproval(byte buttonApproval) {
        this.buttonApproval = buttonApproval;
    }

    public byte getButtonMoreInfo() {
        return buttonMoreInfo;
    }

    public void setButtonMoreInfo(byte buttonMoreInfo) {
        this.buttonMoreInfo = buttonMoreInfo;
    }

    public byte getButtonSubmitAndPost() {
        return buttonSubmitAndPost;
    }

    public void setButtonSubmitAndPost(byte buttonSubmitAndPost) {
        this.buttonSubmitAndPost = buttonSubmitAndPost;
    }

    public byte getButtonOK() {
        return buttonOK;
    }

    public void setButtonOK(byte buttonOK) {
        this.buttonOK = buttonOK;
    }
}