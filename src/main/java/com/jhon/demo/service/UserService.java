package com.jhon.demo.service;

import com.jhon.demo.entity.User;

import java.util.List;

public interface UserService {
    Integer registerUser(User user) throws Exception;

    List<User> getUsers();

    User getUser();

    default Integer testdefault(){
        return 1;
    }

}
