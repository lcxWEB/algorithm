package com.example.demo.datastructure.stackqueue;

/**
 * Created by lcx on 2018/10/10.
 */
public interface Queue<E> {

    void enqueue(E e);
    E dequeue();
    E getFront();
    int getSize();
    boolean isEmpty();
}
