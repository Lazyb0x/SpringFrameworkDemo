package cn.beanbang.springcore.jdbc.service;

import cn.beanbang.springcore.jdbc.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {

    List<User> findAll();

    int add(User user);

    User findById(int id);

    int update(User user);

    int delete(int id);
}
