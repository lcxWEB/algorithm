package com.example.problems.nowcoder.offer;

/**
 * Created by lichunxia on 2020-02-02 14:54
 */
public class Add {

    public int Add(int num1, int num2) {
        int sum, carry;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);
        return sum;
    }

}
