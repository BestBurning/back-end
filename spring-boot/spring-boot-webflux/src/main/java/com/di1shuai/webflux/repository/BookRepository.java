package com.di1shuai.webflux.repository;

import com.di1shuai.webflux.domain.Book;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BookRepository extends ReactiveCrudRepository<Book, Long> {

}
