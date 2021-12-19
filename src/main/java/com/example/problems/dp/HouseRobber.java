package com.example.problems.dp;

/**
 * Created by lichunxia on 2019-08-29 16:36
 * <p>
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * <p>
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class HouseRobber {

    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 2};
        HouseRobber houseRobber = new HouseRobber();
        int rob = houseRobber.rob(arr);
        System.out.println(rob);
    }

    /**
     * Wrong Answer
     *
     * @param nums
     * @return
     */
    public int robWrong(int[] nums) {
        // if (nums.length == 1) {
        //     return nums[0];
        // }
        int oddNum = 0;
        int num = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            oddNum = oddNum + nums[i];
        }
        for (int i = 1; i < nums.length; i = i + 2) {
            num = num + nums[i];
        }

        return oddNum > num ? oddNum : num;
    }


    /**
     * 动态规划
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber.
     * Memory Usage: 34 MB, less than 100.00% of Java online submissions for House Robber.
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // if (nums.length == 2) {
        //     return Math.max(nums[0], nums[1]);
        // }
        int previous = nums[0];
        int current = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = current;
            current = Math.max(previous + nums[i], current);
            previous = temp;
        }
        return current;
    }


}
