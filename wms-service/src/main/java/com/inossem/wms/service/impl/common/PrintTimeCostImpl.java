package com.inossem.wms.service.impl.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PrintTimeCostImpl {
	private static Logger logger = LogManager.getLogger(PrintTimeCostImpl.class);

	@Pointcut("@annotation(com.inossem.wms.service.common.PrintTimeCost)")
	public void printTimeCostPointCut() {
	}

	@Around("printTimeCostPointCut()")
	public Object costAround(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object object = joinPoint.proceed();
		long costTime = System.currentTimeMillis() - startTime;
		if (logger.isInfoEnabled()) {
			logger.info("执行方法:" + joinPoint.getSignature().getName() + " 花费时间：" + costTime + "ms");
		}
		return object;
	}
}
