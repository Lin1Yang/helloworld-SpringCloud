package com.inossem.wms.common.aop;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.inossem.wms.annotation.RequestLimit;
import com.inossem.wms.common.exception.RequestAlreadyInProgressException;

/**
 * 接口访问限制
 * 对于短时间内连续访问相同接口的请求予以拦截并抛出异常
 * @author libin
 * 2019年7月2日
 */
@Aspect
@Component
public class RequestLimitHandler {

	/**
	 * 以ip地址和访问url作为相同请求的标识key
	 * value是访问次数的计数
	 */
	private static Map<String, Integer> template = new HashMap<>();
	
	/**
	 * 对于同一个接口访问，在没有超过接口限制的最大次数前，增加访问计数<br>
	 * 计数增加后，设置定时器在指定时间后扣减计数<br>
	 * 以此来实现在规定时间内，指定接口的访问次数不能超过最大值的功能
	 * 
	 * @param joinPoint
	 * @return
	 * @author libin
	 */
	@Before("@annotation(com.inossem.wms.annotation.RequestLimit)")
	public boolean requestLimit(final JoinPoint joinPoint) {
		HttpServletRequest request = null;
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		if(ra!=null){
			 request = ((ServletRequestAttributes) ra).getRequest();
		}
		if(request!=null){
			String ip = request.getLocalAddr();
			String url = request.getRequestURL().toString();
			// 以ip地址和访问url作为相同请求的标识key
			String key = "req_limit_".concat(url).concat(ip);
			
			int count = template.getOrDefault(key, 0);
			MethodSignature ms = (MethodSignature) joinPoint.getSignature();
			Method method = ms.getMethod();
			RequestLimit anno = method.getAnnotation(RequestLimit.class);
			
			if (count < anno.count()) {
				// 增加计数，并设置定时器减少计数
				synchronized (template) {
					template.put(key, template.getOrDefault(key, 0).intValue() + 1);
				}
				Timer timer = new Timer();
				TimerTask timerTask = new TimerTask() {
					@Override
					public void run() {
						synchronized (template) {
							template.put(key, template.getOrDefault(key, 0).intValue() - 1);
							if (count <= 0) {
								// 计数为0时，删除key，避免map容量过大
								template.remove(key);
							}
						}
					}
				}; 
				// 这个定时器设定在time规定的时间之后会执行
				timer.schedule(timerTask, anno.time());
			} else if (count >= anno.count()) {
				// 不增加计数，抛出异常
				throw new RequestAlreadyInProgressException();
			}
			return true;
		}else{
			return false;
		}
		

		
		
	}
}