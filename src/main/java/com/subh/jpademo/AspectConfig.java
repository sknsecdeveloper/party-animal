package com.subh.jpademo;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class AspectConfig {


    Logger logger = LoggerFactory.getLogger(AspectConfig.class);


    @Before("execution(* com.subh.jpademo.controller.*.* (..))")
    public void M1BeginingOfMethod(JoinPoint joinPoint) {

        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        Object[] argsNames = joinPoint.getArgs();


        logger.info("Entering into class name : {}, method name : {} and with args {}", className, methodName, argsNames);




    }
}
