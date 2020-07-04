package cn.beanbang.springcore.springerr.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ErrAspect {

    @Pointcut("execution(* cn.beanbang.springcore.springerr.service.*.*(..))")
    public void pointcut(){}

    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    public void err(JoinPoint joinPoint, Exception e){
//        System.out.println("err: " + e.getMessage());
        //MyThrowException.throwErr(e);
        throw new RuntimeException("测试");

    }
}
