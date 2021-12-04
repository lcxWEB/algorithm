package com.example.problems.nowcoder.offer;

/**
 * Created by lichunxia on 2020-01-27 19:53
 */
public class FindGreatestSumOfSubArray {

    public static void main(String[] args) {
        int[] array = {6, -3, -2, 7, -15, 1, 2, 2};
        FindGreatestSumOfSubArray sumOfSubArray = new FindGreatestSumOfSubArray();
        int max = sumOfSubArray.FindGreatestSumOfSubArrayRecurse(array);
        System.out.println(max);
        System.out.println(sumOfSubArray.FindGreatestSumOfSubArray212(array));
    }

    /**
     * 2.12
     * 递归写法
     *
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArrayRecurse(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] result = new int[array.length];
        findMaxNumEndWithI(array, array.length - 1, result);
        int max = result[0];
        for (int i = 1; i < result.length; i++) {
            if (result[i] > max) {
                max = result[i];
            }
        }
        return max;
    }

    private int findMaxNumEndWithI(int[] array, int index, int[] result) {
        if (index == 0) {
            result[0] = array[0];
            return array[0];
        }
        int maxNumEndWithI = findMaxNumEndWithI(array, index - 1, result);
        int max = maxNumEndWithI <= 0 ? array[index] : maxNumEndWithI + array[index];
        result[index] = max;
        return max;
    }

    /**
     * 2.12
     *
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray212(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int max = array[0];
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (sum <= 0) {
                sum = array[i];
            } else {
                sum = sum + array[i];
            }
            // sum = sum + array[i];
            // if (array[i] > sum) {
            //     sum = array[i];
            // }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }


    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (sum <= 0) {
                sum = array[i];
            } else {
                sum = sum + array[i];
            }

            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }


}
