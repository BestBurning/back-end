package com.di1shuai.drools.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author Shea
 * @date 2021-02-03
 * @description
 */

@SpringBootApplication
public class DroolsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DroolsApplication.class, args);
//        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);


    }

}
