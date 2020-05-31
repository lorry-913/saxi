package com.midea.saximanager.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;
//谷歌的guava   调用次数限制  令牌桶算法
@Target(ElementType.METHOD) // 作用到方法上
@Retention(RetentionPolicy.RUNTIME) // 运行时有效
@Documented
public @interface RateLimit {
	/**
     * 每秒向桶中放入令牌的数量   默认最大即不做限流
     * @return
     */
    double perSecond() default Double.MAX_VALUE;

    /**
     * 获取令牌的等待时间  默认0
     * @return
     */
    int timeOut() default 0;

    /**
     * 超时时间单位
     * @return
     */
    TimeUnit timeOutUnit() default TimeUnit.MILLISECONDS;


}
