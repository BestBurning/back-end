package com.di1shuai.cloud.alibaba.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: Bruce
 * @date: 2019-11-25
 * @description:
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "com.di1shuai.cloud.alibaba")
@ComponentScan("com.di1shuai.cloud.alibaba")
public class AliConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AliConsumerApplication.class,args);
    }

}
