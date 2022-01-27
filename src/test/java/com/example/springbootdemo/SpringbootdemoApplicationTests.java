package com.example.springbootdemo;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootdemoApplicationTests {

//    @Autowired
//    HelloController helloController;

    @Test
    void contextLoads() {
    }

//    @Test
//    public void hello() {
//        String res = helloController.hello();
//        String expected = "hello world, fuck you !!!";
//        Assertions.assertEquals(expected, res);
//    }

    @Test
    public void hello1() {
        HelloControllerTest helloControllerTest = new HelloControllerTest();
        helloControllerTest.hello();
    }


}
