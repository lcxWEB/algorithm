package com.example.demo.nowcoder.offer;

/**
 * Created by lichunxia on 2020-02-14 14:00
 */
public class GetMaxValue {

    public static void main(String[] args) {
        int[][] array = new int[4][4];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = 2;
            }
        }
        GetMaxValue getMaxValue = new GetMaxValue();
        int maxValue = getMaxValue.getMaxValue(array);
        System.out.println(maxValue);
        maxValue = getMaxValue.getMaxValueOp(array);
        System.out.println(maxValue);
    }

    /**
     * 2.14
     * O(rows * columns), O(rows * columns)
     * <p>
     * f(i,j)表示到达坐标(i,j)的格子时能拿到的礼物总和的最大值
     * f(i,j) = max(f(i-1,j), f(i,j-1)) + gift[i][j]
     *
     * @param values
     * @return
     */
    public int getMaxValue(int[][] values) {
        if (values == null || values.length <= 0 || values[0].length <= 0) {
            return 0;
        }
        int rows = values.length;
        int columns = values[0].length;
        int[][] maxValues = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int left = 0;
                int up = 0;
                if (i > 0) {
                    up = maxValues[i - 1][j];
                }
                if (j > 0) {
                    left = maxValues[i][j - 1];
                }
                maxValues[i][j] = Math.max(left, up) + values[i][j];
            }
        }
        return maxValues[rows - 1][columns - 1];
    }


    /**
     * 2.14
     * 优化空间复杂度
     * (i,j) 只与 (i-1, j) 和 (i, j - 1)有关，
     * 只需存储第 i 行的(0 ～ j-1) 列，和第 i-1 行的(j ～ 最后一列)
     * 长度为columns的一维数组
     *
     * @param values
     * @return
     */
    public int getMaxValueOp(int[][] values) {
        if (values == null || values.length <= 0 || values[0].length <= 0) {
            return 0;
        }
        int rows = values.length;
        int columns = values[0].length;
        int[] maxValues = new int[columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int left = 0;
                int up = 0;
                if (i > 0) {
                    up = maxValues[j];
                }
                if (j > 0) {
                    left = maxValues[j - 1];
                }
                maxValues[j] = Math.max(left, up) + values[i][j];
            }
        }
        return maxValues[columns - 1];
    }


}
