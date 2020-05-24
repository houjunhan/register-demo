package com.jhon.demo.controller;

import com.jhon.demo.entity.CommonResult;
import com.jhon.demo.entity.User;
import com.jhon.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class userController {

    @Autowired
    private UserService registerServiceImpl;

    @PostMapping("/register")
    public CommonResult<Integer> register(@RequestBody @Validated User user) throws Exception {

        Integer insertRows = 0;

        insertRows = registerServiceImpl.registerUser(user);
        log.info("****用户user表插入行数：" + insertRows);

        CommonResult<Integer> integerCommonResult = insertRows > 0 ?
                new CommonResult<>() :
                new CommonResult<>(444, "插入失败", insertRows);
        return integerCommonResult;
    }

}
