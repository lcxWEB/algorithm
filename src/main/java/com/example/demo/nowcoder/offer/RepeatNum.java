package com.example.demo.nowcoder.offer;


import java.util.HashSet;

public class RepeatNum {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 2, 1, 4, 3};
        int a = new RepeatNum().findRepeatNumBySet(arr);
        System.out.println(a);
        int b = new RepeatNum().findRepeatNum(arr);
        System.out.println(b);
        int c = new RepeatNum().getDuplicatedNum(arr, arr.length);
        System.out.println(c);
    }

    public int findRepeatNumBySet(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 || arr[i] > arr.length - 1) {
                return -1;
            }
        }
        HashSet set = new HashSet<>(10);
        for (int num : arr) {
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }
        return -1;
    }

    public int findRepeatNum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 || arr[i] > arr.length - 1) {
                return -1;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            // 第i个位置的值
            int m = arr[i];
            // 循环 直到第i个位置的值等于i
            while (m != i) {
                // 如果第i个位置的值等于第m个位置的值
                if (m == arr[m]) {
                    return m;
                }
                // 交换i和m位置的数值
                arr[i] = arr[m];
                arr[m] = m;
            }
        }
        return -1;
    }

    public int getDuplicatedNum(int[] arr, int length) {
        if (arr == null || length <= 0) {
            return -1;
        }
        int start = 1;
        int end = length - 1;
        while (end >= start) {
            int middle = ((end - start) >> 1) + start;
            int count = count(arr, length, start, middle);

            if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }
            if (end == start) {
                if (count > 1) {
                    return start;
                } else break;
            }
        }
        return -1;
    }

    private int count(int[] arr, int length, int start, int end) {
        if (arr == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] >= start && arr[i] <= end) {
                count++;
            }
        }
        return count;

    }
}

