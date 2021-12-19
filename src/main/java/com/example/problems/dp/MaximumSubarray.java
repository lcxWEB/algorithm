package com.example.problems.dp;

/**
 * Created by lichunxia on 2019-08-27 12:15
 * <p>
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * Example:
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * <p>
 * Follow up:
 * <p>
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

public class MaximumSubarray {

    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int[] nums = {-2, 1, 9, -3, 4, -1, 2, 1, -5, 4};
        int i = maximumSubarray.maxSubArray(nums);
        System.out.println(i);
        int j = maximumSubarray.maxSubArrayDC(nums);
        System.out.println(j);
    }

    /**
     * DP
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Subarray.
     * Memory Usage: 37.6 MB, less than 99.06% of Java online submissions for Maximum Subarray.
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int sum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum < nums[i]) {
                sum = nums[i];
            }
            maxSum = sum > maxSum ? sum : maxSum;
        }
        return maxSum;
    }


    /**
     * Divide and Conquer
     *
     * Runtime: 2 ms, faster than 11.27% of Java online submissions for Maximum Subarray.
     * Memory Usage: 41.9 MB, less than 5.16% of Java online submissions for Maximum Subarray.
     *
     * @param nums
     * @return
     */
    public int maxSubArrayDC(int[] nums) {
        if (nums.length == 0) return 0;
        return helper(nums, 0, nums.length - 1);
    }

    public int helper(int[] nums, int left, int right) {
        if (left >= right) return nums[left];
        int mid = left + (right - left) / 2;
        int lmax = helper(nums, left, mid - 1);
        int rmax = helper(nums, mid + 1, right);
        int mmax = nums[mid], t = mmax;
        for (int i = mid - 1; i >= left; --i) {
            t += nums[i];
            mmax = Math.max(mmax, t);
        }
        t = mmax;
        for (int i = mid + 1; i <= right; ++i) {
            t += nums[i];
            mmax = Math.max(mmax, t);
        }
        return Math.max(mmax, Math.max(lmax, rmax));
    }
}
