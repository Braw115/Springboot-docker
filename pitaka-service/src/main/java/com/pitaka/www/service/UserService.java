package com.pitaka.www.service;


import com.pitaka.www.model.User;

public interface UserService {

    /**
     *  通过用户名查询用户
     * @Param username
     * @return
     */
    User findByUsername(String username);

}
