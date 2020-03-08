package com.example.demo.nowcoder.offer;

import java.util.ArrayList;
import java.util.TreeSet;

public class Permutation {

    public static void main(String[] args) {
        ArrayList<String> result = new Permutation().Permutation("mbc");
        System.out.println(result);
        // mbc mcb    bmc bcm    cbm cmb
    }

    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList<>();
        }
        TreeSet<String> set = new TreeSet<>();
        permutation(str.toCharArray(), 0, set);
        ArrayList<String> result = new ArrayList<>();
        result.addAll(set);
        return result;
    }

    public void permutation(char[] arr, int index, TreeSet<String> set) {
        if (index == arr.length - 1) {
            System.out.println(String.valueOf(arr));
            set.add(String.valueOf(arr));
        } else {
            for (int i = index; i < arr.length; i++) {
                //我们从index向后扫描每一个字符（即指针i指向的字符），交换index和i指向的字符
                swap(arr, i, index);
                //对index后面的字符数组递归地做排列操作
                permutation(arr, index + 1, set);
                //每次递归固定要排列字符数组第一个字符不变

                // 第二个swap用以使得字符数组的顺序回到进入递归前的状态，这样才不会影响外部的遍历顺序。
                // 因为在第一次交换后进入递归运算的时候，字符数组的顺序改变了，例如“abc”， i = 0时对应‘a’，j = 1时对应 'b'，进行一次交换，
                // 此时的字符数组的顺序为 "bac"，
                // 从递归返回时，顺序依然是“bac”，则进行第二次交换使得 “bac” -> “abc”，这样在后续才可以进行'a'与'c'的交换，不会落下某一种情况。
                swap(arr, i, index);
            }
        }
    }

    public void swap(char[] arr, int idx1, int idx2) {
        char temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

}