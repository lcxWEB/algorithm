package com.example.problems.nowcoder.offer;

/**
 * Created by lichunxia on 2020-02-13 15:03
 */
public class GetNumberSameAsIndex {

    public static void main(String[] args) {
        int[] array = new int[]{-3, -1, 1, 3, 5, 6};
        int numberSameAsIndex = getNumberSameAsIndex(array);
        System.out.println(numberSameAsIndex);
    }

    /**
     * 2.13
     * 单调递增数组中数值和下标相等的元素
     *
     * @param array
     * @return
     */
    public static int getNumberSameAsIndex(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int begin = 0;
        int end = array.length - 1;
        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            if (array[mid] == mid) {
                return mid;
            }
            if (array[mid] > mid) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return -1;
    }


}
