package com.example.demo.nowcoder.offer;

/**
 * Created by lichunxia on 2020-02-01 19:11
 * 链接：https://www.nowcoder.com/questionTerminal/c61c6999eecb4b8f88a98f66b273a3cc?f=discussion
 * 来源：牛客网
 *
 * 回溯
 * 基本思想：
 * 0.根据给定数组，初始化一个标志位数组，初始化为false，表示未走过，true表示已经走过，不能走第二次
 * 1.根据行数和列数，遍历数组，先找到一个与str字符串的第一个元素相匹配的矩阵元素，进入judge
 * 2.根据i和j先确定一维数组的位置，因为给定的matrix是一个一维数组
 * 3.确定递归终止条件：越界，当前找到的矩阵值不等于数组对应位置的值，已经走过的，这三类情况，都直接false，说明这条路不通
 * 4.若k，就是待判定的字符串str的索引已经判断到了最后一位，此时说明是匹配成功的
 * 5.下面就是本题的精髓，递归不断地寻找周围四个格子是否符合条件，只要有一个格子符合条件，就继续再找这个符合条件的格子的四周是否存在符合条件的格子，直到k到达末尾或者不满足递归条件就停止。
 * 6.走到这一步，说明本次是不成功的，我们要还原一下标志位数组index处的标志位，进入下一轮的判断。
 */
public class HasPath {

    public static void main(String[] args) {
        char[] matrix = "abcesfcsadee".toCharArray();
        char[] str = "bcced".toCharArray();
        boolean hasPath = new HasPath().hasPath(matrix, 3, 4, str);
        System.out.println(hasPath);
        str = "bccied".toCharArray();
        hasPath = new HasPath().hasPath(matrix, 3, 4, str);
        System.out.println(hasPath);
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[] flag = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix, i, j, rows, cols, str, flag, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasPathCore(char[] matrix, int i, int j, int rows, int cols, char[] str, boolean[] flag, int k) {
        int index = i * cols + j;
        if (i < 0 || j < 0 || i >= rows || j >= cols || matrix[index] != str[k] || flag[index]) {
            return false;
        }
        //若k已经到达str末尾了，说明之前的都已经匹配成功了，直接返回true即可
        if (k == str.length - 1) {
            return true;
        }
        //要走的第一个位置置为true，表示已经走过了
        flag[index] = true;
        //回溯，递归寻找，每次找到了就给k加一，找不到，还原
        if (hasPathCore(matrix, i - 1, j, rows, cols, str, flag, k + 1) ||
                hasPathCore(matrix, i + 1, j, rows, cols, str, flag, k + 1) ||
                hasPathCore(matrix, i, j - 1, rows, cols, str, flag, k + 1) ||
                hasPathCore(matrix, i, j + 1, rows, cols, str, flag, k + 1)) {
            return true;
        }
        //走到这，说明这一条路不通，还原，再试其他的路径
        flag[index] = false;
        return false;
    }
}
