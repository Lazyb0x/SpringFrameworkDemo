package cn.beanbang.springcore.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    @Pointcut("execution(* cn.beanbang.springcore.service.*.*(..)))")
    public void pointCut(){}

    @Before("pointCut()")
    // JoinPoint 类可以获取到代理类的方法名字
    public void before(JoinPoint joinPoint){
        System.out.println("before..." + joinPoint.getSignature());
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint){
        System.out.println("after..." + joinPoint.getSignature());
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint joinPoint){
        System.out.println("around: " + joinPoint.getSignature());

        Object result = null;

        // 获取被切方法的返回值
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("around: finished, result: " + result);

    }

    /**
     * 异常的统一处理
     */
    @AfterThrowing(pointcut = "pointCut()", throwing = "e")
    public void err(JoinPoint joinPoint, Exception e){
        System.out.println("err: " + joinPoint.getSignature() + " " +
        e.getMessage());
    }
}
