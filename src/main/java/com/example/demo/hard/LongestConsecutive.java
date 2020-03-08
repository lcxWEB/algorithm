package com.example.demo.hard;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by lichunxia on 2020-02-15 15:01
 */
public class LongestConsecutive {

    public static void main(String[] args) {
        int[] arr = {4, 0, -4, -2, 2, 5, 2, 0, -8, -8, -8, -8, -1, 7, 4, 5, 5, -4, 6, 6, -3};
        LongestConsecutive consecutive = new LongestConsecutive();
        int maxLength = consecutive.longestConsecutive(arr);
        System.out.println(maxLength);
        maxLength = consecutive.longestConsecutiveOp(arr);
        System.out.println(maxLength);
    }

    /**
     * 2.15
     * O(n^2), O(n)
     * Runtime: 697 ms, faster than 5.02% of Java online submissions for Longest Consecutive Sequence.
     * Memory Usage: 42.2 MB, less than 5.17% of Java online submissions for Longest Consecutive Sequence.
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int maxLength = 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int length = 1;
            while (numSet.contains(num - 1)) {
                num = num - 1;
                length++;
            }
            maxLength = maxLength > length ? maxLength : length;
        }
        return maxLength;
    }

    /**
     * 2.15
     * Runtime: 5 ms, faster than 76.24% of Java online submissions for Longest Consecutive Sequence.
     * Memory Usage: 41 MB, less than 5.17% of Java online submissions for Longest Consecutive Sequence.
     *
     * @param nums
     * @return
     */
    public int longestConsecutiveOp(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 数组的每个数作为key，每个数所在连续序列的长度作为value
        Map<Integer, Integer> hashMap = new HashMap<>();
        int maxLength = 1;
        for (int num : nums) {
            if (!hashMap.containsKey(num)) {
                int left = hashMap.getOrDefault(num - 1, 0);
                int right = hashMap.getOrDefault(num + 1, 0);
                // length of the sequence num is in
                int length = left + right + 1;
                hashMap.put(num, length);
                // keep track of the max length
                maxLength = Math.max(maxLength, length);
                // extend the length to the boundary of the sequence
                // will do nothing if n has no neighbors
                hashMap.put(num - left, length);
                hashMap.put(num + right, length);
            }
        }
        return maxLength;
    }


}
