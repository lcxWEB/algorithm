package com.example.problems.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: lichunxia
 * @create: 12/14/21 8:52 PM
 */
public class LetterCasePermutation {

    public List<String> letterCasePermutation(String s) {
        List<String> result = new LinkedList<>();
        char[] chars = s.toCharArray();
        dfs(chars, 0, result);
        return result;
    }


    void dfs(char[] chars, int index, List<String> res) {

        if(index == chars.length) {
            res.add(new String(chars));
            System.out.print(res);

            return;
        }

        char c = chars[index];
        if(Character.isLetter(c)) {
            chars[index] = Character.toLowerCase(c);
            dfs(chars, index + 1, res);
            chars[index] = Character.toUpperCase(c);
            dfs(chars, index + 1, res);
        } else {
            dfs(chars, index + 1, res);
        }
    }

}
