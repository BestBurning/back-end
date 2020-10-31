package com.di1shuai.model;

import java.util.List;

/**
 * @author Bruce
 * @since 2019-02-12
 */
public class Tree {

    private String name;

    private List<Tree> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tree> getChildren() {
        return children;
    }

    public void setChildren(List<Tree> children) {
        this.children = children;
    }

    public Tree() {
    }

    public Tree(String name, List<Tree> children) {
        this.name = name;
        this.children = children;
    }
}
