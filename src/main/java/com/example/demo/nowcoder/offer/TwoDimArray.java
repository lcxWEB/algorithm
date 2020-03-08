package com.example.demo.nowcoder.offer;

/**
 * @Author: lcx
 * @Date: 2019/2/28 20:58
 * @Description:
 */

public class TwoDimArray {

    public static void main(String[] args) {
        int[][] array = {{0, 2, 3}, {6, 7, 8}};
        System.out.println(array.length);
        System.out.println(array[0].length);
        System.out.println(new TwoDimArray().Find(1, array));
    }

    public boolean Find(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (target == array[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean Find1(int target, int[][] array) {
        if (array == null) {
            return false;
        }
        int rows = array.length;
        int columns = array[0].length;

        if (rows <= 0 || columns <= 0) {
            return false;
        }

        int row = 0;
        int column = columns - 1;

        while (row < rows && column >= 0) {
            // 右上角
            if (target == array[row][column]) {
                return true;
            } else if (target < array[row][column]) { // 如果目标值小于右上角，则剔除最后一列
                column--;
            } else { // 如果目标值大于右上角，则剔除第一行，缩小查找范围
                row++;
            }
        }
        return false;
    }

    public boolean Find2(int target, int[][] array) {
        boolean found = false;
        if (array == null) {
            return found;
        }
        int rows = array.length;
        int columns = array[0].length;

        if (rows <= 0 || columns <= 0) {
            return found;
        }

        int row = rows - 1;
        int column = 0;

        while (row >= 0 && column < columns) {
            // 左下角
            if (target == array[row][column]) {
                found = true;
                break;
            } else if (target > array[row][column]) { // 如果目标值大于左下角，则剔除第一列
                column++;
            } else { // 如果目标值小于左下角，则剔除最后一行，缩小查找范围
                row--;
            }
        }
        return found;
    }


}
