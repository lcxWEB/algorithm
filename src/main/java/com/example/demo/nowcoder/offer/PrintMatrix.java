package com.example.demo.nowcoder.offer;

import java.util.ArrayList;

/**
 * @author lichunxia
 */
public class PrintMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 4, 5}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(matrix.length);
        System.out.println(new PrintMatrix().printMatrix(matrix));
    }

    public ArrayList<Integer> printMatrix0(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        ArrayList<Integer> result = new ArrayList<>();
        int l = matrix.length;
        for (int i = 0; i < l; i++) {
            int[] row = matrix[i];
            if (i == 0) {
                for (int j = 0; j < row.length; j++) {
                    result.add(row[j]);
                }
            } else if (i == l - 1) {
                for (int j = row.length - 1; j >= 0; j--) {
                    result.add(row[j]);
                }
            } else {
                result.add(row[row.length - 1]);
            }

        }

        return result;
    }

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        int start = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        ArrayList<Integer> result = new ArrayList();
        while (columns > start * 2 && rows > start * 2) {
            printMatrixInCircle(matrix, columns, rows, start, result);
            ++start;
        }
        return result;
    }

    private void printMatrixInCircle(int[][] matrix, int columns, int rows, int start, ArrayList<Integer> arrayList) {
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;

        // 从左到右打印一行
        for (int i = start; i <= endX; i++) {
            arrayList.add(matrix[start][i]);
        }
        // 从上到下打印一列
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                arrayList.add(matrix[i][endX]);
            }
        }
        // 从右到左打印一行
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                arrayList.add(matrix[endY][i]);
            }
        }
        // 从下到上打印一列
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i > start; i--) {
                arrayList.add(matrix[i][start]);
            }
        }
    }

}
