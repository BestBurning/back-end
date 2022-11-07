package com.di1shuai.mine;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: 上下文
 * @author: orangeCs
 * @create: 2020-08-22
 */
public class Context implements Serializable {

    private final Map<Class<?>,Object> CONTEXT = new ConcurrentHashMap<>();

    public <T> T get(Class<T> clazz) {
        return (T) CONTEXT.get(clazz);
    }

    public void put(Object obj) {
        if(null == obj) {
            return;
        }
        CONTEXT.put(obj.getClass(),obj);
    }
}
