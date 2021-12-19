package com.example.problems.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lichunxia on 2019-08-30 09:01
 * <p>
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 * <p>
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeroes {

    public static void main(String[] args) {
        // int[] nums = {0, 1, 0, 3, 12};
        int[] nums = { 0};
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 第一种解法
     * Runtime: 2 ms, faster than 15.95% of Java online submissions for Move Zeroes.
     * Memory Usage: 37.9 MB, less than 94.41% of Java online submissions for Move Zeroes.
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        Map<Integer, Integer> map = new HashMap<>();
        // 0的数量
        int numOfZeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                map.put(i, numOfZeros);
            } else {
                numOfZeros++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            Integer integer = map.get(i);
            if (integer != null) {
                nums[i - integer] = nums[i];
            }
            if (i >= nums.length - numOfZeros) {
                nums[i] = 0;
            }
        }
    }




}
