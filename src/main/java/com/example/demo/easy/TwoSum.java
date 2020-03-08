package com.example.demo.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */

public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {1, 2, 3, 6};
        // int[] result = twoSum.twoSum(nums, 4);
        // int[] result = twoSum.twoSumByMap(nums, 9);
        int[] result = twoSum.twoSumByMapOptimize(nums, 9);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 双层循环
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length <= 1) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }


    /**
     * 借助Map
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumByMap(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length <= 1) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int otherNum = target - nums[i];
            // if (map.get(otherNum) != null) {
            if (map.containsKey(otherNum)) {
                result[0] = map.get(otherNum);
                result[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

    /**
     * 优化
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumByMapOptimize(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int otherNum = target - nums[i];
            if (map.containsKey(otherNum)) {
                return new int[]{map.get(otherNum), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}
