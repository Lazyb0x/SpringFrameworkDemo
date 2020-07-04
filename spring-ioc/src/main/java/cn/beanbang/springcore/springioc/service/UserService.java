package cn.beanbang.springcore.springioc.service;

import cn.beanbang.springcore.springioc.bean.User;
import cn.beanbang.springcore.springioc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
//@Scope("prototype")     // 默认是单例("singleton")
public class UserService {

    @Autowired
    private UserDao userDao;

    public UserService(UserDao userDao){
        this.userDao = userDao;
    }

    public void saveUser(User user){
        userDao.saveUser(user);
        System.out.println("saveUser: " + user);
    }

    public UserService() {
        System.out.println("UserService 创建了");
    }

    /**
     * 初始化注解
     */
    @PostConstruct
    public void init(){
        System.out.println("UserService 初始化");
    }

    /**
     * 销毁注解
     */
    @PreDestroy
    public void destroy(){
        System.out.println("UserService 销毁");
    }
}
