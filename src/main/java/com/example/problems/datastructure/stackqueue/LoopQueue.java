package com.example.problems.datastructure.stackqueue;

/**
 * Created by lcx on 2018/10/10.
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity){
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoopQueue: ");
        sb.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length){
            sb.append(data[i]);
            if (i != tail - 1){
                sb.append(", ");
            }
        }
        sb.append("] tail");

        return sb.toString();
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int newCapacity){
        E[] newdata = (E[])new Object[newCapacity + 1];
        for (int i = 0; i < size; i++){
            newdata[i] = data[(front + i) % data.length];
        }
        data = newdata;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        E re = data[front];
        data[front] = null;//lotering
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity() / 2);
        }
        return re;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot an empty queue");
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    public static void main(String[] args){

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0; i < 10; i++){
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
            if (i % 3 == 2){
                loopQueue.dequeue();
                System.out.println(loopQueue);
            }
        }

    }
}
