package com.cll.demo.controller;

import com.cll.demo.pojo.User;
import com.cll.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
        @Autowired
        UserService userService;
        @GetMapping("/getAllUser")
        public List<User> getAllUser(int id){
                List<User> list = userService.getAllUserById(id);
                return list;
        }
        @RequestMapping("/addUser")
        public User addUser(User user){
                User u = userService.addUser(user);
                return u;
        }
        @GetMapping("/getUserById")
        public User getUser(int id){
                User user = userService.getUserById(id);
                if (user != null) return user;
               else return null;
        }
}
