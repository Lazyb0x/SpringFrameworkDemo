package cn.beanbang.springcore.service.impl;

import cn.beanbang.springcore.annotation.MyAspect;
import cn.beanbang.springcore.bean.User;
import cn.beanbang.springcore.service.IUserService;

public class UserService implements IUserService {
    @MyAspect("saveUser 方法")
    @Override
    public void saveUser(User user) {
        System.out.println("saveuser: " + user.getName());
    }
}
