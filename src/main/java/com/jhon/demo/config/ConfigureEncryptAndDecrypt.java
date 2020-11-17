package com.jhon.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigureEncryptAndDecrypt {

    public static final String CHAR_ENCODING = "UTF-8";

    public static final String CHARSET = "gbk";

    public static final String AES_ALGORITHM = "AES/ECB/PKCS5Padding";

    public static final String RSA_ALGORITHM = "RSA/ECB/PKCS1Padding";

    @Value("${config.socket.serverIpTo}")
    public String serverIp;

    @Value("${config.socket.serverportTo}")
    public Integer serverport;

    @Value("${config.socket.timeout}")
    public Integer timeout;

    @Value("${config.socket.privateKey}")
    public String privateKey;

    @Value("${config.socket.publicKey}")
    public String publicKey;

}
