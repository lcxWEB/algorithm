package com.example.problems.datastructure.stackqueue;

import com.example.problems.datastructure.linkedlist.LinkedListQueue;

import java.util.Random;

/**
 * Created by lcx on 2018/10/11.
 */
public class Main {

    private static double testQueue(Queue<Integer> queue, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(opCount);
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("Arrayqueue: " + time1 + "s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>(opCount);
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue: " + time2 + "s");


        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueue(linkedListQueue, opCount);
        System.out.println("LinkedListQueue: " + time3 + "s");
    }
}
