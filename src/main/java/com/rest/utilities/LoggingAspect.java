package com.rest.utilities;
 import org.aspectj.lang.ProceedingJoinPoint;
    import org.aspectj.lang.annotation.Around;
    import org.aspectj.lang.annotation.Aspect;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import org.springframework.stereotype.Component;

    @Aspect
    @Component
    public class LoggingAspect {
         private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

         @Around("execution(* com.rest.controller..*(..))")
         public Object logExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        	  System.out.println("LoggingAspect.logExecution() called");
              logger.info("Entering method: {} with arguments: {}", joinPoint.getSignature(), joinPoint.getArgs());
              Object result = joinPoint.proceed();
              logger.info("Exiting method: {} with result: {}", joinPoint.getSignature(), result);
              return result;
         }
    }