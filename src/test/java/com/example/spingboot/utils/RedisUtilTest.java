package com.example.spingboot.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/5/14 15:28
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisUtilTest {

        @Autowired
        private RedisUtil redisUtil;

        @Test
        public void save(){
                redisUtil.save("abbas","jdskdjsofncjdsci.xsnicnusicns.dsjiajcdus");
        }

        @Test
        public void get(){
                System.out.println(redisUtil.getToken("abbas"));
        }


}
