package com.example.problems.medium;

/**
 * Created by lichunxia on 2019-09-03 16:35
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * ind two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 * Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 *
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,6,3,8};
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int maxArea = containerWithMostWater.maxArea(height);
        System.out.println(maxArea);
    }

    /**
     * 自己的解法
     * Runtime: 206 ms, faster than 16.39% of Java online submissions for Container With Most Water.
     * Memory Usage: 39.7 MB, less than 95.51% of Java online submissions for Container With Most Water.
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                result = result > area ? result : area;
            }
        }
        return result;
    }


}
