package com.example.demo.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lichunxia on 2019-09-04 08:59
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum {

    public static void main(String[] args) {
        // int[] nums = {-1, 0, 1, 2, -1, -4, 3, 0};
        int[] nums = {-2,0,0,2,2};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum2(nums);
        System.out.println(lists);
    }

    /**
     * Wrong Answer
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSumW(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3 || nums[0] > 0 || nums[nums.length - 1] < 0) return result;

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0 || (i > 0 && nums[i] == nums[i-1])) continue;
            int l = i + 1;
            int h = nums.length - 1;
            int target = 0 - nums[i];
            while (l < h) {
                if (nums[l] + nums[h] == target) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[h]));
                    l++;
                    h--;
                } else if (nums[l] + nums[h] < target) {
                    l++;
                } else h--;
            }

        }
        return result;
    }

    /**
     * Runtime: 26 ms, faster than 97.42% of Java online submissions for 3Sum.
     * Memory Usage: 48.2 MB, less than 81.27% of Java online submissions for 3Sum.
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3 || nums[0] > 0 || nums[nums.length - 1] < 0) return result;

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0 || (i > 0 && nums[i] == nums[i-1])) continue;
            int l = i + 1;
            int h = nums.length - 1;
            int target = 0 - nums[i];
            while (l < h) {
                if (nums[l] + nums[h] == target) {
                    // 去重
                    if (nums[l] == nums[l - 1] && (h < nums.length - 1 && nums[h] == nums[h + 1])) {
                        l++;
                        h--;
                        continue;
                    }
                    result.add(Arrays.asList(nums[i], nums[l], nums[h]));
                    l++;
                    h--;
                } else if (nums[l] + nums[h] < target) {
                    l++;
                } else h--;
            }

        }
        return result;
    }

    /**
     * Runtime: 27 ms, faster than 94.96% of Java online submissions for 3Sum.
     * Memory Usage: 48 MB, less than 83.04% of Java online submissions for 3Sum.
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3 || nums[0] > 0 || nums[nums.length - 1] < 0) return result;

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0 || (i > 0 && nums[i] == nums[i-1])) continue;
            int l = i + 1;
            int h = nums.length - 1;
            int target = 0 - nums[i];
            while (l < h) {
                if (nums[l] + nums[h] == target) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[h]));
                    while (l < h && nums[l] == nums[l + 1]) l++;
                    while (l < h && nums[h] == nums[h - 1]) h--;
                    l++;
                    h--;
                } else if (nums[l] + nums[h] < target) {
                    l++;
                } else h--;
            }

        }
        return result;
    }

}
