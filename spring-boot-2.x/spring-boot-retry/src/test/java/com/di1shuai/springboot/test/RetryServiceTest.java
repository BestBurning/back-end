package com.di1shuai.springboot.test;

import com.di1shuai.springboot.retry.RetryApplication;
import com.di1shuai.springboot.retry.service.RetryService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RetryApplication.class,webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class RetryServiceTest {

    @Autowired
    private RetryService retryService;

    @Test
    void testService1() throws IllegalAccessException {
        retryService.service1();
    }
    @Test
    void testService2() throws IllegalAccessException {
        retryService.service2();
    }
    @Test
    void testService3() throws IllegalAccessException {
        retryService.service3();
    }
    @Test
    void testService7() throws IllegalAccessException {
        retryService.service7();
    }
    @Test
    void testService13() throws IllegalAccessException {
        retryService.service13("ceshi1");
    }


}