package com.di1shuai.model;

import java.util.List;

/**
 * @author Bruce
 * @since 2018/4/18
 */
public class A {

    private String name;
    private List<A> as;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<A> getAs() {
        return as;
    }

    public void setAs(List<A> as) {
        this.as = as;
    }
}
