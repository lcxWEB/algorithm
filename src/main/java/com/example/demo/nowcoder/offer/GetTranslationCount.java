package com.example.demo.nowcoder.offer;

/**
 * Created by lichunxia on 2020-02-14 14:59
 */
public class GetTranslationCount {

    public static void main(String[] args) {
        int count = new GetTranslationCount().getTranslationCount(1234567);
        System.out.println(count);
    }

    public int getTranslationCount(int number) {
        int count = getTranslationCount(String.valueOf(number));
        return count;
    }

    /**
     * 2.14
     * O(n), O(n)
     * f(i)表示从第i位开始的不同翻译的数目
     * f(i) = f(i+1) + g(i,i+1) * f(i+2)
     * 当第i位和第i+1两位数字拼接起来的数字在10～25范围内时，函数g(i,i+1)的值为1，否则为0
     *
     * @param s
     * @return
     */
    private int getTranslationCount(String s) {
        int length = s.length();
        if (length <= 1) {
            return length;
        }
        int[] counts = new int[length];
        counts[length - 1] = 1;
        int count;
        for (int i = length - 2; i >= 0; i--) {
            // f(i+1)
            count = counts[i + 1];
            // f(i+2)
            int digit1 = s.charAt(i) - '0';
            int digit2 = s.charAt(i + 1) - '0';
            int converted = digit1 * 10 + digit2;
            if (converted >= 10 && converted <= 25) {
                // g(i,i+1) = 1
                if (i < length - 2) {
                    count = count + counts[i + 2];
                } else {
                    count = count + 1;
                }
            }
            counts[i] = count;
        }
        return counts[0];
    }

}
