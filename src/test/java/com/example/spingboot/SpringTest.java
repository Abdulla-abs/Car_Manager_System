package com.example.spingboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTest {

    @Autowired
    private Test test;
    @Test
    public void m1(){
        System.out.println(test.toString());
    }

    @Test
    public void m2(){

    }

    static class ViewHolder{

    }

}
