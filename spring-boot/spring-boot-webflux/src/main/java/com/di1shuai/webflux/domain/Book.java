package com.di1shuai.webflux.domain;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;

@Data
@ToString
@Builder
@Table("post")
public class Book {

    @Id
    private Long id;

    private String title;

    private String content;

    @CreatedDate
    private Date createDate;


}
