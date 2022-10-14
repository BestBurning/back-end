package com.di1shuai.webflux.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoOperator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shea
 * @since 2022/8/18
 */
@Service
public class HelloService {

    List<String> data = Arrays.asList("1", "2", "3");

    public Flux<String> findAll() {
        String[] d = new String[data.size()];
        return Flux.just(data.toArray(d));
    }

    public Mono<String> findById(int index) {
        return data.get(index) != null ? Mono.just(data.get(index)) : Mono.empty();
    }

    public Mono<String> save(String str) {
        data.add(str);
        return Mono.just(str);
    }


    public Mono<Void> deleteByIndex(int index) {
        return Mono.empty().doFirst(
                () -> data.remove(index)
        ).then();
    }
}
