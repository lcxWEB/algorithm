package com.example.demo.nowcoder.offer;

/**
 * Created by lichunxia on 2020-02-14 10:56
 */
public class LongestSubstringWithoutDuplication {

    private int maxLength;

    public static void main(String[] args) {
        int longestSubstring = new LongestSubstringWithoutDuplication().lengthOfLongestSubstring("abcdafgadfg");
        System.out.println(longestSubstring);
    }

    /**
     * Runtime: 8 ms, faster than 59.97% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 50 MB, less than 5.20% of Java online submissions for Longest Substring Without Repeating Characters.
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int[] position = new int[26];
        for (int i = 0; i < position.length; i++) {
            position[i] = -1;
        }
        lengthOfLongestSubstring(s, s.length() - 1, position);
        return maxLength;
    }


    private int lengthOfLongestSubstring(String str, int end, int[] position) {
        if (end == 0) {
            position[str.charAt(end) - 'a'] = end;
            return 1;
        }
        int preLength = lengthOfLongestSubstring(str, end - 1, position);
        int curLength = 0;
        int preIndex = position[str.charAt(end) - 'a'];
        if (preIndex < 0 || preLength < end - preIndex) {
            curLength = preLength + 1;
        } else {
            curLength = end - preIndex;
        }
        if (curLength > maxLength) {
            maxLength = curLength;
        }
        position[str.charAt(end) - 'a'] = end;
        return curLength;
    }

}
