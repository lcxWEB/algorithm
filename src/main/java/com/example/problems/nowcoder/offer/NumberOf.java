package com.example.problems.nowcoder.offer;

public class NumberOf {


    public static void main(String[] args) {
        NumberOf numberOf = new NumberOf();
        System.out.println(numberOf.NumberOf1(1));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(1073741824 * 2);
//        System.out.println(numberOf.NumberOf1(3));
//        System.out.println(numberOf.NumberOf1(0));
//        System.out.println(numberOf.NumberOf1(-1));
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(1073741824));
        System.out.println(Integer.toBinaryString(-2147483648));
        System.out.println(numberOf.NumberOf1(12222));
        System.out.println(numberOf.NumberOf12(12222));
    }

    public int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((flag & n) != 0) {
                count++;
            }
            flag = flag << 1;
            // System.out.println(flag);
        }
        return count;
    }

    public int NumberOf12(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

}
