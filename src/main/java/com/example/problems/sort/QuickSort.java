package com.example.problems.sort;

import java.util.Arrays;

/**
 * Created by lichunxia on 2020-02-05 21:24
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{6, 1, 2, 7, 9, 11, 4, 5, 10, 6, 8};
        // arr = new int[]{1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10};
        new QuickSort().quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void quickSort(int[] array) {
        quickSortCoreOffer(array, 0, array.length - 1);
        // quickSortCore(array, 0, array.length - 1);
        quckSortFill(array, 0, array.length - 1);
        // quckSortFill1(array, 0, array.length - 1);
    }

    private void quickSortCoreOffer(int[] array, int start, int end) {
        if (start < 0 || end >= array.length || start == end) {
            return;
        }

        int small = partitionOffer(array, start, end);

        if (small > start) {
            quickSortCoreOffer(array, start, small - 1);
        }
        if (small < end) {
            quickSortCoreOffer(array, small + 1, end);
        }
    }

    private int partitionOffer(int[] array, int start, int end) {
        int index = getMedianThreeIndex(array, start, end);
        // 放到最后
        swap(array, index, end);
        int small = start - 1;
        for (index = start; index < end; index++) {
            if (array[index] < array[end]) {
                small++;
                if (small != index) {
                    swap(array, small, index);
                }
            }
        }
        small++;
        swap(array, small, end);
        return small;
    }

    private void quickSortCore(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = getMedianThree(array, left, right);
        if (right - left <= 2) {
            return;
        }
        int i = left + 1;
        int j = right - 2;
        while (true) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(array, i, j);
            } else break;
        }
        array[right - 1] = array[i];
        array[i] = pivot;

        quickSortCore(array, left, i - 1);
        quickSortCore(array, i + 1, right);
    }

    /**
     * arr[left] < arr[right - 1] < arr[right]
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    private int getMedianThreeIndex(int[] array, int left, int right) {
        int mid = left + (right - left) / 2;
        if (array[left] < array[mid] && array[mid] < array[right]) {
            return mid;
        }
        if (array[left] > array[mid] && array[left] < array[right]) {
            return left;
        }
        return right;
    }


    /**
     * arr[left] < arr[right - 1] < arr[right]
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    private int getMedianThree(int[] array, int left, int right) {
        int mid = left + (right - left) / 2;
        if (array[left] > array[mid]) {
            swap(array, left, mid);
        }
        if (array[left] > array[right]) {
            swap(array, left, right);
        }
        if (array[mid] > array[right]) {
            swap(array, mid, right);
        }
        // 以上步骤实现 left < mid < right

        // 将枢纽放入right-1的位置。那么只需要对left+1 -- right-2的位置划分子集
        swap(array, right - 1, mid);
        return array[right - 1];
    }


    /**
     * 挖坑填数法
     *
     * @param arr
     * @param left
     * @param right
     */
    private void quckSortFill(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = getMedianThree(arr, left, right);
        if (right - left <= 2) {
            return;
        }
        int low = left + 1;
        // 需要填的坑（pivot所在位置）在右端，所以先从左侧开始找大于主元的数
        int high = right - 1;
        while (low < high) {
            while (arr[low] < pivot && low < high) {
                low++;
            }
            if (low < high) {
                arr[high] = arr[low];
                high--;
            }
            while (arr[high] > pivot && low < high) {
                high--;
            }
            if (low < high) {
                arr[low] = arr[high];
                low++;
            }
        }
        arr[low] = pivot;

        quckSortFill(arr, left, low - 1);
        quckSortFill(arr, low + 1, right);
    }

    private void quckSortFill1(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = partition(arr, left, right);
        quckSortFill1(arr, left, mid - 1);
        quckSortFill1(arr, mid + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = getMedianThree2(arr, left, right);
        if (right - left <= 1) {
            return left;
        }
        // arr[left] 是需要填的第一个坑（pivot所在位置），所以先从右侧开始找一个比主元小的数
        while (left < right) {
            while (arr[right] >= pivot && left < right) {
                right--;
            }
            if (left < right) {
                arr[left] = arr[right];
                left++;
            }
            while (arr[left] <= pivot && left < right) {
                left++;
            }
            if (left < right) {
                arr[right] = arr[left];
                right--;
            }
        }
        arr[left] = pivot;
        return left;
    }

    /**
     * arr[中间] < arr[左端] < arr[右端]
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    private int getMedianThree2(int[] array, int left, int right) {
        int mid = left + (right - left) / 2;
        if (array[left] > array[right]) {
            swap(array, left, right);
        }
        if (array[mid] > array[right]) {
            swap(array, mid, right);
        }
        // 中间 < 左端 < 右端
        if (array[left] < array[mid]) {
            swap(array, left, mid);
        }
        return array[left];
    }

    private void swap(int[] array, int m, int n) {
        int temp = array[m];
        array[m] = array[n];
        array[n] = temp;
    }

}
