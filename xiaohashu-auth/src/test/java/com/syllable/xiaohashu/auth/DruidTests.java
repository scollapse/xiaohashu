package com.syllable.xiaohashu.auth;


import com.alibaba.druid.filter.config.ConfigTools;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description:  druid测试类
 * @author: syl
 * @create: 2025-08-25 17:08
 **/
@SpringBootTest
@Slf4j
public class DruidTests {


    @Test
    @SneakyThrows
    void testEncodePassword() {
        String password = "root" ;
        String[] arr = ConfigTools.genKeyPair(512);

        //私钥
        log.info("privateKey: {}", arr[0]);

        //公钥
        log.info("publicKey: {}", arr[1]);

        //加密后的密码
        String encodedPassword = ConfigTools.encrypt(arr[0], password);
        log.info("encodedPassword: {}", encodedPassword);

    }
}
