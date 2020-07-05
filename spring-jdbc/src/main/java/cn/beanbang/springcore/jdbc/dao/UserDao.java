package cn.beanbang.springcore.jdbc.dao;

import cn.beanbang.springcore.jdbc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Transactional
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> findAll() {
        String sql = "SELECT * FROM t_user";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    public int add(User user) {
        String sql = "INSERT INTO t_user(name, age) VALUES (?, ?)";
        return jdbcTemplate.update(sql, user.getName(), user.getAge());
    }

    public User findById(int id){
        String sql = "SELECT * FROM t_user WHERE id = ?";
        User user = null;

        try {
            user = jdbcTemplate.queryForObject(sql, new UserRowMapper(), id);
        }
        catch (EmptyResultDataAccessException e){   // 如果查询为空会抛该异常
            e.printStackTrace();
        }

        return user;
    }

    public int update(User user){
        String sql = "UPDATE t_user set name = ?, age = ? WHERE id = ?";
        return jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getId());
    }

    public int delete(int id){
        String sql = "DELETE FROM t_user WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setAge(resultSet.getInt("age"));
            return user;
        }
    }
}
