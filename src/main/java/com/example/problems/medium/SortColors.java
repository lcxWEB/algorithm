package com.example.problems.medium;

import java.util.Arrays;

/**
 * Created by lichunxia on 2019-09-12 11:18
 *
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 *
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */
public class SortColors {

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] nums = new int[]{2,0,2,1,1,0};
        sortColors.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }


    /**
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
     * Memory Usage: 35.3 MB, less than 99.21% of Java online submissions for Sort Colors.
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else if (nums[i] == 1) {
                oneCount++;
            } else if (nums[i] == 2) {
                twoCount++;
            }
        }
        int i = 0;
        while (i < nums.length) {
           while (zeroCount > 0) {
               nums[i] = 0;
               zeroCount--;
               i++;
           }
           while (oneCount > 0) {
               nums[i] = 1;
               oneCount--;
               i++;
           }
           while (twoCount > 0) {
               nums[i] = 2;
               twoCount--;
               i++;
           }
       }
    }
}
