package com.pitaka.www.mapper;


import com.pitaka.www.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
   User findByUsername(@Param("username")String username);

}
