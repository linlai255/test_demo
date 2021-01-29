package com.cll.demo.services;

import com.cll.demo.pojo.User;

import java.util.List;

public interface UserService {
    List<User> getAllUserById(int id);

    User addUser(User user);

    User getUserById(int id);
}
