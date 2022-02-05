package com.inossem.wms.service.impl.common;

import javax.annotation.PostConstruct;
import javax.jms.DeliveryMode;
import javax.jms.Destination;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.lang.NonNull;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.inossem.wms.common.exception.WMSException;
import com.inossem.wms.constant.Const;
import com.inossem.wms.service.common.IMessageProducerService;

@Service
public class MessageProducerServiceImpl implements IMessageProducerService {
	
	protected Logger logger = LoggerFactory.getLogger(Const.LOGGER_NAME_ACTIVE_MQ);
	
	@Autowired
	protected JmsMessagingTemplate jmsMessagingTemplate;
	
	private final static long RECEIVE_TIMEOUT_MILLISECONDS = 30 * 1000;  // 30s
	
	@PostConstruct
    public void init(){
		JmsTemplate jmsTemplate = this.jmsMessagingTemplate.getJmsTemplate();
		if (jmsTemplate != null) {
			jmsTemplate.setExplicitQosEnabled(true);
			jmsTemplate.setDeliveryMode(DeliveryMode.PERSISTENT);
			jmsTemplate.setReceiveTimeout(RECEIVE_TIMEOUT_MILLISECONDS);
		}
    }
	
	@Override
	public void sendQueueMsg(String queueName, @NonNull Object msg) {
		JmsTemplate jmsTemplate = this.jmsMessagingTemplate.getJmsTemplate();
		if (jmsTemplate != null) {
			jmsTemplate.setPubSubDomain(false);
		}
		logger.info("消息队列[发送消息] - 类型：queue 地址：{} 消息内容：{}", queueName, JSON.toJSONString(msg));
		this.jmsMessagingTemplate.convertAndSend(queueName, msg);
	}
	
	@Override
	public void sendQueueMsg(Destination destination, @NonNull Object msg) {
		JmsTemplate jmsTemplate = this.jmsMessagingTemplate.getJmsTemplate();
		if (jmsTemplate != null) {
			jmsTemplate.setPubSubDomain(false);
		}
		logger.info("消息队列[发送消息] - 类型：queue 地址：{} 消息内容：{}", destination.toString(), JSON.toJSONString(msg));
		this.jmsMessagingTemplate.convertAndSend(destination, msg);
	}
	
	@Override
	public void sendTopicMsg(String topicName, @NonNull Object msg) {
		JmsTemplate jmsTemplate = this.jmsMessagingTemplate.getJmsTemplate();
		if (jmsTemplate != null) {
			jmsTemplate.setPubSubDomain(true);
		}
		logger.info("消息队列[发送消息] - 类型：topic 地址：{} 消息内容：{}", topicName, JSON.toJSONString(msg));
		this.jmsMessagingTemplate.convertAndSend(topicName, msg);
	}

	@Override
	public <T> Message<?> sendAndReceive(String queueName, @NonNull T msg) {
		JmsTemplate jmsTemplate = this.jmsMessagingTemplate.getJmsTemplate();
		if (jmsTemplate != null) {
			jmsTemplate.setPubSubDomain(false);
		}
		Message<T> msgToSend = new GenericMessage<T>(msg);
		logger.info("消息队列[发送消息] - 类型：queue 地址：{} 消息内容：{}", queueName, JSON.toJSONString(msg));
		Message<?> replyMsg = this.jmsMessagingTemplate.sendAndReceive(queueName, msgToSend);
		if (replyMsg != null && replyMsg.getPayload() instanceof Exception) {
			if (replyMsg.getPayload() instanceof WMSException) {
				throw (WMSException) replyMsg.getPayload();
			} else {
				// RPC调用出现了其他异常
				throw new WMSException();
			}
		}
		return replyMsg;
	}
	
}

