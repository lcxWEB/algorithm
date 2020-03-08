package com.example.demo.nowcoder.offer;

/**
 * Created by lichunxia on 2020-02-02 16:16
 */
public class IsNumeric {

    private int index = 0;

    public boolean isNumeric(char[] str) {
        if (str == null || str.length < 1) {
            return false;
        }

        boolean flag = scanInteger(str);

        if (index < str.length && str[index] == '.') {
            index++;
            // 小数可以没有整数部分
            // 小数点后面可以没有数字
            // 小数点前面和后面都可以有数字
            flag = scanUnsignedInteger(str) || flag;
        }

        if (index < str.length && (str[index] == 'E' || str[index] == 'e')) {
            index++;
            // e|E 前面没有数字，不能表示数字
            // e|E 后面没有整数，不能表示数字
            flag = flag && scanInteger(str);
        }

        return flag && index == str.length;

    }


    private boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-') )
            index++;
        return scanUnsignedInteger(str);

    }

    private boolean scanUnsignedInteger(char[] str) {
        int start = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9')
            index++;
        return start < index; //是否存在整数
    }

}


