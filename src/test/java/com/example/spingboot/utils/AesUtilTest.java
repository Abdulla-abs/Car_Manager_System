package com.example.spingboot.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/5/14 20:55
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AesUtilTest {

        @Autowired
        private AesUtil aesUtil;

        @Test
        public void t1(){
                long currentTime = System.currentTimeMillis();
                long expires = currentTime + 1000*60*60*24;
                String content = "123456,"+expires;
                String encrypt = aesUtil.encrypt(content);
                System.out.println(encrypt);
        }
}
