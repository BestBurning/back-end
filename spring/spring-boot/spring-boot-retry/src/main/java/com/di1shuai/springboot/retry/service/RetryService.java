package com.di1shuai.springboot.retry.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class RetryService {

    @Retryable(value = IllegalAccessException.class)
    public void service1() throws IllegalAccessException {
        log.info("do something... {}", LocalDateTime.now());
        throw new IllegalAccessException("manual exception");
    }

    /**
     * 写死的次数
     * @throws IllegalAccessException
     */
    @Retryable(include = IllegalAccessException.class, maxAttempts = 5)
    public void service2() throws IllegalAccessException {
        log.info("do something... {}", LocalDateTime.now());
        throw new IllegalAccessException("manual exception");
    }

    /**
     * 读取配置中的次数
     * @throws IllegalAccessException
     */
    @Retryable(value = IllegalAccessException.class, maxAttemptsExpression = "${maxAttempts}")
    public void service3() throws IllegalAccessException {
        log.info("do something... {}", LocalDateTime.now());
        throw new IllegalAccessException("manual exception");
    }

    /**
     * 重试间隔
     * @throws IllegalAccessException
     */
    @Retryable(value = IllegalAccessException.class,
            backoff = @Backoff(value = 2000))
    public void service7() throws IllegalAccessException {
        log.info("do something... {}", LocalDateTime.now());
        throw new IllegalAccessException();
    }

    @Retryable(value = ArithmeticException.class)
    public int service13(String message) throws IllegalAccessException {
        log.info("do something... {},{}", message, LocalDateTime.now());
        return 1 / 0;
    }
    @Recover
    public int recover13(ArithmeticException e, String message) {
        log.info("{},service retry after Recover => {}", message, e.getMessage());
        return 0;
    }


}  
