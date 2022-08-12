package com.springbook.biz.common;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {

	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {
	}
	

	@AfterThrowing(pointcut = "allPointcut()",throwing ="e")
	public void exceptionLog(Exception e) {
		System.out.println("[예외처리] 비즈니스 로직 수행 중 예외 발생");
	}
}
