package com.example.problems.other;

import java.util.Stack;

/**
 * Created by lichunxia on 2019-08-28 16:53
 * <p>
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStack {

    private Stack<Integer> stack;

    private Stack<Integer> sortStack;


    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack();
        sortStack = new Stack<>();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(5);
        minStack.push(-3);
        minStack.push(-9);
        minStack.push(9);
        int min = minStack.getMin();
        System.out.println(min);
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.getMin());
    }

    /**
     * Time Limit Exceeded
     *
     * @param x
     */
    // public void push(int x) {
    //     stack.push(x);
    //     if (sortStack.isEmpty()) {
    //         min = x;
    //     } else {
    //         min = sortStack.peek();
    //     }
    //     if (x <= min) {
    //         sortStack.push(x);
    //     } else {
    //         List<Integer> pop = new LinkedList<>();
    //         while (!sortStack.isEmpty() && min < x) {
    //             min = sortStack.peek();
    //             ((LinkedList<Integer>) pop).addFirst(min);
    //             sortStack.pop();
    //         }
    //         sortStack.push(x);
    //         Iterator<Integer> iterator = pop.iterator();
    //         while (iterator.hasNext()) {
    //             sortStack.push(iterator.next());
    //         }
    //     }
    // }


    public void push(int x) {
        stack.push(x);
        if (sortStack.isEmpty()) {
            sortStack.push(x);
        } else {
            int min = sortStack.peek();
            if (x < min) {
                sortStack.push(x);
            } else {
                sortStack.push(min);
            }
        }
    }

    // public void pop() {
    //     int peek = stack.peek();
    //     int min = sortStack.peek();
    //     if (peek <= min) {
    //         sortStack.pop();
    //     }
    //     stack.pop();
    // }

    /**
     * Runtime: 48 ms, faster than 32.34% of Java online submissions for Min Stack.
     * Memory Usage: 40.5 MB, less than 28.99% of Java online submissions for Min Stack.
     *
     */
    public void pop() {
        stack.pop();
        sortStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return sortStack.peek();
    }

}
