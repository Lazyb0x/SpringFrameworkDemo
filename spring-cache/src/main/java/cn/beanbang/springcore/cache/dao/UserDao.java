package cn.beanbang.springcore.cache.dao;

import cn.beanbang.springcore.cache.model.User;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 简单内存数据库
 */
@Repository
public class UserDao {

    final Map<Integer, User> users = new ConcurrentHashMap<>();
    AtomicInteger key = new AtomicInteger(0);

    public User save(User user){
        users.put(key.incrementAndGet(), user);
        user.setId(key.get());
        return user;
    }

    public User get(int id){
        return users.get(id);
    }

    public void deleteById(int id) {
        users.remove(id);
    }
}
