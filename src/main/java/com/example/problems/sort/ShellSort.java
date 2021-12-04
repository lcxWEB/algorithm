package com.example.problems.sort;

/**
 * Created by lichunxia on 2020-02-15 10:52
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {16, 4, 10, 14, 7, 9, 3, 2, 4, 8, 1};
        shellSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    /**
     * 原始的算法实现在最坏的情况下需要进行O(n^2)的比较和交换
     * V. Pratt的书[1]对算法进行了少量修改，可以使得性能提升至O(n log^2 n)
     * 一个更好理解的希尔排序实现：将数组列在一个表中并对列排序（用插入排序）。重复这过程，不过每次用更长的列来进行。
     * 最后整个表就只有一列了。将数组转换至表是为了更好地理解这算法，
     * 算法本身仅仅对原数组进行排序（通过增加索引的步长，例如是用i += step_size而不是i++ ）。
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int length = arr.length;
        int temp;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                temp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp;
            }
        }
    }
}
