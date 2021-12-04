package com.example.problems.hard;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * You may assume nums1 and nums2 cannot be both empty.
 */

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        int[] nums1 = new int[]{1, 4, 8};
        int[] nums2 = new int[]{5, 6, 9};
        double result = medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

    /**
     * 第一个解法
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArr = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                mergedArr[k] = nums1[i];
                i++;
                k++;
            } else {
                mergedArr[k] = nums2[j];
                j++;
                k++;
            }
        }

        while (j < nums2.length) {
            mergedArr[k] = nums2[j];
            j++;
            k++;
        }

        while (i < nums1.length) {
            mergedArr[k] = nums1[i];
            i++;
            k++;
        }
        double result;
        if (mergedArr.length % 2 != 0) {
            result = mergedArr[mergedArr.length / 2];
        } else {
            result = (mergedArr[mergedArr.length / 2] + mergedArr[mergedArr.length / 2 - 1]) / 2.0;
        }
        return result;
    }
}
