package com.di1shuai.mongo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot 项目集成 Swagger 实例文档")
                .description("我的博客网站：https://di1shuai.com，欢迎大家访问。")
                .version("API V1.0")
                .termsOfServiceUrl("Terms of service")
                .contact(new Contact("第一帅", "https://di1shuai.com", "zhushuai026@gmail.com")).license("Apache").licenseUrl("http://www.apache.org/")
                .build();
    }
}