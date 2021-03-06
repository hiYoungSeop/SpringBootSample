package com.example.java.component;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Aspect
@Component
public class SimpleAspect {

	private static final Logger logger = LoggerFactory.getLogger(SimpleAspect.class);

	private static final AtomicInteger counter = new AtomicInteger();

	@Before("execution(* com.example.java.service.*.*Aop(..))")
	public void onBeforeHandler(JoinPoint joinPoint) {
		logger.info("=============== onBeforeThing");
		counter.incrementAndGet();
	}

	@After("execution(* com.example.java.service.*.*Aop(..))")
	public void onAfterHandler(JoinPoint joinPoint) {
		logger.info("=============== onAfterHandler");
	}

	@AfterReturning(pointcut = "execution(* com.example.java.service.*.*Aop(..))", returning = "str")
	public void onAfterReturningHandler(JoinPoint joinPoint, Object str) {
		logger.info("@AfterReturning : " + str);
		logger.info("=============== onAfterReturningHandler");
	}

	@Pointcut("execution(* com.example.java.service.*.*Aop(..))")
	public void onPointcut(JoinPoint joinPoint) {
		logger.info("=============== onPointcut");
	}

	public static int count() {
		return counter.get();
	}
}
