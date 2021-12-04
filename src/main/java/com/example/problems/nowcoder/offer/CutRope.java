package com.example.problems.nowcoder.offer;

/**
 * Created by lichunxia on 2020-02-01 21:28
 * 题目描述
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。
 * 请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class CutRope {

    public static void main(String[] args) {
        int max = new CutRope().cutRopeGreedy(10);
        System.out.println(max);
    }

    /**
     * O(n^2) O(n)
     * @param target
     * @return
     */
    public int cutRope(int target) {
        if (target < 2) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }

        int[] products = new int[target + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;
        // 自下而上基于循环求解问题
        for (int i = 4; i <= target; i++) {
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (product > max) {
                    max = product;
                }
            }
            products[i] = max;
            max = 0;
        }
        max = products[target];
        return max;
    }

    /**
     * O(1) O(1)
     * @param target
     * @return
     */
    public int cutRopeGreedy(int target) {
        if (target < 2) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }

        // 尽可能多地剪去长度为3地段
        int timesOf3 = target / 3;
        // 当剩下绳子长度为4时，不能再剪去3，此时更好的办法是剪成两个2
        // if (target - timesOf3 * 3 == 1) {
        //     timesOf3--;
        // }

        if (target % 3 == 1) {
            timesOf3--;
        }

        int timesOf2 = (target - timesOf3 * 3) / 2;

        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }
}
