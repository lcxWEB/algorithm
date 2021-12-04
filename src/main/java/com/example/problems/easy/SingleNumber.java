package com.example.problems.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lichunxia on 2019-08-28 15:22
 * <p>
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,1]
 * Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input: [4,1,2,1,2]
 * Output: 4
 */


public class SingleNumber {

    public static void main(String[] args) {
        int[] arr = {4,1,2,1,2};
        // int[] arr = {2, 2, 1};
        SingleNumber singleNumber = new SingleNumber();
        int number = singleNumber.singleNumberW(arr);
        System.out.println(number);
    }

    /**
     * 自己想的
     * Runtime: 8 ms, faster than 20.36% of Java online submissions for Single Number.
     * Memory Usage: 40.3 MB, less than 91.85% of Java online submissions for Single Number.
     *
     * @param nums
     * @return
     */
    public int singleNumberW(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                set.remove(nums[i]);
            }
        }
        Object[] objects = set.toArray();
        return (int) objects[0];
    }


    public int singleNumber(int[] nums) {

        return 0;
    }

}
