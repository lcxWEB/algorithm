package com.example.demo.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lichunxia on 2019-09-02 12:31
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 */
public class FindAllNumbersDisappeared {

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        FindAllNumbersDisappeared findAllNumbersDisappeared = new FindAllNumbersDisappeared();
        List<Integer> disappearedNumbers = findAllNumbersDisappeared.findDisappearedNumbers(nums);
        System.out.println(disappearedNumbers);
    }

    /**
     * Runtime: 6 ms, faster than 79.84% of Java online submissions for Find All Numbers Disappeared in an Array.
     * Memory Usage: 47 MB, less than 94.34% of Java online submissions for Find All Numbers Disappeared in an Array.
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i+1) {
                int temp = nums[nums[i] - 1];
                if (temp != nums[i]) {
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;
                } else {
                    break;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {
                result.add(i+1);
            }
        }
        return result;
    }

}
