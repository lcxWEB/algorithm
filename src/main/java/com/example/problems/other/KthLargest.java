package com.example.problems.other;

import java.util.PriorityQueue;

/**
 * Created by lichunxia on 2019-09-15 08:29
 *
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.
 *
 * Example:
 *
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * Note:
 * You may assume that nums' length ≥ k-1 and k ≥ 1.
 */


    /**
     * Runtime: 58 ms, faster than 87.86% of Java online submissions for Kth Largest Element in a Stream.
     * Memory Usage: 45.3 MB, less than 96.67% of Java online submissions for Kth Largest Element in a Stream.
     */
 public class KthLargest {

        private int k;
        private PriorityQueue<Integer> queue;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            queue = new PriorityQueue<>();
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if (queue.size() < k) {
                queue.offer(val);
            } else if (queue.peek() < val) {
                queue.poll();
                queue.offer(val);
            }
            return queue.peek();
        }

        public static void main(String[] args) {
            int[] arr = {6,4,5,8,2};
            KthLargest kthLargest = new KthLargest(3, arr);
            kthLargest.add(1);
            System.out.println();
        }
    }



