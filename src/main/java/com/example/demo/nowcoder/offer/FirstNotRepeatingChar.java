package com.example.demo.nowcoder.offer;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by lichunxia on 2020-01-28 15:20
 */
public class FirstNotRepeatingChar {

    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() <= 0) {
            return -1;
        }
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (charCountMap.get(c) == 1) {
                return i;
            }
        }

        return -1;
    }

    public int FirstNotRepeatingChar1(String str) {
        if (str == null || str.length() <= 0) {
            return -1;
        }
        int[] hashTable = new int[256];
        for (int i = 0; i < str.length(); i++) {
            hashTable[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (hashTable[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}
