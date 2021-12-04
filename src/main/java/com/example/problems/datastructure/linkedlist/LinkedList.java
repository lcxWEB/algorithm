package com.example.problems.datastructure.linkedlist;

/**
 * @Author: lcx
 * @Date: 2018/11/29 9:10
 * @Description:
 */

public class LinkedList<E> {

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

    // private Node head;
    // 虚拟头结点
    private Node dummyHead;
    private int size;

    public LinkedList() {
        // head = null;
        dummyHead = new Node(null, null);
        size = 0;
    }

    // 获取链表中的元素个数
    public int getSize() {
        return size;
    }

    // 判断链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 在链表头添加新的元素
    public void addFirst(E e) {
        // Node node = new Node(e);
        // node.next = head;
        // head = node;
        // head = new Node(e, head);
        // size++;
        add(0, e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        // if (index == 0) {
        //     addFirst(e);
        // } else {
        //     Node prev = head;
        //     for (int i = 0; i < index - 1; i++) {
        //         prev = prev.next;
        //     }
        //     // Node node = new Node(e, prev.next);
        //     // prev.next = node;
        //     prev.next = new Node(e, prev.next);
        //     size++;
        // }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while(cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node delNode = pre.next;
        pre.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size-1);
    }

    // 从链表中删除元素e
    public void removeElement(E e){
        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.e.equals(e))
                break;
            prev = prev.next;
        }

        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        // Node cur = dummyHead.next;
        // while(cur != null) {
        //    res.append(cur + "->");
        //    cur = cur.next;
        // }
        for (Node cur = dummyHead.next; cur != null; cur=cur.next) {
            res.append(cur + "->");
        }
        res.append("NULL");
        return res.toString();
    }

}
