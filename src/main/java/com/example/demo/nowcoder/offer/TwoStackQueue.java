package com.example.demo.nowcoder.offer;

import java.util.Stack;

public class TwoStackQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        // if (!stack2.isEmpty()) {
        //     return stack2.pop();
        // } else {
        //     while (!stack1.isEmpty()) {
        //         stack2.push(stack1.pop());
        //     }
        //     if (stack2.empty()) {
        //         throw new RuntimeException("queue is empty");
        //     }
        //     return stack2.pop();
        // }


        if (stack1.empty() && stack2.empty()) {
            throw new RuntimeException("queue is empty");
        }
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}