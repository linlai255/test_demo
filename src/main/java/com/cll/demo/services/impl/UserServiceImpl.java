package com.cll.demo.services.impl;

import com.cll.demo.dao.UserMapper;
import com.cll.demo.pojo.User;
import com.cll.demo.services.UserService;
import com.mysql.cj.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    /*@Cacheable(cacheNames = "first")*/
    @Override
    public List<User> getAllUserById(int id) {
        System.out.println("获取用户");
        List<User> u = jdbcTemplate.query("select * from ums_user", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setAge(resultSet.getInt("age"));
                user.setEmail(resultSet.getString("email"));
                user.setUser(resultSet.getString("user"));
                return user;
            }
        });
        return u;
    }
@Autowired
    UserMapper userMapper;
    @CachePut(cacheNames = "add",key = "#result.id")
    @Override
    public User addUser(User user) {
        System.out.println("添加");
        userMapper.addUser(user);
        User user1 = userMapper.getUserByUser(user.getUser());
        return user1;
    }
    @Cacheable(cacheNames = "add")
    @Override
    public User getUserById(int id) {
        System.out.println("打印");
        return userMapper.getUserById(id);
    }
}
