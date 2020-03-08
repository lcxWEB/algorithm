package com.example.demo.medium;

/**
 * Created by lichunxia on 2019-09-11 23:14
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 */
public class MinimumPathSum {

    public static void main(String[] args) {
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        int pathSum = minimumPathSum.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
        System.out.println(pathSum);
    }

    /**
     *
     * Runtime: 2 ms, faster than 90.00% of Java online submissions for Minimum Path Sum.
     * Memory Usage: 41.4 MB, less than 90.54% of Java online submissions for Minimum Path Sum.
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }
}
