package com.example.problems.nowcoder.offer;

public class ReplaceWhitespace {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("wewew ddfd");
        System.out.println(replaceSpace1(sb));
    }

    public static String replaceSpace(StringBuffer str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                // sb.append('%').append('2').append('0');
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String replaceSpace1(StringBuffer str) {
        int length = str.length();
        int spaceCount = 0;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        int newLength = length + spaceCount * 2;
        char[] chars = new char[newLength];
        for (int i = 0; i < length; i++) {
            chars[i] = str.charAt(i);
        }
        int indexOfOriginal = length - 1;
        int indexOfNew = newLength - 1;
        // 从后往前复制
        while (indexOfOriginal >= 0 && indexOfNew >= 0) {
            if (chars[indexOfOriginal] == ' ') {
                chars[indexOfNew--] = '0';
                chars[indexOfNew--] = '2';
                chars[indexOfNew--] = '%';
            } else {
                chars[indexOfNew--] = chars[indexOfOriginal];
            }
            indexOfOriginal--;
        }
        return new String(chars);
    }

}
