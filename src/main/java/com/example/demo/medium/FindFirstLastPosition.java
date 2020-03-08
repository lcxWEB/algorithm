package com.example.demo.medium;

import java.util.Arrays;

/**
 * Created by lichunxia on 2019-09-06 14:42
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 */
public class FindFirstLastPosition {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        // int[] nums = {5};
        FindFirstLastPosition findFirstLastPosition = new FindFirstLastPosition();
        int[] range = findFirstLastPosition.searchRange(nums, 10);
        System.out.println(Arrays.toString(range));
    }

    /**
     * O(n)
     * Runtime: 1 ms, faster than 14.54% of Java online submissions for Find First and Last Position of Element in Sorted Array.
     * Memory Usage: 42.7 MB, less than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = {nums.length, nums.length};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (result[0] == nums.length) {
                    result[0] = i;
                } else {
                    result[1] = i;
                }
            }
        }
        // if (nums.length == 1) {
        //     for (int i = 0; i < result.length; i++) {
        //         if (result[i] == nums.length && result[0] == 0) {
        //             result[i] = 0;
        //         } else if (result[i] == nums.length){
        //             result[i] = -1;
        //         }
        //     }
        // } else {
            for (int i = 0; i < result.length; i++) {
                if (result[i] == nums.length) {
                    if (result[0] != nums.length) {
                        result[i] = result[0];
                    } else {
                        result[i] = -1;
                    }
                }
            }
        // }
        return result;
    }
}
