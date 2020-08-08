package cn.beanbang.springcore.jdbc.service.impl;

import cn.beanbang.springcore.jdbc.dao.UserDao;
import cn.beanbang.springcore.jdbc.model.User;
import cn.beanbang.springcore.jdbc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public int add(User user) {
        return userDao.add(user);
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public int delete(int id) {
        return userDao.delete(id);
    }
}
