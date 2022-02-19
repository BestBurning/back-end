package com.di1shuai.hugegraph.config;

import com.baidu.hugegraph.driver.HugeClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shea
 * @since 2022/2/8
 */
@Configuration
public class HugegraphConfig {

    @Value("${huge.url}")
    String url;

    @Value("${huge.graph}")
    String graph;

    @Bean
    public HugeClient hugeClient(){
        HugeClient hugeClient = HugeClient.builder(url, graph)
            .build();
        return hugeClient;
    }


}
