package com.example.demo.datastructure.stackqueue;

/**
 * Created by lcx on 2018/10/9.
 */
public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();

}
