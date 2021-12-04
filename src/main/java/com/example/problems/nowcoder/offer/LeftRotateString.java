package com.example.problems.nowcoder.offer;

/**
 * Created by lichunxia on 2020-01-30 19:39
 */
public class LeftRotateString {

    public static void main(String[] args) {
        String result = new LeftRotateString().LeftRotateString2("XYZdefabc", 3);
        System.out.println(result);
    }

    public String LeftRotateString(String str, int n) {
        String result = "";
        if (str == null || str.length() < n) {
            return result;
        }

        int length = str.length();
        char[] strArray = str.toCharArray();
        char[] resArray = new char[length];
        for (int i = 0; i < n; i++) {
            resArray[i + length - n] = strArray[i];
        }

        for (int i = n; i < length; i++) {
            resArray[i - n] = strArray[i];
        }

        for (char c : resArray) {
            result = result + c;
        }
        return result;
    }

    public String LeftRotateString1(String str, int n) {
        String result = "";
        if (str == null || str.length() < n) {
            return result;
        }

        int length = str.length();
        n = n % length;
        str += str;
        result = str.substring(n, length + n);
        return result;
    }

    public String LeftRotateString2(String str, int n) {
        if (str == null || str.length() < n) {
            return "";
        }
        if (n < 1) {
            return str;
        }

        int length = str.length();
        char[] charArray = str.toCharArray();
        reverse1(charArray, 0, n-1);
        reverse1(charArray, n, length - 1);
        reverse1(charArray, 0, length - 1);
        // StringBuilder sb = new StringBuilder();
        // for (char c : charArray) {
        //     sb.append(c);
        // }
        // return sb.toString();
        return new String(charArray);
    }

    private void reverse(char[] array, int begin, int end) {
        int endIndex = (begin + end) / 2;
        for (int i = begin; i <= endIndex; i++) {
            char temp = array[i];
            array[i] = array[end - (i - begin)];
            array[end - (i - begin)] = temp;
        }
    }

    private void reverse1(char[] array, int begin, int end) {
       while (begin < end) {
           char temp = array[begin];
           array[begin] = array[end];
           array[end] = temp;
           begin++;
           end--;
       }
    }

}
