package com.di1shuai.webflux.controller;

import com.di1shuai.webflux.domain.Book;
import com.di1shuai.webflux.execption.NotFoundException;
import com.di1shuai.webflux.repository.BookRepository;
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
@RequestMapping("/book")
public class BookController {


    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public Flux<Book> list() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Book> get(@PathVariable("id") Long id) {
        return bookRepository.findById(id)
                .switchIfEmpty(Mono.error(new NotFoundException(String.valueOf(id))));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Book> save(@RequestBody Book book) {
        // Couldn't get id in H2 after save
        return bookRepository.save(book);
    }


    @PutMapping("/{id}")
    public Mono<Book> update(@PathVariable("id") Long id, @RequestBody Book book) {
        return bookRepository.findById(id)
                .switchIfEmpty(Mono.error(new NotFoundException(String.valueOf(id))))
                .map(p -> {
                    p.setTitle(book.getTitle());
                    p.setContent(book.getContent());
                    return p;
                })
                .flatMap(p -> bookRepository.save(p))
                // Query again for can't get id in H2
                .flatMap(p -> bookRepository.findById(p.getId()));
    }



    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") Long id) {
        return bookRepository
                .findById(id)
                .switchIfEmpty(Mono.error(new NotFoundException(String.valueOf(id))))
                .then(bookRepository.deleteById(id));
    }


}
