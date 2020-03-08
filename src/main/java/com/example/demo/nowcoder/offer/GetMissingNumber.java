package com.example.demo.nowcoder.offer;

/**
 * Created by lichunxia on 2020-02-13 14:01
 */
public class GetMissingNumber {

    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 3, 4, 5, 6};
        int missingNumber = getMissingNumber(array);
        System.out.println(missingNumber);
    }

    /**
     * 2.13
     * 递增数组中缺失的数字
     * n = array.length;
     * 查找 0 - n 范围内缺失的数字
     *
     * @param array
     * @return
     */
    public static int getMissingNumber(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int begin = 0;
        int end = array.length - 1;
        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            if (array[mid] == mid) {
                begin = mid + 1;
            } else {
                if (mid > 0 && array[mid - 1] != mid - 1) {
                    end = mid - 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }
}
