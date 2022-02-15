package com.example.problems.array;

/**
 * @author: lichunxia
 * @create: 2/15/22 11:29 AM
 */
public class SpiralPrint {

    public static void main(String[] args) {
        // char[] in = new char[10];
        // for (int i = 0; i < in.length; i++) {
        //     System.out.println(in[i]);
        // }
        printSpiral(3);
    }

    private static void printSpiral(int n) {
        if (n <= 0) {
            return;
        }
        if (n == 1) {
            System.out.println('A');
        }

        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[][] res = new char[n][n];
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        for (int i = 0, x = 0, y = 0, d = 0; i < n * n; i++) {
            res[x][y] = chars[i];
            int a = x + dx[d], b = y + dy[d];
            if (a < 0 || a >= n || b < 0 || b >= n || res[a][b] != 0) {
                d = (d + 1) % 4;
                a = x + dx[d];
                b = y + dy[d];
            }
            x = a;
            y = b;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = res[i][j];
                System.out.print(c);
                if (j == n - 1) {
                    System.out.println();
                } else {
                    System.out.print(" ");
                }
            }
        }
    }
}
