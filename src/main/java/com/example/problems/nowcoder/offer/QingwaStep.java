package com.example.problems.nowcoder.offer;

public class QingwaStep {

    public int JumpFloor(int target) {
        if (target <= 2) {
            return target;
        }
        // 后退两节 f(n-2)
        int f1 = 1;
        // 后退一节 f(n-1)
        int f2 = 2;
        // 总和
        int f = 0;
        for (int i = 0; i < target - 2; i++) {
            f = f1 + f2; // 当前台阶跳法总数
            f1 = f2; // 后退一节的变成后退两节的
            f2 = f; // 当前台阶变成后退一节的
        }
        return f;
    }


    public static void main(String[] args) {
        System.out.println(new QingwaStep().JumpFloor(3));
        System.out.println(new QingwaStep().JumpFloor(4));
        System.out.println(new QingwaStep().JumpFloor(5));
        System.out.println(new QingwaStep().JumpFloor(6));
    }
}
