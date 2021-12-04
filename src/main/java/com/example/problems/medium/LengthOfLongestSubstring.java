package com.example.problems.medium;

import java.util.*;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class LengthOfLongestSubstring {

    private int maxLength;

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        int result = lengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew");
        result = lengthOfLongestSubstring.lengthOfLongestSubstringOp("1");
        result = lengthOfLongestSubstring.lengthOfLongestSubstring214("adbccba");
        System.out.println(result);
        result = lengthOfLongestSubstring.lengthOfLongestSubstringTwoPointer("adbccba");
        System.out.println(result);
    }

    /**
     * 2.15
     * Runtime: 2 ms, faster than 99.85% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 39.6 MB, less than 13.69% of Java online submissions for Longest Substring Without Repeating Characters.
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringTwoPointer(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] position = new int[256];
        for (int i = 0; i < 256; i++) {
            position[i] = -1;
        }
        int maxLength = 0;
        for (int i = 0, j = -1; i < s.length(); i++) {
            if (position[s.charAt(i)] > -1) {
                // 窗口之间是不重复的字符
                // j 指向当前窗口的左侧，上次出现该字符的位置 或者 当前值，初始值是-1
                j = Math.max(j, position[s.charAt(i)]);
            }
            position[s.charAt(i)] = i;
            maxLength = Math.max(maxLength, i - j);
        }
        return maxLength;
    }

    /**
     * 2.14
     * hashmap 改为 数组
     * Runtime: 2 ms, faster than 99.85% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 40.1 MB, less than 9.68% of Java online submissions for Longest Substring Without Repeating Characters.
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringArray(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int[] position = new int[256];
        for (int i = 0; i < 256; i++) {
            position[i] = -1;
        }
        int curLength = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int preIndex = position[s.charAt(i)];
            if (preIndex < 0 || i - preIndex > curLength) {
                curLength++;
            } else {
                curLength = i - preIndex;
            }
            if (curLength > maxLength) {
                maxLength = curLength;
            }
            position[s.charAt(i)] = i;
        }
        return maxLength;
    }

    /**
     * 2.14
     * Runtime: 7 ms, faster than 76.72% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 41.9 MB, less than 5.20% of Java online submissions for Longest Substring Without Repeating Characters.
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring214(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        Map<Character, Integer> position = new HashMap<>();
        int curLength = 0;
        int maxLength = 0;
        // s.toCharArray() 很耗时
        for (int i = 0; i < s.length(); i++) {
            int preIndex = -1;
            if (position.get(s.charAt(i)) != null) {
                preIndex = position.get(s.charAt(i));
            }
            if (preIndex < 0 || i - preIndex > curLength) {
                curLength++;
            } else {
                curLength = i - preIndex;
            }
            if (curLength > maxLength) {
                maxLength = curLength;
            }
            position.put(s.charAt(i), i);
        }
        return maxLength;
    }

    /**
     * 2.14
     * 递归
     * Runtime: 8 ms, faster than 59.97% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 50 MB, less than 5.20% of Java online submissions for Longest Substring Without Repeating Characters.
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringRecurse214(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        Map<Character, Integer> position = new HashMap<>();
        lengthOfLongestSubstringHelper(s, s.length() - 1, position);
        return maxLength;
    }

    private int lengthOfLongestSubstringHelper(String str, int end, Map<Character, Integer> position) {
        if (end == 0) {
            position.put(str.charAt(end), end);
            return 1;
        }
        int preLength = lengthOfLongestSubstringHelper(str, end - 1, position);
        int curLength = 0;
        int preIndex = -1;
        if (position.get(str.charAt(end)) != null) {
            preIndex = position.get(str.charAt(end));
        }
        if (preIndex < 0 || preLength < end - preIndex) {
            curLength = preLength + 1;
        } else {
            curLength = end - preIndex;
        }
        if (curLength > maxLength) {
            maxLength = curLength;
        }
        position.put(str.charAt(end), end);
        return curLength;
    }

    /**
     * 第一种解法
     * Runtime: 62 ms, faster than 15.32% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 39.5 MB, less than 14.63% of Java online submissions for Longest Substring Without Repeating Characters.
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new LinkedHashSet<>();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            set.add(c1);
            int j = i + 1;
            while (j < s.length()) {
                char c2 = s.charAt(j);
                if (!set.contains(c2)) {
                    set.add(c2);
                    j++;
                } else {
                    result = set.size() > result ? set.size() : result;
                    set.clear();
                    break;
                }
            }
            result = set.size() > result ? set.size() : result;
        }
        return result;
    }

    /**
     * 双层for循环，使用HashSet
     * Runtime: 49 ms, faster than 18.60% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 37.6 MB, less than 81.84% of Java online submissions for Longest Substring Without Repeating Characters.
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringOp(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        Set<Character> set = new HashSet<>();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            set.add(c1);
            for (int j = i + 1; j < s.length(); j++) {
                char c2 = s.charAt(j);
                if (!set.contains(c2)) {
                    set.add(c2);
                } else {
                    break;
                }
            }
            result = set.size() > result ? set.size() : result;
            set.clear();
        }
        return result;
    }
}

