package cn.beanbang.springcore.cache.service;

import cn.beanbang.springcore.cache.config.SpringConfig;
import cn.beanbang.springcore.cache.dao.UserDao;
import cn.beanbang.springcore.cache.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;

    @Test
    void getName() {
        userDao.save(new User("xiaoming"));

        for (int i=0; i<3; i++){
            System.out.println(userService.getUser(1));
        }
        assert(true);
    }

    @Test
    void testSaveUser() {
        String[] names = {"aaa", "bbb", "ccc"};

        System.out.println("添加三个用户");
        for (int i=0; i<names.length; i++){
            userService.addUser(new User(names[i]));
        }

        System.out.println("获取并打印用户");
        for (int i=0; i<3; i++){
            System.out.println(userService.getUser(i+1));
            System.out.println(userService.getUser(i+1));
        }

        System.out.println("删除id=3的用户并尝试获取");
        userService.delUser(3);
        System.out.println(userService.getUser(3));
    }
}
