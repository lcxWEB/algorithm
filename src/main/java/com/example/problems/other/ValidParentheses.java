package com.example.problems.other;

import java.util.Stack;

/**
 * Created by lichunxia on 2019-08-27 10:04
 * <p>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 */
public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        boolean valid = validParentheses.isValid("[()]{}");
        System.out.println(valid);
    }

    /**
     * 第一种解法
     * Runtime: 2 ms, faster than 60.88% of Java online submissions for Valid Parentheses.
     * Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for Valid Parentheses.
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        char[] chars = new char[]{'(', ')', '{', '}', '[', ']'};
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char chari = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(chari);
            } else {
                Character peek = stack.peek();
                if ((peek.equals(chars[0]) && chari == chars[1]) || (peek.equals(chars[2]) && chari == chars[3]) || (peek.equals(chars[4]) && chari == chars[5])) {
                    stack.pop();
                } else {
                    stack.push(chari);
                }
            }
        }
        return stack.isEmpty();
    }
}
