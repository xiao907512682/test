package com.company.project.service;
import com.company.project.model.User;
import com.company.project.core.Service;


/**
 * Created by CodeGenerator on 2021/03/23.
 */
public interface UserService extends Service<User> {

    User userLogin(User user);
}
