package com.example.demo.nowcoder.company;

import java.util.Scanner;

/**
 * 快手2019年春季校园招聘笔试试题--工程B试卷
 *
 * 思路：
 * 开一个二维数组d[i][j]来记录a0-ai与b0-bj之间的编辑距离，要递推时，需要考虑对其中一个字符串的删除操作、
 * 插入操作和替换操作分别花费的开销，从中找出一个最小的开销即为所求。
 * <p>
 * 具体算法：
 * 首先给定第一行和第一列，然后，每个值d[i,j]这样计算：d[i][j] = min(d[i-1][j]+1,d[i][j-1]+1,d[i-1][j-1]+(s1[i] == s2[j]?0:1));
 * 最后一行，最后一列的那个值就是最小编辑距离
 **/
public class MinimumEditDistance {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine().toLowerCase();
        String str2 = sc.nextLine().toLowerCase();
        int res = minChangeSteps(str1, str2);
        System.out.println(res);
    }

    public static int minChangeSteps(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < s2.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < s1.length(); i++) {
            for (int j = 1; j < s2.length(); j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + 1,
                        Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + (s1.charAt(i) == s2.charAt(j) ? 0 : 1)));
            }
        }
        return dp[s1.length() - 1][s2.length() - 1];
    }

}