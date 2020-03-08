package com.example.demo.nowcoder.offer;

import java.util.Arrays;

public class RotateArraySolution {

    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) return 0;
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] > array[high]) {
                low = mid + 1;
            } else if (array[mid] == array[high]) {
                high = high - 1;
            } else {
                high = mid;
            }
        }
        return array[low];
    }

    public int minNumberInRotateArray2(int[] array) {
        if (array.length == 0) return 0;
        Arrays.sort(array);
        return array[0];
    }


    public static void main(String[] args) {
        RotateArraySolution arraySolution = new RotateArraySolution();
        int[] arr = new int[]{1, 1, 1, 1, 1};
        System.out.println(arraySolution.minNumberInRotateArray(arr));
        System.out.println(arraySolution.minNumberInRotateArray2(arr));
    }
}
