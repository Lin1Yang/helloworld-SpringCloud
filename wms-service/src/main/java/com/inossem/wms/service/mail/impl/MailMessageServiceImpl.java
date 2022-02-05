package com.inossem.wms.service.mail.impl;

import com.inossem.wms.common.exception.WMSException;
import com.inossem.wms.enums.EnumReturnCode;
import com.inossem.wms.model.mail.MailMessages;
import com.inossem.wms.service.mail.IMailMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;
import java.util.Objects;

/**
 * @ClassName MailMessageServiceImpl
 * @Description 邮件实现类
 * @Author myk
 * @Date 2020/3/19 14:31
 **/
@Service
public class MailMessageServiceImpl implements IMailMessageService {

    private static final Logger log = LoggerFactory.getLogger(MailMessageServiceImpl.class);

    @Autowired
    private JavaMailSenderImpl mailSender;

    @Value("spring.mail.username")
    private String sendAddress;


    // 解决发送附件时中文名字邮件乱码
    static {
        System.setProperty("mail.mime.splitlongparameters", "false");
    }
    /**
     * @param message
     * @return void
     * @Author myk
     * @Description 发送邮件工具类
     * @Date 14:30 2020/3/19
     * @Param [mailMessages] 接收发送内容
     */
    @Override
    public boolean sendMail(@Valid MailMessages message)  {
        message.setSendAddress(sendAddress);
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = null;
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
            //设置发件人
            mimeMessageHelper.setFrom(message.getSendAddress());

            // 设置接收人
            if(ObjectUtils.isEmpty(message.getReceiveAddressList())){
                throw new WMSException(EnumReturnCode.RETURN_CODE_MAIL_MESSAGE_EXIST_NULL,"邮件接收人");
            }else {
                mimeMessageHelper.setTo(message.getReceiveAddressList());
            }
            // 设置文本
            if(ObjectUtils.isEmpty(message.getText())){
                throw new WMSException(EnumReturnCode.RETURN_CODE_MAIL_MESSAGE_EXIST_NULL,"邮件正文");
            }else{
                mimeMessageHelper.setText(message.getText());
            }

            // 设置主题
            if(ObjectUtils.isEmpty(message.getSubject())){
                throw new WMSException(EnumReturnCode.RETURN_CODE_MAIL_MESSAGE_EXIST_NULL,"邮件主题");
            }else{
                mimeMessageHelper.setSubject(message.getSubject());
            }
            //设置抄送
            if(!ObjectUtils.isEmpty(message.getCcList())){
                mimeMessageHelper.setCc(message.getCcList());
            }
            // 设置隐秘抄送
            if(!ObjectUtils.isEmpty(message.getBccList())){
                mimeMessageHelper.setBcc(message.getBccList());
            }
            // 发送附件
            for(MultipartFile file : message.getAttachments()){
                mimeMessageHelper.addAttachment(Objects.requireNonNull(file.getOriginalFilename()),file);
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            mailSender.send(mimeMessage);
        }catch (MailSendException e){
            detectInvalidAddress(e);
        }

        return true;
    }

    private void detectInvalidAddress(MailSendException me) {
        Exception[] messageExceptions = me.getMessageExceptions();
        if (messageExceptions.length > 0) {
            Exception messageException = messageExceptions[0];
            if (messageException instanceof SendFailedException) {
                SendFailedException sfe = (SendFailedException) messageException;
                Address[] invalidAddresses = sfe.getInvalidAddresses();
                if(invalidAddresses != null) {
                    StringBuilder addressStr = new StringBuilder();
                    for (Address address : invalidAddresses) {
                        addressStr.append(address.toString()).append("; ");
                    }

                    log.error("发送邮件时发生异常！可能有无效的邮箱：{}", addressStr);
                    return;
                }
            }
        }
        log.error("发送邮件时发生异常！", me);
    }
}
