/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-26 20:51:18 UTC+08:00
 ****************************************************/
package host.fairy.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author Lionel Johnson
 */
@Slf4j
@Component
@Aspect
public class TimeAspect {
    @Around("execution(* host.fairy.service.*.*(..))")
    public Object recordTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object proceed = proceedingJoinPoint.proceed();
        log.info("{}方法执行时间: {} 毫秒", proceedingJoinPoint.getSignature(), System.currentTimeMillis() - startTime);
        return proceed;
    }
}
