package com.example.problems.datastructure.linkedlist;


import com.example.problems.datastructure.stackqueue.Stack;

/**
 * @Author: lcx
 * @Date: 2018/12/7 11:47
 * @Description:
 */

public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> linkedList;

    public LinkedListStack() {
        linkedList = new LinkedList<E>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack：top ");
        res.append(linkedList);
        return res.toString();
    }
}
