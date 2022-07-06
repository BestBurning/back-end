package com.di1shuai.cloud.api.service.fallback;

import com.di1shuai.cloud.api.model.User;
import com.di1shuai.cloud.api.service.UserService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Bruce
 * @date: 2019-11-23
 * @description:
 */
@Component
public class UserServiceFallbackFactory implements FallbackFactory<UserService> {
    @Override
    public UserService create(Throwable throwable) {
        return new UserService() {
            @Override
            public boolean save(User user) {
                return false;
            }

            @Override
            public User getById(Long id) {
                return new User();
            }

            @Override
            public List<User> list() {
                return new ArrayList<User>(){};
            }
        };
    }

}
