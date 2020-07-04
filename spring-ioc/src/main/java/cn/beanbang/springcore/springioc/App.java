package cn.beanbang.springcore.springioc;

import cn.beanbang.springcore.springioc.bean.User;
import cn.beanbang.springcore.springioc.dao.UserDao;
import cn.beanbang.springcore.springioc.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args){
        // 通过注解配置
        ApplicationContext context = new AnnotationConfigApplicationContext(
                "cn.beanbang.springcore.springioc");

        // scope 注解测试
        for (int i=0; i<3; i++){
            UserService userService = context.getBean(UserService.class);

            System.out.println(userService);

            userService.saveUser(new User("xiaoming"));
        }

        // 当 bean 类型为 prototype 时由 GC 管理
        ((AnnotationConfigApplicationContext)context).close();
    }
}
