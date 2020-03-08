package com.example.demo.nowcoder.offer;

/**
 * Created by lichunxia on 2020-02-02 15:08
 */
public class StrToInt {

    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int result = 0;
        int index = 0;
        boolean minus = false;
        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            minus = true;
            index++;
        }

        while (index < str.length()) {
            char ch = str.charAt(index);

            if (ch >= '0' && ch <= '9') {
                int currentDigit = ch - '0';
                /*
                 * 异常情况4：已经等于Integer.MAX_VALUE / 10，判断要添加的最后一位的情况：
                 * 如果是负数的话，最后一位最大是8 如果是正数的话最后一位最大是7
                 */
                if (result == Integer.MAX_VALUE / 10) {
                    // 2147483647  -2147483648
                    if ((!minus && currentDigit > 7) || (minus && currentDigit > 8)) {
                        return 0;
                    }
                    /*
                     * 异常情况5：已经大于Integer.MAX_VALUE / 10
                     * 无论最后一位是什么都会超过Integer.MAX_VALUE
                     */
                } else if (result > Integer.MAX_VALUE / 10) {
                    return 0;
                }

                result = result * 10 + currentDigit;
                index++;
            } else {
                return 0;
            }
        }
        return minus ? -result : result;
    }

    public int StrToInt1(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        long result = 0;
        int index = 0;
        boolean minus = false;
        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            minus = true;
            index++;
        }

        while (index < str.length()) {
            char ch = str.charAt(index);

            if (ch >= '0' && ch <= '9') {
                int currentDigit = ch - '0';
                result = result * 10 + currentDigit;
                if ((minus && result > 2147483648L) || (!minus && result > 2147483647)) {
                    return 0;
                }
                index++;
            } else {
                return 0;
            }
        }
        return (int) (minus ? -result : result);
    }


}
