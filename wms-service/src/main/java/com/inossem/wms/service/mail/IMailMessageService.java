package com.inossem.wms.service.mail;

import com.inossem.wms.model.mail.MailMessages;

/**
 * @ClassName IMailMessageService
 * @Description 邮件service
 * @Author 马永康
 * @Date 2020/3/19 14:29
 **/
public interface IMailMessageService {

    /**
     * @Author myk
     * @Description 发送邮件工具类
     * @Date 14:30 2020/3/19
     * @Param [mailMessages] 接收发送内容
     * @return void
     **/
    boolean sendMail(MailMessages mailMessages) throws Exception;

}
