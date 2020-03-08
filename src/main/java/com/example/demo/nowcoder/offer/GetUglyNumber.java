package com.example.demo.nowcoder.offer;

/**
 * Created by lichunxia on 2020-01-28 11:36
 */
public class GetUglyNumber {

    public static void main(String[] args) {
        int i = new GetUglyNumber().GetUglyNumber_Solution2(1500);
        System.out.println(i);
    }

    /**
     * 2.12
     * 空间换时间
     *
     * @param index
     * @return
     */
    public int GetUglyNumber212(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] uglyNums = new int[index];
        uglyNums[0] = 1;
        // 该位置及之后的数 * 2 或 3 或 5 都大于当前数组的最大丑数
        int t2 = 0, t3 = 0, t5 = 0;
        int i = 1;
        while (i < index) {
            int num2 = uglyNums[t2];
            int num3 = uglyNums[t3];
            int num5 = uglyNums[t5];
            int min = Math.min(num2 * 2, Math.min(num3 * 3, num5 * 5));
            uglyNums[i] = min;
            if (min == num2 * 2) {
                t2++;
            }
            if (min == num3 * 3) {
                t3++;
            }
            if (min == num5 * 5) {
                t5++;
            }
            i++;
        }
        return uglyNums[index - 1];
    }

    /**
     * 解法一
     *
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) return 0;
        int i = 0;
        int n = 0;
        while (i < index) {
            n++;
            if (isUgly(n)) {
                i++;
            }
        }
        return n;
    }

    private boolean isUgly(int num) {
        while (num % 2 == 0) {
            num = num / 2;
        }
        while (num % 3 == 0) {
            num = num / 3;
        }
        while (num % 5 == 0) {
            num = num / 5;
        }
        return num == 1 ? true : false;
    }


    /**
     * 解法二
     *
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution2(int index) {
        if (index <= 0) return 0;
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0, i = 1;
        while (i < index) {
            int min = Math.min(uglyNumbers[t2] * 2, Math.min(uglyNumbers[t3] * 3, uglyNumbers[t5] * 5));
            uglyNumbers[i] = min;
            if (min == uglyNumbers[t2] * 2) t2++;
            if (min == uglyNumbers[t3] * 3) t3++;
            if (min == uglyNumbers[t5] * 5) t5++;
            i++;
        }
        return uglyNumbers[index - 1];
    }


}
