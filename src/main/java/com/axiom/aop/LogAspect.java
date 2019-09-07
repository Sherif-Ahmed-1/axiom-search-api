package com.axiom.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Configuration
@EnableAspectJAutoProxy
@Component
public class LogAspect {
	@Around("@annotation(org.springframework.web.bind.annotation.RestController)")
	public Object logServiceTime(ProceedingJoinPoint joinPoint) throws Throwable {

		long startTime = System.currentTimeMillis();
		Object result = joinPoint.proceed();
		long timeTaken = System.currentTimeMillis() - startTime;
		log.info("execution time {} is {}", joinPoint, timeTaken);
		return result;

	}
}
