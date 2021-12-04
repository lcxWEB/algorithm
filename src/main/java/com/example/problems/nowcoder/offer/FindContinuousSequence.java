package com.example.problems.nowcoder.offer;

import java.util.ArrayList;

/**
 * Created by lichunxia on 2020-01-30 19:13
 */
public class FindContinuousSequence {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = new FindContinuousSequence().FindContinuousSequence(10);
        System.out.println(result);
    }

    /**
     * 2.13
     *
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence213(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum <= 2) {
            return result;
        }
        // 双指针
        int small = 1;
        int big = 2;
        int cur = small + big;
        int mid = (sum + 1) / 2;
        // 循环结束条件
        while (small < mid) {
            if (cur > sum) {
                cur = cur - small;
                small++;
            } else if (cur == sum) {
                ArrayList<Integer> seq = new ArrayList<>();
                for (int i = small; i <= big; i++) {
                    seq.add(i);
                }
                result.add(seq);
                big++;
                cur = cur - small + big;
                small++;
            } else {
                big++;
                cur = cur + big;
            }
        }
        return result;
    }


    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int low = 1, high = 2;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while (high > low) {
            int tempSum = (low + high) * (high - low + 1) / 2;
            if (tempSum == sum) {
                ArrayList<Integer> res = new ArrayList<>();
                for (int i = low; i <= high; i++) {
                    res.add(i);
                }
                result.add(res);
                low++;
                // high++; //也可以
            } else if (tempSum > sum) {
                low++;
            } else {
                high++;
            }
        }
        return result;
    }

}
