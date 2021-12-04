package com.example.problems.hard;

/**
 * Created by lichunxia on 2020-02-15 16:17
 */
public class RegularExpressionMatching {

    private Boolean[][] memo;

    public static void main(String[] args) {
        RegularExpressionMatching matching = new RegularExpressionMatching();
        boolean match = matching.isMatch("aa", "a*");
        System.out.println(match);
        match = matching.isMatchDP("aa", "a*");
        System.out.println(match);
    }

    /**
     * 2.15
     * 动态规划，自底向上
     * Runtime: 4 ms, faster than 60.18% of Java online submissions for Regular Expression Matching.
     * Memory Usage: 38.2 MB, less than 47.47% of Java online submissions for Regular Expression Matching.
     *
     * @param text
     * @param pattern
     * @return
     */
    public boolean isMatchDPBottomToTop(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
                boolean firstMatch = (i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || firstMatch && dp[i + 1][j];
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    /**
     * 2.15
     * 动态规划，自顶向下
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Regular Expression Matching.
     * Memory Usage: 38.4 MB, less than 46.46% of Java online submissions for Regular Expression Matching.
     *
     * @param text
     * @param pattern
     * @return
     */
    public boolean isMatchDP(String text, String pattern) {
        memo = new Boolean[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }

    public boolean dp(int i, int j, String text, String pattern) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        boolean ans;
        if (j == pattern.length()) {
            ans = i == text.length();
        } else {
            boolean firstMatch = (i < text.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
            if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                ans = (dp(i, j + 2, text, pattern) ||
                        firstMatch && dp(i + 1, j, text, pattern));
            } else {
                ans = firstMatch && dp(i + 1, j + 1, text, pattern);
            }
        }
        memo[i][j] = ans;
        return ans;
    }

    /**
     * 2.15
     * Runtime: 68 ms, faster than 13.47% of Java online submissions for Regular Expression Matching.
     * Memory Usage: 42 MB, less than 32.32% of Java online submissions for Regular Expression Matching.
     *
     * @param text
     * @param pattern
     * @return
     */
    public boolean isMatch1(String text, String pattern) {
        //如果都为空则匹配成功
        if (pattern.isEmpty()) return text.isEmpty();

        //第一个是否匹配上
        boolean firstMatch = (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            // 看有没有可能,剩下的pattern匹配上全部的text
            // 看有没有可能,剩下的text匹配整个pattern
            // isMatch(text, pattern.substring(2)) 指当p第二个为*时，前面的字符不影响匹配所以可以忽略，
            // 所以将*以及*之前的一个字符删除后匹配之后的字符，这就是为什么用pattern.substring(2)
            // 如果第一个已经匹配成功，并且第二个字符为*时，这是我们就要判断之后的需要匹配的字符串是否是多个前面的元素（*的功能），
            // 这就是first_match && isMatch(text.substring(1), pattern))的意义
            return (isMatch1(text, pattern.substring(2)) ||
                    (firstMatch && isMatch1(text.substring(1), pattern)));
        } else {
            //没有星星的情况:第一个字符相等,而且剩下的text,匹配上剩下的pattern，没有星星且第一个匹配成功，那么s和p同时向右移动一位看是否仍然能匹配成功
            return firstMatch && isMatch1(text.substring(1), pattern.substring(1));
        }
    }

    /**
     * 2.15
     * Runtime: 1579 ms, faster than 5.02% of Java online submissions for Regular Expression Matching.
     * Memory Usage: 38 MB, less than 47.47% of Java online submissions for Regular Expression Matching.
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int sIndex = 0;
        int pIndex = 0;
        return isMatch(s, sIndex, p, pIndex);
    }

    private boolean isMatch(String s, int sIndex, String p, int pIndex) {
        if (sIndex == s.length() && pIndex == p.length()) {
            return true;
        }
        if (sIndex < s.length() && pIndex == p.length()) {
            return false;
        }
        // 下一个是*
        if (pIndex < p.length() - 1 && p.charAt(pIndex + 1) == '*') {
            // 如果当前匹配
            if (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.') {
                return isMatch(s, sIndex + 1, p, pIndex + 2) // 匹配一个 *
                        || isMatch(s, sIndex + 1, p, pIndex) // 匹配多个 *
                        || isMatch(s, sIndex, p, pIndex + 2); // 不匹配 *
            } else {
                return isMatch(s, sIndex, p, pIndex + 2);// 不匹配
            }
        }
        // 下一个不是*，看当前是否匹配
        if ((sIndex < s.length() && s.charAt(sIndex) == p.charAt(pIndex))
                || (sIndex < s.length() && p.charAt(pIndex) == '.')) {
            return isMatch(s, sIndex + 1, p, pIndex + 1);
        }
        return false;
    }

}
