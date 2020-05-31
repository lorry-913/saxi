package com.midea.saximanager.intercepter;

import javax.servlet.http.HttpServletRequest;

import com.midea.saximanager.annotation.AopLog;
import com.midea.saximanager.util.IPUtil;
import com.midea.saximanager.util.JacksonUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Aspect
@Component
public class LoggerAopInterceptor {
	protected Logger logger = Logger.getLogger(this.getClass());

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    /**
     * 切点
     */
    @Pointcut("execution(public * com.midea.saximanager.controller.*Controller.*(..))")
    @Order(2)
    public void pointCut(){};

    /**
     * 切点之前执行 这里做的是统一log日志管理
     *  Advice
     * 表示通知。是切面的具体实现方法。
     * 可分为前置通知（Before）、
     * 后置通知（AfterReturning）、
     * 异常通知（AfterThrowing）、
     * 最终通知（After）和环绕通知（Around）五种。
     * 实现方法具体属于哪类通知，是在配置文件和注解中指定的。
     */
    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint){
        System.out.println("方法执行前执行......before");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("<=====================================================");
        logger.info("请求来源： =》" + IPUtil.getIpAddr(request));
        logger.info("请求URL：" + request.getRequestURL().toString());
        logger.info("请求方式：" + request.getMethod());
        logger.info("响应方法：" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("请求参数：" + JacksonUtils.toJSon(request.getParameterMap()));
        logger.info("------------------------------------------------------");
        startTime.set(System.currentTimeMillis());
    }

    /**
     * 用自定义注解来代表切点  其中切点的返回值为Obj
     * @param obj
     * @param aopLog
     */
    @AfterReturning(returning="obj",pointcut="@annotation(aopLog)")
    public void afterReturning(JoinPoint joinPoint,Object obj, AopLog aopLog){
        logger.info("=====================================================>");
        logger.info(joinPoint.getSignature().getName()+"耗时:"+(System.currentTimeMillis()-startTime.get()));
        logger.info("参数返回:"+JacksonUtils.toJSon(obj));
    }
}
