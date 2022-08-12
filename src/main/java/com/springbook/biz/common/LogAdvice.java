package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;


@Aspect
public class LogAdvice {
	

	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {
	}

	
	@Before("allPointcut()")
	public void printLog(JoinPoint point) {
		// 클라이언트가 호출한 비지니스 메소드의 정보를 확인
		// getSignature() getTarget() getArgs() getName() 
		String method = point.getSignature().getName();
		Object[] args = point.getArgs();
		
		for (Object object : args) {
			System.out.println("[사전 처리] "+ method + "() 메소드 ARGS 정보"+ object.toString());
			
		}
	}	
}
