package cn.beanbang.springcore.cache;

import cn.beanbang.springcore.cache.config.SpringConfig;
import cn.beanbang.springcore.cache.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        UserService userService = context.getBean(UserService.class);
    }
}
