package com.di1shuai.mongo.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Customer {

    @Id
    public String id;

    public String firstName;
    public String lastName;


}