package cn.zyt;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class CryptTest {
    @Test
    public void test() {
        //测试下md5加密

        /* 这个是spring提供的  加盐得自己处理
        String s = DigestUtils.md5DigestAsHex("123456".getBytes());
        System.out.println(s);
        */

        //这个是springSecurity框架提供的 可以自动加盐 无需自己保存盐值
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("123456")); //自动加盐了 所以这两个打出来的不一样
        System.out.println(passwordEncoder.encode("123456")); //拿到解密的网站里 是解不出来的 但是可以匹配上
        System.out.println(passwordEncoder.matches("123456", "$2a$10$fUvt/SiNS5u1mfq4rqUhiuLho7UfR0poMSI40g4ohrUdm4remFn.W"));
        //它自己有套机制 解密
    }
}
