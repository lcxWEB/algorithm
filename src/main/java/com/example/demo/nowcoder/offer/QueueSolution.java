package com.example.demo.nowcoder.offer;

import java.util.Stack;

public class QueueSolution {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();


    public void push(int node) {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(node);
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
    }

    public int pop() {
        return stack1.pop();
    }


    public static void main(String[] args) {
        QueueSolution qs = new QueueSolution();
        qs.push(100);
        qs.push(200);
        qs.push(300);
        qs.push(400);

        System.out.println(qs.pop());
        System.out.println(qs.pop());
        System.out.println(qs.pop());
        System.out.println(qs.pop());
    }


}
