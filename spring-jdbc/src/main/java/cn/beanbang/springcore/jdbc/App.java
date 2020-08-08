package cn.beanbang.springcore.jdbc;

import cn.beanbang.springcore.jdbc.dao.UserDao;
import cn.beanbang.springcore.jdbc.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@ComponentScan
@Configuration
public class App {
    public static void main(String[] args){
        // 加载配置文件类
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        UserDao userDao = context.getBean(UserDao.class);
        List<User> users = userDao.findAll();
        for (User user : users){
            System.out.println(user);
        }
    }
}
