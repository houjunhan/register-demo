package com.jhon.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * jhon 2020年5月20日.
 * 用户注册-user.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User implements Serializable {
    //自增id.
    private Long id;
    //登录名.
    @NotNull(message = "账号不允许为空")
    private String userName;
    //登录密码（加密后）
    @NotNull(message = "用户密码不允许为空")
    private String password;
    //用户姓名
    @NotNull(message = "用户名不允许为空")
    private String name;
    //性别。0：男，1：女
    @NotNull(message = "性别不允许为空")
    private byte sex;
    //收入
    @NotNull(message = "收入不允许为空")
    private BigDecimal salary;
    //生日
    @NotNull(message = "生日不允许为空")
    private String birthday;
    //手机号
    @NotBlank(message = "手机号不允许为空")
    private String mobile;

}
