package com.example.problems.greedy;

/**
 * @author: lichunxia
 * @create: 12/13/21 10:36 PM
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        int dis = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > dis) {
                break;
            }
            dis = Math.max(dis, i + nums[i]);
            if (dis >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

}
