package com.example.problems.datastructure.stackqueue;

/**
 * Created by lcx on 2018/10/8.
 */
public class Array<E> {

    private E[] data;
    private int size;

    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    public Array(){
        this(10);
    }

    public Array(E[] arr){
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = data.length;
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addLast(E e){
//        if(size == data.length){
//            throw new IllegalArgumentException("array is full");
//        }
//        data[size] = e;
//        size++;
        add(size, e);
    }

    public void addFirst(E e){
        add(0, e);
    }

    public void add(int index, E e){

        if (index < 0 || index > size){
            throw new IllegalArgumentException("index illegal");
        }

        if(size == data.length){
            resize(2 * data.length);
        }
        for (int i = size-1; i>=index; i--)
            data[i+1] = data[i];
        data[index] = e;
        size++;
    }


    public E get(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("index illegal");
        }
        return data[index];
    }

    public E getLast(){
        return get(size-1);
    }

    public E getFirst(){
        return get(0);
    }


    public void set(int index, E e){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("index illegal");
        }
        data[index] = e;
    }

    public boolean contains(E e){
        for (int i = 0; i < size; i++){
//            if (data[i] == e)
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    public int find(E e){
        for (int i = 0; i < size; i++){
//            if (data[i] == e)
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    public E remove(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("index illegal");
        }
        E res = data[index];
        for (int i = index+1; i < size; i++){
            data[i-1] = data[i];
        }
        size--;
        data[size] = null;

        if (size == data.length / 4 && data.length / 2 !=0)
            resize(data.length / 2);
        return res;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    public void removeElement(E e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size){
            throw new IllegalArgumentException("index illegal");
        }
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size = %d, capacity = %d\n", size, data.length) );
        res.append('[');
        for (int i = 0; i < size; i++){
            res.append(data[i]);
            if (i != size-1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;

    }

}
