package com.jhon.demo.mapper;

import com.jhon.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    Integer registerUser(User user);
}
