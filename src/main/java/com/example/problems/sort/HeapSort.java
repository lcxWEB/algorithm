package com.example.problems.sort;

import java.util.Arrays;

/**
 * Created by lichunxia on 2020-02-06 14:27
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        // arr = new int[]{6, 5, 4, 3, 2, 1};
        new HeapSort().heapSort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println(System.currentTimeMillis() / 1000);
    }

    private void heapSort(int[] arr) {
        int beginIndex = arr.length / 2 - 1;
        int lastIndex = arr.length - 1;
        /*
         *  第一步：将数组堆化
         *  beginIndex = 第一个非叶子节点。
         *  从第一个非叶子节点开始即可。无需从最后一个叶子节点开始。
         *  叶子节点可以看作已符合堆要求的节点，根节点就是它自己且自己以下值为最大。
         */
        for (int i = beginIndex; i >= 0; i--) {
            // buildMaxHeap(arr, i, lastIndex);
            buileMinHeapRecursively(arr, i, lastIndex);
        }
        /*
         * 第二步：对堆化数据排序
         * 每次都是移出最顶层的根节点A[0]，与最尾部节点位置调换，同时遍历长度 - 1。
         * 然后从新整理被换到根节点的末尾元素，使其符合堆的特性。
         * 直至未排序的堆长度为 0。
         */
        for (int i = lastIndex; i > 0; i--) {
            swap(arr, 0, i);
            // buildMaxHeap(arr, 0, i - 1);
            buileMinHeapRecursively(arr, 0, i - 1);
        }

    }

    /**
     * 调整索引为 index 处的数据，使其符合堆的特性。
     *
     * @param arr
     * @param index     需要堆化处理的数据的索引
     * @param lastIndex 未排序的堆（数组）的最后索引
     */
    private void buildMaxHeapRecursively(int[] arr, int index, int lastIndex) {
        // 左孩子索引
        int left = index * 2 + 1;
        if (left > lastIndex) {
            return;
        }
        int right = left + 1;
        int maxIndex = left;
        if (right <= lastIndex && arr[right] > arr[left]) {
            maxIndex = right;
        }
        if (arr[index] < arr[maxIndex]) {
            swap(arr, index, maxIndex); // 如果父节点被子节点调换，
            buildMaxHeapRecursively(arr, maxIndex, lastIndex); // 则需要继续判断换下后的父节点是否符合堆的特性。
        }
    }


    /**
     * 调整索引为 index 处的数据，使其符合堆的特性。
     *
     * @param arr
     * @param index
     * @param lastIndex
     */
    private void buildMaxHeap(int[] arr, int index, int lastIndex) {
        // // 左孩子索引
        // int left = index * 2 + 1;
        // int temp = arr[index];
        // while (left <= lastIndex) {
        //     int right = left + 1;
        //     int maxIndex = left;
        //     if (right <= lastIndex && arr[right] > arr[left]) {
        //         maxIndex = right;
        //         left++;
        //     }
        //     if (arr[index] < arr[left]) {
        //         arr[index] = arr[left];
        //         index = left;
        //         left = 2 * left + 1;
        //     } else break;
        // }
        // arr[index] = temp;

        int k = index, temp = arr[index], maxIndex = 2 * k + 1;
        while (maxIndex <= lastIndex) {
            if (maxIndex + 1 <= lastIndex) {
                if (arr[maxIndex] < arr[maxIndex + 1]) {
                    maxIndex = maxIndex + 1;
                }
            }
            if (arr[maxIndex] > temp) {
                arr[k] = arr[maxIndex];
                k = maxIndex;
                maxIndex = 2 * k + 1;
            } else {
                break;
            }
        }
        arr[k] = temp;
    }


    private void buileMinHeapRecursively(int[] arr, int index, int lastIndex) {
        // 左孩子索引
        int left = index * 2 + 1;
        if (left > lastIndex) {
            return;
        }
        int right = left + 1;
        int minIndex = left;
        if (right <= lastIndex && arr[right] < arr[left]) {
            minIndex = right;
        }
        if (arr[index] > arr[minIndex]) {
            swap(arr, index, minIndex); // 如果父节点被子节点调换，
            buileMinHeapRecursively(arr, minIndex, lastIndex); // 则需要继续判断换下后的父节点是否符合堆的特性。
        }
    }

    private void swap(int[] array, int m, int n) {
        int temp = array[m];
        array[m] = array[n];
        array[n] = temp;
    }
}
