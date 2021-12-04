package com.example.problems.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lichunxia on 2020-02-14 20:22
 */
public class BucketSort {

    public static void main(String[] args) {
        int[] array = new int[]{77, 56, 1, 2, 3, 8, 4, 5, 6, 7};
        new BucketSort().bucketSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
    }

    private int indexFor(int a, int min, int step) {
        return (a - min) / step;
    }

    /**
     * O(n^2), O(n*k)
     * 设置一个定量的数组当作空桶子。
     * 寻访序列，并且把项目一个一个放到对应的桶子去。
     * 对每个不是空的桶子进行排序。
     * 从不是空的桶子里把项目再放回原来的序列中。
     *
     * @param arr
     */
    public void bucketSort(int[] arr) {
        int max = arr[0], min = arr[0];
        for (int a : arr) {
            if (max < a)
                max = a;
            if (min > a)
                min = a;
        }
        // 該值也可根據實際情況選擇
        int bucketNum = max / 10 - min / 10 + 1;
        List<List<Integer>> buckList = new ArrayList<>();
        // create bucket
        for (int i = 1; i <= bucketNum; i++) {
            buckList.add(new ArrayList<>());
        }
        // push into the bucket
        for (int i = 0; i < arr.length; i++) {
            int index = indexFor(arr[i], min, 10);
            buckList.get(index).add(arr[i]);
        }
        ArrayList<Integer> bucket = null;
        int index = 0;
        for (int i = 0; i < bucketNum; i++) {
            bucket = (ArrayList<Integer>) buckList.get(i);
            insertSort(bucket);
            for (int k : bucket) {
                arr[index++] = k;
            }
        }

    }

    // 把桶內元素插入排序
    private void insertSort(List<Integer> bucket) {
        for (int i = 1; i < bucket.size(); i++) {
            int temp = bucket.get(i);
            int j = i - 1;
            for (; j >= 0 && bucket.get(j) > temp; j--) {
                bucket.set(j + 1, bucket.get(j));
            }
            bucket.set(j + 1, temp);
        }
    }

}
