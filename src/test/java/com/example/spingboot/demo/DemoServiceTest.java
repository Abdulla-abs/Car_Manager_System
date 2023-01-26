package com.example.spingboot.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/7 17:42
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoServiceTest {

        @Autowired
        private DemoService demoService;

        @Test
        public void test(){
                int i = demoService.addMethod(1, 1);
                System.out.println("返回："+i);
        }
}
