package com.example.problems.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lichunxia on 2019-09-04 10:31
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 */
public class LetterCombinations {

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> combinations = letterCombinations.letterCombinations("23");
        System.out.println(combinations);
    }

    /**
     * Runtime: 1 ms, faster than 64.05% of Java online submissions for Letter Combinations of a Phone Number.
     * Memory Usage: 36.4 MB, less than 98.63% of Java online submissions for Letter Combinations of a Phone Number.
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

        // for (int i = 0; i < digits.length(); i++) {
        //     Integer num = Integer.valueOf(digits.charAt(i));
        //     char[] chars = map.get(num);
        // }
        helper(digits,"", 0, result, map);
        return result;
    }

    /**
     * DFS
     * @param digits
     * @param curStr
     * @param index
     * @param result
     * @param map
     */
    private void helper(String digits, String curStr, int index, List<String> result, Map<Character, char[]> map) {
        if (index == digits.length()) {
            result.add(curStr);
        } else {
            // for (int i = 0; i < digits.length(); i++) {
                char c1 = digits.charAt(index);
                if (map.containsKey(c1)) {
                    for (char c : map.get(c1)) {
                        helper(digits, curStr + c, index + 1, result, map);
                    }
                }
            // }
        }
    }
}
