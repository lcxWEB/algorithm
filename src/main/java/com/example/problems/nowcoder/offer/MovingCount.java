package com.example.problems.nowcoder.offer;

/**
 * Created by lichunxia on 2020-02-01 20:30
 */
public class MovingCount {

    public static void main(String[] args) {
        int movingCount = new MovingCount().movingCount(5, 3, 4);
        System.out.println(movingCount);

    }

    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows < 0 || cols < 0) {
            return 0;
        }
        boolean[][] flag = new boolean[rows][cols];
        int result = movingCountCore(threshold, rows, cols, 0, 0, flag);
        return result;
    }

    private int movingCountCore(int threshold, int rows, int cols, int i, int j, boolean[][] flag) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || flag[i][j]) {
            return 0;
        }
        if (getNum(i) + getNum(j) > threshold) {
            return 0;
        }
        flag[i][j] = true;
        int count = 1 + movingCountCore(threshold, rows, cols, i - 1, j, flag)
                + movingCountCore(threshold, rows, cols, i + 1, j, flag)
                + movingCountCore(threshold, rows, cols, i, j - 1, flag)
                + movingCountCore(threshold, rows, cols, i, j + 1, flag);

        return count;
    }

    private int getNum(int num) {
        int sum = 0;
        while (num > 0) {
            sum = sum + num % 10;
            num = num / 10;
        }
        return sum;
    }

}
