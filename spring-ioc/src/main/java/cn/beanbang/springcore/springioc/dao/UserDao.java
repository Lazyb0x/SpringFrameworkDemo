package cn.beanbang.springcore.springioc.dao;

import cn.beanbang.springcore.springioc.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    public void saveUser(User user){
        System.out.println("保存到数据库：" + user);
    }
}
