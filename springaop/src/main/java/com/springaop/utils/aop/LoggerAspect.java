package com.springaop.utils.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component // 让 IoC 容器管理它
@Aspect // 该类是切面类
public class LoggerAspect {

    // CalImpl 中的所有方法
    @Before("execution(public int com.springaop.utils.impl.CalImpl.*(..))")
    public void before(JoinPoint joinPoint) {
        // 获取方法名
        String signature = joinPoint.getSignature().getName();
        String string = Arrays.toString(joinPoint.getArgs());
        System.out.println(signature + "方法的参数是" + string);
    }

    @AfterReturning(value = "execution(public int com.springaop.utils.impl.CalImpl.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "方法执行的结果是" + result);
    }

    @AfterThrowing(value = "execution(public int com.springaop.utils.impl.CalImpl.*(..))", throwing = "exception")
    public void throwing(JoinPoint joinPoint, Exception exception) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "抛出的异常为: " + exception.getMessage());
    }

    @After("execution(public int com.springaop.utils.impl.CalImpl.*(..))")
    public void after(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "执行结束");
    }

}
