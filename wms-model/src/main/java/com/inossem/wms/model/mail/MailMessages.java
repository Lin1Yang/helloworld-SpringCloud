package com.inossem.wms.model.mail;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @ClassName MailMessage
 * @Description 邮件信息实体类
 * @Author wsail
 * @Date 2020/3/18 17:50
 **/


@ApiModel(value = "com.inossem.wms.model.mail.MailMessage",description = "邮件对象")
public class MailMessages {

    @ApiModelProperty(value = "发件人地址")
    private String sendAddress;

    @ApiModelProperty(value = "收件人地址")
    @NotNull(message = "收件人不能为空")
    @Size(min = 1,message = "收件人不能为空")
    private String[] receiveAddressList;


    @ApiModelProperty(value = "邮件主题")
    @NotBlank(message = "主题不能为空")
    private String subject;


    @ApiModelProperty(value = "文本内容")
    @NotBlank(message = "文本不能为空")
    private String text;

    @ApiModelProperty(value = "附件")
    private MultipartFile[] attachments;

    @ApiModelProperty(value = "抄送者")
    private String [] ccList;

    @ApiModelProperty(value = "隐秘抄送者")
    private String [] bccList;

    @ApiModelProperty(value = "发送时间")
    private Date sendDate = new Date();

    public MailMessages() {

    }

    public String getSendAddress() {
        return sendAddress;
    }

    public void setSendAddress(String sendAddress) {
        this.sendAddress = sendAddress;
    }

    public String[] getReceiveAddressList() {
        return receiveAddressList;
    }

    public void getReceiveAddressList(String[] receiveAddressList) {
        this.receiveAddressList = receiveAddressList;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MultipartFile[] getAttachments() {
        return attachments;
    }

    public void setAttachments(MultipartFile[] attachments) {
        this.attachments = attachments;
    }

    public String[] getCcList() {
        return ccList;
    }

    public void setCcList(String[] ccList) {
        this.ccList = ccList;
    }

    public String[] getBccList() {
        return bccList;
    }

    public void setBccList(String[] bccList) {
        this.bccList = bccList;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }
}
