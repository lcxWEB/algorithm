package com.example.demo.nowcoder.offer;

import java.util.Scanner;

/**
 * Created by lichunxia on 2020-02-03 17:55
 */
public class Find {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        boolean find = new Find().Find(7, arr);
        System.out.println(find);
    }

    /**
     * 2.11
     * O(m + n)
     *
     * @param target
     * @param array
     * @return
     */
    public boolean Find211(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int rows = array.length;
        int columns = array[0].length;
        int row = 0;
        int column = columns - 1;
        while (row < rows && column >= 0) {
            int num = array[row][column];
            if (num == target) {
                return true;
            }
            if (target > num) {
                row++;
            } else {
                column--;
            }
        }
        return false;
    }

    /**
     * O(m + n)
     *
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0) {
            return false;
        }

        int row = 0;
        int columns = array[0].length;
        int column = columns - 1;

        int rows = array.length;
        while (row < rows && column >= 0) {
            int current = array[row][column];
            if (current == target) {
                return true;
            }

            if (current > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

}

/**
 * 第四范式
 */
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int target = scanner.nextInt();
        System.out.println(search(matrix, target));
    }

    public static boolean search(int[][] array, int target) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int rows = array.length;
        int columns = array[0].length;
        int row = 0;
        int column = columns - 1;
        while (row < rows && column >= 0) {
            int num = array[row][column];
            if (num == target) {
                return true;
            }
            if (target > num) {
                row++;
            } else {
                column--;
            }
        }
        return false;
    }

}
