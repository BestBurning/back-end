package com.di1shuai.shardingsphere;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Bruce
 * @since 2018/6/26
 */
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
@MapperScan("com.di1shuai.shardingsphere.dao")
public class ShardingSphereApplication {

    public static void main(String[] args) {
        
        SpringApplication.run(ShardingSphereApplication.class,args);
    }

}
