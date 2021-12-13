package com.example.problems.greedy;

/**
 * @author: lichunxia
 * @create: 12/13/21 10:36 PM
 */
public class JumpGameII {

    public int jump(int[] nums) {
        if(nums == null) {
            return 0;
        }
        if(nums.length == 1) {
            return 0;
        }
        int newMax = 0, maxi = 0, step = 0;
        for(int i = 0; i < nums.length; i++) {
            newMax = Math.max(newMax, i + nums[i]);
            if(i == maxi) {
                step++;
                maxi = newMax;
                if(maxi >= nums.length - 1) {
                    break;
                }
            }
        }
        return step;
    }
}
