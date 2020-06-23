package cn.beanbang.springcore.springlog.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* cn.beanbang.springcore.springlog.service.*.*(..))")
    public void pointcut(){}

    @Around("pointcut()")
    public void log(ProceedingJoinPoint joinPoint){
        long startTime = System.currentTimeMillis();

        // 时间
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(new Date());
        // 方法名
        String methodName = joinPoint.getSignature().getName();

        // 类名
        String className = joinPoint.getSignature().getDeclaringTypeName();

        // 传入的参数
        Object[] args = joinPoint.getArgs();

        // 操作信息（注解获取）
        String action = "";
        String desc = "";
        // 获得被代理类的所有方法
        Method[] methods = joinPoint.getTarget().getClass().getMethods();
        for (Method m : methods){
            if (m.getName().equals(methodName)){
                // 获取对应方法的注解信息
                MyLog myLog = m.getAnnotation(MyLog.class);
                action = myLog.action();
                desc = myLog.desc();
                break;
            }
        }

        // 返回的内容
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        // 响应时间
        long respTime = System.currentTimeMillis() - startTime;

        Map<String, Object> logMap = new HashMap();
        logMap.put("time", time);
        logMap.put("className", className);
        logMap.put("methodName", methodName);
        logMap.put("args", Arrays.toString(args));
        logMap.put("operate", action);
        logMap.put("desc", desc);
        logMap.put("result", result);
        logMap.put("respTime", respTime);

        System.out.println("logMap: " + logMap);
    }
}
