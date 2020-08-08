package cn.beanbang.springcore.cache.service;

import cn.beanbang.springcore.cache.dao.UserDao;
import cn.beanbang.springcore.cache.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Cacheable(value = "user", key = "#id")
    public User getUser(int id){
        // 有输出说明执行了该方法
        System.out.println("UserService.getUser() 执行");
        return userDao.get(id);
    }

    @CachePut(value = "user", key = "#user.id")
    public User addUser(User user){
        return userDao.save(user);
    }

    @CacheEvict(value = "user", key = "#id")
    public void delUser(int id){
        userDao.deleteById(id);
    }
}
