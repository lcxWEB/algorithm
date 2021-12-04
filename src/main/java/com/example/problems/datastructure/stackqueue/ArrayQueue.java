package com.example.problems.datastructure.stackqueue;

/**
 * Created by lcx on 2018/10/10.
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity){
        array = new Array<E>(capacity);
    }


    public ArrayQueue(){
        array = new Array<E>();
    }


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("ArrayQueue: ");
        sb.append("front [");
        for (int i = 0; i < array.getSize(); i++){
            sb.append(array.get(i));
            if (i != array.getSize()-1){
                sb.append(", ");
            }
        }
        sb.append("] tail");

        return sb.toString();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }


    @Override
    public E dequeue() {
       return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    public static void main(String[] args){

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
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
