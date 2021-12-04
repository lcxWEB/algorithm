package com.example.problems.medium;

/**
 * Created by lichunxia on 2019-09-06 14:26
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();
        int result = search.search2(nums, 0);
        System.out.println(result);
    }

    /**
     * O(n)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
     * Memory Usage: 37.3 MB, less than 61.01% of Java online submissions for Search in Rotated Sorted Array.
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * O(logn)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
     * Memory Usage: 38.4 MB, less than 44.65% of Java online submissions for Search in Rotated Sorted Array.
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            if(nums[start] == target) {
                return start;
            }
            if(nums[end] == target) {
                return end;
            }
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[end]) {
                // 说明mid处于前半段递增序列
                if (nums[mid] > target && target > nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // 说明mid处于后半段递增序列
                if (nums[mid] < target && target < nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 旋转点，也就是最小值所在位置
        int minIdx = findMinIdx(nums);
        if (target == nums[minIdx]) {
            return minIdx;
        }
        int start = 0;
        int end = nums.length - 1;
        if (target > nums[nums.length - 1]) {
            end = minIdx - 1;
        } else {
            start = minIdx + 1;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private int findMinIdx(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

}
