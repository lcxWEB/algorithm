package com.example.problems.nowcoder.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lichunxia on 2020-01-30 17:20
 */
public class FindNumbersWithSum {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        ArrayList<Integer> arrayList = new FindNumbersWithSum().FindNumbersWithSum1(array, 5);
        System.out.println(arrayList);
    }

    /**
     * 2.12
     *
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum21201(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array == null || array.length == 0) {
            return result;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] + array[right] == sum) {
                result.add(array[left]);
                result.add(array[right]);
                break;
            }
            while (left < right && array[left] + array[right] > sum) {
                right--;
            }
            while (left < right && array[left] + array[right] < sum) {
                left++;
            }
        }
        return result;
    }

    /**
     * 2.12
     *
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum212(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array == null || array.length == 0) {
            return result;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int curSum = array[left] + array[right];
            if (curSum == sum) {
                result.add(array[left]);
                result.add(array[right]);
                break;
            }
            if (curSum > sum) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        if (array == null || array.length < 2) {
            // 不能返回null
            return new ArrayList<>();
        }

        int start = 0;
        int end = array.length - 1;

        List<List<Integer>> numbersWithSum = new ArrayList<>();
        while (start < end) {
            int startNum = array[start];
            int endNum = array[end];
            int tempSum = startNum + endNum;
            if (tempSum == sum) {
                List<Integer> numers = new ArrayList<>(2);
                numers.add(startNum);
                numers.add(endNum);
                numbersWithSum.add(numers);
                end--;
                start++;
            } else if (tempSum > sum) {
                end--;
            } else {
                start++;
            }
        }
        int min = Integer.MAX_VALUE;
        ArrayList<Integer> result = new ArrayList<>();
        for (List<Integer> list : numbersWithSum) {
            int temp = list.get(0) * list.get(1);
            if (temp < min) {
                min = temp;
                result.clear();
                result.add(list.get(0));
                result.add(list.get(1));
            }
        }
        return result;
    }

    public ArrayList<Integer> FindNumbersWithSum1(int[] array, int sum) {
        if (array == null || array.length < 2) {
            // 不能返回null
            return new ArrayList<>();
        }

        int start = 0;
        int end = array.length - 1;

        ArrayList<Integer> result = new ArrayList<>();
        int modify = Integer.MAX_VALUE;
        while (start < end) {
            int startNum = array[start];
            int endNum = array[end];
            int tempSum = startNum + endNum;
            if (tempSum == sum) {
                int temp = startNum * endNum;
                if (temp < modify) {
                    modify = temp;
                    result.clear();
                    result.add(startNum);
                    result.add(endNum);
                }
                end--;
                start++;
            } else if (tempSum > sum) {
                end--;
            } else {
                start++;
            }
        }
        return result;
    }

    public ArrayList<Integer> FindNumbersWithSum2(int[] array, int sum) {
        if (array == null || array.length < 2) {
            // 不能返回null
            return new ArrayList<>();
        }

        int start = 0;
        int end = array.length - 1;

        ArrayList<Integer> result = new ArrayList<>();
        while (start < end) {
            int startNum = array[start];
            int endNum = array[end];
            int tempSum = startNum + endNum;
            if (tempSum == sum) {
                result.add(startNum);
                result.add(endNum);
                break; // 外层乘积最小，直接跳出循环
            } else if (tempSum > sum) {
                end--;
            } else {
                start++;
            }
        }
        return result;
    }
}
