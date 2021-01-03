package com.yanglei.springshiro.service.impl;

import com.yanglei.springshiro.entity.User;
import com.yanglei.springshiro.mapper.UserMapper;
import com.yanglei.springshiro.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User queryByName(String name) {
        return userMapper.queryByName(name);
    }
}
