package com.jhon.demo.mapper;

import com.jhon.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    Integer registerUser(User user);
    List<User> getUsers();
}

