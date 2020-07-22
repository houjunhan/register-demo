package com.jhon.demo.controller;

import com.jhon.demo.entity.CommonResult;
import com.jhon.demo.entity.Loan;
import com.jhon.demo.entity.User;
import com.jhon.demo.proxy.DynamicPoxy;
import com.jhon.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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


    @GetMapping("/all")
    public List<User> getAllUsers() {

        return registerServiceImpl.getUsers();
    }


    @GetMapping("/proxyall")
    public Object getUsers() {

        DynamicPoxy handler = new DynamicPoxy();
        //指定要代理的真实对象
        handler.setTarget(registerServiceImpl);

        return ((UserService) handler.getProxyInstance()).getUser();
    }


    @GetMapping("/random")
    public String getRandom() {

        String val = "";
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            val += String.valueOf(random.nextInt(10));
        }
        return val;
    }

    @GetMapping("/myfilter")
    public List<Loan> myfilter() {
        List<Loan> list = new ArrayList<>();
        List<Loan> result = null;

        list.add(Loan.builder().loanRepayStatus("ok").loanStatus("day").num(1).build());
        list.add(Loan.builder().loanRepayStatus("ok").loanStatus("day").num(2).build());
        list.add(Loan.builder().loanRepayStatus("FAIL_REPAYMENT").loanStatus("HYD_WEEK_LOAN").num(3).build());
        list.add(Loan.builder().loanRepayStatus("FAIL_REPAYMENT").loanStatus("HYD_WEEK_LOAN").num(4).build());

        result = list.stream()
                .filter(e -> !(e.getLoanRepayStatus().equals("FAIL_REPAYMENT") && e.getLoanStatus().equals("HYD_WEEK_LOAN")))
                .collect(Collectors.toList());


        return result;
    }
}



