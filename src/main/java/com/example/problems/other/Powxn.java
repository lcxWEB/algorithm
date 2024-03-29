package com.example.problems.other;

/**
 * Created by lichunxia on 2019-09-15 16:53
 *
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 *
 * Example 1:
 *
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 *
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 *
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * Note:
 *
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−231, 231 − 1]
 */
public class Powxn {

    public static void main(String[] args) {
        Powxn powxn = new Powxn();
        powxn.myPow(2, 10);
    }

    /**
     * Time Limit Exceeded
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        double result = 1;
        int cnt = n;
        if (n < 0) {
            cnt = -n;
        }
        for (int i = 0; i < cnt; i++) {
            result = result * x;
        }
        if (n < 0) {
            result = 1 / result;
        }
        return result;
    }

    public double myPowR(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            // ??
            if( n == Integer.MIN_VALUE ) {
                ++n;
                n = -n;
                x = 1 / x;
                return x * x * myPowR( x * x, n / 2 );
            }
            n = -n;
            x = 1 / x;
        }
        return n % 2 == 0 ? myPowR(x * x, n / 2) : x * myPowR(x * x, n / 2);
    }
}
