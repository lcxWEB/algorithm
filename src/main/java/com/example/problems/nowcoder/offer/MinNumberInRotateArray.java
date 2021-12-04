package com.example.problems.nowcoder.offer;

import java.util.Scanner;

/**
 * Created by lichunxia on 2020-02-06 20:16
 */
public class MinNumberInRotateArray {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 1, 2, 2, 2, 2, 2};
        int min = new MinNumberInRotateArray().minNumberInRotateArray(arr);
        System.out.println(min);
    }


    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int low = 0;
        int high = array.length - 1;
        if (array[low] < array[high]) {
            return array[low];
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] < array[high]) {
                // 说明最小数在前半段，也可能当前位置就是最小数。所以 high = mid，而不能是 mid - 1;
                high = mid;
            } else if (array[mid] > array[high]) {
                // 说明最小数在后半段。
                low = mid + 1;
            } else {
                high = high - 1;
            }
        }
        return array[low];
    }


    class Main {
        public void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            String[] nums = str.split(" ");
            int[] array = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                array[i] = Integer.parseInt(nums[i]);
            }
            System.out.println(searchInRotateArray(array));
        }

        public int searchInRotateArray(int[] array) {
            if (array == null || array.length == 0) {
                return 0;
            }
            int left = 0;
            int right = array.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                int midNum = array[mid];
                if (midNum > array[right]) {
                    left = mid + 1;
                } else if (midNum < array[right]) {
                    right = mid;
                } else {
                    right = right - 1;
                }
            }
            return array[left];
        }
    }
}