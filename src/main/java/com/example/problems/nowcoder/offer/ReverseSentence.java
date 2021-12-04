package com.example.problems.nowcoder.offer;

/**
 * Created by lichunxia on 2020-01-31 10:21
 */
public class ReverseSentence {

    public static void main(String[] args) {
        String s = new ReverseSentence().ReverseSentence3("Iab am a student.");
        System.out.println(s);
    }

    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        // 字符串为 "  "
        if (str.trim().length() == 0) {
            return str;
        }
        int length = str.length();
        char[] array = str.toCharArray();
        reverse(array, 0, length - 1);
        String[] words = new String(array).split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            char[] wordArr = words[i].toCharArray();
            reverse(wordArr, 0, wordArr.length - 1);
            sb.append(new String(wordArr));
            if (i < words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public String ReverseSentence1(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        // 字符串为 "  "
        if (str.trim().length() == 0) {
            return str;
        }
        int length = str.length();
        char[] array = str.toCharArray();
        reverse(array, 0, length - 1);
        int currentBlank = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ') {
                reverse(array, currentBlank + 1, i - 1);
                currentBlank = i;
            }
        }
        reverse(array, currentBlank + 1, length - 1);
        return new String(array);
    }

    public String ReverseSentence2(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        // 字符串为 "  "
        if (str.trim().length() == 0) {
            return str;
        }
        int length = str.length();
        char[] array = str.toCharArray();
        reverse(array, 0, length - 1);
        int s, e;
        int i = 0;
        while (i < length) {
            while (i < length && array[i] == ' ') {
                i++;
            }
            // 单词的第一个字符的位置
            s = e = i;
            // 单词的最后一个字符的位置
            while (i < length && array[i] != ' ') {
                i++;
                e++;
            }
            reverse(array, s, e - 1);
        }
        return new String(array);
    }


    public String ReverseSentence3(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        // 字符串为 "  "
        if (str.trim().length() == 0) {
            return str;
        }
        int length = str.length();
        char[] array = str.toCharArray();
        reverse(array, 0, length - 1);
        int s = 0, e = 0;
        while (s < length) {
            if (array[s] == ' ') {
                s++;
                e++;
            } else if (array[e] == ' ') {
                reverse(array, s, e - 1);
                e++;
                s = e;
            } else if (e == length - 1) {
                reverse(array, s, e);
                break;
            } else {
                e++;
            }
        }
        return new String(array);
    }


    private void reverse(char[] array, int begin, int end) {
        while (begin < end) {
            char temp = array[begin];
            array[begin] = array[end];
            array[end] = temp;
            begin++;
            end--;
        }
    }
}
