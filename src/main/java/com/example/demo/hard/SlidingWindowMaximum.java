package com.example.demo.hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by lichunxia on 2019-09-15 09:36
 *
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 *
 * Example:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 *
 * Follow up:
 * Could you solve it in linear time?
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] maxSlidingWindow = slidingWindowMaximum.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(maxSlidingWindow));
    }

    /**
     * Runtime: 10 ms, faster than 74.17% of Java online submissions for Sliding Window Maximum.
     * Memory Usage: 41.3 MB, less than 81.25% of Java online submissions for Sliding Window Maximum.
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 注意边界判断
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int[] r = new int[nums.length - k + 1];
        int ri = 0;
        Deque<Integer> window = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // peek 队列头；peekLast 队列尾
            // remove numbers out of range k
            while (!window.isEmpty() && window.peek() < i - k + 1) {
                window.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!window.isEmpty() && nums[window.peekLast()] < nums[i]) {
                window.pollLast();
            }
            // q contains index... r contains content
            window.offer(i);
            if (i >= k - 1) {
                r[ri] = nums[window.peek()];
                ri++;
            }
        }
        return r;
    }
}
