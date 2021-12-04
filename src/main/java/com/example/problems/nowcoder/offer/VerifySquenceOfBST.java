package com.example.problems.nowcoder.offer;

/**
 * BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），
 * 如果去掉最后一个元素的序列为T，那么T满足：T可以分成两段，前一段（左子树）小于x，
 * 后一段（右子树）大于x，且这两段（子树）都是合法的后序序列。完美的递归定义 : ) 。
 */
public class VerifySquenceOfBST {

    public static void main(String[] args) {
        int[] arr = {4, 8, 6, 12, 16, 14, 10};
        // arr = new int[]{4, 6, 7, 5};
        // arr = new int[]{5, 4, 3, 2, 1};
        System.out.println(VerifySquenceOfBST2101(arr));
        System.out.println(VerifySquenceOfBST(arr));
        System.out.println(VerifySquenceOfBST1(arr));
        System.out.println(VerifySquenceOfBSTWhile(arr));
    }

    /**
     * 2.10
     * 非递归
     * 确实是重复遍历了多次左子树，总结来说，非递归版本的最好和最坏时间开销都是O（n^2），
     * 递归版本的最好时间开销是O（n*log2 n），最差时间开销是O（n^2）
     * @param sequence
     * @return
     */
    public static boolean VerifySquenceOfBSTWhile(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        int length = sequence.length;
        if (length == 1) {
            return true;
        }
        int i = 0;
        while (length > 0) {

            int root = sequence[length - 1];
            while (sequence[i] < root) {
                i++;
            }
            while (sequence[i] > root) {
                i++;
            }
            if (i < length - 1) {
                return false;
            }
            i = 0;
            length--;
        }
        return true;
    }

    /**
     * 2.10
     *
     * @param sequence
     * @return
     */
    public static boolean VerifySquenceOfBST2101(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        boolean result = verify(sequence, 0, sequence.length - 1);
        return result;
    }

    private static boolean verify(int[] sequence, int left, int right) {
        // 只有一个节点
        if (left == right) {
            return true;
        }
        int root = sequence[right];
        int i = 0;
        while (sequence[i] < root) {
            i++;
        }
        for (int j = i; j < right; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }
        boolean leftTree = true;
        if (i > 0) {
            leftTree = verify(sequence, left, i - 1);
        }
        boolean rightTree = true;
        if (i < right - 1) {
            rightTree = verify(sequence, i, right - 1);
        }
        return leftTree && rightTree;
    }

    /**
     * 2.10
     *
     * @param sequence
     * @return
     */
    public static boolean VerifySquenceOfBST210(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        int length = sequence.length;
        int root = sequence[length - 1];
        int i = 0;
        // 找到第一个大于root的位置；或者找到最后(i==length-1)没有找到，说明右子树为空
        for (; i < length - 1; i++) {
            if (sequence[i] > root) {
                break;
            }
        }

        for (int k = i; k < length - 1; k++) {
            if (sequence[i] < root) {
                return false;
            }
        }

        int[] leftTree = new int[i];
        int[] rightTree = new int[length - 1 - i];
        boolean left = true;
        if (leftTree.length > 0) {
            for (int j = 0; j < leftTree.length; j++) {
                leftTree[j] = sequence[j];
            }
            left = VerifySquenceOfBST210(leftTree);
        }


        boolean right = true;
        if (rightTree.length > 0) {
            for (int j = 0; j < rightTree.length; j++) {
                rightTree[j] = sequence[j + i];
            }
            right = VerifySquenceOfBST210(rightTree);
        }
        return left && right;
    }


    public static boolean VerifySquenceOfBST(int[] sequence) {

        if (sequence == null || sequence.length == 0) {
            return false;
        }

        int len = sequence.length;
        int root = sequence[len - 1];
        // 找到左右子树的分界点
        int i = 0;
        for (; i < len - 1; i++) {
            if (sequence[i] > root) break;
        }
        for (int j = i; j < len - 1; j++) {
            if (sequence[j] < root) return false;
        }

        int[] leftTree = new int[i];
        int[] rightTree = new int[len - 1 - i];


        for (int j = 0; j < i; j++) {
            leftTree[j] = sequence[j];
        }

        for (int j = i; j < len - 1; j++) {
            rightTree[j - i] = sequence[j];
        }

        boolean left = true;
        if (leftTree.length > 1) {
            left = VerifySquenceOfBST(leftTree);
        }
        boolean right = true;
        if (rightTree.length > 1) {
            right = VerifySquenceOfBST(rightTree);
        }
        return left && right;
    }


    public static boolean VerifySquenceOfBST1(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return judge(sequence, 0, sequence.length - 1);

    }

    /**
     * @param arr
     * @param left  左边界索引
     * @param right 右边界索引
     * @return
     */
    static boolean judge(int[] arr, int left, int right) {
        if (left > right) {
            return true;
        }
        // 左右子树临界点
        int i = 0;
        while (i < right && arr[i] < arr[right]) i++;
        for (int j = i; j < right; j++) {
            if (arr[j] < arr[right]) return false;
        }
        return judge(arr, left, i - 1) && judge(arr, i, right - 1);
    }
}
