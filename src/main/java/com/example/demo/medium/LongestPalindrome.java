package com.example.demo.medium;

/**
 * Created by lichunxia on 2019-08-26 22:50
 * <p>
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 */

public class LongestPalindrome {

    private int low, maxLen;

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String palindrome = longestPalindrome.longestPalindrome215("acdc");
        System.out.println(palindrome);
    }

    /**
     * 2.15
     * O(n^2), O(1)
     * Expand Around Center
     * Runtime: 23 ms, faster than 63.02% of Java online submissions for Longest Palindromic Substring.
     * Memory Usage: 37.6 MB, less than 57.66% of Java online submissions for Longest Palindromic Substring.
     *
     * @param s
     * @return
     */
    public String longestPalindrome215(String s) {
        if (s == null) {
            return null;
        }
        int len = s.length();
        if (len < 2) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            // 假设长度是奇数
            extendPalindrome(s, i, i);
            // 假设长度是偶数
            extendPalindrome(s, i, i + 1);
        }
        return s.substring(low, low + maxLen);
    }


    private void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (maxLen < right - left - 1) {
            maxLen = right - left - 1;
            low = left + 1;
        }
    }

    /**
     * 第一种解法
     * Time Limit Exceeded
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        String result = null;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > i; j--) {
                String sub = s.substring(i, j);
                boolean isPalindrome = true;
                for (int k = 0; k < sub.length(); k++) {
                    char l = sub.charAt(k);
                    char r = sub.charAt(sub.length() - 1 - k);
                    if (l != r) {
                        isPalindrome = false;
                        break;
                    }
                }
                if (isPalindrome) {
                    if (result == null) {
                        result = sub;
                    } else {
                        result = result.length() > sub.length() ? result : sub;
                    }
                }
            }
        }
        return result;
    }

}
