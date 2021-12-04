package com.example.problems.nowcoder.offer;

public class PowerSolution {


    public static void main(String[] args) {
        PowerSolution ps = new PowerSolution();
        double result = ps.Power(10.11, 999);
        System.out.println(result);
    }

    public double Power(double base, int exponent) {
        if (base == 0 && exponent < 0) {
            throw new RuntimeException("分母不能为0");
        }
        double result = 1;
        for (int i = 0; i < Math.abs(exponent); i++) {
            result *= base;
        }

        if (exponent < 0) {
            result = 1 / result;
        }
        return result;
    }

    public double Power2(double base, int exponent) {
        double result = 1, cur = base;
        int n;
        if (exponent > 0) {
            n = exponent;
        } else if (exponent < 0) {
            if (base == 0) {
                throw new RuntimeException("分母不能为0");
            }
            n = -exponent;
        } else {
            return 1;
        }
        while (n != 0) {
            if ((n & 1) == 1) {
                result *= cur;
            }
            cur *= cur;
            n >>= 1;
        }
        return exponent > 0 ? result : 1 / result;
    }
}
