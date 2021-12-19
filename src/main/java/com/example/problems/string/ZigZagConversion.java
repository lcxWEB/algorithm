package com.example.problems.string;

/**
 * Created by lichunxia on 2020-02-15 20:24
 */
public class ZigZagConversion {


    public String convert(String s, int nRows) {
        int len = s.length();
        if (len == 0 || nRows <= 1) return s;

        StringBuilder[] ans = new StringBuilder[nRows];
        for (int i = 0; i < nRows; i++) {
            ans[i] = new StringBuilder();
        }
        int row = 0, delta = 1;
        for (int i = 0; i < len; i++) {
            ans[row].append(s.charAt(i));
            row += delta;
            if (row >= nRows) {
                row = nRows - 2;
                delta = -1;
            }
            if (row < 0) {
                row = 1;
                delta = 1;
            }
        }

        for (int i = 1; i < nRows; i++) {
            ans[0].append(ans[i]);
        }
        return ans[0].toString();
    }

}
