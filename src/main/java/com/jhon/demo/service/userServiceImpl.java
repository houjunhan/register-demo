package com.jhon.demo.service;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.jhon.demo.common.md5Utils;
import com.jhon.demo.entity.User;
import com.jhon.demo.mapper.UserMapper;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class userServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public Integer registerUser(User user) throws RuntimeException {

        HashMap hs = new HashMap();
        hs.put(1, 1);
        try {
            //获取自增趋势id 伪snowflake
            final Long id = idWorker.getId();
            //密码加密
            String mixedPwd = md5Utils.getMixedPassword(user.getPassword());
            user.setId(id);
            user.setPassword(mixedPwd);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return userMapper.registerUser(user);
    }

    @Override
    @Transactional
    public List<User> getUsers() {
        return userMapper.getUsers();
    }

    @Override
    public User getUser() {
        //使用this调用改成动态代理调用(AopContext.currentProxy())
        userServiceImpl proxy = (userServiceImpl) AopContext.currentProxy();
        User user = proxy.getUsers().stream().findFirst().get();

        return user;
    }


}
