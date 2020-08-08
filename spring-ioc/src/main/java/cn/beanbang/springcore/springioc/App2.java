package cn.beanbang.springcore.springioc;

import cn.beanbang.springcore.springioc.bean.User;
import cn.beanbang.springcore.springioc.dao.UserDao;
import cn.beanbang.springcore.springioc.service.ISysService;
import cn.beanbang.springcore.springioc.service.UserService;
import cn.beanbang.springcore.springioc.service.impl.SysService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class App2 {

    public static void main(String[] args){
        applicationContext2();
    }

    /**
     * Beanfactory 容器（过时）
     * 延时加载
     */
    public static void beanFactory(){
        BeanFactory beanFactory = new XmlBeanFactory(
                new ClassPathResource("applicationContext.xml"));

        UserService userService = (UserService) beanFactory.getBean("userService");

        User user = new User();
        user.setName("Mae");

        userService.saveUser(user);
    }

    /**
     * ApplicationContext 容器
     * 加载容器时加载
     */
    public static void applicationContext(){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        UserService userService = (UserService) context.getBean(UserService.class);

        userService.saveUser(new User("Max"));

        ((ClassPathXmlApplicationContext)context).close();
    }

    public static void applicationContext2(){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        ISysService sysService = (ISysService) context.getBean("sysService");
        System.out.println(sysService.getToken());

        // 属性值注入测试
        UserDao userDao = ((SysService)sysService).getUserDao();
        userDao.saveUser(new User("sss"));
    }
}
