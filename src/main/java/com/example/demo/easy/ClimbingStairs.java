package com.example.demo.easy;

/**
 * Created by lichunxia on 2019-08-27 22:02
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        int i = climbingStairs.climbStairs(45);
        System.out.println(i);
    }

    /**
     * 第一种解法
     * Time Limit Exceeded
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }
        int result = climbStairs(n - 1) + climbStairs(n - 2);
        return result;
    }
}
