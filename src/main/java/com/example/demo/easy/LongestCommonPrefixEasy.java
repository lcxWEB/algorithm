package com.example.demo.easy;

/**
 * Created by lichunxia on 2020-02-15 20:32
 */
public class LongestCommonPrefixEasy {

    public static void main(String[] args) {
        LongestCommonPrefixEasy common = new LongestCommonPrefixEasy();
        common.longestCommonPrefix(new String[]{"flower", "fly"});
    }

    /**
     * 2.15
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Longest Common Prefix.
     * Memory Usage: 37.5 MB, less than 88.30% of Java online submissions for Longest Common Prefix.
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String common = strs[0];
        int i = 1;
        while (i < strs.length) {
            // 找到前两个的共同前缀；如果common为空，跳出循环，否则i++，继续寻找当前共同前缀与后序字符串的共同前缀
            while (strs[i].indexOf(common) != 0) {
                common = common.substring(0, common.length() - 1);
            }
            if (common == "") {
                break;
            }
            i++;
        }
        return common;
    }
}
