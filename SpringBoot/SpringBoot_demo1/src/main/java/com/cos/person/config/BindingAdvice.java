package com.cos.person.config;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.cos.person.domain.CommonDto;

// @Controller, @RestController, @Component, @Configuration

@Component
@Aspect
public class BindingAdvice {
	
	@Before("execution(* com.cos.person.web..*Controller.save(..))")
	public void testCheck() {
		System.out.println("전처리 로그를 남겼습니다");
	}
	
	@After("execution(* com.cos.person.web..*Controller.save(..))")
	public void testCheck2() {
		System.out.println("후처리 로그를 남겼습니다");
	}
	
	// 함수 : 앞 뒤
	// 함수 : 앞 (username이 안들어왔으면 내가 강제로 넣어주고 실행)
	// 함수 : 뒤 (응답만 관리)
	
	// @Before
	// @After
	@Around("execution(* com.cos.person.web..*Controller.save(..))")
	public Object validCheck(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		String type = proceedingJoinPoint.getSignature().getDeclaringTypeName();
		String method = proceedingJoinPoint.getSignature().getName();
		
		System.out.println("type :" + type);
		System.out.println("method :" + method);
		
		Object[] args = proceedingJoinPoint.getArgs();
		
		for (Object arg : args) {
			if(arg instanceof BindingResult) {
				BindingResult bindingResult = (BindingResult) arg;
				
				if(bindingResult.hasErrors()) {
					Map<String, String> errorMap = new HashMap<>();
					
					for(FieldError error : bindingResult.getFieldErrors()) {
						errorMap.put(error.getField(), error.getDefaultMessage());
					}
					
					return new CommonDto<>(HttpStatus.BAD_REQUEST.value(), errorMap);
				}
			}
		}
		
		return proceedingJoinPoint.proceed(); // 함수의 스택을 실행해라
	}
}
