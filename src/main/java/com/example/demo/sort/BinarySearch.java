package com.example.demo.sort;

import com.example.demo.assistant.RandomUtil;

import java.util.Arrays;

/**
 * Created by lichunxia on 2020-02-07 13:33
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = RandomUtil.randomArray(100, 99);
        new MergeSort().mergeSort(array);
        System.out.println(Arrays.toString(array));
        binarySearch(array, 8);
        System.out.println(Arrays.toString(array));
    }

    private static void binarySearch(int[] arr, int target) {
        int loc = binarySearchWhile(arr, 0, arr.length - 1, target);
        System.out.println(loc);
        loc = binarySearchRecurse(arr, 0, arr.length - 1, target);
        System.out.println(loc);
    }

    private static int binarySearchRecurse(int[] arr, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] > target) {
            return binarySearchRecurse(arr, start, mid - 1, target);
        }
        if (arr[mid] < target) {
            return binarySearchRecurse(arr, mid + 1, end, target);
        }
        return mid;
    }

    private static int binarySearchWhile(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
