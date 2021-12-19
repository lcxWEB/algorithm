package com.example.problems.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lichunxia on 2019-09-05 19:12
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        List<String> parenthesis = generateParentheses.generateParenthesis(3);
        System.out.println(parenthesis);
    }


    /**
     * Runtime: 1 ms, faster than 93.29% of Java online submissions for Generate Parentheses.
     * Memory Usage: 36 MB, less than 100.00% of Java online submissions for Generate Parentheses.
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTrack(result, "", 0, 0, n);
        return result;
    }

    private void backTrack(List<String> result, String s, int open, int close, int n) {
        if (s.length() == n * 2) {
            result.add(s);
            return;
        }

        if (open < n) {
            backTrack(result, s + "(", open + 1, close, n);
        }
        if (close < open) {
            backTrack(result, s + ")", open, close + 1, n);
        }
    }
}
