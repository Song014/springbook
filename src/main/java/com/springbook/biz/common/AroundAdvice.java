package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
		
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {
		
	}
	
	
	@Around("allPointcut()")
	public Object aroundLog(ProceedingJoinPoint point) throws Throwable {
		// pointcut 실행 전
		
		System.out.println("[BEFORE] ===================================");
		String method = point.getSignature().getName();
		StopWatch sw = new StopWatch();
		sw.start();
		
		Object retrunOBJ = point.proceed();
		
		sw.stop();
	
		System.out.println("[사후 처리] 메소드 시간 "+method+"() " +sw.getTotalTimeMillis()+"(ms)초");
		// pointcut 실행 후
		return retrunOBJ;
	}
}
