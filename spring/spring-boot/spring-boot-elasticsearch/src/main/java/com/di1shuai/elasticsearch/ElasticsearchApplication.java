package com.di1shuai.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author: Shea
 * @date: 2020/11/23
 * @description:
 */
@EnableElasticsearchRepositories(basePackages = "com.di1shuai.elasticsearch.repository")
@SpringBootApplication
public class ElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchApplication.class,args);
    }

}
