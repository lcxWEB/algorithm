package com.example.demo.nowcoder.offer;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

/**
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变
 */
public class ReOrderArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ReOrderArray reOrderArray = new ReOrderArray();
        reOrderArray.reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{1, 2, 3, 4, 5, 6};
        reOrderArray.reOrderArray1(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{1, 2, 3, 4, 5, 6};
        arr = new int[]{6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(arr));
        int i = 1 /0;

        // Scanner scanner = new Scanner(System.in);
        // int length = scanner.nextInt();
        // int i = 0;
        // arr = new int[length];
        // while (i < length && scanner.hasNextInt()) {
        //     arr[i] = scanner.nextInt();
        //     i++;
        // }
        // reOrderArray.selectSort(arr);
        // System.out.println(Arrays.toString(arr));
    }

    /**
     * O(n^2),O(1)
     *
     * @param array
     */
    public void reOrderArray(int[] array) {

//        List<Integer> list = new LinkedList<>();
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] % 2 == 0) {
//                list.add(array[i]);
//            } else {
//                list.ad
//            }
//        }

        int temp;
        for (int i = 0; i < array.length; i++) {
//            for(int j=0; j<array.length-i-1; j++){
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] % 2 == 0 && array[j + 1] % 2 == 1) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

    }


    /**
     * 空间换时间
     * O(n),O(n)
     *
     * @param array
     */
    public void reOrderArrayStable(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int[] arr = new int[array.length];
        int arrIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) != 0) {
                arr[arrIndex] = array[i];
                arrIndex++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 0) {
                arr[arrIndex] = array[i];
                arrIndex++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = arr[i];
        }
    }


    /**
     * 双指针，不稳定
     * O(n)
     *
     * @param array
     */
    public void reOrderArray1(int[] array) {
        int begin = 0;
        int end = array.length - 1;
        while (begin < end) {
            while (begin < end && (array[begin] & 1) != 0) {
                begin++;
            }
            while (begin < end && (array[end] & 1) == 0) {
                end--;
            }
            if (begin < end) {
                int temp = array[begin];
                array[begin] = array[end];
                array[end] = temp;
            }
        }
    }

    /**
     * 双指针，不稳定
     * O(n)
     *
     * @param array
     */
    public void reOrderArray2(int[] array) {
        reorderArray(array, this::isEven);
    }

    /**
     * 解耦成两部分：
     * 1 判断数字是应该在前半部分还是后半部分的标准
     * 2 拆分数组的操作
     * 这样提高了代码的可扩展性
     *
     * @param array
     * @param fuc
     */
    public void reorderArray(int[] array, Function<Integer, Boolean> fuc) {
        int begin = 0;
        int end = array.length - 1;
        while (begin < end) {
            while (begin < end && !fuc.apply(array[begin])) {
                begin++;
            }
            while (begin < end && fuc.apply(array[end])) {
                end--;
            }
            if (begin < end) {
                int temp = array[begin];
                array[begin] = array[end];
                array[end] = temp;
            }
        }
    }

    boolean isEven(int num) {
        return (num & 1) == 0;
    }


    /**
     * 插入排序
     *
     * @param array
     */
    public void reorderArray(int[] array) {
        if (array == null) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                continue;
            }
            for (int j = i; j > 0; j--) {
                if (array[j - 1] % 2 == 0) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * 插入排序
     *
     * @param array
     */
    public void reorderArray1(int[] array) {
        if (array == null) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            if (temp % 2 == 0) {
                continue;
            }
            int j;
            for (j = i; j > 0; j--) {
                if (array[j - 1] % 2 == 0) {
                    array[j] = array[j - 1];
                } else {
                    break;
                }
            }
            array[j] = temp;
        }
    }


    public void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j;
            for (j = i - 1; j >= 0 && array[j] > current; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = current;
        }
    }

    public void insertSort1(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j;
            for (j = i; j > 0; j--) {
                if (array[j - 1] > temp) {
                    array[j] = array[j - 1];
                } else {
                    break;
                }
            }
            array[j] = temp;
        }
    }

    public void insertSort2(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }

    public void selectSort(int[] array) {
        //对n个元素的数组进行排序，总共进行至多n-1次交换
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            // 不在正确位置
            if (min != i) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }

    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    public void bubbleSort2(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
                if (!flag) {
                    break;
                }
            }
        }
    }

    public void bubbleSort1(int[] array) {
        boolean exchanged = true;
        for (int i = 0; exchanged && i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                exchanged = false;
                if (array[j + 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    exchanged = true;
                }
                if (!exchanged) {
                    break;
                }
            }
        }
    }

    /**
     * 小米
     */
    public class Main {
        public void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            String[] strs = str.split(" ");
            int[] nums = new int[strs.length];
            for (int i = 0; i < strs.length; i++) {
                nums[i] = Integer.parseInt(strs[i]);
            }
            int[] result = reorder(nums);
            for (int i = 0; i < nums.length; i++) {
                System.out.print(result[i]);
                System.out.print(" ");
            }
        }

        private int[] reorder(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }
            int length = nums.length;
            int[] result = new int[length];
            int index = 0;
            int last = length - 1;
            for (int i = 0; i < length; i++) {
                if (nums[i] % 2 == 0) {
                    result[index] = nums[i];
                    index++;
                } else {
                    result[last] = nums[i];
                    last--;
                }
            }
            return result;
        }

    }

}
