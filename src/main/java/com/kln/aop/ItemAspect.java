package com.kln.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.kln.dto.ItemAddRequestDTO;

@Aspect
@Component
public class ItemAspect {
	
	 private static final Logger logger = LoggerFactory.getLogger(ItemAspect.class);
	 
	 @After("execution(* com.kln.controller.ItemController.addItem(..)) && args(item)")
	 public void afterItemAdd(ItemAddRequestDTO item) {
		 
		logger.info("Item added : {}",item); 
	 }
	 
	 @After("execution(* com.kln.service.*.*(..))")
	 public void FindItemByid(JoinPoint joinpoint) {
		 
		 logger.info("method executed {}",joinpoint.getSignature().getName());
		 
		 
	 }
	 
	 @AfterThrowing(pointcut="execution(* com.kln.service.*.*(..))",throwing="ex")
	 public void itemNotFindByid(JoinPoint joinpoint,Exception ex) {
		 
		 logger.info("item not found with id : {} ,exception : {} ,at {}",joinpoint.getSignature().getName());
		 
		 
	 }
	 
}
