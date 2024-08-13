package com.example.Library.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {


    @Around("execution(* com.example.Library.service..*(..))") // Pointcut expression
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("Method " + joinPoint.getSignature() + " execution started");

        Object result;
        try {
            result = joinPoint.proceed(); // Proceed with the method call
        } catch (Throwable throwable) {
//            logger.error("Exception in method " + joinPoint.getSignature(), throwable);
            throw throwable;
        }

        System.out.println("Method " + joinPoint.getSignature() + " ended." );

        return result;
    }
}
