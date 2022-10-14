package com.di1shuai.webflux.execption;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author shea
 * @since 2022/8/18
 */
@Data
@AllArgsConstructor
public class NotFoundException extends Throwable{

    private String name;




}
