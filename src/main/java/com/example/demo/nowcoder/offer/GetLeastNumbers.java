package com.example.demo.nowcoder.offer;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeSet;

public class GetLeastNumbers {

    public static void main(String[] args) {
        int[] array = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> leastNumbers = new GetLeastNumbers().GetLeastNumbers(array, 4);
        System.out.println(leastNumbers);
        leastNumbers = new GetLeastNumbers().GetLeastNumbers_Solution(array, 4);
        System.out.println(leastNumbers);
        leastNumbers = new GetLeastNumbers().GetLeastNumbersPartition(array, 4);
        System.out.println(leastNumbers);
    }


    /**
     * 2.12
     * 快速排序
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbersPartition(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || input.length == 0 || k <= 0 || input.length < k) {
            return result;
        }
        int begin = 0;
        int end = input.length - 1;
        int index = partition(input, 0, end);
        while (index != k - 1) {
            if (index < k - 1) {
                begin = index + 1;
                index = partition(input, begin, end);
            } else {
                end = index - 1;
                index = partition(input, begin, end);
            }
        }
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

    private int partition(int[] array, int begin, int end) {
        int pivotIndex = getMedian(array, begin, end);
        swap(array, begin, pivotIndex);
        int pivot = array[begin];
        while (begin < end) {
            while (begin < end && array[end] >= pivot) {
                end--;
            }
            array[begin] = array[end];
            while (begin < end && array[begin] <= pivot) {
                begin++;
            }
            array[end] = array[begin];
        }
        array[begin] = pivot;
        return begin;
    }

    private void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    private int getMedian(int[] array, int begin, int end) {
        int mid = begin + (end - begin) / 2;
        if (array[begin] < array[mid] && array[mid] < array[end]) {
            return mid;
        }
        if (array[begin] > array[mid] && array[begin] < array[end]) {
            return begin;
        }
        return end;
    }


    /**
     * 2.12
     * 最大堆
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || input.length == 0 || k <= 0 || input.length < k) {
            return result;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < input.length; i++) {
            int num = input[i];
            if (priorityQueue.size() < k) {
                priorityQueue.add(num);
            } else {
                int max = priorityQueue.peek();
                if (max > num) {
                    priorityQueue.poll();
                    priorityQueue.add(num);
                }
            }
        }
        result.addAll(priorityQueue);
        return result;
    }


    /**
     * 2.
     * 红黑树
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || input.length == 0 || k <= 0 || input.length < k) {
            return result;
        }
        TreeSet<Integer> set = new TreeSet();
        for (Integer i : input) {
            if (set.size() < k) {
                set.add(i);
            } else {
                int max = set.last();
                if (i < max) {
                    set.remove(max);
                    set.add(i);
                }
            }
        }
        result.addAll(set);
        return result;
    }

    /**
     * 有赞
     * <p>
     * 题目描述
     * 给定一个无序的整型数组A[n],数组大小大于等于3,允许有值相同(所以不能用treeset)的元素;请设计算法找到该数组排序后第三大的元素值并输出.
     */
    public class Main {
        public void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            String[] strs = line.replace("[", "").replace("]", "").split(",");
            int[] nums = new int[strs.length];
            for (int i = 0; i < strs.length; i++) {
                nums[i] = Integer.parseInt(strs[i]);
            }
            int num = findKthBigNum(nums, 3);
            System.out.println(num);
        }

        private int findKthBigNum(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            // 最小堆(存储前k大元素)，堆顶就是第k大元素
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int i = 0; i < nums.length; i++) {
                if (queue.size() < k) {
                    queue.add(nums[i]);
                } else {
                    int min = queue.peek();
                    if (min < nums[i]) {
                        queue.poll();
                        queue.add(nums[i]);
                    }
                }
            }
            return queue.peek();
        }

    }

}
