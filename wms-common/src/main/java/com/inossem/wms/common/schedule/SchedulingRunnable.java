package com.inossem.wms.common.schedule;

import com.inossem.wms.common.util.UtilSpringContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * 定时任务线程类
 * @author myk
 */
public class SchedulingRunnable implements Runnable {


    private static final Logger log = LoggerFactory.getLogger(SchedulingRunnable.class);

    private String beanName;

    private String methodName;

    public SchedulingRunnable(String beanName, String methodName) {
        this.beanName = beanName;
        this.methodName = methodName;
    }

    @Override
    public void run() {
        // ScheduleFuture.cache 无法直接停止正在停止的定时任务，所以这里进行处理如果是非 interrupted 才执行
        if(!Thread.currentThread().isInterrupted()){
            //转换首字母为小写，方便从ioc中取出实例对象
            this.beanName = toLowerCaseFirstOne(beanName);
            log.info("定时任务开始执行： --bean: {}  --method: {}" + LocalDateTime.now().toLocalTime(),beanName,methodName);
            long startTime = System.currentTimeMillis();
            try {
                Object target = UtilSpringContext.getBean(beanName);
                Method method = target.getClass().getDeclaredMethod(methodName);
                method.invoke(target);
            }catch (Exception ex){
                ex.printStackTrace();
            }

            long times = System.currentTimeMillis() - startTime;
            log.info("定时任务结束：  --bean: {}  --method: {} , 耗时： {} 毫秒 "+LocalDateTime.now().toLocalTime(),beanName,methodName,times);
        }
    }



    /*
    首字母转小写，才能重ioc中取值
     */
    public static String toLowerCaseFirstOne(String s){
        if(Character.isLowerCase(s.charAt(0))){
            return s;
        }else {
            return Character.toLowerCase(s.charAt(0))+s.substring(1);
        }
    }

    /**
     * 重写equals 方法 ，并重写hasCode,因为线程map中使用的是Runnable作为key
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SchedulingRunnable)) {
            return false;
        }
        SchedulingRunnable that = (SchedulingRunnable) o;

        if (!getBeanName().equalsIgnoreCase(that.getBeanName())) {
            return false;
        }
        return getMethodName().equalsIgnoreCase(that.getMethodName());
    }

    @Override
    public int hashCode() {
        int result = getBeanName().hashCode();
        result = 31 * result + getMethodName().hashCode();
        return result;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }


    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
