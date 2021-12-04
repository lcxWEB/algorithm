package com.example.problems.nowcoder.offer;

/**
 * Created by lichunxia on 2020-01-27 21:13
 */
public class NumberOf1Between1AndN {

    public int NumberOf1Between1AndN_Solution(int n) {

        if(n <= 0)
            return 0;
        int count = 0;
        for(long i = 1; i <= n; i *= 10){
            long diviver = i * 10;
            count += (n / diviver) * i + Math.min(Math.max(n % diviver - i + 1, 0), i);
        }
        return count;

    }
}
