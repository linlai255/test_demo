package com.cll.demo.dao;

import com.cll.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void addUser(User user);

    User getUserById(int id);

    User getUserByUser(String user);
}
