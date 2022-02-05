package com.inossem.wms.service.common;

import javax.jms.Destination;

import org.springframework.messaging.Message;

public interface IMessageProducerService {

	public void sendQueueMsg(String queueName, Object msg);

	public void sendQueueMsg(Destination destination, Object msg);

	public void sendTopicMsg(String topicName, Object msg);

	<T> Message<?> sendAndReceive(String queueName, T msg);

}
