package com.inossem.wms.service.impl.common;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.jms.Destination;

import org.apache.shiro.authz.UnauthorizedException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.inossem.wms.common.exception.WMSException;
import com.inossem.wms.common.util.UtilJsonCompactor;
import com.inossem.wms.common.util.UtilText;
import com.inossem.wms.constant.Const;
import com.inossem.wms.dao.conf.MqRetryMapper;
import com.inossem.wms.enums.EnumMqMsgType;
import com.inossem.wms.enums.EnumReturnCode;
import com.inossem.wms.service.common.IMessageConsumerService;
import com.inossem.wms.service.common.IMessageProducerService;
import com.inossem.wms.vo.conf.MqRetryVo;
// import com.inossem.wms.service.log.impl.ExceptionLogService;

@Aspect
@Service
@Order(Ordered.LOWEST_PRECEDENCE)
public class MessageConsumerServiceImpl implements IMessageConsumerService {

	protected Logger logger = LoggerFactory.getLogger(Const.LOGGER_NAME_ACTIVE_MQ);

	@Autowired
	protected MqRetryMapper mqRetryMapper;

	@Pointcut("@annotation(org.springframework.jms.annotation.JmsListener)")
	public void jmsListenerPointCut() {
	}

	// @Autowired
	// private ExceptionLogService exceptionLogService;

	@Autowired
	private IMessageProducerService messageProducerServiceSubImpl;

	private final static String REPLY_STRING_SUCCESS = "execute success";
	private final static String MESSAGE_HEADER_KEY_REPLY_TO = "jms_replyTo";

	/**
	 * 接收推送消息前，输出日志
	 * 
	 * @param joinPoint
	 * @author libin
	 */
	@Before("jmsListenerPointCut()")
	public void before(JoinPoint joinPoint) {
		// 获取切点方法签名
		Signature signature = joinPoint.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		// 获取切点的JmsListener注解，得到注解上的destination取值
		JmsListener jmsListener = methodSignature.getMethod().getAnnotation(JmsListener.class);
		String destination = jmsListener.destination();
		String containerFactory = jmsListener.containerFactory();
		String msgType = null;
		if (containerFactory.equals(Const.QUEUE_LISTENER_CONTAINER)) {
			msgType = "queue";
		} else if (containerFactory.equals(Const.TOPIC_LISTENER_CONTAINER)) {
			msgType = "topic";
		} else {
			msgType = "unkown";
		}
		Object msg = joinPoint.getArgs(); // 获取切点的入参，即发送的消息对象
		logger.info("消息队列[接收消息] - 类型：{} 地址：{} 消息内容：{}", msgType, destination, JSON.toJSONString(msg));
	}

	/**
	 * 消息处理失败后，将消息对象持久化，用于后续手动重传
	 * 
	 * @param joinPoint 切点
	 * @param e 抛出异常
	 */
	@AfterThrowing(pointcut = "jmsListenerPointCut()", throwing = "e")
	public void handleException(JoinPoint joinPoint, Throwable e) {
		/* ******** 异常输出 ********** */
		logger.error("消息接收方处理失败.");
		logger.error("异常信息：{}", e.getMessage());
		synchronized (logger) {
			logger.error(e.toString());
			StackTraceElement[] trace = e.getStackTrace();
			for (StackTraceElement traceElement : trace)
				logger.error("\tat " + traceElement);
		}
		this.saveReTryInfo(joinPoint, e);
		/* ******** 持久化消息内容 ****** */
		try {
			String langCode = Const.DEFAULT_LANG_CODE;
			if (e instanceof WMSException) {
				WMSException wmsException = (WMSException) e;
				logger.error("{}, {}", e,
				        UtilText.getMessage(langCode, wmsException.getErrorCode().name(), wmsException.getArgs()));
				// exceptionLogService.save(e,this.getMessage(langCode, wmsException.getErrorCode().name(),
				// wmsException.getArgs()));
			} else {
				EnumReturnCode returnCode;
				if (e instanceof ArithmeticException) {
					// 算术异常：ArithmeticException
					returnCode = EnumReturnCode.RETURN_CODE_ARITHMETIC_EXCEPTION;
				} else if (e instanceof NullPointerException) {
					// 空指针异常：NullPointerException
					returnCode = EnumReturnCode.RETURN_CODE_NULL_POINTER_EXCEPTION;
				} else if (e instanceof ClassCastException) {
					// 类型强制转换异常：ClassCastException
					returnCode = EnumReturnCode.RETURN_CODE_CLASS_CAST_EXCEPTION;
				} else if (e instanceof NegativeArraySizeException) {
					// 数组负下标异常：NegativeArrayException
					returnCode = EnumReturnCode.RETURN_CODE_NEGATIVE_ARRAY_SIZE_EXCEPTION;
				} else if (e instanceof ArrayIndexOutOfBoundsException) {
					// 数组下标越界异常：ArrayIndexOutOfBoundsException
					returnCode = EnumReturnCode.RETURN_CODE_ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION;
				} else if (e instanceof SecurityException) {
					// 违背安全原则异常：SecturityException
					returnCode = EnumReturnCode.RETURN_CODE_SECURITY_EXCEPTION;
				} else if (e instanceof EOFException) {
					// 文件已结束异常：EOFException
					returnCode = EnumReturnCode.RETURN_CODE_EOF_EXCEPTION;
				} else if (e instanceof FileNotFoundException) {
					// 文件未找到异常：FileNotFoundException
					returnCode = EnumReturnCode.RETURN_CODE_FILE_NOT_FOUND_EXCEPTION;
				} else if (e instanceof NumberFormatException) {
					// 字符串转换为数字异常：NumberFormatException
					returnCode = EnumReturnCode.RETURN_CODE_NUMBER_FORMAT_EXCEPTION;
				} else if (e instanceof SQLException) {
					// 操作数据库异常：SQLException
					returnCode = EnumReturnCode.RETURN_CODE_SQL_EXCEPTION;
				} else if (e instanceof IOException) {
					// 输入输出异常：IOException
					returnCode = EnumReturnCode.RETURN_CODE_IO_EXCEPTION;
				} else if (e instanceof NoSuchMethodException) {
					// 方法未找到异常：NoSuchMethodException
					returnCode = EnumReturnCode.RETURN_CODE_NO_SUCH_METHOD_EXCEPTION;
				} else if (e instanceof UnauthorizedException) {
					// 方法未找到异常：NoSuchMethodException
					returnCode = EnumReturnCode.RETURN_CODE_ACCESS_DENY;
				} else {
					returnCode = EnumReturnCode.RETURN_CODE_EXCEPTION;
				}
				// exceptionLogService.save(e,this.getMessage(langCode, returnCode.name(), null));
				logger.error("{}, {}", e, UtilText.getMessage(langCode, returnCode.name(), null));
			}
		} catch (Exception e1) {
			logger.error("消息队列推送参数异常");
		}
		/* ******** 应答 ********** */
		Object[] params = joinPoint.getArgs();
		Message<?> msg = null;
		Destination destination = null;
		if (params != null && params.length > 0) {
			if (!(params[0] instanceof Message)) {
				return;
			}
			msg = (Message<?>) params[0];
			destination = (Destination) msg.getHeaders().get(MESSAGE_HEADER_KEY_REPLY_TO);
		}
		if (destination == null) {
			// 如果没有设置应答地址，则不做处理
			return;
		}
		messageProducerServiceSubImpl.sendQueueMsg(destination, e);
	}

	@AfterReturning("jmsListenerPointCut()")
	public void handleCallBack(JoinPoint joinPoint) {
		Object[] params = joinPoint.getArgs();
		Message<?> msg = null;
		Destination destination = null;
		if (params != null && params.length > 0) {
			if (!(params[0] instanceof Message)) {
				return;
			}
			msg = (Message<?>) params[0];
			destination = (Destination) msg.getHeaders().get(MESSAGE_HEADER_KEY_REPLY_TO);
		}
		if (destination == null) {
			// 如果没有设置应答地址，则不做处理
			return;
		}
		messageProducerServiceSubImpl.sendQueueMsg(destination, REPLY_STRING_SUCCESS);
	}

	/**
	 * 保存失败重发信息到数据库中，用于重发
	 * 这个方法需要将本类的aop拦截设置优先级成比事务拦截器更低才能执行
	 * 否则保存操作将被一并回滚
	 * 
	 * @param joinPoint
	 * @param e
	 * @author 李斌
	 */
	@Override
	public void saveReTryInfo(JoinPoint joinPoint, Throwable e) {
		// 获取切点方法签名
		Signature signature = joinPoint.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		// 获取切点的JmsListener注解，得到注解上的destination取值
		JmsListener jmsListener = methodSignature.getMethod().getAnnotation(JmsListener.class);
		String destinationName = jmsListener.destination();
		String containerFactory = jmsListener.containerFactory();
		String msgType;
		if (containerFactory.equals(Const.QUEUE_LISTENER_CONTAINER)) {
			msgType = EnumMqMsgType.QUEUE.name().toLowerCase();
		} else if (containerFactory.equals(Const.TOPIC_LISTENER_CONTAINER)) {
			msgType = EnumMqMsgType.TOPIC.name().toLowerCase();
		} else {
			msgType = EnumMqMsgType.UNKOWN.name().toLowerCase();
		}
		Object msgObj = null;
		Class<?> clazz = null;
		try {
			msgObj = joinPoint.getArgs()[0]; // 获取切点的入参，即发送的消息对象
			clazz = methodSignature.getParameterTypes()[0];
		} catch (Exception e1) {
			logger.error("消息队列推送参数异常");
		}
		MqRetryVo vo = new MqRetryVo();
		vo.setDestination(destinationName);
		String jsonMsg = JSON.toJSONString(msgObj);
		vo.setMsg(UtilJsonCompactor.json(jsonMsg));
		if (clazz != null) {
			vo.setMsgClassFullName(clazz.getName());
		}
		vo.setMsgType(msgType);
		vo.setReason(e.getMessage());
		int num = mqRetryMapper.insert(vo);
		logger.debug("保存消息推送内容， {}", num > 0 ? "成功" : "失败");
	}

}
