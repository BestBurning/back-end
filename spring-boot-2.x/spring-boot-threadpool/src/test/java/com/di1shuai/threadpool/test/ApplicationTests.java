package com.di1shuai.threadpool.test;

import com.di1shuai.threadpool.service.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private Task task;

    @Test
    public void test() throws Exception {

        task.doTaskOne();
//        task.doTaskOne();
//        task.doTaskTwo();
//        task.doTaskThree();

        Thread.currentThread().join();
    }

}