package com.demo.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by pingping on 三月/11/15.
 */
@Component
@Aspect
public class LogAspect {

    private Logger log = LogManager.getLogger(LogAspect.class);

    /**
     * 定义pointcut，可以供其他方法调用，如 @Before("check()")
     * pointcut()是个方法签名，不需要实际代码
     */
    @Pointcut("execution (* com.demo.handler.UserSecurityHandler.*(..))")
    private void check(){
        log.entry();
        log.debug("... ... debug with Pointcut");
        log.exit();;
    }

    @Before("check()")
//    @Before("execution (* com.demo.handler.UserSecurityHandler.*(..))")
    public void logBefore(){
        log.entry();
        log.info("... ... aspectj before");
        log.exit();
    }

    /*@After("execution (* com.demo.handler.UserSecurityHandler.*(..))")
    public void after(){
        log.entry();
        log.info("... ... aspectj after");
        log.exit();;
    }



    @AfterThrowing(throwing="ex", pointcut="execution(* com.demo.handler.UserSecurityHandler.*(..))")
    public void AfterThrowing(Throwable ex) {
        log.debug("目标方法中抛出的异常：" + ex);
    }

    */

    /**
     * Object[] getArgs(): 返回执行目标方法时的参数。<p>
     * Signature getSignature(): 返回被增强的方法的相关信息。<p>
     * Object getTarget(): 返回被织入增强处理的目标对象。<p>
     * Object getThis(): 返回 AOP 框架为目标对象生成的代理对象。<p>
     * 提示：当时使用 Around 处理时，我们需要将第一个参数定义为 ProceedingJoinPoint 类型，该类型是 JoinPoint 类型的子类。
     * @param point
     * @return
     * @throws Throwable
     *//*
    @Around("execution(* com.demo.handler.UserSecurityHandler.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        log.entry();
        log.info("... ... aspectj around");
        log.info(Arrays.toString(point.getArgs()));
        log.exit();
        return point.proceed();
        // 执行目标方法，并保存目标方法执行后的返回值
//        Object rvt = jp.proceed(new String[]{"被改变的参数"});
//        System.out.println("执行目标方法之前，模拟结束事物...");
//        return rvt + "新增的内容";
    }*/

//    @AfterReturning(returning="rvt", pointcut="execution(* com.demo.handler.UserSecurityHandler.*(..))")
//    public void afterReturning(Object rvt) {
//        log.debug("模拟目标方法返回值：" + rvt);
//    }

//    // 使用@Pointcut Annotation 时指定切入点表达式
//    @Pointcut("execution( * com.demo.handler.UserSecurityHandler.*(..))")
//    // 使用一个返回值为void，方法体为空的方法来命名切入点
//    private void isValid(){}
//
    // 使用上面定义的切入点
    @AfterReturning(pointcut = "check()", returning= "reVal")
    public void writeLog(Object reVal){
        log.debug("返回值:"+reVal);
    }


}
