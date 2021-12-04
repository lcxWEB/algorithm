package com.example.problems.nowcoder.offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lichunxia on 2020-01-30 12:40
 */
public class FindNumsAppearOnce {

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 3, 4, 5, 4, 5, 0, 0, 9};
        int[] one = new int[1];
        int[] two = new int[1];
        new FindNumsAppearOnce().FindNumsAppearOnce3(array, one, two);
        System.out.println(Arrays.asList(one[0], two[0]));
    }

    /**
     * 2.13
     * 异或
     *
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce213(int[] array, int num1[], int num2[]) {
        if (array == null || array.length == 0) {
            return;
        }
        int xorResult = array[0];
        for (int i = 1; i < array.length; i++) {
            xorResult = xorResult ^ array[i];
        }
        int flag = 1;
        // 找到某一位为1
        while ((xorResult & flag) == 0) {
            flag = flag << 1;
        }
        num1[0] = num2[0] = 0;
        // 将数组分成两组
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & flag) == 0) {
                num1[0] = num1[0] ^ array[i];
            } else {
                num2[0] = num2[0] ^ array[i];
            }
        }
    }

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        Set<Integer> integerSet = new HashSet<>();
        for (int num : array) {
            if (integerSet.contains(num)) {
                integerSet.remove(num);
            } else {
                integerSet.add(num);
            }
        }
        Integer[] onceNumbers = integerSet.toArray(new Integer[2]);
        num1[0] = onceNumbers[0];
        num2[0] = onceNumbers[1];
    }

    public void FindNumsAppearOnce2(int[] array, int num1[], int num2[]) {
        if (array == null || array.length < 2) {
            return;
        }

        int xorResult = 0;
        for (int num : array) {
            xorResult = xorResult ^ num;
        }

        // index从低位计算
        int indexOf1 = findFirstBitIs1(xorResult);
        num1[0] = num2[0] = 0;
        for (int num : array) {
            boolean isBit1 = isBit1(num, indexOf1);
            if (isBit1) {
                num1[0] = num1[0] ^ num;
            } else {
                num2[0] = num2[0] ^ num;
            }
        }
    }

    private boolean isBit1(int num, int index) {
        num = num >> index;
        num = num & 1;
        return num == 1;
    }

    private int findFirstBitIs1(int num) {
        int index = 0;
        while ((num & 1) == 0 && index < 8 * 4) {
            num = num >> 1;
            index++;
        }
        return index;
    }

    public void FindNumsAppearOnce3(int[] array, int num1[], int num2[]) {
        if (array == null || array.length < 2) {
            return;
        }

        int xorResult = 0;
        for (int num : array) {
            xorResult = xorResult ^ num;
        }

        int flag = 1;
        while ((xorResult & flag) == 0) {
            flag = flag << 1;
        }
        num1[0] = num2[0] = 0;
        for (int num : array) {
            if ((num & flag) == 0) {
                num1[0] = num1[0] ^ num;
            } else {
                num2[0] = num2[0] ^ num;
            }
        }
    }
}
