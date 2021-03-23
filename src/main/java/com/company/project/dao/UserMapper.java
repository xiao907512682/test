package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends Mapper<User> {

    //根据账号查用户
    User getUserByAccount(@Param("account")String account);

    //登录
    User userLogin(User user);
}