package com.example.demo.medium;

import java.util.Arrays;

/**
 * Created by lichunxia on 2019-09-08 11:47
 *
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Note:
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 */
public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 10},{4, 5, 6, 11}, {7, 8, 9, 12}, {13,14,15,16}};
        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));

        }
    }


    /**
     * 不是自己解出来的
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Image.
     * Memory Usage: 36.3 MB, less than 100.00% of Java online submissions for Rotate Image.
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        // int[] tempO = matrix[0];
        // matrix[0] = matrix[matrix.length - 1];
        // matrix[matrix.length - 1] = tempO;

        int s = 0, e = matrix.length - 1;
        while(s < e){
            int[] temp = matrix[s];
            matrix[s] = matrix[e];
            matrix[e] = temp;
            s++; e--;
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = i+1; j < matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
