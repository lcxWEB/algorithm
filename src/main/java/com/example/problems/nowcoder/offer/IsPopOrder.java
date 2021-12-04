package com.example.problems.nowcoder.offer;

import java.util.Stack;

public class IsPopOrder {

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null || pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> assistStack = new Stack<>();
        // 标示弹出序列的位置
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            assistStack.push(pushA[i]);
            // 辅助栈的栈顶元素如果与弹出序列一样，则弹出
            while (!assistStack.isEmpty() && assistStack.peek() == popA[popIndex]) {
                // 出栈
                assistStack.pop();
                // 弹出序列后移一位
                popIndex++;
            }
        }
        // 循环结束，辅助栈为空说明弹出序列
        return assistStack.isEmpty();
    }
}
