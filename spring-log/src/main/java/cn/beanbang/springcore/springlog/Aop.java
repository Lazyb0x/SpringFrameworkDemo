package cn.beanbang.springcore.springlog;

import cn.beanbang.springcore.springlog.bean.User;
import cn.beanbang.springcore.springlog.service.SysService;
import cn.beanbang.springcore.springlog.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Aop {
    public static void main(String[] args){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean(UserService.class);
        SysService sysService = context.getBean(SysService.class);

        User user = new User();
        user.setName("xiaoming");

        userService.saveUser(user);
        userService.updateUser(user);

        User user2 = userService.getUser();

        System.out.println(user2);

        sysService.getTimestamp();
    }
}
