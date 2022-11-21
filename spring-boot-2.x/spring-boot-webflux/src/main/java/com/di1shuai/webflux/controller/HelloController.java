package com.di1shuai.webflux.controller;

import com.di1shuai.webflux.execption.NotFoundException;
import com.di1shuai.webflux.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * @author shea
 * @since 2022/8/18
 */
@RestController
@RequestMapping("/hello")
public class HelloController {


    @Autowired
    private HelloService helloService;

    @GetMapping("list")
    public Flux<String> list() {
        return helloService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<String> get(@PathVariable("index") int index) {
        return helloService.findById(index)
                .switchIfEmpty(Mono.error(new NotFoundException(String.valueOf(index))));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<String> save(String str) {
        return helloService.save(str);
    }


    @PutMapping("/{index}")
    public Mono<String> update(@PathVariable("index") int index, String str) {
        return helloService.findById(index)
                .switchIfEmpty(Mono.error(new NotFoundException(String.valueOf(index))))
                .map(p -> {
                    p = "追加数据: "+p;
                    return p;
                })
                .flatMap(p -> helloService.save(p))
                // Query again for can't get id in H2
                .flatMap(p -> helloService.findById(index));
    }



    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("index") int index) {
        return helloService
                .findById(index)
                .switchIfEmpty(Mono.error(new NotFoundException(String.valueOf(index))))
                .then(helloService.deleteByIndex(index));
    }


}
