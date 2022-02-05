package com.inossem.wms.annotation;

import java.lang.annotation.*;

/**
 * 可将注解写在service方法上或dao方法上,碍于事务可控性所以建议不要
 * 再一个serivce里面调用多个数据源建议只调用其它数据源查询方法
 * Created by sw on 2019/1/8.
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    //数据源名字
    String name() default "";
}