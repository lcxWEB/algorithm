package com.example.demo.datastructure.set;

/**
 * @Author: lcx
 * @Date: 2019/1/24 10:15
 * @Description:
 */

public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();

}
