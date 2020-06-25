package cn.beanbang.springcore.springerr;

import cn.beanbang.springcore.springerr.bean.User;
import cn.beanbang.springcore.springerr.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService = context.getBean(UserService.class);

        User user = new User();
        user.setName("小鸣");
        user.setAge(160);

        userService.saveUser(user);
    }
}
