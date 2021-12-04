package com.example.problems.nowcoder.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lichunxia on 2020-02-02 12:09
 */
public class Duplicate {

    public static void main(String[] args) {
        int[] array = new int[]{2, 1, 3, 1, 4};
        int[] duplication = new int[1];
        boolean duplicate = new Duplicate().duplicate4(array, 5, duplication);
        System.out.println(duplicate);
        System.out.println(duplication[0]);
    }


    /**
     * 2.11
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate211(int numbers[], int length, int[] duplication) {
        if (numbers == null || length <= 0) {
            return false;
        }
        for (int i = 0; i < numbers.length; i++) {
            while (numbers[i] != i) {
                int temp = numbers[numbers[i]];
                if (temp == numbers[i]) {
                    duplication[0] = temp;
                    return true;
                }
                numbers[numbers[i]] = numbers[i];
                numbers[i] = temp;
            }
        }
        return false;
    }

    /**
     * O(n)  O(n)
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length == 0 || length <= 0
                || duplication == null || duplication.length == 0) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            if (set.contains(number)) {
                duplication[0] = number;
                return true;
            } else {
                set.add(number);
            }
        }
        return false;
    }


    /**
     * O(n) O(1)
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate1(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length == 0 || length <= 0
                || duplication == null || duplication.length == 0) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > length - 1) {
                return false;
            }
        }

        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                // 调换以当前位置数字为下标的数字 和 当前数字
                // swap numbers[i] and numbers[numbers[i]]
                if (numbers[numbers[i]] != numbers[i]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[temp];
                    numbers[temp] = temp;
                } else {
                    duplication[0] = numbers[i];
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * O(n), O(n)
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate3(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length == 0 || length <= 0
                || duplication == null || duplication.length == 0) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > length - 1) {
                return false;
            }
        }
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
        for (int i = 0; i < length; i++) {
            if (arr[numbers[i]] == numbers[i]) {
                duplication[0] = numbers[i];
                return true;
            }
            arr[numbers[i]] = numbers[i];
        }
        return false;
    }


    /**
     * 适用于 不修改数组找出重复的数字
     * 二分查找的过程中统计个数
     * O(nlogn)
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate4(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length == 0 || length <= 0
                || duplication == null || duplication.length == 0) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > length - 1) {
                return false;
            }
        }
        int start = 0;
        int end = length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            int count = countRange(numbers, length, start, middle);
            if (start == end) {
                if (count > 1) {
                    duplication[0] = start;
                    return true;
                }
            }

            if (count > middle - start + 1) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return false;
    }

    private int countRange(int[] numbers, int length, int start, int end) {
        if (numbers == null) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (numbers[i] >= start && numbers[i] <= end) {
                result++;
            }
        }
        return result;
    }


}
