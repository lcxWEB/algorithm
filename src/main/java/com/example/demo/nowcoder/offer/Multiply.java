package com.example.demo.nowcoder.offer;

/**
 * Created by lichunxia on 2020-02-02 13:21
 */
public class Multiply {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6};
        int[] multiply = new Multiply().multiply(A);
        for (int num : multiply) {
            System.out.println(num);
        }
    }


    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        int[] result = new int[A.length];
        result[0] = 1;
        //计算下三角连乘
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] * A [i - 1];
        }

        //计算上三角
        int temp = 1;
        for (int i = result.length - 2; i >= 0 ; i--) {
            temp = temp * A[i + 1];
            result[i] = result[i] * temp;
        }

        return result;
    }

}
