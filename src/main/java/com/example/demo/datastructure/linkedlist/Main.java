package com.example.demo.datastructure.linkedlist;

import com.example.demo.datastructure.stackqueue.ArrayStack;
import com.example.demo.datastructure.stackqueue.Stack;

import java.util.Random;

/**
 * Created by lcx on 2018/10/11.
 */
public class Main {

    private static double testStack(Stack<Integer> stack, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;

    }


    public static void main(String[] args) {

        // LinkedList<Integer> linkedList = new LinkedList<>();
        // for (int i = 0; i< 5; i++) {
        //     linkedList.addFirst(i);
        //     System.out.println(linkedList);
        // }
        // linkedList.add(3, 88);
        // System.out.println(linkedList);
        // linkedList.remove(3);
        // System.out.println(linkedList);
        // System.out.println(linkedList.removeFirst());
        // System.out.println(linkedList);
        // // System.out.println(linkedList.getSize());
        //
        // System.out.println(linkedList.removeLast());
        // System.out.println(linkedList);


        LinkedListStack<Integer> listStack = new LinkedListStack<>();
        //
        // for (int i = 0; i < 5; i++){
        //     listStack.push(i);
        //     System.out.println(listStack);
        // }
        //
        // listStack.pop();
        // System.out.println(listStack);

        int opCount = 10000000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack：" + time1);
        double time2 = testStack(listStack, opCount);
        System.out.println("LinkedListStack：" + time2);

    }
}
