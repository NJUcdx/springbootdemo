package com.example.springbootdemo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
public class HelloControllerTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void hello() {
        HelloController helloController = new HelloController();
        String res = helloController.hello();
        String expected = "hello world, fuck you !!!";
        Assert.assertEquals(expected, res);
    }
}