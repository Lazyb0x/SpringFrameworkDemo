package cn.beanbang.springcore.service.impl;

import cn.beanbang.springcore.bean.User;
import cn.beanbang.springcore.service.IUserService;

public class UserService implements IUserService {
    @Override
    public void saveUser(User user) {
        System.out.println("saveuser: " + user.getName());
    }
}
