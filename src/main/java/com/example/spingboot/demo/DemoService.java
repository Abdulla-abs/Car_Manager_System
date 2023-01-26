package com.example.spingboot.demo;

import org.springframework.stereotype.Component;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/7 17:24
 */
@Component
public class DemoService {

        public int init(){
                return 0;
        }

        public int addMethod(int x,int y){
//                int i = 1 / 0;
                return x+y;
        }
}
