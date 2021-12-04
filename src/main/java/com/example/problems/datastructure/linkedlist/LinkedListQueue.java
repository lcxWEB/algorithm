package com.example.problems.datastructure.linkedlist;


import com.example.problems.datastructure.stackqueue.Queue;

/**
 * @Author: lcx
 * @Date: 2018/12/7 12:28
 * @Description:
 */

public class LinkedListQueue<E> implements Queue<E> {

    private class Node {
        E e;
        Node next;

        Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        Node(E e) {
            this(e, null);
        }

        Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LinkedListQueue：front ");
        for (Node cur = head; cur != null; cur=cur.next) {
            res.append(cur + "->");
        }
        res.append("NULL tail");
        return res.toString();
    }

    public static void main(String[] args){

        LinkedListQueue<Integer> arrayQueue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++){
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);
            if (i % 3 == 2){
                arrayQueue.dequeue();
                System.out.println(arrayQueue);
            }
        }

    }
}
