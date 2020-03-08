package com.example.demo.medium;

/**
 * Created by lichunxia on 2019-09-09 10:30
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 */
public class JumpGame {

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        JumpGame jumpGame = new JumpGame();
        boolean canJump = jumpGame.canJump(nums);
        System.out.println(canJump);
    }

    /**
     *
     * Runtime: 1 ms, faster than 99.23% of Java online submissions for Jump Game.
     * Memory Usage: 39 MB, less than 100.00% of Java online submissions for Jump Game.
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int dis = 0;
        for (int i = 0; i <= dis; i++) {
            dis = Math.max(i + nums[i], dis);
            if (dis >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
