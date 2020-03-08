package com.example.demo.nowcoder.offer;

import java.util.HashMap;

public class MoreThanHalfNum {


    /**
     * 2.11
     * O(n), O(1)
     *
     * @param array
     * @return
     */
    public int MoreThanHalfNum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int result = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                result = array[i];
                times = 1;
            } else if (array[i] == result) {
                times++;
            } else {
                times--;
            }

        }
        int time = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == result) {
                time++;
            }
        }
        if (time >= array.length / 2 + 1) {
            return result;
        }
        return 0;
    }


    /**
     * 2.11
     * <p>
     * O(n), O(n)
     *
     * @param array
     * @return
     */
    public int MoreThanHalfNum211(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int length = array.length;
        if (length == 1) {
            return array[0];
        }
        int result = 0;
        HashMap<Integer, Integer> numCountMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (numCountMap.get(array[i]) == null) {
                numCountMap.put(array[i], 1);
            } else {
                int count = numCountMap.get(array[i]) + 1;
                if (count >= length / 2 + 1) {
                    result = array[i];
                    break;
                } else {
                    numCountMap.put(array[i], count);
                }
            }
        }
        return result;
    }

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        int l = array.length;
        int result = array[0];
        int times = 1;
        for (int i = 0; i < l; i++) {
            if (times == 0) {
                result = array[i];
                times = 1;
            } else if (array[i] == result) {
                times++;
            } else {
                times--;
            }
        }

        int count = 0;
        for (int i = 0; i < l; i++) {
            if (array[i] == result) {
                count++;
            }
        }

        if (count * 2 <= l) {
            result = 0;
        }

        return result;
    }
}
