package com.example.spingboot.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author abbas
 * @description: Jwt 工具类测试
 * @date 2022/5/14 14:34
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtUtilTest {

        @Autowired
        private JwtUtil jwtUtil;

        @Test
        public void t1(){
                String token = jwtUtil.generateTaken("abbas");
                System.out.println(token);

                String username = jwtUtil.getUsername(token);
                System.out.println(username);
        }
}
