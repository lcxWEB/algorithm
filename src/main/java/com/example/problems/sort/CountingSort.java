package com.example.problems.sort;

public class CountingSort {

    public static void main(String[] args) {
        int[] A = CountingSort.countingSort(new int[]{16, 4, 10, 14, 7, 9, 3, 2, 4, 8, 1});
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + ",");
        }
        System.out.println();
    }

    /**
     * 2.14
     * O(n+k)
     *
     * @param A
     * @return
     */
    public static int[] countingSort(int[] A) {
        int[] B = new int[A.length];
        // 假设A中的数据a'有，0<=a' && a' < k并且k=100
        int k = 100;
        countingSort(A, B, k);
        return B;
    }

    private static void countingSort(int[] A, int[] B, int k) {
        int[] C = new int[k];
        // 计数
        for (int j = 0; j < A.length; j++) {
            int a = A[j];
            C[a] += 1;
        }

        for (int i = 0; i < C.length; i++) {
            System.out.print(C[i] + ",");
        }
        System.out.println();

        // 求计数和
        for (int i = 1; i < k; i++) {
            C[i] = C[i] + C[i - 1];
        }

        for (int i = 0; i < C.length; i++) {
            System.out.print(C[i] + ",");
        }
        System.out.println();

        // 整理，反向填充为了保证稳定性
        for (int j = A.length - 1; j >= 0; j--) {
            int a = A[j];
            System.out.print(a + "==" + C[a] + ", ");
            B[C[a] - 1] = a;
            C[a] -= 1;
        }
        System.out.println();
    }
}