package com.springbook.biz.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;


@Aspect
public class AfterAdvice {

	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void afterPointcut() {
	}

	@After("afterPointcut()")
	public void finallyLog() {
		System.out.println("[사후 처리3] 비즈니스 로직 수행 후 무조건 동작");

	}
}
