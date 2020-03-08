package com.example.demo.datastructure.maxheap;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Random;

/**
 * @Author: lcx
 * @Date: 2019/1/28 20:45
 * @Description:
 */

public class Test {
    private static double testHeap(Integer[] testData, boolean isHeapify) {
        long startTime = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if (isHeapify) {
            maxHeap = new MaxHeap<>(testData);
        } else {
            maxHeap = new MaxHeap<>();
            for (int num : testData) {
                maxHeap.add(num);
            }
        }

        int[] arr = new int[testData.length];
        for (int i = 0; i < testData.length; i++) {
            arr[i] = maxHeap.extractMax();
        }
        for (int i = 1; i < testData.length; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Test maxHeap complete");
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int n = 1000000;
        // MaxHeap<Integer> maxHeap = new MaxHeap<>();
        // Random random = new Random();
        // for (int i = 0; i < n; i++) {
        //     maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        // }
        //
        // int[] arr = new int[n];
        // for (int i = 0; i < n; i++) {
        //     arr[i] = maxHeap.extractMax();
        // }
        // for (int i = 1; i < n; i++) {
        //     if (arr[i - 1] < arr[i]) {
        //         throw new IllegalArgumentException("Error");
        //     }
        // }
        // System.out.println("Test maxHeap complete");

        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }
        System.out.println(testHeap(testData, false));

        System.out.println(testHeap(testData, true));


        ZoneId shanghaiZoneId = ZoneId.of("Asia/Shanghai");

        System.out.println(Instant.now(Clock.system(shanghaiZoneId)));
    }

}
