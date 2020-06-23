package cn.beanbang.springcore;

import cn.beanbang.springcore.service.SysService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Aop {
    public static void main(String[] args){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        SysService sysService = context.getBean(SysService.class);
        sysService.getToken();
//        sysService.validate();
    }
}
