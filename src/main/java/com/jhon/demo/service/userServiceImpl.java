package com.jhon.demo.service;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.jhon.demo.common.md5Utils;
import com.jhon.demo.entity.User;
import com.jhon.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public Integer registerUser(User user) throws RuntimeException {

        try {
            //获取自增趋势id
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
}
