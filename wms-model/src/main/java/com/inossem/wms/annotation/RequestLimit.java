package com.inossem.wms.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
public @interface RequestLimit {

	/**
	 * 允许访问的次数，默认值MAX_VALUE
	 */
	int count() default 1;

	/**
	 * 时间段，单位为毫秒
	 */
	long time() default 2000;
}