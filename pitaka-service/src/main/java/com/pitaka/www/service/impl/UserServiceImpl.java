package com.pitaka.www.service.impl;


import com.pitaka.www.mapper.UserMapper;
import com.pitaka.www.model.User;
import com.pitaka.www.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
