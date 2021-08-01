package cn.beanbang.springcore.common;

import cn.beanbang.springcore.annotation.MyAspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnnotationAspect {

    @Pointcut("@annotation(cn.beanbang.springcore.annotation.MyAspect)")
    public void pointCut() {
    }

    @Around("pointCut() && @annotation(annotation)")
    public Object around(ProceedingJoinPoint joinPoint, MyAspect annotation) throws Throwable {
        String desc = annotation.value();
        System.out.println(desc + "开始");
        Object result = joinPoint.proceed();
        System.out.println(desc + "结束");
        return result;
    }

}
