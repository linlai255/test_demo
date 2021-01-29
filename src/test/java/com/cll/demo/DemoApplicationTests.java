package com.cll.demo;

import com.cll.demo.config.MyRedisTemplate;
import com.cll.demo.dao.UserMapper;
import com.cll.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.sql.DataSource;

@SpringBootTest
class DemoApplicationTests {
@Autowired
    DataSource dataSource;
    @Test
    void contextLoads() {
        System.out.println(dataSource.getClass());
    }
   /* @Autowired
    UserMapper userMapper;
    @Autowired
    RedisTemplate MyredisTemplate;
    @Test
    void testFn(){
        User user = userMapper.getUserById(8);
        MyredisTemplate.opsForValue().set("测试",user);
    }*/

}
