package cn.beanbang.springcore.jdbc.service;

import cn.beanbang.springcore.jdbc.config.SpringConfig;
import cn.beanbang.springcore.jdbc.model.User;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
class IUserServiceTest {

    @Autowired
    IUserService userService;

    @Test
    void findAll() {
        List<User> users = userService.findAll();
        for (User user : users){
            System.out.println(user);
        }
        assertNotNull(users);
    }

    @Test
    @Transactional      // Transactional 注解再此会使方法执行完事务回滚
    public void add() {
        User user = new User("xiaohong", 20);
        int res = userService.add(user);
        System.out.println(res);
        assertNotEquals(res, 0);
    }

    @Test
    void findById() {
        User user = userService.findById(1);
        System.out.println(user);
        assertNotNull(user);
    }

    @Test
    @Transactional
    void update() {
        User user = new User("Mae", 20);
        user.setId(1);
        int res = userService.update(user);
        findAll();
        assertNotEquals(res, 0);
    }

    @Test
    @Transactional
    void delete() {
        int res = userService.delete(1);
        findAll();
        assertNotEquals(res, 0);
    }
}