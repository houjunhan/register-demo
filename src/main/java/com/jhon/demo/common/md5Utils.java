package com.jhon.demo.common;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;

public  class md5Utils {

    @Value("${const.solt}")
    static private String solt;

    /**
     * @param str 待加密字符串.
     * @return
     */
    public static String getMixedPassword(String str) {

        // DigestUtils.md5Hex()此方法为加密方法
        String password = DigestUtils.md5Hex(str);
        //此处加密后加盐再进行加密
        return DigestUtils.md5Hex(password + solt);
    }

}
