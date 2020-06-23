package cn.beanbang.springcore.springlog.service;

import cn.beanbang.springcore.springlog.bean.User;
import cn.beanbang.springcore.springlog.common.MyLog;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @MyLog(action = "保存用户", desc = "新增用户描述")
    public void saveUser(User user){
        System.out.println("saveuser: " + user);
    }

    @MyLog(action = "更新用户")
    public void updateUser(User user){
        System.out.println("updateuser: " + user);
    }

    @MyLog(action = "获取用户")
    public User getUser(){
        User user = new User();
        user.setName("测试");
        return user;
    }
}
