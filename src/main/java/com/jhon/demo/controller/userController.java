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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.text.Format;

import java.text.SimpleDateFormat;

import java.util.Calendar;

import java.util.Date;

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


    @GetMapping("/reference")
    public Object refTest() {

//        StringBuilder result = new StringBuilder();
//        result.append("<br> aaa");
//        tesRefArray(result);


        List<String> result = new ArrayList<>();
        result.add("aaa");
        testList(result);
        return result;
    }

    private void tesRefArray(StringBuilder input) {
        input.append("<br> bbb");
    }

    private static void testList(List<String> input) {
        input.add("bbb");
    }

//    public static void main(String[] args) {
//        List<String> result = new ArrayList<>();
//        result.add("aaa");
//        testList(result);
//        System.out.println(result);
//    }

    public static void streamTest() {

        List<Loan> list = new ArrayList<>();
        list.add(new Loan(1, 11, "0", "1", 100L));
        list.add(new Loan(1, 22, "0", "1", 100L));
        list.add(new Loan(2, 33, "0", "3", 100L));
        list.add(new Loan(2, 44, "0", "4", 100L));


        Map<Integer, List<Loan>> map = list.stream().collect(Collectors.groupingBy(Loan::getId));

        List<Loan> dailyLoanDTOS = new ArrayList();

        map.forEach((k, v) -> {
            LongSummaryStatistics longSummaryStatistics = v.stream().collect(Collectors.summarizingLong(Loan::getNum));
            Loan dailyLoanDTO = v.stream().findFirst().get();
            dailyLoanDTO.setNum((int) longSummaryStatistics.getSum());
            dailyLoanDTOS.add(dailyLoanDTO);
        });


        System.out.println("OK");

    }


    public static void main(String[] args) throws ParseException {
        /*Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -10);
        String tenBefore = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
        System.out.println(tenBefore);*/

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        Date today = simpleDateFormat.parse("2020-10-23");


        Format f=new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("今天bai是du:" +f.format(today));

        Calendar c=Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.DAY_OF_MONTH,1);//今天+1天
        c.add(Calendar.SECOND,-1);
        Date tomorrow=c.getTime();

        System.out.println("明天是:" +tomorrow.toString());


    }

}







