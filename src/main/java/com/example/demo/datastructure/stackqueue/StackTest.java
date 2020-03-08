package com.example.demo.datastructure.stackqueue;

/**
 * Created by lcx on 2018/10/9.
 */
public class StackTest {

    public static void main(String[] args){

        ArrayStack<Integer> arrayStack = new ArrayStack<>();

        for (int i = 0; i < 5; i++){
            arrayStack.push(i);
        }

        System.out.println(arrayStack);
        arrayStack.pop();
        System.out.println(arrayStack);


    }
}
