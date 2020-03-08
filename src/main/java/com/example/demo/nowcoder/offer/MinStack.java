package com.example.demo.nowcoder.offer;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> minStack = new Stack();
    private Stack<Integer> dataStack = new Stack();
//    private int min;

    public void push(int node) {
        dataStack.push(node);
        if (minStack.size() == 0 || node < minStack.peek()) {
//            min = node;
//            minStack.push(min);
            minStack.push(node);
        } else {
//            minStack.push(min);
            minStack.push(minStack.peek());
        }

    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
//        min = minStack.peek();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
//        return min;
        return minStack.peek();
    }
}
