package com.di1shuai.cloud.alibaba.sentinel.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

/**
 * @author shea
 * @since 2022/7/7
 */
@Service
public class StudentService {


    @SentinelResource(value = "HelloSentinel", blockHandler = "back")
    public String getMessage() {
            return "hello Sentinel";
    }

    public String back(BlockException e) {
            return "已被降级";
    }

}
