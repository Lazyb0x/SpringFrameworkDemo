package cn.beanbang.springcore.springioc.service.impl;

import cn.beanbang.springcore.springioc.dao.UserDao;
import cn.beanbang.springcore.springioc.service.ISysService;

public class SysService implements ISysService {

    UserDao userDao;

    @Override
    public Long getToken() {
        Long token = System.currentTimeMillis();
        return token;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
