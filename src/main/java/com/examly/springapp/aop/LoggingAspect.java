package com.examly.springapp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    // 1️⃣ BEFORE advice – logs method entry
    @Before("execution(* com.examly.springapp.controller..*(..))")
    public void logBeforeMethod(JoinPoint joinPoint) {

        String methodName = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();

        System.out.println(
            "[BEFORE] " + LocalDateTime.now() +
            " | Method: " + methodName +
            " | Arguments: " + Arrays.toString(args)
        );
    }

    // 2️⃣ AFTER RETURNING – logs successful execution
    @AfterReturning(
        pointcut = "execution(* com.examly.springapp.controller..*(..))",
        returning = "result"
    )
    public void logAfterReturning(JoinPoint joinPoint, Object result) {

        String methodName = joinPoint.getSignature().toShortString();

        System.out.println(
            "[AFTER SUCCESS] " + LocalDateTime.now() +
            " | Method: " + methodName +
            " | Returned: " + result
        );
    }

    // 3️⃣ AFTER THROWING – logs exceptions
    @AfterThrowing(
        pointcut = "execution(* com.examly.springapp.controller..*(..))",
        throwing = "exception"
    )
    public void logAfterException(JoinPoint joinPoint, Throwable exception) {

        String methodName = joinPoint.getSignature().toShortString();

        System.err.println(
            "[EXCEPTION] " + LocalDateTime.now() +
            " | Method: " + methodName +
            " | Error: " + exception.getMessage()
        );
    }

    // 4️⃣ AROUND advice – measures execution time
    @Around("execution(* com.examly.springapp.service..*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed(); // execute actual method

        long endTime = System.currentTimeMillis();

        String methodName = joinPoint.getSignature().toShortString();

        System.out.println(
            "[PERFORMANCE] Method: " + methodName +
            " | Time Taken: " + (endTime - startTime) + " ms"
        );

        return result;
    }
}
