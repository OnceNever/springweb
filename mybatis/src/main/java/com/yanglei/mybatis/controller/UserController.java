package com.yanglei.mybatis.controller;

import com.yanglei.mybatis.entity.User;
import com.yanglei.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserMapper mapper;

    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        List<User> list = mapper.queryUserList();
        for(User temp : list){
            System.out.println(temp);
        }
        return list;
    }

    @GetMapping("/queryById/{id}")
    public User queryById(@PathVariable("id") int id){
        User user = mapper.queryById(id);
        return user;
    }

    @GetMapping("/addUser")
    public String addUser(){
        mapper.addUser(new User(3, "zhangsan", "123456"));
        return "ok";
    }

    @GetMapping("/updateUser")
    public String updateUser(){
        mapper.updateUser(new User(3, "lisi", "123456"));
        return "ok";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(){
        mapper.deleteUser(3);
        return "ok";
    }
}
