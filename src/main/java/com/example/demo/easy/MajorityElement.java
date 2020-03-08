package com.example.demo.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lichunxia on 2019-08-29 16:21
 * <p>
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
public class MajorityElement {

    public static void main(String[] args) {
        // int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int[] arr = {3,2,3};
        MajorityElement majorityElement = new MajorityElement();
        int element = majorityElement.majorityElement(arr);
        System.out.println(element);
    }


    /**
     *  第一种解法
     * Runtime: 13 ms, faster than 30.14% of Java online submissions for Majority Element.
     * Memory Usage: 40.9 MB, less than 98.53% of Java online submissions for Majority Element.
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int midLen = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                int times = map.get(nums[i]) + 1;
                if (times > midLen) {
                    return nums[i];
                } else {
                    map.put(nums[i], times);
                }
            }
        }
        return 0;
    }

}
