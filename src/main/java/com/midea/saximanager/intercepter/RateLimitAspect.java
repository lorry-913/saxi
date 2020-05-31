package com.midea.saximanager.intercepter;



import java.lang.reflect.Method;

import com.midea.saximanager.annotation.RateLimit;
import com.midea.saximanager.response.BaseResponseView;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.util.concurrent.RateLimiter;



@Aspect
@Component
public class RateLimitAspect {
	protected Logger logger = Logger.getLogger(this.getClass());

	private RateLimiter rateLimiter = RateLimiter.create(50);

    /**
     * 定义切点
     * 1、通过扫包切入
     * 2、带有指定注解切入
     */
//    @Pointcut("execution(public * com.ycn.springcloud.*.*(..))")
    @Pointcut("@annotation(com.midea.saximanager.annotation.RateLimit)")
    public void checkPointcut() { }

    @ResponseBody
    @Around(value = "checkPointcut()")
    public Object aroundNotice(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("拦截到了{}方法..."+ pjp.getSignature().getName());
        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature)signature;
        //获取目标方法
        Method targetMethod = methodSignature.getMethod();
        if (targetMethod.isAnnotationPresent(RateLimit.class)) {
            //获取目标方法的@LxRateLimit注解
        	BaseResponseView baseResponseView=new BaseResponseView();
            RateLimit rateLimit = targetMethod.getAnnotation(RateLimit.class);
            rateLimiter.setRate(rateLimit.perSecond());
            if (!rateLimiter.tryAcquire(rateLimit.timeOut(), rateLimit.timeOutUnit())){
            	baseResponseView.setCode("-1");
            	baseResponseView.setMsg("服务器繁忙，请稍后再试!");
            	return baseResponseView;
            }
        }
        return pjp.proceed();
    }
}
