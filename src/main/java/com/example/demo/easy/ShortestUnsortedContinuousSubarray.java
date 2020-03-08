package com.example.demo.easy;


/**
 * Created by lichunxia on 2019-09-02 19:43
 *
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 *
 * You need to find the shortest such subarray and output its length.
 *
 * Example 1:
 *
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * Note:
 *
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 */
public class ShortestUnsortedContinuousSubarray {

    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        ShortestUnsortedContinuousSubarray subarray = new ShortestUnsortedContinuousSubarray();
        int unsortedSubarray = subarray.findUnsortedSubarray(nums);
        System.out.println(unsortedSubarray);
    }

    /**
     *
     * Runtime: 998 ms, faster than 5.00% of Java online submissions for Shortest Unsorted Continuous Subarray.
     * Memory Usage: 49.7 MB, less than 7.69% of Java online submissions for Shortest Unsorted Continuous Subarray.
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    r = Math.max(r, j);
                    l = Math.min(l, i);
                }
            }
        }
        return r - l < 0 ? 0 : r - l + 1;
    }
}
