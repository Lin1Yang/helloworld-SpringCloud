package com.inossem.wms.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target({ TYPE, METHOD })
public @interface LogDescription {
	
    /**
     * 日志模块名
     */
    String moduleName() default "";
    
    /**
     * 操作名称
     */
    String operationName() default "";
    
    /**
     * 描述
     */
    String description() default "";
    
}
