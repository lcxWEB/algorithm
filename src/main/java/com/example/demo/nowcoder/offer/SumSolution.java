package com.example.demo.nowcoder.offer;

/**
 * Created by lichunxia on 2020-02-02 14:46
 */
public class SumSolution {

    public static void main(String[] args) {
        int sum = new SumSolution().Sum_Solution(2);
        System.out.println(sum);
    }

    public int Sum_Solution(int n) {
        int sum = n;
        boolean b = n > 0 && (sum += Sum_Solution(n - 1)) > 0;
        return sum;
    }
}
