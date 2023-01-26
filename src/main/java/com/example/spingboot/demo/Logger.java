package com.example.spingboot.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/7 17:34
 */
@Component
@Aspect
public class Logger {

        @Pointcut("execution(* com.example.spingboot.demo.DemoService.*Method(..))")
        public void pointcut(){}

        @Before(value = "pointcut()")
        public static void doLog(JoinPoint joinPoint){
                System.out.println("Log日志记录");

                System.out.println("业务类："+joinPoint.getTarget().getClass().getName());
                System.out.println("方法名："+joinPoint.getSignature().getName());
                Object[] args = joinPoint.getArgs();
                for (Object arg : args) {
                        System.out.println(arg);
                }

                System.out.println("Log日志记录结束");
        }

        @After(value = "pointcut()")
        public void after(){
                System.out.println("后置通知");
        }

        @AfterReturning(value = "pointcut()",returning = "result")
        public void afterRunning(JoinPoint joinPoint,int result){
                System.out.println("函数执行后通知，返回值为："+result);
        }

        @AfterThrowing(value = "pointcut()",throwing = "e")
        public void afterThrowing(JoinPoint joinPoint,Exception e){
                System.out.println("异常："+e.toString());
        }

        @Around(value = "pointcut()")
        public Object around(ProceedingJoinPoint proceedingJoinPoint){
                System.out.println("环绕前置通知");

                Object proceed = null;
                try {
                        proceed = proceedingJoinPoint.proceed();
                } catch (Throwable throwable) {
                        throwable.printStackTrace();
                }

                System.out.println("环绕后置通知");
                return proceed;
        }


}
